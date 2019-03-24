package person;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("n = ");
		int n = sc.nextInt();
		sc.nextLine();
		System.out.printf(
				"Enter %d lines with information in format: <първо_име>;<последно_име>;<пол>;<височина>;<дата_на_раждане>;<код_за_тип_образование>;<име_на_институция>;<дата_на_ започване_на_образование>;<дата_на_завършване>;[<оценка_ако_е_завършил>]  \n",
				n);
		Person[] perArr = new Person[n];
		for (int i = 0; i < n; i++) {
			String line = sc.nextLine();
			perArr[i] = Person.readInfo(line);
		}
		for (int i = 0; i < n; i++) {
			perArr[i].printInfo();
		}
		sc.close();

	}

}
