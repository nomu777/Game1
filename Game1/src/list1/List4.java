package list1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class ListNodeForList {
	ListNodeForList(int data) {
		this.data = data;
	}
	
	//前の要素
	public ListNodeForList prev;
	//次の要素
	public ListNodeForList next;
	//この要素が持っているデータ
	public final int data;
}

class List4 {
	public static void main(String[] args) {
		ListNodeForList firstNode = null, lastNode = null;
		
		int buf;
		do {
			System.out.println("整数を入力してください" + "（０を入力すると終了）");
			buf = intReader();
			if(buf != 0) {
				//新しいノードを作成
				ListNodeForList newNode = new ListNodeForList(buf);
				newNode.next = null;
				if(lastNode != null) {
					//既にあるリストの末尾に新しいノードを繋げる
					lastNode.next = newNode;
					newNode.prev = lastNode;
					lastNode = newNode;
				} else {
					//これが最初の要素だった
					firstNode = lastNode = newNode;
					newNode.prev = null;
				}
			}
		} while(buf != 0);
		
		//合計値を算出
		int sum = 0;
		System.out.println("--入力されたのは以下の数です--");
		for(ListNodeForList thisNode = firstNode; thisNode != null; thisNode = thisNode.next) {
			System.out.println(thisNode.data + " ");
			sum += thisNode.data;
		}
		System.out.println("\n以上の数の合計値は" + sum + "です");
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
