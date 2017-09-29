package sort1;

import java.util.Random;
import java.util.Arrays;

public class Qsort {
	//データの挿入
	private static final int N = 10;
	private static int[] sort = new int[N];
	
	public static void main(String[] args) {
		Random random = new Random();
		System.out.println("ソート準備");
		for(int i = 0; i < N; i++) {
			sort[i] = random.nextInt(1000);
			System.out.println(sort[i] + " ");
		}
		System.out.println("\nソート開始");
		//配列に格納された数を並べ替え
		Arrays.sort(sort);
		System.out.println("ソート終了");
		
		for(int i = 0; i < N; i++) {
			System.out.println(sort[i] + " ");
		}
	}
}
