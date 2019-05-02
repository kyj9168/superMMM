package view.game;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.sound.midi.Synthesizer;

public class CoinController {
	private List<CoinVO> coinList;
	
	public CoinController() {
		coinList = new ArrayList<>();
	}
	
	// ������ ����Ʈ�� �߰�
	public void addCoin() {
		System.out.println("addcoin");
		Random random = new Random();
		final int coinX = 950; // �ʱ� x��ǥ
		int coinY = random.nextInt(100)+500; // �ʱ� y��ǥ
		if(coinList.size()>0) {
			int lastCoinY = coinList.get(coinList.size()-1).getCoinY(); // ������ ������ y��ǥ	
		}
		char coinType = ( random.nextInt(10) > 0 )? 'y' : 'p';
		CoinVO coinVO = new CoinVO(coinX, coinY, coinType);
		System.out.println(coinVO);
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
