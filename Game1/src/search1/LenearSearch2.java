package search1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Random;

public class LenearSearch2 {
	public static void main(String[] args) {
		int[] array = new int[6];
		Random random = new Random();
		for(int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(10);
			System.out.println(array[i] + " ");
		}
		System.out.println("\n何を探しますか");
		int x = intReader();
		
		int r = lenearSearch(x, array);
		
		if(r == -1) {
			System.out.println(x + "は見つかりません");
		} else {
			System.out.println(x + "は" + (r+1) + "番目です");
		}
	}
	
	private static int intReader() {
		try {
			BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
			String str = read.readLine();
			return Integer.parseInt(str);
		} catch(IOException e) {
			System.out.println("IO exception");
			return 0;
		} catch(NumberFormatException e) {
			return 0;
		}
	}
	
	private static int lenearSearch(int x, int[] a) {
		int n = 0;
		
		//最後の値をxに入れ替える
		int t = a[a.length - 1];
		a[a.length - 1] = x;
		
		//配列の範囲内で目的の値を探す
		while(a[n] != x) {
			n++;
		}
		
		//配列最後の値を元に戻す
		a[a.length - 1] = t;
		
		if(n < a.length - 1) {
			return n;   //一番最後以外で一致
		}
		if(x == t) {
			return n;   //一番最後が一致
		}
		
		return -1;
	}
}
