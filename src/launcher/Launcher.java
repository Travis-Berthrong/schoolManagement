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
import service.InstructorService;
import service.StudentService;

public class Launcher {

	public static void printStudents(List<Students> list) {
		for (int i = 0; i < list.size(); i++) {
		    Students el = list.get(i);
		    System.out.printf("ID: %s Name: %s Age: %s Courses: %s Department: %s Year: %s Fee: %.2f Paid: %s%n",
		            el.getStudId(), el.getName(), el.getAge(), el.getCourse().toString(), el.getDepartment(),
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
		
		StudentService studentservice = new StudentService();
		try {
			List<Students> student_list = studentservice.read();
			System.out.println("Before sort: \n");
			printStudents(student_list);
			studentservice.sortByYear(student_list);
			System.out.println("\n\n After sort: \n");
			printStudents(student_list);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.print("\n\n");
		System.out.println("Instructors: \n");
		InstructorService instructorService = new InstructorService();
		try {
			List<Instructors> instructorList = instructorService.readCSV();
			for (int i = 0; i < instructorList.size(); i++) {
				Instructors el = instructorList.get(i);
				System.out.printf("ID: %s Name: %s Subject: %s Phone: %s Email: %s Target Year: %s%n",
						el.getInstructorId(), el.getName(), el.getSubject(), el.getPhoneNumber(), el.getEmail(),
						el.getTarget_year());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
