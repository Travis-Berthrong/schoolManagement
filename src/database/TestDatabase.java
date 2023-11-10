package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestDatabase {
    public static void main(String[] args) {
        try {
            String sql = "jdbc:mysql://localhost:3306/testdatabase";
            String username = "root";
            String password = "password";

            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(sql, username, password);
            PreparedStatement prep, prep1, prep2;
            prep = conn.prepareStatement("insert into sample (id, name) values(?, ?)");
            prep.setString(1, "100");
            prep.setString(2, "abcd");

            prep1 = conn.prepareStatement("alter table sample add age INT");
            prep2 = conn.prepareStatement("select * from sample");

            prep.executeUpdate();
            // prep1.executeUpdate();
            ResultSet rs = prep2.executeQuery();
            while(rs.next()) {
                String id = rs.getString("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println(id + " " + name + " " + age);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

