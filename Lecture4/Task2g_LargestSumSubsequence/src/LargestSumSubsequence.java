import java.util.Scanner;

public class LargestSumSubsequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("n = ");
		int n = sc.nextInt();

		int[] intArr = new int[n];
		System.out.printf("Enter %d numbers\n", n);
		for (int i = 0; i < n; i++) {
			intArr[i] = sc.nextInt();
		}

		int sumMax = Integer.MIN_VALUE;
		int indexMax = 0;
		int kMax = 1;

		int sumTemp = 0;
		int kTemp = 0;

		while (kTemp < n) {
			for (int i = 0; i < n - kTemp + 1; i++) {
				for (int j = i; j < i + kTemp; j++) {
					sumTemp += intArr[j];
				}
				if (sumTemp > sumMax) {
					sumMax = sumTemp;
					indexMax = i;
					kMax = kTemp;
				}
				sumTemp = 0;
			}
			kTemp++;
		}

		System.out.println("The sequence with largest sum is: ");
		for (int i = indexMax; i < indexMax + kMax; i++) {
			System.out.print(intArr[i] + " ");
		}
		sc.close();

	}

}
