package view.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CoinController {
	private List<CoinVO> coinList;
	
	public CoinController() {
		coinList = new ArrayList<>();
	}
	
	// ������ ����Ʈ�� �߰�
	public void addCoin() {
		Random random = new Random();
		final int coinX = 900; // �ʱ� x��ǥ
		int coinY = random.nextInt(300);
		if(coinList.size()>0) {
			int lastCoinY = coinList.get(coinList.size()-1).getCoinY(); // ������ ������ y��ǥ
			int distance = lastCoinY-coinY;
			while( ( distance>0 && distance<50 ) || ( distance<=0 && distance>-50 )  ) {
				coinY = random.nextInt(300)+300; // �ʱ� y��ǥ
				distance = lastCoinY-coinY;
			}
		}
		
		char coinType = ( random.nextInt(10) > 0 )? 'Y' : 'P';
		CoinVO coinVO = new CoinVO(coinX, coinY, coinType);
		coinList.add(coinVO);
	}
	
	// ��� ���ε��� �������� x��ŭ �̵�
	public void moveToX(int x) {
//		for (int i=0; i< coinList.size(); i++) {
//			coinList.get(i);
//		}
		for (CoinVO coinVO : coinList) {
			// coinVO.setCoinX( coinVO.getCoinX() - x );
			coinVO.moveToX(x);
		}
	}
	
	// x��ǥ, y��ǥ ������ ������ list������ index�� ����
	public int getIndex(int x, int y) {
		int i = 0;
		for (CoinVO coinVO : coinList) {
			if( coinVO.getCoinX() == x && coinVO.getCoinY() == y )
				return i;
			i++;
		}
		return -1;
	}
	
	// ���� �ϳ��� ����Ʈ���� ����
	public void removeCoin(int x, int y) {
		int removeIndex = this.getIndex(x, y);
		if(removeIndex > 0)
			coinList.remove(removeIndex);
		else
			System.out.println("removeCoin() ����");
	}

	public List<CoinVO> getCoinList() {
		return coinList;
	}

	public void setCoinList(List<CoinVO> coinList) {
		this.coinList = coinList;
	}
}
