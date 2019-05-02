package view;

import java.awt.Image;
import java.util.Random;

public class Bomb {

	Image img;

	int x, y;

	int w, h;

	int dy;

	int width, height;

	boolean isDead = false;

	public Bomb(Image imgBomb, int width, int height) {
		this.width = width;
		this.height = height;

		img = imgBomb.getScaledInstance(50, 50, Image.SCALE_SMOOTH);

		w = 50;

		h = 50;

		Random rnd3 = new Random();

		x = rnd3.nextInt(width - w * 2) + w;
		y = h;

		dy =+ rnd3.nextInt(15) + 1;
	}

	public void move() {
		y += dy;

		if (y > height + h) {
			isDead = true;
		}
	}
}
