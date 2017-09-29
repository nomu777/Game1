package sort1;

import java.util.Random;

public class BinaryInsertSort1 {
	//データの件数
	private static final int N = 10;
	private static int[] sort = new int[N];
	
	private static void binaryInsertSort() {
		//最初から最後まで全てソート済みになるまで繰り返す
		for(int sorted = 1; sorted < N; sorted++) {
			//ソート済み領域の最後の値を取り出す
			int insert = sort[sorted];
			//挿入する場所を見つける（バイナリサーチ）
			int i, left, right;
			left = 0;
			right = sorted;
			while(left < right) {
				int mid = (left + right) / 2;
				if(sort[mid] < insert) {
					left = mid + 1;
				} else {
					right = mid;
				}
			}
			i = left;
			//ソート済み領域直後の値を挿入する
			while(i <= sorted) {
				int temp = sort[i];
				sort[i] = insert;
				insert = temp;
				i++;
			}
		}
	}
	
	public static void main(String[] args) {
		Random random = new Random();
		System.out.println("ソート準備");
		for(int i = 0; i < N; i++) {
			sort[i] = random.nextInt(1000);
			System.out.println(sort[i] + " ");
		}
		System.out.println("\nソート開始");
		binaryInsertSort();
		System.out.println("ソート終了");
		
		for(int i = 0; i < N; i++) {
			System.out.println(sort[i] + " ");
		}
	}
}
