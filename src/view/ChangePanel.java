package view;

import javax.swing.JPanel;

public class ChangePanel {
	
	public static void changePanel(MainFrame mf, JPanel op, JPanel np){
		mf.remove(op);
		mf.add(np);
		mf.repaint();
	}
}
