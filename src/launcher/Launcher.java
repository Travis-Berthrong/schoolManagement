package launcher;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import datamodel.Admin;
import datamodel.Courses;
import datamodel.Enrollment;
import datamodel.Instructors;
import datamodel.Students;
import datamodel.Payment;
import datamodel.Subjects;
import service.PayService;

public class Launcher {

	public static void printStudents(List<Students> list) {
		for (int i = 0; i < list.size(); i++) {
		    Students el = list.get(i);
		    System.out.printf("ID: %d Name: %s Age: %d Courses: %s Department: %s Year: %d Fee: %.2f Paid: %.2f%n",
		            el.getStudId(), el.getName(), el.getAge(), el.getCourse(), el.getDepartment(),
		            el.getYear(), el.getFee(), el.getPaid());
		}
	}

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		Admin admin = new Admin();
		admin.setAdminId("ad123");
		admin.setPassword("EPITA2023");

		Courses course = new Courses();
		course.setCourseId("J2023");
		course.setCourseDuration(30);
		course.setCourseName("Java Application Development");

		Enrollment enroll = new Enrollment();
		enroll.setEnrollmentId(202301);
		enroll.setEnrollmentDate(sdf.parse("01/01/2023"));
		enroll.setEnrollmentDetails("Fall 2023 enrollment!");

		Students student = new Students();
		student.setStudId("F123");
		student.setName("Tom");
		student.setAge("20");
		student.setDepartment("Bachelor's of Computer Science");
		student.setYear("2023");

		List<String> courses = new ArrayList<String>();
		courses.add("Java");
		courses.add("python");
		courses.add("C++");
		student.setCourse(courses); // courses.forEach(c -> System.out.println(c));
		
		PayService payservice = new PayService();
		try {
			List<Students> student_list = payservice.read();
			System.out.println("Before sort: \n");
			printStudents(student_list);
			payservice.sortByYear(student_list);
			System.out.println("\n\n After sort: \n");
			printStudents(student_list);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
