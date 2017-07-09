package babanuki;

/**
 * ババ抜きのプレイヤークラス
 * @author nomuradaichi
 *
 */
public class Player {
	/** 進行役 */
	private Master master;
	
	/** テーブル */
	private Table table;
	
	/** 自分の手札 */
	private HandCard myHand = new HandCard();
	
	/** 名前 */
	private String name;
	
	/**
	 * コンストラクタ
	 * 
	 * @param name
	 * @param master
	 * @param table
	 */
	public Player(String name, Master master, Table table) {
		this.name = name;
		this.master = master;
		this.table = table;
	}
	
	/**
	 * 順番を指名する
	 * 
	 * @param nextPlayer
	 */
	public void play(Player nextPlayer) {
		//次のプレイヤーに手札を出してもらう
		HandCard nextHand = nextPlayer.showHand();
		
		//相手の手札からカードを１枚引く
		Card pickedCard = nextHand.pickCard();
		
		//引いた結果を表示
		System.out.println(this + ":" + nextPlayer + "さんから" + pickedCard + "を引きました！");
		
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
		}
		
		//引いたカードを自分の手札に加え、同じ数のカードがあったら捨てる
		dealCard(pickedCard);
		
		//手札がゼロになったかどうか調べる
		if(myHand.getNumberOfCards() == 0) {
			//進行役に上がりを宣言する
			master.declareWin(this);
		} else {
			//現在の手札を表示する
			System.out.println(this + ":残りの手札は" + myHand + "です");
		}
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
		}
	}
	
	/**
	 * 手札を見せる
	 * 
	 * @return 自分の手札
	 */
	
	public HandCard showHand() {
		//もしこの時点で手札が残り一枚ならば上がりとなるので宣言する
		if(myHand.getNumberOfCards() == 1) {
			master.declareWin(this);
		}
		
		//見せる前にシャッフルする
		myHand.shuffle();
		
		return myHand;
	}
	
	/**
	 * カードを受け取る
	 * 
	 * @param card 受け取ったカード
	 */
	public void receiveCard(Card card) {
		//引いたカードを自分の手札に加え、同じ数のカードがあったら捨てる
		dealCard(card);
	}
	
	/**
	 * カードを自分の手札に加え、同じ数のカードがあったら捨てる
	 * 
	 * @param card
	 */
	private void dealCard(Card card) {
		//引いたカードを自分の手札に加える
		myHand.addCard(card);
		
		//今加えたカードと同じカードを探す　見つかった場合、二枚一組なので配列の要素数は２。
		Card[] sameCards = myHand.findSameNumberCard();
		
		//同じカードの組み合わせが存在した場合
		if(sameCards != null) {
			//テーブルへカードを捨てる
			System.out.println(this + " : ");
			table.disposeCard(sameCards);
		}
	}
	
	/**
	 * プレイヤーの名前を返す
	 * ObjectクラスのtoStringメソッドをオーバーライドしたメソッド
	 * 
	 * @return プレイヤーの名前
	 */
	public String toString() {
		return name;
	}
}
