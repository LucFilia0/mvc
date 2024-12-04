package view.panel;

import javax.swing.BoxLayout;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import controller.AbstractController;
import controller.ctl.AddFormController;
import controller.ctl.DelFormController;
import model.GraduatedClass;

/**
 * The panel from which we can create a new student or remove one from its number.
 * 
 * @author Luc le Manifik
 */
public class FormPanel extends JInternalFrame {

	// Class attributes

	/**
	 * FormPanel Width
	 */
	public static final int FORM_PAN_WIDTH = 900;

	/**
	 * FormPanel height
	 */
	public static final int FORM_PAN_HEIGHT = 130;

	// Attributes

	private JSpinner addStudentNumber;

	private JTextField addStudentFirstName;

	private JTextField addStudentLastName;

	private JComboBox<String> addStudentDegree;

	private JSpinner addStudentDepartment;

	private JSpinner deleteStudentNumber;

	private AbstractController controller;

	private GraduatedClass graduatedClass;

	// Constructor

	/**
	 * Creates a new FormPanel.
	 * @param title The FormPanel title
	 * @param graduatedClass The GraduatedClass that the panel will modify
	 */
	public FormPanel(String title, GraduatedClass graduatedClass) {
		super(title);

		this.graduatedClass = graduatedClass;
		this.setSize(FormPanel.FORM_PAN_WIDTH, FormPanel.FORM_PAN_HEIGHT);

		this.addElements();
	}

	private void addElements() {

		this.getContentPane().setLayout(new BorderLayout());

		JPanel addStudentPanel = new JPanel();
		addStudentPanel.setLayout(new BorderLayout());

		JPanel addStudentLabel = new JPanel();
		addStudentLabel.setLayout(new BoxLayout(addStudentLabel, BoxLayout.X_AXIS));
		
		JPanel addStudentInformationsPanel = new JPanel();
		addStudentInformationsPanel.setLayout(new BoxLayout(addStudentInformationsPanel, BoxLayout.X_AXIS));
		
		JPanel deleteStudentPanel = new JPanel();
		deleteStudentPanel.setLayout(new BorderLayout());

		JPanel deleteStudentLabel = new JPanel();
		deleteStudentLabel.setLayout(new BoxLayout(deleteStudentLabel, BoxLayout.X_AXIS));

		JPanel deleteStudentInformationsPanel = new JPanel();
		deleteStudentInformationsPanel.setLayout(new BorderLayout());

		JPanel deleteStudentInformationsPanel_left = new JPanel();
		deleteStudentInformationsPanel_left.setLayout(new BoxLayout(deleteStudentInformationsPanel_left, BoxLayout.X_AXIS));

		addStudentLabel.add(new JLabel("Ajouter un ancien étudiant :"));

		// SpinnerNumberModel spModel = new SpinnerNumberModel(0, 0, null, 1); // TODO

		this.addStudentNumber 		= new JSpinner(new SpinnerNumberModel(0, 0, null, 1));
		this.addStudentFirstName 	= new JTextField();
		this.addStudentLastName		= new JTextField();
		this.addStudentDegree		= new JComboBox<String>(new String[] {"---", "G", "T", "A", "Pro"});
		this.addStudentDepartment	= new JSpinner(new SpinnerNumberModel(0, 0, null, 1));

		int spinnerWidth	= 50;
		int spinnerHeight	= 20;

		this.addStudentNumber.setPreferredSize(new Dimension(spinnerWidth, spinnerHeight));
		this.addStudentDepartment.setPreferredSize(new Dimension(spinnerWidth, spinnerHeight));

		JButton addStudentButton = new JButton("Ajouter");

		addStudentInformationsPanel.add(new JLabel("Numéro : "));
		addStudentInformationsPanel.add(this.addStudentNumber);
		addStudentInformationsPanel.add(new JLabel("Prénom : "));
		addStudentInformationsPanel.add(this.addStudentFirstName);
		addStudentInformationsPanel.add(new JLabel("Nom : "));
		addStudentInformationsPanel.add(this.addStudentLastName);
		addStudentInformationsPanel.add(new JLabel("Bac : "));
		addStudentInformationsPanel.add(this.addStudentDegree);
		addStudentInformationsPanel.add(new JLabel("Département : "));
		addStudentInformationsPanel.add(this.addStudentDepartment);
		addStudentInformationsPanel.add(addStudentButton);

		addStudentPanel.add(addStudentLabel, BorderLayout.NORTH);
		addStudentPanel.add(addStudentInformationsPanel, BorderLayout.SOUTH);

		deleteStudentLabel.add(new JLabel("Supprimer un ancien étudiant : "));

		this.deleteStudentNumber = new JSpinner(new SpinnerNumberModel(0, 0, null, 1));

		JButton deleteStudentButton = new JButton("Supprimer");

		deleteStudentInformationsPanel_left.add(new JLabel("Numéro : "));
		deleteStudentInformationsPanel_left.add(this.deleteStudentNumber);

		deleteStudentInformationsPanel.add(deleteStudentInformationsPanel_left, BorderLayout.WEST);
		deleteStudentInformationsPanel.add(deleteStudentButton, BorderLayout.EAST);

		this.deleteStudentNumber.setPreferredSize(new Dimension(spinnerWidth, spinnerHeight));

		deleteStudentPanel.add(deleteStudentLabel, BorderLayout.NORTH);
		deleteStudentPanel.add(deleteStudentInformationsPanel, BorderLayout.SOUTH);

		this.getContentPane().add(addStudentPanel, BorderLayout.NORTH);
		this.getContentPane().add(deleteStudentPanel, BorderLayout.SOUTH);

		// Actions

		addStudentButton.addActionListener(new AddStudentListener(this));

		deleteStudentButton.addActionListener(new DeleteStudentListener(this));
	}

