package controller.ctl;

import java.util.ArrayList;

import controller.AbstractController;
import exception.StudentNotFoundException;
import model.GraduatedClass;
import model.GraduatedStudent;
import view.panel.FormPanel;
import view.popup.ErrorPopup;

/**
 * This class extends the {@link controller.AbstractController} and is used from the formPanel
 * to add a {@link model.GraduatedStudent GraduatedStudent} to the {@link model.GraduatedClass GraduatedClass}
 * 
 * @author Luc le Manifik 
 */
public class AddFormController extends AbstractController {

	// Attributes

	/**
	 * The FormPanel that will be updated after adding a new student.
	 */
	private FormPanel formPanel;

	// Constructor

	/**
	 * Creates a new AddFormController.
	 * @param graduatedClass The GraduatedClass where the new student is added
	 * @param formPanel The FormPanel wich will be updated after adding the student
	 */
	public AddFormController(GraduatedClass graduatedClass, FormPanel formPanel) {
		super(graduatedClass);
		this.formPanel = formPanel;
	}

	// Methods
	
	public void control(ArrayList<String> data) {
		
		if(data != null && data.get(0) != null && data.get(1) != null && data.get(2) != null && data.get(3) != null && !data.get(3).equals("---") && data.get(4) != null) {
			
			GraduatedStudent student = null;

			int studentNumber = 0;
			int studentDepartment = 0;

			try {
				studentNumber = Integer.parseInt(data.get(0));
				studentDepartment = Integer.parseInt(data.get(4));
			} catch(NumberFormatException ex) {
				ErrorPopup.promptErrorPopup("Valeurs incorrectes entrées");
			}

			String studentFirstName = data.get(1);
			String studentLastName = data.get(2);
			String studentDegree = data.get(3);

			try {
				student = this.graduatedClass.get(studentNumber);
				ErrorPopup.promptErrorPopup("Le numéro du nouvel étudiant est déjà attribué.");
			} catch(StudentNotFoundException ex) {
				student = new GraduatedStudent(studentNumber, studentFirstName, studentLastName, studentDepartment, studentDegree);
				this.graduatedClass.add(student);
				this.graduatedClass.notifyObservers();
				this.formPanel.clearAddPanel();
			}

		} else {
			ErrorPopup.promptErrorPopup("Données manquantes pour pouvoir ajouter un étudiant.");
		}
	}
}
