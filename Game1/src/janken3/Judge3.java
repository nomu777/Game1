package janken3;

public class Judge3 {
	public void startJanken(Player3 p1, Player3 p2) {
		System.out.println("【ジャンケン開始】\n");

		try {
			Thread.sleep(1000);
		} catch(InterruptedException e) {
		}

		boolean loop = true;
		int count = 1;
		while(loop == true) {
			boolean janken = false;
			do {
				System.out.println((count) + "回目！");
				count++;
				Player3 winner = judgeJanken(p1, p2);

				try {
					Thread.sleep(1000);
				} catch(InterruptedException e) {
				}

				if(winner != null) {
					
					try {
						Thread.sleep(1000);
					} catch(InterruptedException e) {
					}
					
					System.out.println(winner.getName() + "の勝ち\n");
					System.out.println("------------------");
					winner.notifyResult(true);
					janken = false;
				} else {
					System.out.println("あいこ！再勝負！\n");
					System.out.println("------------------");
					janken = true;
				}
			//あいこの時はもう一度ジャンケンを行う
			} while(janken == true);

			try {
				Thread.sleep(1000);
			} catch(InterruptedException e) {
			}
			
			//どちらかが三勝したらループを抜ける
			if(p1.getWinCount() == 3 || p2.getWinCount() == 3) {
				loop = false;
			}
		}

		Player3 finalWinner = finalJudgeJanken(p1, p2);
		System.out.println(p1.getWinCount() + ":" + p2.getWinCount() + "で");
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

		System.out.print(p1.getName() + " ");
		printHand(p1Hand);
		System.out.println(" vs");
		System.out.print(p2.getName() + " ");
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
