package sort1;

import java.util.Random;

public class MergeSort1 {
	//データの件数
	private static final int N = 4;
	private static int[] sort = new int[N];
	
	private static void mergeSort(int n, int[] x, int offset) {
		//配列数が１以下であればリターン
		if(n <= 1) {
			return;
		}
		int m = n / 2; //nが奇数の場合、商が値になる
		
		//ブロックを前半と後半に分ける
		mergeSort(m, x, offset);
		mergeSort(n - m, x, offset + m);
		
		int[] buffer = new int[m];
		//併合（マージ）操作
		for(int i = 0; i < m; i++) {
			buffer[i] = x[offset + i];
		}
		
		int j = m;
		int i = 0;
		int k = 0;
		while(i < m && j < n) {
			if(buffer[i] <= x[offset + j]) {
				x[offset + k++] = buffer[i++];
			} else {
				x[offset + k++] = x[offset + j++];
			}
		}
		
		while(i < m) {
			x[offset + k++] = buffer[i++];
		}
	}
	
	public static void main(String[] args) {
		Random random = new Random();
		System.out.println("ソート準備");
		for(int i = 0; i < N; i++) {
			sort[i] = random.nextInt(10);
			System.out.println(sort[i] + " ");
		}
		System.out.println("\nソート開始");
		mergeSort(N, sort, 0);
		System.out.println("ソート終了");
		
		for(int i = 0; i < N; i++) {
			System.out.println(sort[i] + " ");
		}
	}
}
