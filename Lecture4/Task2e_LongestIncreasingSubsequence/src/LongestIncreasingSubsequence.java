import java.util.Scanner;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("n = ");
		int n = sc.nextInt();

		int[] intArr = new int[n];
		System.out.printf("Enter %d numbers\n", n);
		for (int i = 0; i < n; i++) {
			intArr[i] = sc.nextInt();
		}

		int lenMax = 1;
		int indexMax = 0;
		int lenTemp = 1;
		int index = 0;

		for (int i = 0; i < n - 1; i++) {
			if (intArr[i] <= intArr[i + 1]) {
				lenTemp++;
			}
			if (intArr[i] > intArr[i + 1] || i == n - 2) {
				if (lenTemp > lenMax) {
					lenMax = lenTemp;
					indexMax = index;
				}
				lenTemp = 1;
				index = i + 1;
			}
		}

		System.out.println("The longest increasing subsequence is: ");
		for (int i = indexMax; i < indexMax + lenMax; i++) {
			System.out.print(intArr[i] + " ");
		}
		sc.close();

	}

}
