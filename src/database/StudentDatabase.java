package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

import datamodel.Students;
import service.InstructorService;
import service.StudentService;

public class StudentDatabase {
    
    public void databaseConectivity() {
        try {
            String sql = "jdbc:mysql://localhost:3306/school_management";
            String username = "root";
            String password = "password";

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(sql, username, password);
            PreparedStatement prep, prep1, prep2;

            StudentService studentService = new StudentService();
            List<Students> students = studentService.read();

            prep = conn.prepareStatement("create table if not exists student (id varchar(50), name varchar(50), department varchar(50), age varchar(50), course varchar(75), year int, fee double, paid varchar(50))");
            prep.executeUpdate();

            for (Students student : students) {
                prep1 = conn.prepareStatement("insert into student (id, name, department, age, course, year, fee, paid) values(?, ?, ?, ?, ?, ?, ?, ?)");
                prep1.setString(1, student.getStudId());
                prep1.setString(2, student.getName());
                prep1.setString(3, student.getDepartment());
                prep1.setString(4, student.getAge());
                prep1.setString(5, student.getCourse().toString());
                prep1.setInt(6, Integer.parseInt(student.getYear()));
                prep1.setDouble(7, student.getFee());
                prep1.setString(8, student.getPaid());
                prep1.executeUpdate();
            }

            

        } catch (Exception e) {
            System.out.println(e);
        }
}

public static void main(String[] args) {
    StudentDatabase studentDatabase = new StudentDatabase();
    studentDatabase.databaseConectivity();
}
}
