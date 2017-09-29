package sort1;

import java.util.Random;

public class QuickSort1 {
	//データの件数
	private static final int N = 10;
	private static int[] sort = new int[N];
	
	private static void quickSort(int bottom, int top, int[] data) {
		int lower, upper;
		
		//配列が一つしかなければ並べ替えは必要ないのでリターン
		if(bottom >= top) {
			return;
		}
		//先頭の値を「適当な値」とする
		int div = data[bottom];
		//前方の配列番号が後方の配列番号より小さい限り繰り返す
		for(lower = bottom, upper = top; lower < upper;) {
			//前方の値が先頭の値以下であれば前方の配列番号に１を加算
			while(lower <= upper && data[lower] <= div) {
				lower++;
			}
			//後方の値が先頭の値より大きければ後方の配列番号から１を引く
			while(lower <= upper && data[upper] > div) {
				upper--;
			}
			//前方の配列番号が後方の配列番号より小さい場合、前方の値と後方の値を入れ替える
			if(lower < upper) {
				int temp = data[lower];
				data[lower] = data[upper];
				data[upper] = temp;
			}
		}
		
		//最初に選択した値を中央に移動する
		int temp = data[bottom];
		data[bottom] = data[upper];
		data[upper] = temp;
		
		//自分を呼び出す再帰処理
		quickSort(bottom, upper - 1, data);
		quickSort(upper + 1, top, data);
	}
	
	public static void main(String[] args) {
		Random random = new Random();
		System.out.println("ソート準備");
		for(int i = 0; i < N; i++) {
			sort[i] = random.nextInt(1000);
			System.out.println(sort[i] + " ");
		}
		System.out.println("\nソート開始");
		//先頭の配列番号、最後列の配列番号、項数Nの配列、を引数として渡す
		quickSort(0, N-1, sort);
		System.out.println("ソート終了");
		
		for(int i = 0; i < N; i++) {
			System.out.println(sort[i] + " ");
		}
	}
}
