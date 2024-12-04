package view.panel;

import javax.swing.JInternalFrame;

import model.GraduatedClass;

import view.Window;

import controller.obs.Observer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class HistogramPanel extends JInternalFrame implements Observer {

	private class Histogram extends ChartPanel {

		// Constructor

		Histogram(String title, DefaultCategoryDataset dataset) {
			super(ChartFactory.createBarChart(title, "Bac", "Nombre", dataset, PlotOrientation.VERTICAL, true, false, false));
		}
	}
	
	// Class attributes

	public static final int HISTOGRAM_PAN_WIDTH = Window.WIN_WIDTH - PieChartPanel.PIECHART_PAN_WIDTH - ListPanel.LIST_PAN_WIDTH;

	public static final int HISTOGRAM_PAN_HEIGHT = Window.WIN_HEIGHT - FormPanel.FORM_PAN_HEIGHT - Window.OUTSET;

	// Attributes

	private GraduatedClass graduatedClass;

	private DefaultCategoryDataset dataset;

	// Count

	private int t_count;

	private int g_count;

	private int a_count;

	private int pro_count;

	// Constructor

	public HistogramPanel(String title, GraduatedClass graduatedClass) {
		super(title);
		this.setSize(HistogramPanel.HISTOGRAM_PAN_WIDTH, HistogramPanel.HISTOGRAM_PAN_HEIGHT);
		this.setLocation(PieChartPanel.PIECHART_PAN_WIDTH, FormPanel.FORM_PAN_HEIGHT);

		this.graduatedClass = graduatedClass;
		this.dataset = new DefaultCategoryDataset();

		this.update();
	}

	@Override
	public void update() {

		this.dataset.clear();

		this.t_count = 0;
		this.g_count = 0;
		this.a_count = 0;
		this.pro_count = 0;
		
		this.graduatedClass.getData().forEach( (student) -> {
			switch(student.getDegree().toUpperCase()) {
				case "G" 	: ++this.g_count; break;
				case "T" 	: ++this.t_count; break;
				case "A" 	: ++this.a_count; break;
				case "PRO" 	: ++this.pro_count; break;
				default 	: break;
			}
		});

		this.dataset.setValue(this.g_count, "G", " ");
		this.dataset.setValue(this.t_count, "T", " ");
		this.dataset.setValue(this.a_count, "A", " ");
		this.dataset.setValue(this.pro_count, "Pro", " ");

		this.add(new Histogram(this.title, this.dataset));
	}
}
