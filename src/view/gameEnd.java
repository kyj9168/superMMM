package view;


import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class gameEnd extends JPanel{
	ImageIcon icon;
	private JTextField nameField;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField hpField;
	private MainFrame mf;
	private JPanel op;
	
	public gameEnd(MainFrame mf) {
		this.mf = mf;
		this.op = this;
		
		this.setLayout(null);


		JLabel label = new JLabel(
				new ImageIcon(new ImageIcon("images/gamebackground.jpg").getImage().getScaledInstance(1000, 800, 0)));
		label.setBounds(0, 0, 1000, 800);

		JLabel lblAd = new JLabel();
		Image ad = new ImageIcon("images/ad.PNG").getImage().getScaledInstance(500, 100, 0);
		lblAd.setIcon(new ImageIcon(ad));
		lblAd.setBounds(250, 0, 600, 100);

		JLabel lblCoin = new JLabel();
		Image coin = new ImageIcon("images/gold_0000.gif").getImage().getScaledInstance(100, 80, 0);
		lblCoin.setIcon(new ImageIcon(coin));
		lblCoin.setBounds(330, 200, 200, 100);
		this.add(lblCoin);
		
		JLabel lblGain = new JLabel("X 26");
		lblGain.setBounds(480, 220, 320, 50);
		this.add(lblGain);
		lblGain.setForeground(Color.WHITE);
		lblGain.setFont(lblGain.getFont().deriveFont(35.0f));
		
		
		JLabel lblText = new JLabel("광고 시청시 현재 얻은 코인 X 2");
		lblText.setBounds(280, 370, 380, 50);
		this.add(lblText);
		lblText.setForeground(Color.WHITE);
		lblText.setFont(lblText.getFont().deriveFont(25.0f));


		JButton jRetry = new JButton();
		Image retry = new ImageIcon("images/retry.png").getImage().getScaledInstance(200, 60, 0);
		jRetry.setIcon(new ImageIcon(retry));
		jRetry.setBounds(200, 450, 300, 200);
		jRetry.setOpaque(false);
		jRetry.setContentAreaFilled(false);
		jRetry.setBorderPainted(false);
		this.add(jRetry);

		
		JButton jMain = new JButton();
		Image main = new ImageIcon("images/main.png").getImage().getScaledInstance(200, 60, 0);
		jMain.setIcon(new ImageIcon(main));
		jMain.setBounds(550, 450, 300, 200);
		jMain.setOpaque(false);
		jMain.setContentAreaFilled(false);
		jMain.setBorderPainted(false);
		this.add(jMain);

		
		this.add(lblAd);
		this.add(label);
		this.setSize(1000, 800);
		this.setVisible(true);
	}
}
