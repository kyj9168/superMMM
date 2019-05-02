package view.game;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import view.Character;
import view.GamePanel;
import view.MainFrame;

public class PlayGame extends Thread {
	CoinController coinController = new CoinController();;
	private JFrame mf;
	private JPanel panel;
	GamePanel gamePanel = new GamePanel(mf);
	Character character;

	List<JLabel> tmpLblCoinList = new ArrayList<>();

	public PlayGame(JFrame mf, JPanel panel) {

		this.mf = mf;
		this.panel = panel;

	}

	@Override
	public void run() {
		while (true) {

			System.out.println("PG.run");
			try {
				Thread.sleep(10);
				mf.repaint();
				// coinController.moveToX(5);
				coinController.addCoin();
//				gamePanel.drawCoin();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}