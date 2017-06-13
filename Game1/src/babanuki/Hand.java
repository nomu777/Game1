package babanuki;

import java.util.ArrayList;

public class Hand {
	private ArrayList hand = new ArrayList();
	
	/**
	 * カードを加える
	 * 
	 * @param card 加えるカード
	 */
	public void addCard(Card card) {
		//カードをリストの最後に追加する
		hand.add(card);
	}
	
	/**
	 * カードを引く
	 * 
	 * @return 引いたカード
	 */
	public Card pickCard() {
		Card pickedCard = (Card) hand.remove(0);
		
		return pickedCard;
	}
	
	/**
	 * ジャッフルする
	 */
	public void shuffle() {
		//手札の枚数を取得
		int number = hand.size();
		
		//カードを抜き出す位置
		int pos;
		
		//カードをランダムに抜き取って最後に加える動作を繰り返す
		for(int count = 0; count < number * 2; count++) {
			//ランダムな位置からカードを１枚抜き取る
			pos = (int) (Math.random() * number);
			Card pickedCard = (Card) hand.remove(pos);
			
			//抜き取ったカードを最後に加える
			hand.add(pickedCard);
		}
	}
	
	/**
	 * 枚数を数える
	 * 
	 * @return 手札にあるカードの枚数
	 */
	public int getNumberOfCards() {
		return hand.size();
	}
	
	/**
	 * 同じ数のカードを探す
	 * 同じ数のカードがない場合はnullを返します。
	 * 
	 * @return 同じ数のカード
	 */
	public Card[] findSameNumberCard() {
		int numberOfCards = hand.size();
		Card[] sameCards = null;
		
		//手札にカードが１枚もない場合は何もしない
		if(numberOfCards > 0) {
			//最後に追加されたカードを取得する
			int lastIndex = numberOfCards - 1;
			Card lastAddedCard = (Card) hand.get(lastIndex);
			
			//最後に追加されたカードの数字を取得する
			int lastAddedCardNum = lastAddedCard.getNumber();
			
			for(int index = 0; index < lastIndex; index++) {
				Card card = (Card) hand.get(index);
				if(card.getNumber() == lastAddedCardNum) {
					//最後に追加されたカードと同じカードが見つかった場合、見つかった組み合わせをsameCardsに格納し、ループを抜ける
					sameCards = new Card[2];
					sameCards[0] = (Card) hand.remove(lastIndex);
					sameCards[1] = (Card) hand.remove(index);
					
					break;
				}
				
				//同じ数の組み合わせが見つからなかった場合、sameCardsはnullのままになる
			}
		}
		
		return sameCards;
	}
	
	/**
	 * 手札にあるカードを文字列で表現する
	 * ObjectクラスのtoStringメソッドをオーバーライドしたメソッド
	 * 
	 * @return 手札にあるカードの文字列表現
	 */
	public String toString() {
		StringBuffer string = new StringBuffer();
		
		int size = hand.size();
		if(size > 0) {
			for(int index = 0; index < size; index++) {
				Card card = (Card) hand.get(index);
				string.append(card);
				string.append(" ");
			}
		}
		
		return string.toString();
	}
}













