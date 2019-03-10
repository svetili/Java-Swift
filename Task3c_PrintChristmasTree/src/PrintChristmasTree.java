import java.util.Scanner;

public class PrintChristmasTree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("number greater than 4: ");
		int num = sc.nextInt();

		if (num > 4) {
			for (int i = 0; i < num; i++) {
				for (int j = 0; j < 2 * num - 5; j++) { // the number of "*" in the longest row is 2*(num - 2) - 1
					if ((i < num - 2 && j >= num - 3 - i && j <= num - 3 + i) // print of the tree - find the middle of
																				// the longest row (2*(num - 2) - 1)/2 =
																				// num - 2 => add -1 to compensate the
																				// count from 0 => print i "*" before
																				// and after the middle;
							|| (i == num - 2 && j == num - 3) || (i == num - 1 && j >= num - 4 && j <= num - 2)) { // print
																													// of
																													// the
																													// base
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
					if (j == 2 * num - 6) {
						System.out.println();
					}
				}
			}
		} else {
			System.out.println("Wrong number!");
		}
		sc.close();

	}

}
