package view.panel;

import javax.swing.BoxLayout;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
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

public class FormPanel extends JInternalFrame {

	// Class attributes

	public static final int FORM_PAN_WIDTH = 900;

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

		this.addStudentNumber 		= new JSpinner();
		this.addStudentFirstName 	= new JTextField();
		this.addStudentLastName		= new JTextField();
		this.addStudentDegree		= new JComboBox<String>(new String[] {"---", "G", "T", "A", "Pro"});
		this.addStudentDepartment	= new JSpinner();

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

		this.deleteStudentNumber = new JSpinner();

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

		addStudentButton.addActionListener(new AddStudentListener());

		deleteStudentButton.addActionListener(new DeleteStudentListener());
	}

	private class AddStudentListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			controller = new AddFormController(graduatedClass);
			ArrayList<String> data = new ArrayList<>();

			data.add(String.valueOf(addStudentNumber.getValue()));
			data.add(addStudentFirstName.getText());
			data.add(addStudentLastName.getText());
			data.add(addStudentDegree.getSelectedItem().toString());
			data.add(String.valueOf(addStudentDepartment.getValue()));
			
			controller.control(data);
		}
		
	}

	private class DeleteStudentListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			controller = new DelFormController(graduatedClass);
			ArrayList<String> data = new ArrayList<>();

			data.add(String.valueOf(deleteStudentNumber.getValue()));

			controller.control(data);
		}

	}
}
