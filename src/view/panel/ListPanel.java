package view.panel;

import view.Window;

import model.GraduatedClass;
import model.GraduatedStudent;
import controller.AbstractController;
import controller.ctl.DelListController;
import controller.obs.Observer;

import javax.swing.DefaultListModel;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;

public class ListPanel extends JInternalFrame implements Observer {
	
	// Class attributes

	public static final int LIST_PAN_WIDTH = Window.WIN_WIDTH - FormPanel.FORM_PAN_WIDTH;

	public static final int LIST_PAN_HEIGHT = Window.WIN_HEIGHT - Window.OUTSET;

	// Attributes

	private GraduatedClass graduatedClass;

	private JList<GraduatedStudent> list;

	private JScrollPane scrollPane;

	private DefaultListModel<GraduatedStudent> model;

	private AbstractController controller;

	// Constructor

	public ListPanel(String title, GraduatedClass graduatedClass) {
		super(title);
		this.setLocation(FormPanel.FORM_PAN_WIDTH, 0);
		this.setSize(ListPanel.LIST_PAN_WIDTH, ListPanel.LIST_PAN_HEIGHT);
		
		this.graduatedClass = graduatedClass;

		this.model = new DefaultListModel<>();
		this.list = new JList<>(model);
		this.scrollPane = new JScrollPane(this.list);
		
		this.addElements();
		this.update();
	}

	private void addElements() {

		this.list.setLayoutOrientation(JList.VERTICAL);

		JButton deleteButton = new JButton("Supprimer");

		this.getContentPane().setLayout(new BorderLayout());
		this.add(this.scrollPane, BorderLayout.CENTER);
		this.add(deleteButton, BorderLayout.SOUTH);

		// Actions

		deleteButton.addActionListener(new DeleteStudentListener());
	}

	@Override
	public void update() {
		
		this.model.clear();
		
		this.graduatedClass.getData().forEach((student) -> {
			model.insertElementAt(student, 0);
		});

		this.repaint();
	}

	private class DeleteStudentListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {

			controller = new DelListController(graduatedClass);
			ArrayList<String> data = new ArrayList<>();

			data.add(String.valueOf(list.getSelectedValue().getNumber()));

			controller.control(data);
		}
		
	}
}
