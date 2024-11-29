package controller;

import java.util.ArrayList;

import model.GraduatedClass;

public abstract class AbstractController {

	// Attributes

	protected GraduatedClass graduatedClass;

	// Constructor

	protected AbstractController(GraduatedClass graduatedClass) {
		this.graduatedClass = graduatedClass;
	}

	// Getters

	protected GraduatedClass getGraduatedClass() {
		return this.graduatedClass;
	}

	// Setters

	protected void setGraduatedClass(GraduatedClass graduatedClass) {
		if(!graduatedClass.equals(null))
			this.graduatedClass = graduatedClass;
	}

	// Methods
	
	public abstract void control(ArrayList<String> data);
}
