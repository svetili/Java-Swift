import java.util.Scanner;

public class StringWoVowels {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter text: ");
		String text = sc.nextLine();
		for (char ch : text.toCharArray()) {
			switch (ch) {
			case 'a':
			case 'u':
			case 'o':
			case 'e':
			case 'i':
				break;
			default:
				System.out.print(ch);
			}
		}
		sc.close();
	}

}
