import java.util.Scanner;

public class PrintSplitIndex {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("n = ");
		int n = sc.nextInt();

		int[] intArr = new int[n];
		System.out.printf("Enter %d numbers\n", n);
		for (int i = 0; i < n; i++) {
			intArr[i] = sc.nextInt();
		}

		int index = 0;
		boolean isEqual = false;

		while (index < n && !isEqual) {
			int sum1 = 0, sum2 = 0;
			for (int i = 0; i <= index; i++) {
				sum1 += intArr[i];
			}
			for (int i = index + 1; i < n; i++) {
				sum2 += intArr[i];
			}
			isEqual = (sum1 == sum2);
			index++;
		}

		if (isEqual) {
			System.out.println("The index is: " + index);
		} else {
			System.out.println("There is no such index");
		}

		sc.close();
	}

}
