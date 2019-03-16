import java.util.Scanner;

public class BracketMatching {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter breckets (), [], and {}:");
		String str = sc.nextLine();
		boolean b = true;
		// if the number of brackets is odd then the expression is not valid
		if (str.length() % 2 == 1) {
			b = false;
		} else {
			while (str.length() > 0 && b) {
				char[] chArr = str.toCharArray();
				int i = 0;
				while (i < chArr.length - 1 && chArr[i] != ')' && chArr[i] != ']' && chArr[i] != '}') {
					i++;
				}
				//if the first found closing bracket is in the beginning of the expression then it is not valid
				if (i == 0) {
					b = false;
				} else {
					switch (chArr[i]) {
					case ')':
						b = ('(' == chArr[i - 1]);
						break;
					case ']':
						b = ('[' == chArr[i - 1]);
						break;
					case '}':
						b = ('{' == chArr[i - 1]);
						break;
					default:
						b = false; // if the first found closing bracket doesn't have opening one next to it, then the expression is not valid
					}
					// remove the first found valid brackets from the string
					String strLeft = "";
					String strRight = "";
					if (i > 1) {
						strLeft = str.substring(0, i - 1);
					}
					if (i < str.length() - 1) {
						strRight = str.substring(i + 1, str.length());
					}
					str = strLeft.concat(strRight);
				}
			}
		}
		//print the result
		System.out.println(b);
		sc.close();
	}

}
