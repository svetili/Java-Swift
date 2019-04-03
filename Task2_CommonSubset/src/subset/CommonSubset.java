package subset;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CommonSubset {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		// read number of iterations
		System.out.println("Enter two numbers on a line: ");
		int n = sc.nextInt();
		int m = sc.nextInt();
		sc.nextLine();

		// read n numbers
		System.out.printf("Enter %d numbers: \n", n);
		Set<Integer> intUniqueList1 = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			intUniqueList1.add(sc.nextInt());
		}

		System.out.printf("Enter %d numbers: \n", m);
		Set<Integer> intUniqueList2 = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			Integer k = sc.nextInt();
			if (intUniqueList1.contains(k)) {
				intUniqueList2.add(k);
			}
		}

		// print the unique numbers
		for (Integer i : intUniqueList2) {
			System.out.print(i + " ");
		}
		if (intUniqueList2.isEmpty()) {
			System.out.print("NO");
		}
		System.out.println();

		sc.close();
	}

}
