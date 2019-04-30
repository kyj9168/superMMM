package view.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JLabel;

public class CoinVO {
	private int coinX;	// 코인의 x좌표
	private int coinY;	// 코인의 y좌표
	private char coinType; // 'Y': 노랑타입의 코인, 'P': 핑크타입의 코인
	private int coinValue; // 노랑: 100포인트, 핑크: 10원
	private static String imagePathArr[];
	private static String imagePathArr2[];
	
	
	public CoinVO(int coinX, int coinY, char coinType) {
		this.imagePathArr = new String[5];
		this.imagePathArr2 = new String[5];
		this.imagePathArr[0] = "images/gold_0000.gif";
		this.imagePathArr[1] = "images/gold_0001.gif";
		this.imagePathArr[2] = "images/gold_0002.gif";
		this.imagePathArr[3] = "images/gold_0001.gif";
		this.imagePathArr[4] = "images/gold_0000.gif";
		this.imagePathArr2[0] = "images/pink01.gif";
		this.imagePathArr2[1] = "images/pink02.gif";
		this.imagePathArr2[2] = "images/pink03.gif";
		this.imagePathArr2[3] = "images/pink02.gif";
		this.imagePathArr2[4] = "images/pink01.gif";
		
	
		this.coinX = coinX;
		this.coinY = coinY;
		this.coinType = coinType;
		this.coinValue = (coinType=='y')? coinValue=100 : 10;
	}
	
	public static String[] getImagePathArr2() {
		return imagePathArr2;
	}

	public  void setImagePathArr2(String[] imagePathArr2) {
		this.imagePathArr2 = imagePathArr2;
	}

	public static String[] getImagePathArr() {
		return imagePathArr;
	}

	public void setImagePathArr(String[] imagePathArr) {
		this.imagePathArr = imagePathArr;
	}

	public void moveToX(int x) {
	List<CoinVO> coinList = null;
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

	public CoinVO(int coinX, int coinY, char coinType, int coinValue) {
		super();
		this.coinX = coinX;
		this.coinY = coinY;
		this.coinType = coinType;
		this.coinValue = coinValue;
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
