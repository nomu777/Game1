package search1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class BinarySearch1 {
	private static int binarySearch(int x, int[] a) {
		int left = 0;
		int right = a.length -1;
		int mid;
		
		while(left <= right) {
			mid = (left + right) / 2;
			if(a[mid] == x) {
				return mid;
			}
			if(a[mid] < x) {
				//midより左側にxは存在しない
				left = mid + 1;
			} else {
				//midより右側にxは存在しない
				right = mid - 1;
			}
		}
		
		//サーチ範囲がなくなっても一致するものはなかった
		return -1;
	}
	
	public static void main(String[] args) {
		int[] array = new int[10];
		Random random = new Random();
		for(int i = 0; i < array.length; i++) {
			array[i] = random.nextInt(10);
		}
		Arrays.sort(array);
		for(int i = 0; i < array.length; i++) {
			System.out.println(array[i] + " ");
		}
		System.out.println("\n何を探しますか");
		int x = intReader();
		
		int r = binarySearch(x, array);
		
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
			System.err.println("IO exception");
			return 0;
		} catch(NumberFormatException e) {
			return 0;
		}
	}
}
