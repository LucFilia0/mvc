package controller.ctl;

import controller.AbstractController;
import exception.StudentNotFoundException;
import model.GraduatedClass;
import model.GraduatedStudent;
import view.panel.FormPanel;
import view.popup.ErrorPopup;

import java.util.ArrayList;

/**
 * This class extends the {@link controller.AbstractController} and is used from the formPanel
 * to delete a {@link model.GraduatedStudent GraduatedStudent} from the {@link model.GraduatedClass GraduatedClass}
 * 
 * @author Luc le Manifik 
 */
public class DelFormController extends AbstractController {

	// Attributes

	/**
	 * The FormPanel that will be updated after deleting a new student.
	 */
	private FormPanel formPanel;

	// Constructor

	/**
	 * Creates a new DelFormController.
	 * @param graduatedClass The GraduatedClass from which the student will be removed
	 * @param formPanel The FormPanel which will be updated after deleting a student
	 */
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
