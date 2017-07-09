package janken3;

public class ObjectJanken3 {
	public static void main(String[] args) {
		Judge3 judge = new Judge3();
		
		Player3 p1 = new Player3("のむ");
		Player3 p2 = new Player3("ジョージ");

		judge.startJanken(p1, p2);
	}
}
