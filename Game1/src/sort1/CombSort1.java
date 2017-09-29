package sort1;

import java.util.Random;

public class CombSort1 {
	//データの件数
	private static final int N = 10;
	private static int[] sort = new int[N];
	
	private static void combSort() {
		boolean flag;
		int gap = N;
		
		do {
			//収縮率は1.3（gapが毎回1/1.3になる）
			gap = (gap * 10) / 13;
			
			if(gap == 0) {
				gap = 1;
			}
			flag = true;
			for(int i = 0; i < N - gap; i++) {
				//先端から順に見ていって
				if(sort[i] > sort[i + gap]) {
					//距離がgapだけ離れた要素を比較し、並びがおかしければ入れ替える
					flag = false;
					int temp = sort[i];
					sort[i] = sort[i + gap];
					sort[i + gap] = temp;
				}
			}
			//一度も並べ替えをせずに、gap==1で見終わったら終了
		} while((gap > 1) || !flag);
	}
	
	public static void main(String[] args) {
		Random random = new Random();
		System.out.println("ソート準備");
		for(int i = 0; i < N; i++) {
			sort[i] = random.nextInt(1000);
			System.out.println(sort[i] + " ");
		}
		System.out.println("ソート開始");
		combSort();
		System.out.println("ソート終了");
		
		for(int i = 0; i < N; i++) {
			System.out.println(sort[i] + " ");
		}
	}
}
