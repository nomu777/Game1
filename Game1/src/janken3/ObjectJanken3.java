package janken3;

public class ObjectJanken3 {
	public static void main(String[] args) {
		Judge3 judge = new Judge3();
		
		Player3 p1 = new Player3("のむ");
		//p1に渡す戦略クラスを生成する
		Tactics p1Tactics = new InputTactics();
		//p1に戦略クラスを渡す
		p1.setTactics(p1Tactics);
		
		Player3 p2 = new Player3("ジョージ");
		//p2に渡す戦略クラスを生成する
		Tactics p2Tactics = new AtodahsiTactics();
		//p2に戦略クラスを渡す
		p2.setTactics(p2Tactics);

		judge.startJanken(p1, p2);
	}
}
