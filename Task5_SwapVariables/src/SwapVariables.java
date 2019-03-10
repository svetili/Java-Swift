
public class SwapVariables {

	public static void main(String[] args) {
		int x = 5;
		int y = 9;
		swapV1(x, y);
		x = 11;
		y = 7;
		swapV2(x, y);

	}

// Swap using third variable
	public static void swapV1(int x, int y) {
		System.out.println("Before swap");
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		int c = x;
		x = y;
		y = c;
		System.out.println("After swap");
		System.out.println("x = " + x);
		System.out.println("y = " + y);
	}

//Swap using + and -
	public static void swapV2(int x, int y) {
		System.out.println("Before swap");
		System.out.println("x = " + x);
		System.out.println("y = " + y);
		x = x + y;
		y = x - y;// (x+y)-y = x
		x = x - y;// (x+y)-x = y
		System.out.println("After swap");
		System.out.println("x = " + x);
		System.out.println("y = " + y);
	}
}
