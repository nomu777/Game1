package omikuji;

import java.util.Random;

public class Omikuji {
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		String[] kuji = {"大吉", "中吉", "小吉", "凶"};
		String s = getStick(kuji);
		System.out.println(s);
	}
	
	static String getStick(String[] kuji) {
		Random r = new Random();
		int no = r.nextInt(kuji.length - 1);
		return kuji[no];
	}
}

//修正２