import java.util.Scanner;

public class ReadNNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("n = ");
		int n = sc.nextInt();
		System.out.print("Enter " + n + " numbers (separated with \"space\"): ");
		for (int i = 1; i <= n; i++) {
			int number = sc.nextInt();
			System.out.println(number);
		}
		sc.close();
	}

}
