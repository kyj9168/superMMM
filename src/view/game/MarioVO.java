package view.game;

public class MarioVO {
	private int marioY;
	private int vector;
	private String imagePathArr[];
	
	public MarioVO() {
		this.marioY = 200;
		this.vector = 1;
		this.imagePathArr = new String[5];
		this.imagePathArr[0] = "images/mario_running_0000.gif";
		this.imagePathArr[1] = "images/mario_running_0001.gif";
		this.imagePathArr[2] = "images/mario_running_0003.gif";
		this.imagePathArr[3] = "images/mario_running_0001.gif";
		this.imagePathArr[4] = "images/mario_jumping_0000.gif";
		
	}
	
	public String[] getImagePathArr() {
		return imagePathArr;
	}



	public void setVector(int vector) {
		this.vector = vector;
	}
	
	public void setImagePathArr(String[] imagePathArr) {
		this.imagePathArr = imagePathArr;
	}

	public boolean moveMario(boolean isJumping) {
		boolean returnResult = false;
		if(isJumping) {
			if( this.marioY > 600 || this.marioY <= 100  ) {
				this.vector *= -1;
				if(this.vector > 0) {
					returnResult = false;
				}
			}else {
				returnResult = true;
			}
			
			this.marioY += this.vector;
			
		}else {
			returnResult = false;
		}
		return returnResult;
	}
	
	public int getMarioY() {
		return marioY;
	}
	
	public int getMarioX() {
		return 50;
	}
	public int getVector() {
		return vector;
	}
	public void setMarioY(int marioY) {
		this.marioY = marioY;
	}
}
