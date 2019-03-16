import java.util.Scanner;

public class PrintLargestNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("n = ");
		int n = sc.nextInt();
		int[] intArr = new int[n];
		System.out.printf("Enter %d numbers\n", n);
		int max = Integer.MIN_VALUE;
		for(int i = 0; i < n; i++) {
			intArr[i] = sc.nextInt();
			if(max < intArr[i]) {
				max = intArr[i];
			}
		}
		System.out.print("The max value is: " + max);
		sc.close();
	}

}
