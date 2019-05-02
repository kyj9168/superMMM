package view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Debuggable;
import controller.JumpListener;
import controller.JumpThread;
import view.game.CoinController;
import view.game.MarioVO;

public class GamePanel extends JPanel implements JumpListener, Debuggable {
	int mode = MODE_DEBUG;
	/**
	 * 버전
	 */
	String VERSION = "0.1.0";
	/**
	 * 땅바닥의 Y축 (이 이상의 값으로는 주인공의 Y좌표값이 변화하지 않음)
	 */
	int BOTTOM_Y = 423;
	int lastPressedKeyCode = 1;
	/**
	 * 점프를 누른후에 생성되어서 점프동작을 하는 쓰레드
	 */
	JumpThread jumpThread;
	/**
	 * 점프를 하는 캐릭터에 대한 정보를 담고 있는 클래스
	 */
	private JFrame mf;
	private JPanel panel;
	private CoinController coinController;
	private ImageIcon icon;
	private JLabel mario;
	private JLabel back;
	private MarioVO marioVO;
	private List<JLabel> tmpLblCoinList = new ArrayList<>();
	ArrayList<Coin> coins = new ArrayList<Coin>();
	int width;
	int height;

	int x, y, w, h;
	int dx = 0, dy = 0;

	int score;

	Image imgBack, imgPlayer, imgCoin;

	public GamePanel(JFrame mf) {

		this.mf = mf;
		panel = this;
		this.setBounds(0, 0, 1000, 800);

		Toolkit toolkit = Toolkit.getDefaultToolkit();

		imgBack = toolkit.getImage("images/back.jpg");

		imgPlayer = toolkit.getImage("images/mario0.gif");

		imgCoin = toolkit.getImage("images/gold_0000.gif");

		GameThread gThread = new GameThread();
		gThread.start();
		this.setVisible(true);

	}

	@Override

	public void paintComponent(Graphics g) {
		if (width == 0 || height == 0) {
			width = getWidth();

			height = getHeight();

			imgBack = imgBack.getScaledInstance(width, height, Image.SCALE_SMOOTH);

			imgPlayer = imgPlayer.getScaledInstance(40, 40, Image.SCALE_SMOOTH);

			x = width / 2;
			y = height - 100;
			w = 62;
			h = 62;
		}

		g.drawImage(imgBack, 0, 0, this);

		for (Coin t : coins) {
			g.drawImage(t.img, t.x - t.w, t.y - t.h, this);
		}

		g.drawImage(imgPlayer, x - w, y - h, this);

		g.setFont(new Font(null, Font.BOLD, 20));

		g.drawString("Score: " + score, 10, 30);

	}

	public void move() {
		for (int i = coins.size() - 1; i >= 0; i--) {
			Coin t = coins.get(i);
			t.move();

			if (t.isDead) {
				coins.remove(i);
			}
		}
		x += dx;
//		y += dy;
		if (x < w)
			x = w;

		if (x > width - w)
			x = width - w;

		if (y < h)
			y = h;

		if (y > height - h)
			y = height - h;
	}

	public void makeCoin() {

		if (width == 0 || height == 0)
			return;

		Random rnd = new Random();

		int n = rnd.nextInt(15);

		if (n == 0) {
			coins.add(new Coin(imgCoin, width, height));
		}

	}

	public void checkCollision() {

		for (Coin t : coins) {
			int left = t.x - t.w;

			int right = t.x + t.w;

			int top = t.y - t.h;

			int bottom = t.y + t.h;

			if (x > left && x < right && y > top && y < bottom) {

				t.isDead = true; // 충돌했음

				score += 5;

			}

		}

	}

	class GameThread extends Thread {
		@Override
		public void run() {

			while (true) {
				makeCoin();
				move();
				checkCollision();
				repaint();

				try { // 너무 빨리 돌아서 천천히 돌도록

					sleep(20);

				} catch (InterruptedException e) {
				}

			}

		}

	}

	/**
	 * 화면에 그려질때 호출이 됨.
	 */
	/*
	 * public void paint(Graphics g) { super.paint(g); g.drawLine(0, BOTTOM_Y,
	 * this.getWidth(), BOTTOM_Y); g.setColor(Color.black); String info =
	 * "출처: 진수의 병신짓 "; g.drawString(info, 10, 45); g.setColor(Color.blue); String
	 * info2 = "경고 : 바탕화면 한번 클릭하고 프로그램 다시 클릭해야 움직임"; g.drawString(info2, 10, 60);
	 * 
	 * 
	 * Image image = null; image =
	 * Toolkit.getDefaultToolkit().getImage("images/mario0.gif");
	 * 
	 * BufferedImage bi = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
	 * g.drawImage(image, this.character.getX(), this.character.getY(), this);
	 * g.drawImage(bi, this.character.getX(), this.character.getY(), this);
	 * 
	 * }
	 */
	/**
	 * 디버그를 하기 위한 함수 (함수내부에서 릴리즈 모드일경우 표준출력을 하지 않도록 함)
	 */
	public void debug(String s) {
		if (this.mode == MODE_DEBUG)
			System.out.println(s);
	}

	public void background() {
		URL url2 = getClass().getClassLoader().getResource("background_0000.gif");
		back = new JLabel(new ImageIcon(url2));
		back.setBounds(0, 0, 1000, 800);
		this.add(back);

		this.repaint();
	}

	@Override
	public void jumpTimeArrived(int jumpIdx, int jumpy) {
		// TODO Auto-generated method stub

	}

	@Override
	public void jumpTimeEnded() {
		// TODO Auto-generated method stub

	}

}