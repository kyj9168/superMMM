package view.game;

public class GameThread extends Thread {
	@Override
	public void run() {
		try {
			GameThread.sleep(500);
			System.out.println("thread ����");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
