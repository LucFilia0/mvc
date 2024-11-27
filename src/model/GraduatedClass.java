package model;

import java.util.ArrayList;

public class GraduatedClass {

	// Attributes

	private ArrayList<GraduatedStudent> data;
	
	// Constructor

	public GraduatedClass() {
		this.data = new ArrayList<GraduatedStudent>();
	}

	// Methods

	public void add(GraduatedStudent student) {
		this.data.add(student);
	}

	public void remove(GraduatedStudent student) {
		this.data.remove(student);
	}

	public GraduatedStudent get(int number) {
		int length = this.data.size();
		int i = 0;
		GraduatedStudent student = null;

		while(student == null && i < length) {
			if(this.data.get(i).getNumber() == number)
				student = this.data.get(i);
		}

		return student;
	}

	public ArrayList<GraduatedStudent> getData() {
		return this.data;
	}
}