package view;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import view.GamePanel.GameThread;

public class todayCoin extends JPanel {

	ImageIcon icon;
	private JFrame mf;
	private JPanel panel;

	public todayCoin(JFrame mf) {
		this.mf = mf;
		panel = this;

		this.setVisible(true);
		this.setLayout(null);

		JLabel label = new JLabel(
				new ImageIcon(new ImageIcon("images/bakground.png").getImage().getScaledInstance(1250, 800, 0)));
		label.setBounds(0, 0, 1250, 800);

		JLabel lblUser = new JLabel("0000님");
		lblUser.setBounds(10, 0, 250, 200);
		this.add(lblUser);
		lblUser.setForeground(Color.WHITE);
		lblUser.setFont(lblUser.getFont().deriveFont(30.0f));

		JButton lblStart = new JButton();
		Image start = new ImageIcon("images/start.png").getImage().getScaledInstance(150, 60, 0);
		lblStart.setIcon(new ImageIcon(start));
		lblStart.setBounds(200, 570, 250, 200);
		lblStart.setOpaque(false);
		lblStart.setContentAreaFilled(false);
		lblStart.setBorderPainted(false);
		this.add(lblStart);

		lblStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel cp = new ChangePanel(mf, panel);
				GamePanel gamePanel = new GamePanel(mf);

				// PlayGame pg = new PlayGame(mf, gamePanel);
				// Thread t1 = pg;
				// pg.run();
				// t1.start();

				mf.addKeyListener(new KeyListener() {

					@Override

					public void keyTyped(KeyEvent e) {

						// TODO Auto-generated method stub

					}

					@Override

					public void keyReleased(KeyEvent e) {

						// 눌러진 키가 무엇인지 알아내기

						int keyCode = e.getKeyCode();

						switch (keyCode) {

						case KeyEvent.VK_LEFT:

							gamePanel.dx = 0; // 원랜 getsetter 만들어야함

							break;

						case KeyEvent.VK_RIGHT:

							gamePanel.dx = 0;

							break;

						case KeyEvent.VK_UP:

							gamePanel.dy = 0;

							break;

						case KeyEvent.VK_DOWN:

							gamePanel.dy = 0;

							break;

						}

						// 방향키 4개 구분

					}

					@Override

					public void keyPressed(KeyEvent e) {

						// 눌러진 키가 무엇인지 알아내기

						int keyCode = e.getKeyCode();

						switch (keyCode) {

						case KeyEvent.VK_LEFT:

							gamePanel.dx = -8; // 원랜 getsetter 만들어야함

							break;

						case KeyEvent.VK_RIGHT:

							gamePanel.dx = 8;

							break;

						case KeyEvent.VK_UP:

							gamePanel.dy = -8;

							break;

						case KeyEvent.VK_DOWN:

							gamePanel.dy = 8;

							break;

						}

						// 방향키 4개 구분

					}

				});
				cp.replacePanel(gamePanel);
			}
		});

		JButton lblStore = new JButton();
		Image store = new ImageIcon("images/store.png").getImage().getScaledInstance(150, 60, 0);
		lblStore.setIcon(new ImageIcon(store));
		lblStore.setBounds(500, 570, 450, 200);
		lblStore.setOpaque(false);
		lblStore.setContentAreaFilled(false);
		lblStore.setBorderPainted(false);
		this.add(lblStore);

		lblStore.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel cp = new ChangePanel(mf, panel);
				StorePanel sp = new StorePanel(mf);
				cp.replacePanel(sp);

			}
		});

		JButton lblRank = new JButton();
		Image rank = new ImageIcon("images/rk.png").getImage().getScaledInstance(100, 80, 0);
		lblRank.setIcon(new ImageIcon(rank));
		lblRank.setBounds(800, 100, 100, 80);
		lblRank.setOpaque(false);
		lblRank.setContentAreaFilled(false);
		lblRank.setBorderPainted(false);
		this.add(lblRank);

		lblRank.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ChangePanel cp = new ChangePanel(mf, panel);
				RankPanel rp = new RankPanel(mf);
				cp.replacePanel(rp);

			}
		});

		/*
		 * JLabel lb = new JLabel("코인 개수 : "); lb.setLocation(50, 100); lb.setSize(150,
		 * 50); this.add(lb);
		 */
		this.add(label);
		this.setSize(1000, 800);
	}

}