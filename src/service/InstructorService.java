package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import datamodel.Instructors;

public class InstructorService {

	public List<Instructors> readCSV() throws IOException{
		
		String line = null;
		String splitBy = ",";
		int count = 0;
		BufferedReader br = new BufferedReader(new FileReader
				("C:\\Users\\tbert\\OneDrive\\Documents\\Travis_Classwork\\Java Applications\\instructors.csv"));
		List<Instructors> instructorList = new ArrayList<>();
		
		while((line = br.readLine()) != null) {
			if(count != 0) {
				Instructors instructor = new Instructors();
				String[] instructor_info = line.split(splitBy);
				instructor.setInstructorId(Integer.valueOf(instructor_info[0].trim()));
				instructor.setName(instructor_info[1].trim());
				String subject = instructor_info[2].trim();
				if (subject.equals("C++")) {
					subject = "JavaScript";
				}
				instructor.setSubject(subject);
				instructor.setPhoneNumber(instructor_info[3].trim());
				instructor.setEmail(instructor_info[4].trim());
				instructor.setTarget_year(instructor_info[5].trim());
				
				instructorList.add(instructor);
			}
			count++;
		}
		br.close();
		return instructorList;
	}
}
