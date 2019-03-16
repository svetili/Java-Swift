import java.util.Scanner;

public class LargestSumOfKSubsequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("n = ");
		int n = sc.nextInt();

		System.out.print("k (k < n) = ");
		int k = sc.nextInt();

		int[] intArr = new int[n];
		System.out.printf("Enter %d numbers\n", n);
		for (int i = 0; i < n; i++) {
			intArr[i] = sc.nextInt();
		}

		int sum = Integer.MIN_VALUE;
		int index = 0;

		for (int i = 0; i < n - k + 1; i++) {
			int sumTemp = 0;
			for (int j = i; j < i + k; j++) {
				sumTemp += intArr[j];
			}
			if (sumTemp > sum) {
				sum = sumTemp;
				index = i;
			}

		}

		System.out.println("The sequence with largest sum is: ");
		for (int i = index; i < index + k; i++) {
			System.out.print(intArr[i] + " ");
		}
		sc.close();

	}

}
