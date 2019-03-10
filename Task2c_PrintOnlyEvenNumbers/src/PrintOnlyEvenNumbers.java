import java.util.Scanner;

public class PrintOnlyEvenNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("n = ");
		int n = sc.nextInt();
		System.out.print("Enter " + n + " numbers (separated with \"space\"): ");
		String evenNumbers = "";
		for (int i = 1; i <= n; i++) {
			int number = sc.nextInt();
			if (number % 2 == 0) {
				evenNumbers = evenNumbers + " " + number;
			}
		}
		System.out.println("The even numbers are: " + evenNumbers);
		sc.close();
	}

}
