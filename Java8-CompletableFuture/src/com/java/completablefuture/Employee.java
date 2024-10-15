package com.java.completablefuture;

public class Employee {

	private Long employeeId;
	private String employeeName;
	private String email;
	private String gender;
	private Integer rating;
	private String location;
	private Boolean isNewJoinee;
	private Boolean completedTrainings;
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Boolean getIsNewJoinee() {
		return isNewJoinee;
	}
	public void setIsNewJoinee(Boolean isNewJoinee) {
		this.isNewJoinee = isNewJoinee;
	}
	public Boolean getCompletedTrainings() {
		return completedTrainings;
	}
	public void setCompletedTrainings(Boolean completedTrainings) {
		this.completedTrainings = completedTrainings;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Employee(Long employeeId, String employeeName, String location, Boolean isNewJoinee,
			Boolean completedTrainings) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.location = location;
		this.isNewJoinee = isNewJoinee;
		this.completedTrainings = completedTrainings;
	}
	public Employee(Long employeeId, String employeeName, String email, String location, Boolean isNewJoinee,
			Boolean completedTrainings) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.email = email;
		this.location = location;
		this.isNewJoinee = isNewJoinee;
		this.completedTrainings = completedTrainings;
	}
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Employee(Long employeeId, String employeeName, String email,String gender, Integer rating, String location,
			Boolean isNewJoinee, Boolean completedTrainings) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.email = email;
		this.gender=gender;
		this.rating = rating;
		this.location = location;
		this.isNewJoinee = isNewJoinee;
		this.completedTrainings = completedTrainings;
	}
	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", email=" + email
				+ ", rating=" + rating + ", location=" + location + ", isNewJoinee=" + isNewJoinee
				+ ", completedTrainings=" + completedTrainings + "]";
	}
	
	
}
