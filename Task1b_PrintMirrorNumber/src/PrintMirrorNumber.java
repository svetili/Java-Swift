import java.util.Scanner;

public class PrintMirrorNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("n = ");
		int n = sc.nextInt();
		System.out.print("The mirror number is: ");
		do {
			System.out.print((n % 10));
			n /= 10;
		} while (n != 0);
		sc.close();
	}

}
