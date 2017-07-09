package babanuki;

import java.util.ArrayList;

public class Table {
	
	/** 捨てられたカードを保持しておくためのリスト */
	private ArrayList disposedCards = new ArrayList();
	
	/**
	 * カードを捨てる
	 * 
	 * @param card 捨てるカードの配列
	 */
	public void disposeCard(Card card[]) {        //sameCardsを引数として渡す
		for(int index = 0; index < card.length; index++) {
			
			//捨てられたカードを表示
			System.out.println(card[index] + " ");
		}
		System.out.println("を捨てました\n");
		
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
		}
		
		//捨てられたカードはリストに追加して保持しておく
		disposedCards.add(card);
	}
}
