package janken3;

public class Player3 {
	public static final int STN = 0;
	public static final int SCI = 1;
	public static final int PAP = 2;
	
	private String name;
	private int winCount;
	
	public Player3(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	/** 与えられた戦略 */
	private Tactics tactics;
	
	/**
	 * プレイヤーに戦略を渡す
	 * 
	 * @param tactics 戦略
	 */
	public void setTactics(Tactics tactics) {
		this.tactics = tactics;
	}
	
	public int showHand() {
		//与えられた戦略を読んでジャンケンの手を決める
		int hand = tactics.readTactics();
		
		//決定した手を戻り値として返す
		return hand;
	}
	
	public void notifyResult(boolean result) {
		if(result == true) {
			this.winCount += 1;
		}
	}
	
	public int getWinCount() {
		return winCount;
	}
}
