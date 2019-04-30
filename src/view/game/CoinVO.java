package view.game;

public class CoinVO {
	private int coinX;	// 코인의 x좌표
	private int coinY;	// 코인의 y좌표
	private char coinType; // 'Y': 노랑타입의 코인, 'P': 핑크타입의 코인
	private int coinValue; // 노랑: 100포인트, 핑크: 10원
	
	public CoinVO(int coinX, int coinY, char coinType) {
		this.coinX = coinX;
		this.coinY = coinY;
		this.coinType = coinType;
		this.coinValue = (coinType=='Y')? coinValue=100 : 10;
	}
	
	public void moveToX(int x) {
		if(coinX -x >=0 )
			this.coinX -= x;
	}

	public int getCoinX() {
		return coinX;
	}

	public int getCoinY() {
		return coinY;
	}

	public char getCoinType() {
		return coinType;
	}

	public int getCoinValue() {
		return coinValue;
	}

	public void setCoinX(int coinX) {
		this.coinX = coinX;
	}

	public void setCoinY(int coinY) {
		this.coinY = coinY;
	}

	public void setCoinType(char coinType) {
		this.coinType = coinType;
	}

	public void setCoinValue(int coinValue) {
		this.coinValue = coinValue;
	}

	@Override
	public String toString() {
		return "CoinVO [coinX=" + coinX + ", coinY=" + coinY + ", coinType=" + coinType + ", coinValue=" + coinValue
				+ "]\n";
	}
}
