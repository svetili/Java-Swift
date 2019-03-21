package people;

import java.util.Scanner;

public class MainInterface {

	public static void main(String[] args) {
		Person[] perArr = new Person[500];
		int i = 0;
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		while (!"END".equals(s) && i < 500) {
			String[] strArr = s.split(" ");
			String firstName = strArr[0];
			String lastName = strArr[1];
			if (strArr.length == 5) {
				if (!(Student.isValidName(firstName, "first name") && Student.isValidName(lastName, "last name")
						&& Student.isValidFacultyNumber(strArr[2]) && Student.isValidNumber(strArr[3], "lecture count")
						&& Student.isValidNumber(strArr[4], "exercise count"))) {
					sc.close();
					return;
				}
				String factNum = strArr[2];
				int lecNum = Integer.parseInt(strArr[3]);
				int exNum = Integer.parseInt(strArr[4]);
				Student stud = new Student(firstName, lastName, factNum, lecNum, exNum);
				perArr[i] = stud;
				i++;
			} else {
				if (!(Worker.isValidName(firstName, "first name") && Worker.isValidName(lastName, "last name") && Worker.isValidNumber(strArr[2], "week salary")
						&& Worker.isValidNumber(strArr[3], "hours per day"))) {
					sc.close();
					return;
				}
				double weekSalary = Double.parseDouble(strArr[2]);
				double workHoursPerDay = Double.parseDouble(strArr[3]);
				Worker worker = new Worker(firstName, lastName, weekSalary, workHoursPerDay);
				perArr[i] = worker;
				i++;
			}
			s = sc.nextLine();
		}
		sc.close();
		for (int j = 0; j < i; j++) {
			perArr[j].printInfo();
		}
	}

}
