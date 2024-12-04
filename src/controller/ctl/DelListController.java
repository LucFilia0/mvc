package controller.ctl;

import controller.AbstractController;
import exception.StudentNotFoundException;
import model.GraduatedClass;

import java.util.ArrayList;

public class DelListController extends AbstractController {

	// Controller

	/**
	 * Creates a new DelListController.
	 * @param graduatedClass The GraduatedClass from which the student will be removed.
	 */
	public DelListController(GraduatedClass graduatedClass) {
		super(graduatedClass);
	}

	@Override
	public void control(ArrayList<String> data) {
		
		if(data != null && data.get(0) != null) {

			int number = 0;

			try {
				number = Integer.parseInt(data.get(0));
				graduatedClass.remove(graduatedClass.get(number));
				graduatedClass.notifyObservers();
			} catch(NumberFormatException | StudentNotFoundException ex) {
				System.err.println(ex.getMessage());
			}

		}
	}
}
