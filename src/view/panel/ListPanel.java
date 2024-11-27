package view.panel;
import view.Window;

import model.GraduatedClass;
import model.GraduatedStudent;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JScrollBar;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class ListPanel extends JInternalFrame {
	
	// Class attributes

	public static final int LIST_PAN_WIDTH = Window.WIN_WIDTH - FormPanel.FORM_PAN_WIDTH;

	public static final int LIST_PAN_HEIGHT = Window.WIN_HEIGHT;

	// Attributes

	private GraduatedClass graduatedClass;

	private JList<GraduatedStudent> list;

	// Constructor

	public ListPanel(String title, GraduatedClass graduatedClass) {
		super(title);
		this.setSize(ListPanel.LIST_PAN_WIDTH, ListPanel.LIST_PAN_HEIGHT);
		this.setLocation(FormPanel.FORM_PAN_WIDTH, 0);

		this.graduatedClass = graduatedClass;

		this.addElements();
	}

	private void addElements() {

		// Vector<GraduatedStudent> vector = new Vector<>();
		DefaultListModel<GraduatedStudent> model = new DefaultListModel<>();
		
		this.graduatedClass.getData().forEach((student) -> {
			model.addElement(student);
		});

		this.list = new JList<>(model);
		this.list.setLayoutOrientation(JList.VERTICAL);

		JScrollPane scrollPane = new JScrollPane(this.list);

		JButton deleteButton = new JButton("Supprimer");

		this.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		this.add(scrollPane, gbc);
		gbc.gridy = 4;
		this.add(deleteButton, gbc);

		// TODO Faire le ptn de grisbagconstraint
	}
}
