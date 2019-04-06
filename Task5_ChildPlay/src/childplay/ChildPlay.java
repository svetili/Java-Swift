package childplay;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ChildPlay {

	public static void main(String[] args) {
		List<Integer> childrenHeights = getLinkedList();
		int i = 0;
		while (!childrenHeights.isEmpty() && playRound(childrenHeights)) {
			i++;
		}
		System.out.printf("The game will have %d round(s)\n", i);
	}

	private static List<Integer> getLinkedList() {
		List<Integer> childrenHeights = new LinkedList<Integer>();
		System.out.print("Enter the number of children: ");
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		System.out.printf("Enter the height of %d children:\n", n);
		for (int i = 0; i < n; i++) {
			Integer h = sc.nextInt();
			childrenHeights.add(h);
		}
		sc.close();
		return childrenHeights;
	}

	private static boolean playRound(List<Integer> childrenHeights) {

		Iterator<Integer> iter = childrenHeights.iterator();
		List<Integer> childrenIndexToRemove = new LinkedList<Integer>();
		boolean b = false;
		Integer HeightLeft = iter.next();
		int i = 0;

		// get the index of the elements that will be removed
		while (iter.hasNext()) {
			Integer HeightRight = iter.next();
			i++;
			if (HeightLeft < HeightRight) {
				childrenIndexToRemove.add(i);
				b = true;
			}
			HeightLeft = HeightRight;
		}

		// remove the elements from the list
		if (b) {
			iter = childrenHeights.iterator();
			iter.next();

			Iterator<Integer> iter2 = childrenIndexToRemove.iterator();
			int index = iter2.next();

			int n = childrenHeights.size();
			for (int j = 0; j < n; j++) {
				if (index == j) {
					iter.remove();
					if (iter2.hasNext()) {
						index = iter2.next();
					} else {
						return b;
					}
				}
				if (iter.hasNext()) {
					iter.next();
				} else {
					return b;
				}
			}
		}

		return b;
	}

}
