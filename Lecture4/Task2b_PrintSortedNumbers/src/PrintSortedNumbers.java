import java.util.Scanner;

public class PrintSortedNumbers {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("n = ");
		int n = sc.nextInt();
		int[] intArr = new int[n];
		System.out.printf("Enter %d numbers\n", n);
		for (int i = 0; i < n; i++) {
			intArr[i] = sc.nextInt();
		}
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (intArr[i] > intArr[j]) {
					int swap = intArr[i];
					intArr[i] = intArr[j];
					intArr[j] = swap;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.print(intArr[i] + " ");
		}
		System.out.println();
		sc.close();
	}

}
