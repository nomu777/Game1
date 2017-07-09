package babanuki;

//カードに関する情報はここで処理

public class Card {
	
	/** カードの種類を定数で表す */
	public static final int JOKER = 0;
	
	public static final int SUIT_SPADE = 1;
	
	public static final int SUIT_DIAMOND = 2;
	
	public static final int SUIT_CLUB = 3;
	
	public static final int SUIT_HEART = 4;
	
	/** カードの種類と数をカプセル化 */
	private int suit;
	
	private int number;
	
	
	/**
	 * コンストラクタ
	 * 
	 * @param suit スート
	 * @param number 数（０の場合はジョーカーとして扱う）
	 */
	//カードの種類と数をここでセット
	public Card(int suit, int number) {
		this.suit = suit;
		this.number = number;
	}
	
	/**
	 * 数字を見る
	 * 
	 * @return 数
	 */
	//二組の同じ数のカードの組み合わせにより捨てるため、カードの種類は関係なし。よって、値を取得するのはnumberだけで良い。
	public int getNumber() {
		return number;
	}
	
	/**
	 * カードを文字列で表現する
	 * ObjectクラスのtoStringメソッドをオーバーライドしたメソッド
	 * 
	 * @return カードの文字表現
	 */
	public String toString() {
		StringBuffer string = new StringBuffer();       //文字列を返す
		
		if(number > 0) {
			switch(suit) {
			case SUIT_SPADE :
				string.append("スペード");
				break;
				
			case SUIT_DIAMOND :
				string.append("ダイヤ");
				break;
				
			case SUIT_CLUB :
				string.append("クラブ");
				break;
				
			case SUIT_HEART :
				string.append("ハート");
				break;
			}
			
			//数の表示
			switch(number) {
			case 1 :
				string.append("エース");
				break;
			
			case 10 :
				string.append("10");
				break;
				
			case 11 :
				string.append("ナイト");
				break;
				
			case 12 :
				string.append("クイーン");
				break;
				
			case 13 :
				string.append("キング");
				break;
				
			default :
				string.append(number);
				break;
			}
		} else {
			string.append("ジョーカー");
		}
		return string.toString();
	}
}




