package janken3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 標準入力によりジャンケンの手をユーザーに聞く戦略クラス
 * 
 * @author nomuradaichi
 *
 */
public class InputTactics implements Tactics {
	/**
	 * 戦略を読み、ジャンケンの手を得る
	 * 
	 * @return ジャンケンの手
	 */
	public int readTactics() {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("\nジャンケンの手を入力してください");
		System.out.println("0:グー");
		System.out.println("1:チョキ");
		System.out.println("2:パー");
		System.out.println("? ");
		
		//ジャンケンの手
		int hand = 0;
		
		while(true) {
			try {
				String inputStr = br.readLine();
				
				hand = Integer.parseInt(inputStr);
				
				if(hand == Player3.STN
						|| hand == Player3.SCI
						|| hand == Player3.PAP) {
					break;
				} else {
					System.out.println("入力が正しくありません。再入力してください");
					System.out.println("? ");
				}
			}
			catch(Exception ex) {
				System.out.println("入力が正しくありません。再入力してください");
				System.out.println("? ");
			}
		}
		return hand;
	}
}
