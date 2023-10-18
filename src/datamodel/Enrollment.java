package datamodel;

import java.util.Date;

public class Enrollment {
	
	private int enrollmentId;
	private String enrollmentDetails;
	private String enrollmentRequirments;
	private Date enrollmentDate;
	
	public int getEnrollmentId() {
		return enrollmentId;
	}
	public void setEnrollmentId(int enrollmentId) {
		this.enrollmentId = enrollmentId;
	}
	public String getEnrollmentDetails() {
		return enrollmentDetails;
	}
	public void setEnrollmentDetails(String enrollmentDetails) {
		this.enrollmentDetails = enrollmentDetails;
	}
	public String getEnrollmentRequirments() {
		return enrollmentRequirments;
	}
	public void setEnrollmentRequirments(String enrollmentRequirments) {
		this.enrollmentRequirments = enrollmentRequirments;
	}
	public Date getEnrollmentDate() {
		return enrollmentDate;
	}
	public void setEnrollmentDate(Date enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}

	
}
