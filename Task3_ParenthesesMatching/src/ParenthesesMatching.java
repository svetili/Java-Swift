import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class ParenthesesMatching {

	public static boolean checkElem(Deque<String> deque, String elem) {
		String strTemp = "";
		if (!deque.isEmpty()) {
			strTemp = deque.pollLast();
		}
		if (!strTemp.equals(elem)) {
			return false;
		}
		return true;
	}

	public static boolean checkinfo(String str) {

		Deque<String> deque = new ArrayDeque<String>();

		// add the opening brackets in stack. pop an element and check if it is opening
		// the current closing one
		for (char ch : str.toCharArray()) {

			switch (ch) {
			case '(':
				deque.add("(");
				break;
			case '[':
				deque.add("[");
				break;
			case '{':
				deque.add("{");
				break;
			case ')':
				if (!checkElem(deque, "(")) {
					return false;
				}
				break;
			case ']':
				if (!checkElem(deque, "[")) {
					return false;
				}
				break;
			case '}':
				if (!checkElem(deque, "{")) {
					return false;
				}
			}

		}

		if (deque.isEmpty()) {
			return true;
		} else {
			return false;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter parentheses expression:");
		String str = sc.nextLine();
		System.out.println(checkinfo(str));
		sc.close();
	}

}
