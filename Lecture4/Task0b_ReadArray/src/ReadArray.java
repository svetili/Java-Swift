import java.util.Scanner;

public class ReadArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("n = ");
		int n = sc.nextInt();
		int[] intArr = new int[n];
		System.out.printf("Enter %d numbers: ", n);
		for (int i = 0; i < intArr.length; i++) {
			intArr[i] = sc.nextInt();
		}
		for (int i = 0; i < intArr.length; i++) {
			if (i < intArr.length - 1) {
				System.out.printf("%d, ", intArr[i]);
			} else {
				System.out.print(intArr[i]);
			}
		}
		sc.close();
	}

}
