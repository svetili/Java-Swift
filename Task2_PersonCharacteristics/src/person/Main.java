package person;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
	public static boolean checkLine(String line) {
		Pattern pattern = Pattern.compile("^" // start
				+ "([A-Z][a-z]+;){3,3}" // First, Middle and Last Name
				+ "[MF];" // F or M for gender
				+ "\\d{1,2}\\.\\d{1,2}\\.\\d{4,4};" // date of birth
				+ "\\d{3,3};" // height
				+ "([A-Z][a-z]+;){3,3}" // Country, City, Municipality
				+ "\\d{4,4};" // postal code
				+ "[A-Z][a-z]+;" // street
				+ "\\w+;" // number
				+ "\\d*;" // floor
				+ "\\d*;" // apartment number
				+ "[PSBMD];" // education code
				+ "[\\w\\s]+;" // institution name
				+ "\\d{1,2}\\.\\d{1,2}\\.\\d{4,4};" // enrollment date
				+ "\\d{1,2}\\.\\d{1,2}\\.\\d{4,4};?" // graduation date
				+ "\\d?\\.?\\d{0,2}" // grade if any
				+ "\\s*"
				+ "$"); // end
		Matcher matcher = pattern.matcher(line);
		boolean b = false;
		if (matcher.find()) {
			b = true;
			System.out.println("Entry is ok!");
		} else {
			System.out.println("Wrong input!");
		}
		return b;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("n = ");
		int n = sc.nextInt();
		sc.nextLine();
		System.out.printf("Enter %d lines with personal information:\n", n);
		Person[] perArr = new Person[n];
		for (int i = 0; i < n; i++) {
			String line = sc.nextLine();
			if (checkLine(line)) {
				try {
					perArr[i] = Person.readInfo(line);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
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
