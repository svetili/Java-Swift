import java.util.Scanner;

public class PrintOddFrequencyNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("n = ");
		int n = sc.nextInt();
		int[] intArr = new int[n];

		// initialize the array
		System.out.printf("Enter %d numbers\n", n);
		for (int i = 0; i < n; i++) {
			intArr[i] = sc.nextInt();
		}

		int oddFreqNum = 0;
		boolean hasOddNum = false;
		int i = 0;

		while (i < n && !hasOddNum) {
			// check if the number is already verified
			boolean before = false;
			int j = 0;
			while (j < i && !before) {
				if (intArr[i] == intArr[j]) {
					before = true;
				}
				j++;
			}
			// if it is the first appearance of the number then check if it has odd
			// frequency in the rest of the array
			if (!before) {
				int num = 1;
				for (j = i + 1; j < n; j++) {
					if (intArr[i] == intArr[j]) {
						num++;
					}
				}
				if (num % 2 == 1) {
					oddFreqNum = intArr[i];
					hasOddNum = true;
				}
			}
			// go to next index
			i++;
		}
		System.out.print("The odd frequency number is: " + oddFreqNum);
		sc.close();

	}

}
