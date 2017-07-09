package janken3;

public class Judge3 {
	public void startJanken(Player3 p1, Player3 p2) {
		System.out.println("ジャンケン開始");
		
		boolean loop = false;
		while(loop == false) {
			boolean janken = false;
			do {
				Player3 winner = judgeJanken(p1, p2);
				if(winner != null) {
					System.out.println(winner.getName() + "の勝ち\n");
					winner.notifyResult(true);
					janken = true;
				} else {
					System.out.println("あいこ！再勝負！\n");
				}
			} while(janken == false);
			
			if(p1.getWinCount() == 3 || p2.getWinCount() == 3) {
				loop = true;
			}
		}
		
		Player3 finalWinner = finalJudgeJanken(p1, p2);
		System.out.println(p1.getWinCount() + ":" + p2.getWinCount());
		if(finalWinner != null) {
			System.out.println(finalWinner.getName() + "の勝利");
		} else {
			System.out.println("引き分け");
		}
	}
	
	private Player3 judgeJanken(Player3 p1, Player3 p2) {
		Player3 winner = null;
		int p1Hand = p1.showHand();
		int p2Hand = p2.showHand();
		
		System.out.print(p1.getName());
		printHand(p1Hand);
		System.out.println(" vs");
		System.out.print(p2.getName());
		printHand(p2Hand);
		
		if((p1Hand == Player3.STN && p2Hand == Player3.SCI)
				|| (p1Hand == Player3.SCI && p2Hand == Player3.PAP)
				|| (p1Hand == Player3.PAP && p2Hand == Player3.STN)) {
			winner = p1;
		} else if((p2Hand == Player3.STN && p1Hand == Player3.SCI)
				|| (p2Hand == Player3.SCI && p1Hand == Player3.PAP)
				|| (p2Hand == Player3.PAP && p1Hand == Player3.STN)) {
			winner = p2;
		}
		return winner;
	}
	
	private Player3 finalJudgeJanken(Player3 p1, Player3 p2) {
		Player3 finalWinner = null;
		int p1Win = p1.getWinCount();
		int p2Win = p2.getWinCount();
		
		if(p1Win > p2Win) {
			finalWinner = p1;
		} else if(p1Win < p2Win) {
			finalWinner = p2;
		}
		return finalWinner;
	}
	
	private void printHand(int hand) {
		switch(hand) {
		case Player3.STN :
			System.out.println("グー");
			break;
			
		case Player3.SCI :
			System.out.println("チョキ");
			break;
			
		case Player3.PAP :
			System.out.println("パー");
			break;
			
		default :
			break;
		}
	}
}
