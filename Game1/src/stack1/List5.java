package stack1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class IntVectorQueue {
	private final int size;
	private int[] queue;
	private int first = 0, last = 0;
	
	IntVectorQueue(int size) {
		this.size = size + 1;
		queue = new int[size];
	}
	
	public void enqueue(int val) {
		if((last + 1) % size == first) {
			throw new RuntimeException("エラー：キューが満杯です");
		} else {
			queue[last] = val;
			last = (last + 1) % size;
		}
	}
	
	public int dequeue() {
		int ret;
		
		if(first == last) {
			return - 1;
		} else {
			ret = queue[first];
			first = (first + 1) % size;
			return ret;
		}
	}
	
	public void printQueue() {
		for(int i = first; i != last; i = (i + 1) % size) {
			System.out.println(queue[i] + " ");
		}
	}
}

class List5 {
	public static void main(String[] args) {
		IntVectorQueue queue = new IntVectorQueue(5);
		
		int i;
		
		do {
			System.out.println("現在のキュー");
			queue.printQueue();
			System.out.println("\nコマンド０：終了　１：ジョブをためる　２：ジョブを実行する");
			i = intReader();
			switch(i) {
			case 1 :
				{
					System.out.println("ジョブの識別番号（１〜1000）を適当に入力してください");
					int j = intReader();
					if(j >= 1 && j <= 1000) {
						queue.enqueue(j);
					}
					break;
				}
			
			case 2 :
				{
					int j = queue.dequeue();
					if(j == -1) {
						System.out.println("ジョブがありません");
					} else {
						System.out.println("識別番号" + j + "のジョブを実行中");
					}
				}
				
			}
		} while(i != 0);
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
