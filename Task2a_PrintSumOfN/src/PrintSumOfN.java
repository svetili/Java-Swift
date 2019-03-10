import java.util.Scanner;

public class PrintSumOfN {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("n = ");
		int n = sc.nextInt();
		System.out.print("Enter " + n + " numbers (separated with \"space\"): ");
		int sum = 0;
		for (int i = 1; i <= n; i++) {
			int number = sc.nextInt();
			sum += number;
			
		}
		System.out.println("Sum = " + sum);
		sc.close();
	}

}
