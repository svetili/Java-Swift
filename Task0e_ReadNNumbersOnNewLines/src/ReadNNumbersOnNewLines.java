import java.util.Scanner;

public class ReadNNumbersOnNewLines {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("n = ");
		int n = sc.nextInt();
		System.out.printf("Enter %d numbers (separated with new line): \n", n);
		String numStr = "";
		int number;
		for (int i = 1; i <= n; i++) {
			number = sc.nextInt();
			numStr += (" " + number);
		}
		System.out.println(numStr);
		sc.close();
	}

}
