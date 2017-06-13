package janken1;

public class Player1 {
	
	//ジャンケンの手を表す定数
	public static final int STONE = 0;
	public static final int SCISSORS = 1;
	public static final int PAPER = 2;
	
	//-----------------------
	//プレイヤークラスの属性
	//-----------------------
	
	/**プレイヤーの名前*/
	private String name_;
	
	/**プレイヤーの買った回数*/
	private int winCount_ = 0;
	
	/**
	 * プレイヤークラスのコンストラクタ
	 * 
	 * @param name 名前
	 */
	public Player1() {}
	//呼び出される側のメソッドが引数を受け取る時は、必ず「型」を記載する
	public Player1(String name) {
		this.name_ = name;
	}
	
	/**
	 * 自分の名前を答える
	 * 
	 * @param 名前
	 */
	public String getName() {
		return name_;
	}
	
	
	//-----------------------
	//プレイヤークラスの操作
	//-----------------------
	/**
	 * ジャンケンの手を出す
	 * 
	 * @return ジャンケンの手
	 */
	//ジャンケンの手を出す
	//→グー、チョキ、パーどれかを変数に格納
	//どの手が出るかは３分の１の確率→乱数とif文を使う
	public int showHand() {
		//プレイヤーの手
		int hand = 0;
		
		//0.0以上、3.0未満の少数として乱数を得る
		double randomNum = Math.random() * 3;
		if(randomNum < 1) {
			//randomNumが0.0以上、1.0未満の場合、グー
			hand = STONE;
		} else if(randomNum < 2) {
			//randomNumが1.0以上、2.0未満の場合、チョキ
			hand = SCISSORS;
		} else if(randomNum < 3) {
			//randomNumが2.0以上、3.0未満の場合、パー
			hand = PAPER;
		}
		
		//決定した手を戻り値として返す
		return hand;
	}
	
	
	//勝ったかどうかの判断は審判が行う
	/**
	 * 審判から勝敗を聞く
	 * 
	 * @param result true:勝ち、false:負け
	 */
	public void notifyResult(boolean result) {
		if(result == true) {
			//買った場合は勝ち数を加算する
			winCount_ += 1;
		}
	}
	
	/**
	 * 自分の買った回数を答える
	 * 
	 * @return 買った回数
	 */
	//getterメソッドはフィールド値（クラスブロック内に宣言された変数）を取り出すために用いる
	//getterメソッドで取り出すことにより、どのクラスからでも値を利用することが可能になる
	public int getWinCount() {
		return winCount_;
	}
}
