package controller.ctl;

import controller.AbstractController;
import exception.StudentNotFoundException;
import model.GraduatedClass;
import model.GraduatedStudent;
import view.panel.FormPanel;
import view.popup.ErrorPopup;

import java.util.ArrayList;

public class DelFormController extends AbstractController {

	// Attributes

	private FormPanel formPanel;

	// Constructor

	public DelFormController(GraduatedClass graduatedClass, FormPanel formPanel) {
		super(graduatedClass);
		this.formPanel = formPanel;
	}

	// Methods
	
	public void control(ArrayList<String> data) {

		if(data != null && data.get(0) != null) {

			int number = 0;
			GraduatedStudent student = null;

			try {
				number = Integer.parseInt(data.get(0));
				student = graduatedClass.get(number);
				graduatedClass.remove(student);
				graduatedClass.notifyObservers();
				this.formPanel.clearDelPanel();
			} catch(NumberFormatException | StudentNotFoundException ex) {
				ErrorPopup.promptErrorPopup(ex.getMessage());
			}

		}
	}
}
