package view.panel;

import javax.swing.JInternalFrame;

import model.GraduatedClass;
import view.Window;

public class PieChartPanel extends JInternalFrame {
	
	// Class attributes

	public static final int PIECHART_PAN_WIDTH = 450;

	public static final int PIECHART_PAN_HEIGHT = Window.WIN_HEIGHT - FormPanel.FORM_PAN_HEIGHT;

	// Attributes

	private GraduatedClass graduatedClass;

	// Constructor

	public PieChartPanel(String title, GraduatedClass graduatedClass) {
		super(title);
		this.setSize(PieChartPanel.PIECHART_PAN_WIDTH, PieChartPanel.PIECHART_PAN_HEIGHT);
		this.setLocation(0, FormPanel.FORM_PAN_HEIGHT);

		this.graduatedClass = graduatedClass;
	}
}