	/**
	 * Clears the 'adding student' part's inputs.
	 */
	public void clearAddPanel() {
		this.addStudentNumber.setValue(0);
		this.addStudentFirstName.setText("");
		this.addStudentLastName.setText("");
		this.addStudentDegree.setSelectedIndex(0);
		this.addStudentDepartment.setValue(0);
		this.repaint();
	}

	/**
	 * Clears the 'deleting student' part's inputs
	 */
	public void clearDelPanel() {
		this.deleteStudentNumber.setValue(0);
		this.repaint();
	}

	/**
	 * Intern class which implements ActionListener, performs when the Add button is pressed.
	 */
	private class AddStudentListener implements ActionListener {

		// Attributes

		/**
		 * The FormPanel to modify once the action is performed.
		 */
		private FormPanel formPanel;

		// Constructor

		/**
		 * Creates a new AddStudentListener.
		 * @param formPanel The FormPanel to modify once the action is performed
		 */
		AddStudentListener(FormPanel formPanel) {
			this.formPanel = formPanel;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			controller = new AddFormController(graduatedClass, formPanel);
			ArrayList<String> data = new ArrayList<>();

			data.add(String.valueOf(addStudentNumber.getValue()));
			data.add(addStudentFirstName.getText());
			data.add(addStudentLastName.getText());
			data.add(addStudentDegree.getSelectedItem().toString());
			data.add(String.valueOf(addStudentDepartment.getValue()));
			
			controller.control(data);
		}
		
	}

	/**
	 * Intern class which implements ActionListener, performed when the Delete button is pressed.
	 */
	private class DeleteStudentListener implements ActionListener {

		// Attributes

		/**
		 * The FormPanel to update once the action is performed.
		 */
		private FormPanel formPanel;

		// Constructor

		/**
		 * Creates a new DeleteStudentListener.
		 * @param formPanel The FormPanel to update once the action is performed
		 */
		DeleteStudentListener(FormPanel formPanel) {
			this.formPanel = formPanel;
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			controller = new DelFormController(graduatedClass, formPanel);
			ArrayList<String> data = new ArrayList<>();

			data.add(String.valueOf(deleteStudentNumber.getValue()));

			controller.control(data);
		}

	}
}
