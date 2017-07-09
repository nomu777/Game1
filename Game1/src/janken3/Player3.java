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
	
	public int showHand() {
		int hand = 0;
		double random = Math.random() * 3;
		
		if(random < 1) {
			hand = STN;
		} else if(random < 2) {
			hand = SCI;
		} else if(random < 3) {
			hand = PAP;
		}
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
