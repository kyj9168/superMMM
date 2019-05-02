package view;

import java.awt.Image;
import java.util.Random;

public class PinkCoin {
	Image img;

	int x, y;

	int w, h;

	int dy;

	int width, height;

	boolean isDead = false;

	public PinkCoin(Image imgPinkCoin, int width, int height) {
		this.width = width;
		this.height = height;

		img = imgPinkCoin.getScaledInstance(50, 50, Image.SCALE_SMOOTH);

		w = 50;

		h = 50;

		Random rnd = new Random();

		x = rnd.nextInt(width - w * 2) + w;
		y = h;

		dy =+ rnd.nextInt(15) + 1;
	}

	public void move() {
		y += dy;

		if (y > height + h) {
			isDead = true;
		}
	}

}