package view.panel;

import javax.swing.JInternalFrame;

import model.GraduatedClass;

import view.Window;

import controller.obs.Observer;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.SortOrder;


public class PieChartPanel extends JInternalFrame implements Observer {

	private class PieChart extends ChartPanel {

		// Constructor

		PieChart(String title, DefaultPieDataset dataset) {
			super(ChartFactory.createPieChart3D(title, dataset));
		}
	}
	
	// Class attributes

	public static final int PIECHART_PAN_WIDTH = 500;

	public static final int PIECHART_PAN_HEIGHT = Window.WIN_HEIGHT - FormPanel.FORM_PAN_HEIGHT - Window.OUTSET;

	// Attributes

	private GraduatedClass graduatedClass;

	private DefaultPieDataset dataset;

	// Constructor

	public PieChartPanel(String title, GraduatedClass graduatedClass) {
		super(title);
		this.setSize(PieChartPanel.PIECHART_PAN_WIDTH, PieChartPanel.PIECHART_PAN_HEIGHT);
		this.setLocation(0, FormPanel.FORM_PAN_HEIGHT);

		this.graduatedClass = graduatedClass;
		this.dataset = new DefaultPieDataset();

		this.update();
	}

	@Override
	public void update() {

		this.dataset.clear();
		
		this.graduatedClass.getData().forEach( (student) -> {

			String key = String.valueOf(student.getDepartment());

			try {
				double value = (double)this.dataset.getValue(key);
				this.dataset.setValue(key, value + 1);
			} catch(Exception e) {
				this.dataset.setValue(key, 1);
			}
		});

		this.dataset.sortByKeys(SortOrder.ASCENDING);
		
		this.add(new PieChart(this.title, this.dataset));
	}
}
