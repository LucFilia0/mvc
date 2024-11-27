package view.panel;

import javax.swing.JInternalFrame;

import model.GraduatedClass;
import view.Window;

public class HistogramPanel extends JInternalFrame {
	
	// Class attributes

	public static final int HISTOGRAM_PAN_WIDTH = Window.WIN_WIDTH - PieChartPanel.PIECHART_PAN_WIDTH - ListPanel.LIST_PAN_WIDTH;

	public static final int HISTOGRAM_PAN_HEIGHT = Window.WIN_HEIGHT - FormPanel.FORM_PAN_HEIGHT;

	// Attributes

	private GraduatedClass graduatedClass;

	// Constructor

	public HistogramPanel(String title, GraduatedClass graduatedClass) {
		super(title);
		this.setSize(HistogramPanel.HISTOGRAM_PAN_WIDTH, HistogramPanel.HISTOGRAM_PAN_HEIGHT);
		this.setLocation(PieChartPanel.PIECHART_PAN_WIDTH, FormPanel.FORM_PAN_HEIGHT);

		this.graduatedClass = graduatedClass;
	}
}
