import java.util.Scanner;

public class PrintMatrix4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("n = ");
		int n = sc.nextInt();
		int[][] intArr = new int[n][n];
		int t = 0;
		int k = 0;
		int s = n - 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				intArr[i][j] = 0;
			}
		}
		while (k < s) {
			for (int j = k; j <= s; j++) {
				t++;
				intArr[k][j] = t;
			}
			for (int i = k + 1; i <= s; i++) {
				t++;
				intArr[i][s] = t;
			}
			for (int j = s - 1; j >= k; j--) {
				t++;
				intArr[s][j] = t;
			}
			for (int i = s - 1; i > k; i--) {
				t++;
				intArr[i][k] = t;
			}
			k++;
			s--;
		}
		if (k == s) {
			t++;
			intArr[s][k] = t;
		}
		// print
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
