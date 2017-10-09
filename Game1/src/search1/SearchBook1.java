package search1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class SearchBook1 {
	public final String title;
	public final String author;
	public final int bookID;
	public final boolean available;
	
	SearchBook1(String title, String author, int bookID, boolean available) {
		this.title = title;
		this.author = author;
		this.bookID = bookID;
		this.available = available;
	}
}

class List2_5 {
	private static SearchBook1[] bookArray;
	
	private static void sortBook(int bottom, int top, SearchBook1[] books) {
		int lower, upper, div;
		
		if(bottom >= top) {
			return;
		}
		//適当な基準値を選択
		div = books[bottom].bookID;
		for(lower = bottom, upper = top; lower < upper;) {
			while(/*lower<upper &&*/ books[lower].bookID < div) {
				++lower;
			}
			while(/*lower<upper &&*/ books[upper].bookID < div) {
				--upper;
			}
			if(lower < upper) {
				//データへのポインタの順番を入れ替える
				SearchBook1 temp = books[lower];
				books[lower] = books[upper];
				books[upper] = temp;
				++lower;
				--upper;
			}
		}
		sortBook(bottom, upper, books);
		sortBook(upper + 1, top, books);
	}
	
	private static int searchBook(SearchBook1[] books, int key) {
		int left, mid, right;
		
		left = 0;
		right = books.length - 1;
		while(left < right) {
			mid = (left + right) / 2;
			//bookIDの代償を比較
			if(books[mid].bookID < key) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		if(books[left].bookID == key) {
			return left;
		}
		
		//見つからなかった
		return -1;
	}
	
	private static void initData() {
		bookArray = new SearchBook1[5];
		
		bookArray[0] = new SearchBook1("book0", "author0", 1000, true);
		bookArray[1] = new SearchBook1("book1", "author1", 502, false);
		bookArray[2] = new SearchBook1("book2", "author2", 731, false);
		bookArray[3] = new SearchBook1("book3", "author3", 628, true);
		bookArray[4] = new SearchBook1("book4", "author4", 1, true);
	}
	
	public static void main(String[] args) {
		initData();
		sortBook(0, bookArray.length - 1, bookArray);
		
		while(true) {
			System.out.println("検索する本の番号を入力してください" + "（終了する場合は０を入力）");
			int key = intReader();
			if(key == 0) {
				//０が入力されたら終了
				break;
			}
			
			//検索して結果を表示
			int position = searchBook(bookArray, key);
			if(position != -1) {
				System.out.println("--次の本が見つかりました--");
				System.out.println("[タイトル]" + bookArray[position].title);
				System.out.println("[著者]" + bookArray[position].author);
				System.out.println("[管理番号]" + bookArray[position].bookID);
				if(bookArray[position].available) {
					System.out.println("この本は貸出可能です");
				} else {
					System.out.println("申し訳ありませんが、この本は貸出中です");
				}
			} else {
				System.out.println("お探しの本は見つかりませんでした");
			}
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
