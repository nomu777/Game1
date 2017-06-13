package janken1;

public class Judge extends Thread {
	
	/**
	 * ジャンケンを開始する
	 * 
	 * @param player1 判定対象プレイヤー１
	 * @param player2 判定対象プレイヤー２
	 */
	//publicにするメソッドは、他のクラスから呼び出されることを想定しているもの。
	public void startJanken(Player1 player1, Player1 player2) {      //引数にはmurata,yamadaが渡されている
		
		//ジャンケンの開始を宣言する
		System.out.println("【ジャンケン開始！】\n");
		
		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
		}
		
		//ジャンケンを３回行う
		for(int cnt = 0; cnt < 3; cnt++) {
			//何戦目かを表示する
			System.out.println("【" + (cnt + 1) + "回戦目】");
			
			//プレイヤーの手を見て、どちらが勝ちかを判定する
			//Player型の変数にメソッドを代入しているので、judgeJankenメソッドには戻り値が必要。
			Player1 winner = judgeJanken(player1, player2);
			
			if(winner != null) {
				//勝者を表示する
				System.out.println(winner.getName() + "が勝ちました！\n");
				//勝ったプレイヤーへ結果を伝える＝勝ったプレイヤーが審判から勝敗を聞く
				//勝った場合はtrueを渡す
				winner.notifyResult(true);
				
			} else {
				//引き分けの場合
				System.out.println("引き分けです！\n" );
			}
			
			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
			}
			
		}
		
		//ジャンケン終了宣言
		System.out.println("【ジャンケン終了】\n");
		
		//最終的な勝者を判定する
		Player1 finalWinner = judgeFinalWinner(player1, player2);
		
		//結果の表示
		System.out.print(player1.getWinCount() + "対" + player2.getWinCount() + "で");
		
		if(finalWinner != null) {
			System.out.print(finalWinner.getName() + "の勝ちです！\n");
		} else {
			System.out.print("引き分けです！\n");
		}
	}
	/**
	 * 「ジャンケン、ポン！」と声をかけ、プレイヤーの手をみてどちらが勝ちかを判定する
	 * 
	 * @param player1 対象プレイヤー１
	 * @param player2 対象プレイヤー２
	 * @return 勝ったプレイヤー。引き分けの場合はnullを返す
	 */
	//privateにするメソッドは、自クラスからのみアクセス可能にしたいもの
	private Player1 judgeJanken(Player1 player1, Player1 player2) {
		Player1 winner = null;
		
		//プレイヤーが手を出すのも審判が見ている範囲内で行う
		//変数に格納することで、下のif文で比較可能
		//プレイヤー１の手を出す
		int player1hand = player1.showHand();
		//プレイヤー２の手を出す
		int player2hand = player2.showHand();
		
		//それぞれの手を表示する
		//現時点でジャンケンの手は定数となっているので、printHandメソッドで、ある定数が出た時にその定数に対応する手の名前を表示する
		printHand(player1hand);
		System.out.print(" vs. ");
		printHand(player2hand);
		System.out.print("\n");
		
		//プレイヤー１が勝つ場合
		if((player1hand == Player1.STONE && player2hand == Player1.SCISSORS)
				|| (player1hand == Player1.SCISSORS && player2hand == Player1.PAPER)
				|| (player1hand == Player1.PAPER && player2hand == Player1.STONE))
		{
			winner = player1;
		} else if((player2hand == Player1.STONE && player1hand == Player1.SCISSORS)
				|| (player2hand == Player1.SCISSORS && player1hand == Player1.PAPER)
				|| (player2hand == Player1.PAPER && player1hand == Player1.STONE))
		{
			winner = player2;
		}
		
		//どちらでもない場合は引き分けnullを返す
		
		return winner;
	}
	
	/**
	 * 最終的な勝者を判定
	 * 
	 * @param player1 判定対象プレイヤー１
	 * @param player2 判定対象プレイヤー２
	 * @ruturn 勝ったプレイヤー。引き分けの場合はnullを返す
	 */
	private Player1 judgeFinalWinner(Player1 player1, Player1 player2) {
		Player1 winner = null;
		
		//Player1から勝ち数を聞く
		int player1WinCount = player1.getWinCount();
		//Player2から勝ち数を聞く
		int player2WinCount = player2.getWinCount();
		
		if(player1WinCount > player2WinCount) {
			//プレイヤー１の勝ち
			winner = player1;
		} else if(player1WinCount < player2WinCount) {
			//プレイヤー２の勝ち
			winner = player2;
		}
		
		//どちらでもない場合は引き分け
		
		return winner;
	}
	
	/**
	 * ジャンケンの手を表示する
	 * 
	 * @param hand ジャンケンの手
	 */
	private void printHand(int hand) {
		switch(hand) {
		case Player1.STONE :
			System.out.print("グー");
			break;
			
		case Player1.SCISSORS :
			System.out.print("チョキ");
			break;
			
		case Player1.PAPER :
			System.out.print("パー");
			break;
			
		default :
			break;
		}
	}
}
