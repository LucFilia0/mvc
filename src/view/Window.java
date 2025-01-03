package view;

import javax.swing.JFrame;

import model.GraduatedClass;

import javax.swing.JDesktopPane;

import view.panel.FormPanel;
import view.panel.HistogramPanel;
import view.panel.ListPanel;
import view.panel.PieChartPanel;

public class Window extends JFrame {

	// Class variables

	public static final int WIN_WIDTH = 1200;

	public static final int WIN_HEIGHT = 600;

	public static final int OUTSET = 25;

	// Attributes

	private FormPanel		formPanel;

	private HistogramPanel 	histogramPanel;

	private ListPanel 		listPanel;

	private PieChartPanel 	pieChartPanel;

	// Constructor

	public Window(String title, GraduatedClass graduatedClass) {

		// Window's parameters
		this.setTitle(title);
		this.setSize(Window.WIN_WIDTH, Window.WIN_HEIGHT);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);

		// Panels
		this.formPanel		= new FormPanel("Saisie d'anciens étudiants", graduatedClass);
		this.histogramPanel = new HistogramPanel("Bac d'origine", graduatedClass);
		this.listPanel 		= new ListPanel("Liste des anciens étudiants", graduatedClass);
		this.pieChartPanel 	= new PieChartPanel("Départements d'origine", graduatedClass);

		graduatedClass.addObserver(this.histogramPanel);
		graduatedClass.addObserver(this.listPanel);
		graduatedClass.addObserver(this.pieChartPanel);

		this.addElements();
	}

	private void addElements() {

		JDesktopPane desktop = new JDesktopPane();

		this.formPanel.setVisible(true);
		this.histogramPanel.setVisible(true);
		this.listPanel.setVisible(true);
		this.pieChartPanel.setVisible(true);
		
		desktop.add(this.formPanel);
		desktop.add(this.histogramPanel);
		desktop.add(this.listPanel);
		desktop.add(this.pieChartPanel);

		this.setContentPane(desktop);
	}

	// Getters

	public FormPanel getFormPanel() {
		return this.formPanel;
	}

	public HistogramPanel getHistogramPanel() {
		return this.histogramPanel;
	}

	public ListPanel getListPanel() {
		return this.listPanel;
	}

	public PieChartPanel getPieChartPanel() {
		return this.pieChartPanel;
	}
}
