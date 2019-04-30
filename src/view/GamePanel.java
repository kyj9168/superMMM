package view;

import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import view.game.CoinController;
import view.game.CoinVO;

public class GamePanel extends JPanel {
	CoinController coinController;
	ImageIcon icon;
	private MainFrame mf;
	private JPanel op;

	public GamePanel(MainFrame mf) {
		coinController = new CoinController();
		
		this.mf = mf;
		this.op = this;
		this.setVisible(true);
		this.setLayout(null);

		JLabel label = new JLabel(
				new ImageIcon(new ImageIcon("images/gamebackground.jpg").getImage().getScaledInstance(1000, 800, 0)));
		label.setBounds(0, 0, 1000, 800);

		this.setSize(1000, 800);
	}
	
	public void playGame() {
		int playTimes = 0;
		while(playTimes < 10000) {
			try {
				Thread.sleep(300);
				
				drawCoin();
				playTimes += 300;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	// 현재 존재하는 코인들을 그려줌
	public void drawCoin() {
		coinController.addCoin();
		List<CoinVO> coinList = coinController.getCoinList();
		this.removeAll();
		
		for (CoinVO coinVO : coinList) {
			String imgPath = (coinVO.getCoinType()=='Y')? "images/gold_0000.gif" : "images/gold_0000.gif";
			
			JLabel lblCoin = new JLabel();
			Image coin = new ImageIcon( imgPath ).getImage().getScaledInstance(50, 50, 0);
			lblCoin.setIcon(new ImageIcon(coin));
			lblCoin.setBounds(coinVO.getCoinX(), coinVO.getCoinY(), 50, 50);

			this.add(lblCoin);
			this.remove(lblCoin);
		}
	}

}
