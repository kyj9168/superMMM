package view;

import java.awt.Image;
import java.util.Random;

public class Coin {

	Image img;

	int x, y;

	int w, h;

	int dy;

	int width, height;

	boolean isDead = false;

	public Coin(Image imgCoin, int width, int height) {
		this.width = width;
		this.height = height;

		img = imgCoin.getScaledInstance(40, 40, Image.SCALE_SMOOTH);

		w = 30;

		h = 30;

		Random rnd = new Random();

		x = rnd.nextInt(width - w * 2) + w;
		y = h;

		dy = +rnd.nextInt(15) + 1;
	}

	public void move() {
		y += dy;

		if (y > height + h) {
			isDead = true;
		}
	}
}
