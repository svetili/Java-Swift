import java.util.Scanner;

public class PrintClusterCount {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("n = ");
		int n = sc.nextInt();
		int[] intArr = new int[n];
		System.out.printf("Enter %d numbers\n", n);
		for (int i = 0; i < n; i++) {
			intArr[i] = sc.nextInt();
		}
		int num = 0;
		boolean isCluster = false;
		for (int i = 0; i < n - 1; i++) {
			if (!isCluster) {
				if (intArr[i] == intArr[i + 1]) {
					num++;
					isCluster = true;
				}
			} else {
				if (intArr[i] != intArr[i + 1]) {
					isCluster = false;
				}
			}
		}
		System.out.println("The number of clusters is: " + num);
		sc.close();
	}

}
