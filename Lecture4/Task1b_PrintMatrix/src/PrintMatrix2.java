import java.util.Scanner;

public class PrintMatrix2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("n = ");
		int n = sc.nextInt();
		int[][] intArr = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (j % 2 == 0) {
					intArr[i][j] = n * j + i + 1;
				} else {
					intArr[i][j] = n * j + n - i;
				}
				System.out.printf("%4d", intArr[i][j]);
				if (j == n - 1)
					System.out.println();
			}
		}
		sc.close();

	}

}
