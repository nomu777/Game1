package babanuki;

public class OldMaid {
	public static void main(String[] args) {
		//進行役の生成
		Master master = new Master();
		
		//テーブルの生成
		Table field = new Table();
		
		//プレイヤーの生成
		//進行役やカードを捨てるテーブルの情報も必要なため、それぞれ引数として渡しておく
		Player mori = new Player("森", master, field);
		Player yamada = new Player("山田", master, field);
		Player yano = new Player("矢野", master, field);
		
		//進行役へプレイヤーを登録
		master.registerPlayer(mori);
		master.registerPlayer(yamada);
		master.registerPlayer(yano);
		
		//トランプを生成する
		HandCard trump = createTrump();
		
		//ゲームの準備をする
		master.prepareGame(trump);
		
		//ゲームを開始する
		master.startGame();
	}
	
	/**
	 * ５３枚のトランプを生成する
	 * 
	 * @return トランプを格納したHand
	 */
	private static HandCard createTrump() {
		HandCard trump = new HandCard();
		
		//各スート５３枚のカードを生成する
		for(int number = 1; number <= 13; number++) {
			trump.addCard(new Card(Card.SUIT_CLUB, number));
			trump.addCard(new Card(Card.SUIT_DIAMOND, number));
			trump.addCard(new Card(Card.SUIT_HEART, number));
			trump.addCard(new Card(Card.SUIT_SPADE, number));
		}
		//ジョーカーの作成
		trump.addCard(new Card(0, Card.JOKER));
		
		return trump;
	}
}
