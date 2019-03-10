import java.util.Scanner;

public class PrintFirstDigit {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("n = ");
		int n = sc.nextInt();
		while (n/10 != 0) {
			n /= 10;
		}
		System.out.println("The first digit is: " + (n%10));
		sc.close();
	}

}
