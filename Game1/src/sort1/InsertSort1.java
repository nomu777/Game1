package sort1;

import java.util.Random;

public class InsertSort1 {
	//データの件数
	private static final int N = 10;
	private static int[] sort = new int[N];
	
	private static void insertSort() {
		//最初から最後まで全てソート済みになるまで繰り返す
		for(int sorted = 0; sorted < N - 1; sorted++) {
			//ソート済み領域の直後の値を取り出す
			int insert = sort[sorted + 1];
			//挿入する場所を見つける
			int i;
			for(i = 0; i <= sorted; i++) {
				if(sort[i] > insert) {
					break;
				}
			}
			//ソート済み領域直後の値を挿入する
			while(i <= sorted + 1) {
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
		insertSort();
		System.out.println("ソート終了");
		
		for(int i = 0; i < N; i++) {
			System.out.println(sort[i] + " ");
		}
	}
}
