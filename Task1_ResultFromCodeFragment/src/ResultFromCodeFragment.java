
public class ResultFromCodeFragment {

	public static void main(String[] args) {
		codeFragmentA();
		codeFragmentB();
		codeFragmentC();
		codeFragmentD();
	}

	/**
	 * Estimate a, b, c
	 */
	public static void codeFragmentA() {
		int a = 5;
		int b = 10;
		int c = ++a * b--;
		System.out.println("a = " + a);// 6
		System.out.println("b = " + b);// 9
		System.out.println("c = " + c);// 60
	}

	/**
	 * System.out.println exercise 1
	 */
	public static void codeFragmentB() {
		System.out.println("1 + 2 = " + 1 + 2); // 1 + 2 = 12
		System.out.println("1 + 2 = " + (1 + 2));// 1 + 2 = 3
	}

	/**
	 * System.out.println exercise 2
	 */
	public static void codeFragmentC() {
		System.out.println(1 + 2 + "abc");// 3abc
		System.out.println("abc" + 1 + 2);// abc12
	}

	/**
	 * System.out.println exercise 3
	 */
	public static void codeFragmentD() {
		int x = 7;
		float y = 5.6f;
		float z = x * y;
		System.out.println(z + " " + (x * y));//guessed 39.2f 39.2f ... result 39.2 39.2 because the xxxf format for float is only in the code and not in the user display
	}

}
