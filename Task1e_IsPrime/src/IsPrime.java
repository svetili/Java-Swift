import java.util.Scanner;

public class IsPrime {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("n = ");
		int n = sc.nextInt();
		boolean prime = true;
		int i = 2;
		while (i < (n + 1) / 2 && prime == true) {
			if (n % i == 0) {
				prime = false;
			}
			i++;
		}
		System.out.println("Is prime: " + prime);
		sc.close();
	}

}
