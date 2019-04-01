package person;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("n = ");
		int n = sc.nextInt();
		sc.nextLine();
		System.out.printf("Enter %d lines with personal information:\n", n);
		Person[] perArr = new Person[n];
		for (int i = 0; i < n; i++) {
			String line = sc.nextLine();
			try {
				perArr[i] = Person.readInfo(line);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		for (int i = 0; i < n; i++) {
			try {
				if (perArr[i] == null) {
					System.out.println("Person[" + i + "] was not created!\n");
				} else {
					System.out.println(perArr[i]);
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		sc.close();

	}

}
