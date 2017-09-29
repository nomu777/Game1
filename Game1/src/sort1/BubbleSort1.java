package sort1;

import java.util.Random;

//昇順にソート
public class BubbleSort1 {
	//データの件数
	private static final int N = 10;
	private static int[] sort = new int[N];
	
	private static void bubbleSort() {
		boolean flag;
		do {
			flag = false;
			int k = 0;
			for(int i = 0; i < N - 1 - k; i++) {
				//左側の数字が右側より大きければ場所を入れ替える
				if(sort[i] > sort[i + 1]) {
					flag = true;
					int j = sort[i];
					sort[i] = sort[i + 1];
					sort[i + 1] = j;
				}
			}
			++k;
		} while(flag);
	}
	
	public static void main(String[] args) {
		Random random = new Random();
		System.out.println("ソート準備");
		//1000以下の数字からランダムに10個取得し、配列に格納→出力
		for(int i = 0; i < N; i++) {
			sort[i] = random.nextInt(1000);
			System.out.println(sort[i] + " ");
		}
		System.out.println("\nソート開始");
		//バブルソート開始
		bubbleSort();
		System.out.println("ソート終了");
		
		for(int i = 0; i < N; i++) {
			System.out.println(sort[i] + " ");
		}
	}
}
