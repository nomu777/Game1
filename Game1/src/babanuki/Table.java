package babanuki;

import java.util.ArrayList;

public class Table {
	
	private ArrayList disposedCards = new ArrayList();
	
	/**
	 * カードを捨てる
	 * 
	 * @param card 捨てるカードの配列
	 */
	public void disposeCard(Card card[]) {
		for(int index = 0; index < card.length; index++) {
			System.out.println(card[index] + " ");
		}
		System.out.println("を捨てました");
		
		disposedCards.add(card);
	}
}
