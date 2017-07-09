package babanuki;

import java.util.ArrayList;

//手札に関する情報はここで処理

/**
 * ババ抜きの手札を表すクラス
 * @author nomuradaichi
 *
 */
public class HandCard {
	
	/**
	 * 手札にあるカードを保持するためのリスト
	 */
	private ArrayList hand = new ArrayList();
	
	/**
	 * カードを加える
	 * 
	 * @param card 加えるカード
	 */
	//カードを追加する際、ババ抜きクラス、プレイヤークラスによって呼び出される
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
		//removeメソッド・・・（）内に記述された数の要素番号の配列に格納された値を削除する
		//「手札からカードを引く＝手札からカードが１枚なくなる」という操作をremoveメソッドによって表現している
		Card pickedCard = (Card) hand.remove(0);
		
		//removeメソッドによって配列から削除した値を変数pickedCardに格納することで、カードを引く、という操作を表現する
		return pickedCard;
	}
	
	/**
	 * シャッフルする
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
			//上のremoveによってhandから一回削除した値を再び格納している
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
	 * 同じ数のカードがない場合はnullを返す
	 * 
	 * @return　同じ数のカード
	 */
	public Card[] findSameNumberCard() {
		//手札の枚数を取得
		int numberOfCards = hand.size();
		Card[] sameCards = null;
		
		//手札にカードが１枚もない場合は何もしない
		if(numberOfCards > 0) {
			//最後に追加されたカードを取得する
			int lastIndex = numberOfCards - 1;                 //最後に追加されたカードの値が格納されている箱の番号
			Card lastAddedCard = (Card) hand.get(lastIndex);   //最後に追加されたカードを変数に格納
			
			//最後に追加されたカードの数字を取得する
			int lastAddedCardNum = lastAddedCard.getNumber();
			
			for(int index = 0; index < lastIndex; index++) {
				//1番目の配列から順番に取得する
				Card card = (Card) hand.get(index);
				if(card.getNumber() == lastAddedCardNum) {
					//最後に追加されたカードと同じカードが見つかった場合、見つかった組み合わせをsameCardsに格納し、ループを抜ける
					sameCards = new Card[2];
					sameCards[0] = (Card) hand.remove(lastIndex);   //最後に追加されたカードを削除
					sameCards[1] = (Card) hand.remove(index);       //テーブルにカードを捨てるために一旦sameCardsに格納
					
					break;
				}
				
				//同じ数の組み合わせが見つからなかった場合、sameCardsはnullのままとなる
			}
		}
		
		//sameCardsは配列型の変数なので、２枚のカードの値を格納
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
