package view.game;

public class GameThread extends Thread {
	@Override
	public void run() {
		try {
			GameThread.sleep(500);
			System.out.println("thread ³»ºÎ");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
