package datamodel;

public class Instructors {
	
	private int instructorId;
	private String name;
	private String subject;
	private String phoneNumber;
	private String email;	
	private String target_year;

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
	public String getTarget_year() {
		return target_year;
	}
	public void setTarget_year(String target_year) {
		this.target_year = target_year;
	}
	public int getInstructorId() {
		return instructorId;
	}
	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString() {
		return "Instructors [instructorId=" + instructorId + ", name=" + name + ", subject=" + subject
				+ ", phoneNumber=" + phoneNumber + ", email=" + email + ", target_year=" + target_year + "]";
	}
	
	

}
