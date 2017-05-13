package janken1;

public class Judge {
	/**
	 * ジャンケンを開始する
	 * 
	 * @param player1 判定対象プレイヤー１
	 * @param player2 判定対象プレイヤー２
	 */
	public void startJanken(Player player1, Player player2) {
		//ジャンケンの開始を宣言する
		System.out.println("【ジャンケン開始！】\n");
		
		//ジャンケンを３回行う
		for(int cnt = 0; cnt < 3; cnt++) {
			//何戦目かを表示する
			System.out.println("【" + (cnt + 1) + "回戦目】");
			
			//プレイヤーの手を見て、どちらが勝ちかを判定する
			Player winner = judgeJanken(player1, player2);
			
			if(winner != null) {
				//勝者を表示する
				System.out.println(winner.getName() + "が勝ちました！\n");
				//買ったプレイヤーへ結果を伝える
				winner.notifyResult(true);
				
			} else {
				//引き分けの場合
				System.out.println("引き分けです！\n" );
			}
		}
		//ジャンケン終了宣言
		System.out.println("【ジャンケン終了】\n");
		
		//最終的な勝者を判定する
		Player finalWinner = judgeFinalWinner(player1, player2);
		
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
	private Player judgeJanken(Player player1, Player player2) {
		Player winner = null;
		
		//プレイヤー１の手を出す
		int player1hand = player1.showHand();
		//プレイヤー２の手を出す
		int player2hand = player2.showHand();
		
		//それぞれの手を表示する
		printHand(player1hand);
		System.out.print(" vs. ");
		printHand(player2hand);
		System.out.print("\n");
		
		//プレイヤー１が勝つ場合
		if((player1hand == Player.STONE && player2hand == Player.SCISSORS)
				|| (player1hand == Player.SCISSORS && player2hand == Player.PAPER)
				|| (player1hand == Player.PAPER && player2hand == Player.STONE))
		{
			winner = player1;
		} else if((player2hand == Player.STONE && player1hand == Player.SCISSORS)
				|| (player2hand == Player.SCISSORS && player1hand == Player.PAPER)
				|| (player2hand == Player.PAPER && player1hand == Player.STONE))
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
	private Player judgeFinalWinner(Player player1, Player player2) {
		Player winner = null;
		
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
		case Player.STONE :
			System.out.print("グー");
			break;
			
		case Player.SCISSORS :
			System.out.print("チョキ");
			break;
			
		case Player.PAPER :
			System.out.print("パー");
			break;
			
		default :
			break;
		}
	}
}