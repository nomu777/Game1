package list1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class List1 {
	public static void main(String[] args) {
		int array[] = new int[10];
		int count = 0;
		
		int buf;
		do {
			System.out.println("数値を入力してください" + "（０を入力すると終了）");
			buf = intReader();
			if(buf != 0) {
				array[count] = buf;
				count++;
			}
		} while(buf != 0);
		
		//合計値を算出
		int sum = 0;
		System.out.println("--入力されたのは以下の数です");
		for(int n = 0; n < count; n++) {
			System.out.println(array[n] + " ");
			sum += array[n];
		}
		System.out.println("\n以上の数の合計値は　" + sum + "です");
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
