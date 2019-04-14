package person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws Exception {
		// used this line in cmd -> D:\JavaCourse\Task3_PersonCharacteristics\bin> java -cp
		// . person/Main D:\JavaCourse\Task3_PersonCharacteristics\output\persons.txt
		if (0 != args.length && null != args[0]) {
			try {
				FileReader fileR = new FileReader(args[0]);
				BufferedReader br = new BufferedReader(fileR);
				String line = br.readLine();
				while (line != null) {
					Person per = Person.readInfo(line);
					System.out.println(per);
					line = br.readLine();
				}
				br.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		} else {
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

}
