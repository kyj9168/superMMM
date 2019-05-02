package view;

import java.awt.Color;
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
	private ImageIcon icon;
	private JLabel mario;
	private JLabel back;
	ArrayList<Coin> coins = new ArrayList<Coin>();
	ArrayList<PinkCoin> pinkCoins = new ArrayList<PinkCoin>();
	ArrayList<Bomb> bombs = new ArrayList<Bomb>();
	
	int width;
	int height;

	int coinCtn = 0;

	int x, y, w, h;
	int dx = 0, dy = 0;

	int score;

	Image imgBack, imgPlayer, imgCoin, imgPinkCoin, imgBomb;

	public GamePanel(JFrame mf) {

		this.mf = mf;
		panel = this;
		this.setBounds(0, 0, 1000, 800);

		MainFrame.Sound("audio/GameOver.wav", true);

		Toolkit toolkit = Toolkit.getDefaultToolkit();

		imgBack = toolkit.getImage("images/back.jpg");

		imgPlayer = toolkit.getImage("images/mario.png");

		imgCoin = toolkit.getImage("images/gold_0000.gif");
		
		imgPinkCoin = toolkit.getImage("images/pink03.gif");
		
		imgBomb = toolkit.getImage("images/bomb.png");
		

		GameThread gThread = new GameThread();
		gThread.start();
		this.setVisible(true);

	}

	@Override

	public void paintComponent(Graphics g) {

		if (width == 0 || height == 0) {
			width = getWidth();

			height = getHeight();

			imgBack = imgBack.getScaledInstance(width, height, Image.SCALE_DEFAULT);

			imgPlayer = imgPlayer.getScaledInstance(200, 200, Image.SCALE_DEFAULT);

			x = width / 2;
			y = height - 123;
			w = 100;
			h = 100;
		}

		g.drawImage(imgBack, 0, 0, this);

		for (Coin t : coins) {
			g.drawImage(t.img, t.x - t.w, t.y - t.h, this);
		}
		for (PinkCoin p : pinkCoins) {
			g.drawImage(p.img, p.x - p.w, p.y - p.h, this);
		}
		for (Bomb b : bombs) {
			g.drawImage(b.img, b.x - b.w, b.y - b.h, this);
		}

		g.drawImage(imgPlayer, x - w, y - h, this);

		g.setFont(new Font(null, Font.BOLD, 20));

		g.drawString("Score: " + score, 10, 50);

		String info = " 주의 : 캐릭터를 움직이려면 바탕화면을 한번 클릭했다 다시 돌아오세요";
		g.setColor(Color.RED);
		g.setFont(new Font("함초롱돋움", Font.BOLD, 13));
		g.drawString(info, 10, 80);

		String info2 = "진지하니까 궁서체입니다.";
		g.setColor(Color.RED);
		g.setFont(new Font("궁서", Font.BOLD | Font.ITALIC, 13));
		g.drawString(info2, 10, 100);

	}

	public void move() {
		for (int i = coins.size() - 1; i >= 0; i--) {
			Coin t = coins.get(i);
			t.move();

			if (t.isDead) {
				coins.remove(i);
			}
		}
		for (int i = pinkCoins.size() - 1; i >= 0; i--) {
			PinkCoin p = pinkCoins.get(i);
			p.move();
			
			if (p.isDead) {
				pinkCoins.remove(i);
			}
		}
		for (int i = bombs.size() - 1; i >= 0; i--) {
			Bomb b = bombs.get(i);
			b.move();
			
			if (b.isDead) {
				bombs.remove(i);
			}
		}
		x += dx;
		// y += dy;

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

		int n = rnd.nextInt(22);

		if (n == 0) {
			coins.add(new Coin(imgCoin, width, height));
			coinCtn++;
		}

		Random rndo = new Random();

		int n1 = rndo.nextInt(30);

		if (n1 == 0) {
			pinkCoins.add(new PinkCoin(imgPinkCoin, width, height));
			coinCtn++;
		}
		Random rndom = new Random();
		
		int n2 = rndom.nextInt(30);
		
		if (n2 == 0) {
			bombs.add(new Bomb(imgBomb, width, height));
			coinCtn++;
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

				MainFrame.Sound("audio/Coin.wav", false);

				score += 5;

			}

		}
		for (PinkCoin p : pinkCoins) {
			int left = p.x - p.w;
			
			int right = p.x + p.w;
			
			int top = p.y - p.h;
			
			int bottom = p.y + p.h;
			
			if (x > left && x < right && y > top && y < bottom) {
				
				p.isDead = true; // 충돌했음
				
				MainFrame.Sound("audio/Coin.wav", false);
				
				score += 50;
				
			}
			
		}
		for (Bomb b : bombs) {
			int left = b.x - b.w;
			
			int right = b.x + b.w;
			
			int top = b.y - b.h;
			
			int bottom = b.y + b.h;
			
			if (x > left && x < right && y > top && y < bottom) {
				
				b.isDead = true; // 충돌했음
				
				MainFrame.Sound("audio/Coin.wav", false);
				
				score -= 50;
				
			}
			
		}
	}

	class GameThread extends Thread {
		@Override
		public void run() {
			JLabel label = new JLabel("남은시간 : ");
			label.setBounds(850, 0, 150, 50);
			label.setFont(new Font("Sanscerif", Font.BOLD, 20));
			panel.add(label);
			for (int i = 1200; i >= 0; i--) {

				try { // 너무 빨리 돌아서 천천히 돌도록
					System.out.println(i);
					label.setText("남은시간 : " + (i / 40));

					makeCoin();
					move();
					checkCollision();
					repaint();

					sleep(25);

				} catch (InterruptedException e) {
				}

			}
			ChangePanel cp = new ChangePanel(mf, panel);
			gameEnd sp = new gameEnd(mf);
			cp.replacePanel(sp);
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