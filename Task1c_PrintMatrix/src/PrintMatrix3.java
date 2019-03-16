import java.util.Scanner;

public class PrintMatrix3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("n = ");
		int n = sc.nextInt();
		int[][] intArr = new int[n][n];
		int k = 0;
		// initialize upper part of the second diagonal
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				k++;
				if (i % 2 != 0)
					intArr[j][i - j] = k;
				else
					intArr[i - j][j] = k;
			}
		}
		// initialize lower part of the second diagonal
		int p = n;
		int s = 1;
		for (int i = n - 1; i > 0; i--) {
			for (int j = s; j < n; j++) {
				k++;
				if (i % 2 != 0)
					intArr[p - j][j] = k;
				else
					intArr[j][p - j] = k;
			}
			p++;
			s++;
		}
		//print
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.printf("%4d", intArr[i][j]);
				if (j == n - 1)
					System.out.println();
			}
		}
		sc.close();

	}

}
