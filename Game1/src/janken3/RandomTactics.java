package janken3;

/**
 * ランダムに手を出すクラス
 * 
 * @author nomuradaichi
 *
 */
public class RandomTactics implements Tactics {
	
	/**
	 * 戦略を読み、ジャンケンの手を得る
	 * 
	 * @return ジャンケンの手
	 */
	public int readTactics() {
		int hand = 0;
		double random = Math.random() * 3;
		
		if(random < 1) {
			hand = Player3.STN;
		} else if(random < 2) {
			hand = Player3.SCI;
		} else if(random < 3) {
			hand = Player3.PAP;
		}
		return hand;
	}
}
