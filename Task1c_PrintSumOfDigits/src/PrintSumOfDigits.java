import java.util.Scanner;

public class PrintSumOfDigits {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("n = ");
		int n = sc.nextInt();
		int sum = 0;
		System.out.print("The sum of the digits is: ");
		do {
			sum += n % 10;
			n /= 10;
		} while (n != 0);
		System.out.println(sum);
		sc.close();
	}

}
