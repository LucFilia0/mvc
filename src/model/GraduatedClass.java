package model;

import java.util.ArrayList;

import controller.obs.Observable;
import controller.obs.Observer;
import exception.StudentNotFoundException;

/**
 * Represents a set of GraduatedStudent, graduated the same year.
 * 
 * @author Luc le Manifik
 */
public class GraduatedClass implements Observable {

	// Attributes

	/**
	 * The list of all the students.
	 */
	private ArrayList<GraduatedStudent> data;

	/**
	 * The list of all the Observers.
	 */
	private ArrayList<Observer> observers;
	
	// Constructor

	/**
	 * Creates a new GraduatedClass.
	 */
	public GraduatedClass() {
		this.data = new ArrayList<GraduatedStudent>();
		this.observers = new ArrayList<Observer>();
	}

	// Methods

	/**
	 * Adds a new student.
	 * @param student The new student
	 */
	public void add(GraduatedStudent student) {
		this.data.add(student);
	}

	/**
	 * Removes a student.
	 * @param student The student to remove
	 */
	public void remove(GraduatedStudent student) {
		this.data.remove(student);
	}

	/**
	 * Gets a student from its number.
	 * @param number The searched number
	 * @return The students who has the right number
	 * @throws StudentNotFoundException Threw if no student matches the searched number
	 */
	public GraduatedStudent get(int number) throws StudentNotFoundException {
		int length = this.data.size();
		int i = 0;
		GraduatedStudent student = null;

		while(student == null && i < length) {
			if(this.data.get(i).getNumber() == number)
				student = this.data.get(i);
			++i;
		}

		if(student == null) {
			throw new StudentNotFoundException(number);
		}

		return student;
	}

	/**
	 * Gets the ArrayList of students... Only used for forEach loops.
	 * @return The ArrayList containing all the students
	 */
	public ArrayList<GraduatedStudent> getData() {
		return this.data;
	}

	// Observable methods

	@Override
	public void addObserver(Observer observer) {
		this.observers.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		this.observers.remove(observer);
	}

	@Override
	public void notifyObservers() {
		this.observers.forEach((observer) -> {
			observer.update();
		});
	}
}