package controller.ctl;

import controller.AbstractController;
import model.GraduatedClass;
import model.GraduatedStudent;

import java.util.ArrayList;

public class DelFormController extends AbstractController {

	// Controller

	public DelFormController(GraduatedClass graduatedClass) {
		super(graduatedClass);
	}

	// Methods
	
	public void control(ArrayList<String> data) {

		if(data != null && data.get(0) != null) {

			int number = 0;

			try {
				number = Integer.parseInt(data.get(0));
			} catch(NumberFormatException ex) {
				ex.printStackTrace(); // TODO Error
			}

			if(Integer.parseInt(data.get(0)) > 0) {

				GraduatedStudent student = graduatedClass.get(number);
				graduatedClass.remove(student);
				graduatedClass.notifyObservers();

			} else {
				// TODO Error
			}
		}
	}
}
