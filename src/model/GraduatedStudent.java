package model;

/**
 * This class represents a graduated student.
 * 
 * @author Luc le Manifik
 */
public class GraduatedStudent {

	// Attributes

	/**
	 * The student's number.
	 */
	private int number;

	/**
	 * The student's first name.
	 */
	private String firstName;

	/**
	 * The student's last name.
	 */
	private String lastName;
	
	/**
	 * The student's department.
	 */
	private int department;

	/**
	 * The student's degree.
	 */
	private String degree;

	// Constructor

	/**
	 * Creates a new GraduatedStudent.
	 * @param number The student's number
	 * @param firstName The student's first name
	 * @param lastName The student's last name
	 * @param department The student's department
	 * @param degree The student's degree type (G, T, A or Pro)
	 */
	public GraduatedStudent(int number, String firstName, String lastName, int department, String degree) {
		this.setNumber(number);
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setDepartment(department);
		this.setDegree(degree);
	}

	// ToString

	/**
	 * Returns the student's informations in the right format, so that it can directly
	 * be inserted in the ListPanel.
	 */
	public String toString() {
		return this.degree + "_" + this.number + " - " + this.lastName + " " + this.firstName + " (" + this.department + ")";
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
