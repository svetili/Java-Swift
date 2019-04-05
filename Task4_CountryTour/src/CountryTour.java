import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class CountryTour {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// fill number of towns
		System.out.println("Enter number of towns:");
		int n = sc.nextInt();
		sc.nextLine();

		// fill town destination data in form "food - distance" as it is the only data
		// we need

		System.out.printf("Enter %d lines with two numbers on each - distance (int) food(int):\n", n);
		Queue<Integer> queueArr = new ArrayDeque<Integer>();
		for (int i = 0; i < n; i++) {
			int k = sc.nextInt();
			int s = sc.nextInt();
			sc.nextLine();
			queueArr.add(s - k);
		}

		// the outer "for" counts the number of tried routines (maximum - the array
		// length)

		int count = 0;
		for (int i = 0; i < queueArr.size(); i++) {
			count++;

			// the inner "for" sums the remaining food after each travel to a town
			// this I think is the weak part because we have to finish the loop even after
			// we found it is the wrong one. 

			int sum = 0;
			boolean b = true;
			Integer el;

			for (int j = 0; j < queueArr.size(); j++) {
				el = queueArr.poll();
				sum += el.intValue();
				if (sum < 0) {
					b = false;
				}
				queueArr.add(el);
			}
			// if at some point the sum was negative this is not the right routine

			if (b) {
				System.out.println(count);
				sc.close();
				return;
			}
			// move the first element to the end so the new search will start from the next
			// element

			el = queueArr.poll();
			queueArr.add(el);
		}
		System.out.println("NO");
		sc.close();

	}

}
