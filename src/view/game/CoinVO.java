package view.game;

public class CoinVO {
	private int coinX;	// ������ x��ǥ
	private int coinY;	// ������ y��ǥ
	private char coinType; // 'Y': ���Ÿ���� ����, 'P': ��ũŸ���� ����
	private int coinValue; // ���: 100����Ʈ, ��ũ: 10��
	
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
