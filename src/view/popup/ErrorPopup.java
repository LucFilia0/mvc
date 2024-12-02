package view.popup;

import javax.swing.JOptionPane;

public class ErrorPopup {

	public static void promptErrorPopup(String message) {
		// ep.setVisible(true);
		JOptionPane.showMessageDialog(null, message);
	}
}
