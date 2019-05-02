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
	
	// 코인을 리스트에 추가
	public void addCoin() {
		System.out.println("addcoin");
		Random random = new Random();
		final int coinX = 950; // 초기 x좌표
		int coinY = random.nextInt(100)+500; // 초기 y좌표
		if(coinList.size()>0) {
			int lastCoinY = coinList.get(coinList.size()-1).getCoinY(); // 마지막 코인의 y좌표	
		}
		char coinType = ( random.nextInt(10) > 0 )? 'y' : 'p';
		CoinVO coinVO = new CoinVO(coinX, coinY, coinType);
		System.out.println(coinVO);
		coinList.add(coinVO);
	
		
			
			
			
		
	}
	
	// 모든 코인들을 왼쪽으로 x만큼 이동
	public void moveToX(int x) {
//		for (int i=0; i< coinList.size(); i++) {
//			coinList.get(i);
//		}
		for (CoinVO coinVO : coinList) {
			// coinVO.setCoinX( coinVO.getCoinX() - x );
			coinVO.moveToX(x);
		}
		
		
		
	}
	
	// x좌표, y좌표 값으로 코인의 list에서의 index를 구함
	public int getIndex(int x, int y) {
		int i = 0;
		for (CoinVO coinVO : coinList) {
			if( coinVO.getCoinX() == x && coinVO.getCoinY() == y )
				return i;
			i++;
		}
		return -1;
	}
	
	// 코인 하나를 리스트에서 제거
	public void removeCoin(int x, int y) {
		int removeIndex = this.getIndex(x, y);
		if(removeIndex > 0)
			coinList.remove(removeIndex);
		else
			System.out.println("removeCoin() 에러");
	}

	public List<CoinVO> getCoinList() {
		return coinList;
	}

	public void setCoinList(List<CoinVO> coinList) {
		this.coinList = coinList;
	}
}
