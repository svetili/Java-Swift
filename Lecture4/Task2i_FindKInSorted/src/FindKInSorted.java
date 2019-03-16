import java.util.Scanner;

public class FindKInSorted {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("n = ");
		int n = sc.nextInt();

		System.out.print("k = ");
		int k = sc.nextInt();

		int[] intSortedArr = new int[n];
		System.out.printf("Enter %d numbers in increasing order:\n", n);
		for (int i = 0; i < n; i++) {
			intSortedArr[i] = sc.nextInt();
		}

		int index = findIndex(intSortedArr, k, 0, n - 1);
		if (index != -1) {
			System.out.printf("The number %d is at position %d\n", k, index);
		} else {
			System.out.println("NO");
		}
		sc.close();
	}

	public static int findIndex(int[] SortedArr, int k, int i, int j) {
		if (i > j) {
			return -1;
		}
		int index = i + (j - i) / 2;
		int indexRes;
		if (SortedArr[index] == k) {
			return index;
		} else if (SortedArr[index] < k) {
			indexRes = findIndex(SortedArr, k, index + 1, j);
			return indexRes;
		} else {
			indexRes = findIndex(SortedArr, k, i, index - 1);
			return indexRes;
		}
	}

}
