package stack1;

public class Stack1 {
	Stack1(int stackMaxSize) {
		this.stackMaxSize = stackMaxSize;
		stack = new double[stackMaxSize];
	}
	
	private final int stackMaxSize;
	private int stackTop = 0;
	private double stack[];
	
	public void push(double val) {
		if(stackTop == stackMaxSize) {
			//Javaの正しい姿ではないが、Cのソースコードとの対比のためにこうしている。本来は自分で新しい例外クラスを派生するべき。詳しくはList4_3を参照
			throw new RuntimeException("エラー：スタックが満杯です（Stack overflow）");
		} else {
			stack[stackTop] = val;
			stackTop++;
		}
	}
	
	public double pop() {
		if(stackTop == 0) {
			//Javaの正しい姿ではないが、Cのソースコードとの対比のためにこうしている。本来は自分で新しい例外クラスを派生するべき。詳しくはList4_3を参照
			throw new RuntimeException("エラー：スタックが空なのにpopが呼ばれました" + "（Stack underflow）");
		} else {
			stackTop--;
			return stack[stackTop];
		}
	}
}
