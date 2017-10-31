package list1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class ListNodeForList6 {
	ListNodeForList6(int data) {
		this.data = data;
	}
	
	//次の要素
	public ListNodeForList6 next;
	//次の要素が持っているデータ
	public final int data;
}

class List6 {
	public static void main(String[] args) {
		ListNodeForList6 firstNode = null, lastNode = null;
		
		int buf;
		do {
			System.out.println("整数を入力してください" + "（0を入力すると終了）");
			buf = intReader();
			if(buf != 0) {
				//新しいノード作成
				ListNodeForList6 newNode = new ListNodeForList6(buf);
				newNode.next = null;
				if(lastNode != null) {
					//既にあるリストの末尾に新しいノードを繋げる
					lastNode.next = newNode;
					lastNode = newNode;
				} else {
					//これが最初の要素だった
					firstNode = lastNode = newNode;
				}
			}
		} while(buf != 0);
		
		do {
			System.out.println("現在の並び：");
			for(ListNodeForList6 thisNode = firstNode; thisNode != null; thisNode = thisNode.next) {
				System.out.println(thisNode.data + " ");
			}
			
			System.out.println("\n検索する値を入力してください" + "（０を入力すると終了）");
			buf = intReader();
			if(buf != 0) {
				ListNodeForList6 thisNode, tempNode = null;
				//最初に入力した値の中から検索し、見つかったら削除
				for(thisNode = firstNode; thisNode != null; tempNode = thisNode, thisNode = thisNode.next) {
					if(thisNode.data == buf) {
						System.out.println("入力された値の中に" + buf + "が見つかりました");
						if(thisNode != firstNode) {
							//見つかったノードを先頭に持ってくる
							tempNode.next = thisNode.next;
							if(lastNode == thisNode) {
								lastNode = tempNode;
							}
							thisNode.next = firstNode;
							firstNode = thisNode;
						}
						break;
					}
				}
				
				if(thisNode == null) {
					System.out.println(buf + "は入力されていません");
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
