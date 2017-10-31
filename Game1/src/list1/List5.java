package list1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class ListNodeForList5 {
	ListNodeForList5(int data) {
		this.data = data;
	}
	
	//前の要素
	public ListNodeForList5 prev;
	//次の要素
	public ListNodeForList5 next;
	//この要素が持っているデータ
	public final int data;
}

class List5 {
	public static void main(String[] args) {
		ListNodeForList5 firstNode = null, lastNode = null;
		
		int buf;
		do {
			System.out.println("整数を入力してください" + "（0を入力すると終了）");
			buf = intReader();
			if(buf != 0) {
				//新しいノードを作成
				ListNodeForList5 newNode = new ListNodeForList5(buf);
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
		
		do {
			System.out.println("検索する値を入力してください" + "(0を入力すると終了):");
			buf = intReader();
			if(buf != 0) {
				ListNodeForList5 thisNode;
				//最初に入力した値の中から検索し、見つかったら削除
				for(thisNode = firstNode; thisNode != null; thisNode = thisNode.next) {
					if(thisNode.data == buf) {
						System.out.println("入力された値の中に" + buf + "が見つかりました" + "ノードを削除します");
						if(thisNode.prev != null) {
							thisNode.prev.next = thisNode.next;
						} else {
							firstNode = thisNode.next;
						}
						
						if(thisNode.next != null) {
							thisNode.next.prev = thisNode.prev;
						} else {
							lastNode = thisNode.prev;
						}
						break;
					}
				}
				
				if(thisNode == null) {
					System.out.println(buf + "は入力されていないか、あるいは既に削除されています");
				}
			}
		} while(buf != 0);
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
