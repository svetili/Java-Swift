package person;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("n = ");
		int n = sc.nextInt();
		sc.nextLine();
		System.out.printf(
				"Enter %d lines with personal information:\n",
				n);
		Person[] perArr = new Person[n];
		for (int i = 0; i < n; i++) {
			String line = sc.nextLine();
			perArr[i] = Person.readInfo(line);
		}
		for (int i = 0; i < n; i++) {
			System.out.println(perArr[i]);
		}
		sc.close();

	}

}
