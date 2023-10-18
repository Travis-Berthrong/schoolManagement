package datamodel;

public class Instructors {
	
	private int instructorId;
	private String instructorName;
	private String instructorSubject;
	private String phoneNumber;
	private String instructorEmail;
	
	public int getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}
	public String getInstructorName() {
		return instructorName;
	}
	public void setInstructorName(String instructorName) {
		this.instructorName = instructorName;
	}
	public String getInstructorSubject() {
		return instructorSubject;
	}
	public void setInstructorSubject(String instructorSubject) {
		this.instructorSubject = instructorSubject;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getInstructorEmail() {
		return instructorEmail;
	}
	public void setInstructorEmail(String instructorEmail) {
		this.instructorEmail = instructorEmail;
	}
	
	@Override
	public String toString() {
		return "Instructors [instructorId=" + instructorId + ", instructorName=" + instructorName
				+ ", instructorSubject=" + instructorSubject + ", phoneNumber=" + phoneNumber + ", instructorEmail="
				+ instructorEmail + "]";
	}
	
	

}
