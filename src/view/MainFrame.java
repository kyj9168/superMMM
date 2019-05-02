package view;

import java.awt.Toolkit;

import javax.swing.JFrame;

import view.GamePanel.GameThread;

public class MainFrame extends JFrame {

	Character character;

	public MainFrame() {
		this.setTitle("super.Mario");
		this.setBounds(200, 100, 1000, 800);

		setIconImage(Toolkit.getDefaultToolkit().getImage("images/icon.png"));

		this.add(new BackgroundPanel(this));

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		

	}

}
