package babanuki;

//進行役のクラス

import java.util.ArrayList;

public class Master {
	/** プレイヤーのリスト */
	//registerPlayerメソッドによってOldMaidクラスで生成されたプレイヤーがplayersに格納される
	private ArrayList players = new ArrayList();
	
	/**
	 * ゲームの準備をする
	 * 
	 * @param cards トランプを進行役の手札として渡す
	 */
	public void prepareGame(HandCard cards) {
		System.out.println("【カードを配ります】");
		
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
		}
		
		//トランプをシャッフルする
		cards.shuffle();
		
		//トランプの枚数を取得する（53枚）
		int numberOfCards = cards.getNumberOfCards();
		
		//プレイヤーの人数を取得する
		int numberOfPlayers = players.size();
		
		for(int index = 0; index < numberOfCards; index++) {
			//カードから１枚引く
			Card card = cards.pickCard();
			
			//各プレイヤーに順番にカードを配る
			 //0〜52をプレイヤー数（今回のケースでは３）で割った余り（0,1,2の順番に出る）と等しい要素数の配列に格納されているプレイヤーを取得
			Player player = (Player) players.get(index % numberOfPlayers);
			//各プレイヤーがカードを受け取る
			player.receiveCard(card);      //プレイヤーは引いたカードを受け取る
		}
	}
	
	/**
	 * ゲームを開始する
	 */
	public void startGame() {
		System.out.println("\n【ババ抜きを開始します】");
		
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
		}
		
		//プレイヤーの人数を取得する
		for(int count = 0; players.size() > 1; count++) {
			int playerIndex = count % players.size();
			int nextPlayerIndex = (count + 1) % players.size();
			
			//指名するプレイヤーの取得
			Player player = (Player) players.get(playerIndex);
			
			//次のプレイヤーの取得
			Player nextPlayer = (Player) players.get(nextPlayerIndex);
			
			//プレイヤーを指名する
			System.out.println("\n" + player + "さんの番です");
			
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
			}
			
			//次のプレイヤーを引数で渡すことで、引くための手札を出してもらう操作を実行する（プレイヤークラスにて）
			player.play(nextPlayer);
		}
		
		//プレイヤーが上がって残り１名になるとループを抜ける
		System.out.println("【ババ抜きを終了しました】");
	}
	
	/**
	 * 上がりを宣言する
	 * 
	 * @param winner 上がったプレイヤー
	 */
	//プレイヤークラスからの申告
	public void declareWin(Player winner) {
		//上がったプレイヤー
		System.out.println(winner +  "さんが上がりました");
		
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
		}
		
		//上がったプレイヤーをリストから外す
		players.remove(players.indexOf(winner));
		
		//残りプレイヤーが１人になった時は敗者を表示する
		if(players.size() == 1) {
			Player loser = (Player) players.get(0);
			System.out.println(loser + "さんの負けです！");
		}
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
		}
	}
	
	/**
	 * ゲームに参加するプレイヤーを登録する
	 * 
	 * @param player 参加するプレイヤー
	 */
	public void registerPlayer(Player player) {
		//リストに参加者を追加する
		players.add(player);
	}
}
