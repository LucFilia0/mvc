package controller.ctl;

import java.util.ArrayList;

import controller.AbstractController;
import model.GraduatedClass;
import model.GraduatedStudent;

public class AddFormController extends AbstractController {

	// Constructor

	public AddFormController(GraduatedClass graduatedClass) {
		super(graduatedClass);
	}

	// Methods
	
	public void control(ArrayList<String> data) {
		
		if(data != null && data.get(0) != null && data.get(1) != null && data.get(2) != null && data.get(3) != null && !data.get(3).equals("---") && data.get(4) != null) {
			
			int studentNumber = 0;
			int studentDepartment = 0;

			try {
				studentNumber = Integer.parseInt(data.get(0));
				studentDepartment = Integer.parseInt(data.get(4));
			} catch(NumberFormatException ex) {
				ex.printStackTrace(); // TODO Error
			}

			String studentFirstName = data.get(1);
			String studentLastName = data.get(2);
			String studentDegree = data.get(3);

			GraduatedStudent student = new GraduatedStudent(studentNumber, studentFirstName, studentLastName, studentDepartment, studentDegree);

			this.graduatedClass.add(student);

			this.graduatedClass.notifyObservers();

		} else {
			// TODO Error
		}
	}
}
