package model;

public class GraduatedStudent {

	// Attributes

	private int number;

	private String firstName;

	private String lastName;
	
	private int department;

	private String degree;

	// Constructor

	public GraduatedStudent(int number, String firstName, String lastName, int department, String degree) {
		this.setNumber(number);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setDepartment(department);
		this.setDegree(degree);
	}

	// ToString

	public String toString() {
		return this.number + " - " + this.lastName + " " + this.firstName + " (" + this.department + ")";
	}

	// Getters

	public int getNumber() {
		return this.number;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public int getDepartment() {
		return this.department;
	}

	public String getDegree() {
		return this.degree;
	}

	// Setters

	public void setNumber(int number) {
		this.number = number;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setDepartment(int department) {
		this.department = department;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}
}
