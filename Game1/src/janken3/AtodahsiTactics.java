package janken3;

/**
 * 後出しするクラス
 * 
 * @author nomuradaichi
 *
 */
public class AtodahsiTactics implements Tactics {

	 /* 戦略を読み、ジャンケンの手を得る
	 * 
	 * @return ジャンケンの手
	 */
	public int readTactics() {
		 int hand = 0;
		 double random = Math.random() * 3;
		 boolean atodashiFlg = false;
			 
		 if(random < 1) {
			 hand = Player3.STN;
			 atodashi();
		 } else if(random < 2) {
			 hand = Player3.SCI;
			 atodashi();
		 } else if(random < 3) {
			 hand = Player3.PAP;
			 atodashi();
		 }
		 return hand;
	 }
	
	public boolean atodashi() {
		double random = Math.random() * 2;
		if(random < 1) {
			return true;
		} else {
			return false;
		}
	}
}
