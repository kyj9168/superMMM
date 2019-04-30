package view;

import java.awt.Image;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import view.game.CoinController;
import view.game.CoinVO;
import view.game.MarioVO;

public class MainFrame extends JFrame{
	CoinController coinController;
	MarioVO marioVO;
	List<JLabel> tmpLblCoinList = new ArrayList<>();
	
	public MainFrame(){}

	public void startMainFrame() {
		this.setTitle("super.Mario");
		this.setBounds(200, 100, 1000, 800);
	
		setIconImage(Toolkit.getDefaultToolkit().getImage("images/icon.png"));
		
		new BackgroundPanel(this);
		
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
}
