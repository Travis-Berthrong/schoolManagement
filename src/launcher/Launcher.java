package launcher;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
