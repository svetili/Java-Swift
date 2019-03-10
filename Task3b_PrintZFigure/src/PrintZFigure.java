import java.util.Scanner;

public class PrintZFigure {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("n = ");
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || i == n - 1 || j == n - i - 1) {
					System.out.print("* ");
				} else {
					System.out.print("  ");
				}
				if (j == n - 1) {
					System.out.println();
				}
			}
		}
		sc.close();
	}

}
