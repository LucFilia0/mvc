package controller;

import java.util.ArrayList;

import model.GraduatedClass;

/**
 * This class represents a controller, that can be changed and taken by any of its children.
 * Each child has its own 'controll' method, that will be called to perform the right action.
 * 
 * @author Luc le Manifik
 */
public abstract class AbstractController {

	// Attributes

	/**
	 * The GraduatedClass on which is performed the action.
	 */
	protected GraduatedClass graduatedClass;

	// Constructor

	/**
	 * Creates a new AbstractController. Only available for children classes.
	 * @param graduatedClass The GraduatedClass on which is performed the action
	 */
	protected AbstractController(GraduatedClass graduatedClass) {
		this.graduatedClass = graduatedClass;
	}

	// Getters

	protected GraduatedClass getGraduatedClass() {
		return this.graduatedClass;
	}

	// Setters

	protected void setGraduatedClass(GraduatedClass graduatedClass) {
		if(graduatedClass != null)
			this.graduatedClass = graduatedClass;
	}

	// Methods
	
	/**
	 * The methods wich is called to perform the action.
	 * @param data The ArrayList which contains all the necessary values to perform the wanted action.
	 */
	public abstract void control(ArrayList<String> data);
}
