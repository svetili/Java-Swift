
public class Print2dArray {

	public static void main(String[] args) {
		int n = 4;
		int[][] intArr = new int[n][n];
		int k = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				k++;
				intArr[i][j] = k;
				System.out.printf("%3d", intArr[i][j]);
				if (j == n - 1)
					System.out.println();
			}
		}
	}

}
