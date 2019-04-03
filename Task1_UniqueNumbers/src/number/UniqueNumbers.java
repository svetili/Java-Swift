package number;

import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class UniqueNumbers {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		// read number of iterations
		System.out.println("Enter number of iterations: ");
		int n = sc.nextInt();
		sc.nextLine();
		
		// read n numbers
		System.out.printf("Enter %d numbers: \n", n);
		Set<Integer> intUniqueList = new HashSet<Integer>();
		for(int i = 0; i < n; i++) {
			intUniqueList.add(sc.nextInt());
		}
		
		//print the unique numbers
		for(Integer i : intUniqueList) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		sc.close();
	}

}
