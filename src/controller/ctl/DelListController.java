package controller.ctl;

import controller.AbstractController;
import model.GraduatedClass;

import java.util.ArrayList;

public class DelListController extends AbstractController {

	// Controller

	public DelListController(GraduatedClass graduatedClass) {
		super(graduatedClass);
	}

	@Override
	public void control(ArrayList<String> data) {
		
		if(data != null && data.get(0) != null) {

			int number = 0;

			try {
				number = Integer.parseInt(data.get(0));
			} catch(NumberFormatException ex) {
				ex.printStackTrace(); // TODO Error
			}

			graduatedClass.remove(graduatedClass.get(number));

			graduatedClass.notifyObservers();

		} else {
			// TODO Error
		}
	}
}
