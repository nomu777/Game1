package search1;

import java.util.Random;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class OrganizationSearch1 {
	private static int organizationSearch(int x, int[] a) {
		int n = 0;
		
		//配列の範囲内で目的の値を探す
		while(n < a.length && a[n] != x) {
			n++;
		}
		
		if(n < a.length) {
			if(n > 0) {
				//一つ前と入れ替える
				int t = a[n - 1];
				a[n - 1] = a[n];
				a[n] = t;
				return n-1;
			}
			return n;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] array = new int[10];
		Random random = new Random();
		for(int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(10);
		}
		while(true) {
			for(int i = 0; i < array.length; i++) {
				System.out.println(array[i] + " ");
			}
			System.out.println("\n何を探しますか（-1で終了）：");
			int x = intReader();
			if(x == -1) {
				break;
			}
			
			int r = organizationSearch(x, array);
			
			if(r == -1) {
				System.out.println(x + "は見つかりません");
			} else {
				System.out.println(x + "は" + r + "番目です");
			}
		}
	}
	
	private static int intReader() {
		try {
			BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
			String str = read.readLine();
			return Integer.parseInt(str);
		} catch(IOException e) {
			System.err.println("IO Exception");
			return 0;
		} catch(NumberFormatException e) {
			return 0;
		}
	}
}
