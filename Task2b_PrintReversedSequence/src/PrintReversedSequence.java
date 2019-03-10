import java.util.Scanner;

public class PrintReversedSequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("n = ");
		int n = sc.nextInt();
		System.out.print("Enter " + n + " numbers (separated with \"space\"): ");
		String reverse = "";
		for (int i = 1; i <= n; i++) {
			int number = sc.nextInt();
			reverse = number + " " + reverse;
			
		}
		System.out.println("The reverse is: " + reverse);
		sc.close();

	}

}
