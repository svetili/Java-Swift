import java.util.Scanner;

public class CaesarCipher {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter something:");
		String str = sc.nextLine();
		System.out.println("Enter \"encode\" or \"decode\":");
		String coding = sc.nextLine();
		String res = "";
		for (char ch : str.toCharArray()) {
			if (ch >= 'A' && ch <= 'z') {
				if (coding.equals("encode")) {
					switch (ch) {
					case 'z':
						res += 'a';
						break;
					case 'Z':
						res += 'A';
						break;
					default:
						res += (char) (ch + 1);
					}
				} else {
					switch (ch) {
					case 'a':
						res += 'z';
						break;
					case 'A':
						res += 'Z';
						break;
					default:
						res += (char) (ch - 1);
					}
				}
			} else {
				res += ch;
			}
		}
		System.out.println(res);
		sc.close();

	}

}
