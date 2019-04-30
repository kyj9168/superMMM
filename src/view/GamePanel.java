package view;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import view.game.CoinController;
import view.game.CoinVO;
import view.game.MarioVO;

public class GamePanel extends JPanel {
	CoinController coinController;
	ImageIcon icon;
	private MainFrame mf;
	private JPanel op;

	MarioVO marioVO;
	List<JLabel> tmpLblCoinList = new ArrayList<>();

	public GamePanel(MainFrame mf) {
		coinController = new CoinController();

		this.mf = mf;
		this.op = this;
		this.setVisible(true);
		this.setLayout(null);

		JLabel label = new JLabel(
				new ImageIcon(new ImageIcon("images/background_0000.png").getImage().getScaledInstance(1000, 800, 0)));
		label.setBounds(0, 0, 1000, 800);

		this.add(label);
		this.setSize(1000, 800);
		game();
		
	}



	public void game() {


		coinController = new CoinController();
		marioVO = new MarioVO();

		this.setVisible(true);
		this.setLayout(null);

		JLabel label = new JLabel(
				new ImageIcon(new ImageIcon("images/background_0000.png").getImage().getScaledInstance(1000, 800, 0)));
		label.setBounds(0, 0, 1000, 800);
		this.setSize(1000, 800);



		this.setVisible(true);


		this.repaint();
		this.playGame();
	}


	public void playGame() {
		coinController = new CoinController();
		int playTimes = 0;
		boolean isJumping = true;
		while(playTimes < 10000) {
			try {
				Thread.sleep(10);

				coinController.moveToX(5);
				if(playTimes % 10 == 0)
					coinController.addCoin();
				drawCoin();

				if(isJumping) { // 점핑
					if(playTimes % 3 == 0) {
						marioVO.setVector(marioVO.getVector()+1);
					}
					isJumping = drawMario(4, true);
				}
				else { // 걷기
					isJumping = drawMario( ( playTimes / 5 ) % 4, false );
				}

				if(playTimes % 1000 == 0)
					isJumping = true;

				playTimes += 1;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// 현재 존재하는 코인들을 그려줌
	public void drawCoin() {
		List<CoinVO> coinList = coinController.getCoinList();

		// 원래꺼 지워주기
		for (JLabel tmpLblCoin : tmpLblCoinList) {
			this.remove(tmpLblCoin);
		}

		for (CoinVO coinVO : coinList) {
			int imagePathIndex =  coinList.size()%3;
			String imgPath = (coinVO.getCoinType()=='y')? CoinVO.getImagePathArr()[imagePathIndex] : CoinVO.getImagePathArr2()[imagePathIndex];

			JLabel lblCoin = new JLabel();
			Image coin = new ImageIcon( imgPath ).getImage().getScaledInstance(50, 50, 0);
			lblCoin.setIcon(new ImageIcon(coin));
			lblCoin.setBounds(coinVO.getCoinX(), coinVO.getCoinY(), 50, 50);
			this.add(lblCoin);
			tmpLblCoinList.add(lblCoin);


		}

		this.repaint();
	}



	// 마리오를 그려줌
	public boolean drawMario(int imagePathIndex, boolean isJumping) {
		boolean jumpResult = marioVO.moveMario(isJumping);
		String imgPath = marioVO.getImagePathArr()[imagePathIndex];

		JLabel lblMario = new JLabel();
		Image coin = new ImageIcon( imgPath ).getImage().getScaledInstance(50, 50, 0);
		lblMario.setIcon(new ImageIcon(coin));
		lblMario.setBounds(marioVO.getMarioX(), marioVO.getMarioY(), 50, 50);
		this.add(lblMario);
		tmpLblCoinList.add(lblMario);

		this.repaint();

		return jumpResult;
	}
}

