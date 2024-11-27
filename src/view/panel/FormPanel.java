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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPanel extends JInternalFrame {

	// Class attributes

	public static final int FORM_PAN_WIDTH = 900;

	public static final int FORM_PAN_HEIGHT = 150;

	// Attributes

	private JSpinner addStudentNumber;

	private JTextField addStudentFirstName;

	private JTextField addStudentLastName;

	private JComboBox<String> addStudentDegree;

	private JSpinner addStudentDepartment;

	private JSpinner deleteStudentNumber;

	// Constructor

	public FormPanel(String title) {
		super(title);
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
		deleteStudentInformationsPanel.setLayout(new BoxLayout(deleteStudentInformationsPanel, BoxLayout.X_AXIS));

		addStudentLabel.add(new JLabel("Ajouter un ancien étudiant :"));

		this.addStudentNumber 		= new JSpinner();
		this.addStudentFirstName 	= new JTextField();
		this.addStudentLastName		= new JTextField();
		this.addStudentDegree		= new JComboBox<String>(new String[] {"---", "G", "T", "A", "Pro"});
		this.addStudentDepartment	= new JSpinner();

		JButton addStudentButton = new JButton("Ajouter");

		addStudentInformationsPanel.add(new JLabel("Numéro :"));
		addStudentInformationsPanel.add(this.addStudentNumber);
		addStudentInformationsPanel.add(new JLabel("Prénom :"));
		addStudentInformationsPanel.add(this.addStudentFirstName);
		addStudentInformationsPanel.add(new JLabel("Nom :"));
		addStudentInformationsPanel.add(this.addStudentLastName);
		addStudentInformationsPanel.add(new JLabel("Bac :"));
		addStudentInformationsPanel.add(this.addStudentDegree);
		addStudentInformationsPanel.add(new JLabel("Département :"));
		addStudentInformationsPanel.add(this.addStudentDepartment);
		addStudentInformationsPanel.add(addStudentButton);

		addStudentPanel.add(addStudentLabel, BorderLayout.NORTH);
		addStudentPanel.add(addStudentInformationsPanel, BorderLayout.SOUTH);

		deleteStudentLabel.add(new JLabel("Supprimer un ancien étudiant :"));

		this.deleteStudentNumber = new JSpinner();

		JButton deleteStudentButton = new JButton("Supprimer");

		deleteStudentInformationsPanel.add(new JLabel("Numéro"));
		deleteStudentInformationsPanel.add(this.deleteStudentNumber);
		deleteStudentInformationsPanel.add(deleteStudentButton);

		deleteStudentPanel.add(deleteStudentLabel, BorderLayout.NORTH);
		deleteStudentPanel.add(deleteStudentInformationsPanel, BorderLayout.SOUTH);

		this.getContentPane().add(addStudentPanel, BorderLayout.NORTH);
		this.getContentPane().add(deleteStudentPanel, BorderLayout.SOUTH);

		// Actions

		addStudentButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO
			}
			
		});

		deleteStudentButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO
			}
			
		});
	}
}
