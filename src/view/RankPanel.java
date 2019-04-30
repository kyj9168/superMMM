package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RankPanel extends JPanel{
	private MainFrame mf;
	private JPanel op;
	
	public RankPanel(MainFrame mf) {
		
		this.mf = mf;
		this.op = this;
		this.setLayout(null);
		
		this.setBounds(300, 200, 1000, 800);
		
		JLabel label = new JLabel(
				new ImageIcon(new ImageIcon("images/ranking.jpg").getImage().getScaledInstance(1000, 800, 0)));
		label.setBounds(0, 0, 1000, 800);
			
		JButton home = new JButton(new ImageIcon(new ImageIcon("images/home2.PNG").getImage().getScaledInstance(50, 50, 0)));
		home.setBounds(30,30,50,50);
		home.setOpaque(false);
		home.setContentAreaFilled(false);
		home.setBorderPainted(false);
		
		home.addActionListener(new ActionListener() {

	          @Override
	          public void actionPerformed(ActionEvent e) {
	             ChangePanel.changePanel(mf, op, new todayCoin(mf));
	          }
	       });
	       this.add(home);

		JPanel panel = new JPanel();
		panel.setSize(1000,800);
			
		panel.setLayout(null);
			
		panel.add(home);
		panel.add(label);
			
		this.add(panel);
		mf.add(this);
	}
	
	public void printRank() {
		
	}
}
