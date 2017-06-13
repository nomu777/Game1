package janken1;

//インスタンスの生成
//ゲーム開始の宣言

public class ObjectJanken {
	public static void main(String[] args) {
		
		//審判のインスタンス生成
		Judge saito = new Judge();
		
		//プレイヤー１の生成
		Player1 murata = new Player1("村田");
		
		//プレイヤー２の生成
		Player1 yamada = new Player1("山田");
		
		//村田さんと山田さんをプレイヤーとしてジャンケンを開始する
		saito.startJanken(murata, yamada);
	}
}
