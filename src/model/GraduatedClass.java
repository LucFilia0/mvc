package model;

import java.util.ArrayList;

import controller.obs.Observable;
import controller.obs.Observer;

public class GraduatedClass implements Observable {

	// Attributes

	private ArrayList<GraduatedStudent> data;

	private ArrayList<Observer> observers;
	
	// Constructor

	public GraduatedClass() {
		this.data = new ArrayList<GraduatedStudent>();
		this.observers = new ArrayList<Observer>();
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