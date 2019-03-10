import java.util.Scanner;

public class PrintEverySentence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter text: ");
		String text = sc.nextLine();
		boolean nl = true; // flag to not print ' ' in the beginning of a new line
		for (char ch : text.toCharArray()) {
			if (ch == ' ' && nl) {
				nl = false;
			} else {
				if (ch != '.' && ch != '!' && ch != '?') {
					System.out.print(ch);
				} else {
					System.out.println(ch);
					nl = true;
				}
			}
		}
		sc.close();
	}

}
