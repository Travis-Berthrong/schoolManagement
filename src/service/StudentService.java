package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import datamodel.Students;

public class StudentService {

	public List<Students> read() throws IOException {
		
		FileReader fread = new FileReader(
				"C:\\Users\\tbert\\OneDrive\\Documents\\Travis_Classwork\\Java Applications\\students.csv");
		BufferedReader br = new BufferedReader(fread);
		String line = null;
		String splitBy = ",";
		List<Students> students = new ArrayList<Students>();
		int count = 0;
		while ((line = br.readLine()) != null) {
			if (count != 0) {
				Students student = new Students();
				String[] studentList = line.split(splitBy);
				student.setStudId(studentList[0].trim());
				student.setName(studentList[1].trim());
				student.setDepartment(studentList[2].trim());
				String age = studentList[4].trim();
				age = (((!age.isEmpty()) && (Integer.valueOf(studentList[4].trim())) >= 19) ? studentList[4].trim()
						: "0");
				student.setAge(age);
				String CSV = studentList[3].trim();
				String[] values = CSV.split(";");
				student.setCourse(Arrays.asList(values));
				student.setYear(studentList[5].trim());
				student.setFee(Double.parseDouble(studentList[6].trim()));
				student.setPaid(studentList[7].trim());

				students.add(student);
			}
			count++;
		}

		br.close();
		fread.close();
		sortByYear(students);
		return students;
	}
	
	public void sortByYear(List<Students> student_list) {
	    Collections.sort(student_list, (s1, s2) -> Integer.valueOf(s1.getYear()).compareTo(Integer.valueOf(s2.getYear())));
	}

}
