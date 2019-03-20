package person;

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

import education.SecondaryEducation;

public class Person {
	private String firstName;
	private String lastName;
	private char gender;
	private LocalDate birthDate;
	private int height;
	private SecondaryEducation secEducation;

	public Person(String firstName, String lastName, char gender, int height, LocalDate birthDate,
			String institutionName, LocalDate enrollmentDate, LocalDate graduationDate, double finalGrade) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.height = height;
		this.birthDate = birthDate;
		this.secEducation = new SecondaryEducation(institutionName, enrollmentDate, graduationDate, finalGrade);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public char getGender() {
		return gender;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getAge() {
		int age = Period.between(this.getBirthDate(), LocalDate.now()).getYears();
		return age;
	}

	public String[] getGenderArr() {
		String[] strArr = new String[3];
		if (this.getGender() == 'F') {
			String[] strArrTemp = { "She", "She" };
			strArr = strArrTemp;
		} else {
			String[] strArrTemp = { "He", "He" };
			strArr = strArrTemp;
		}
		return strArr;
	}

	public void printInfo() {
		System.out.printf("%s %s is %d years old. %s was born in %d. %s started %s in %s", this.getFirstName(),
				this.getLastName(), this.getAge(), this.getGenderArr()[0], this.getBirthDate().getYear(),
				this.getGenderArr()[1], this.secEducation.getInstitutionName(), this.secEducation.getEnrollmentDate());
		if (this.secEducation.getGraduated()) {
			System.out.printf(" and finished on %s  with a grade of %.2f.", this.secEducation.getGraduationDate(),
					this.secEducation.getFinalGrade());
		} else {
			System.out.printf(" and is supposed to graduate on %s.", this.secEducation.getGraduationDate());
		}
		if (this.getAge() <= 16) {
			System.out.printf(" %s %s is under-aged.\n", this.getFirstName(), this.getLastName());
		} else {
			System.out.println();
		}
	}

	public static Person readInfo(String line) {
		String[] perArr = line.trim().split(";");
		String firstName = perArr[0].trim();
		String lastName = perArr[1].trim();
		char gender = perArr[2].trim().charAt(0);
		int height = Integer.parseInt(perArr[3].trim());
		String[] dateArr1 = (perArr[4].trim().split("\\."));
		LocalDate birthDate = LocalDate.of(Integer.parseInt(dateArr1[2]), Integer.parseInt(dateArr1[1]),
				Integer.parseInt(dateArr1[0]));
		String institutionName = perArr[5].trim();
		String[] dateArr2 = (perArr[6].trim().split("\\."));
		LocalDate enrollDate = LocalDate.of(Integer.parseInt(dateArr2[2]), Integer.parseInt(dateArr2[1]),
				Integer.parseInt(dateArr2[0]));
		String[] dateArr3 = (perArr[7].trim().split("\\."));
		LocalDate gradDate = LocalDate.of(Integer.parseInt(dateArr3[2]), Integer.parseInt(dateArr3[1]),
				Integer.parseInt(dateArr3[0]));
		double finalGrade = -1;
		if (perArr.length > 8) {
			finalGrade = Double.parseDouble(perArr[8].trim());
		} 
		Person person = new Person(firstName, lastName, gender, height, birthDate, institutionName, enrollDate,
				gradDate, finalGrade);

		return person;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("n = ");
		int n = sc.nextInt();
		sc.nextLine();
		System.out.printf(
				"Enter %d lines with information in format: <първо_име>;<последно_име>;<пол>;<височина>;<дата_на_раждане>;<име_на_институция>;<дата_на_започване_на_образование>; <дата_на_завършване>;[<оценка_ако_е_завършил>]  \n",
				n);
		Person[] perArr = new Person[n];
		for (int i = 0; i < n; i++) {
			String line = sc.nextLine();
			perArr[i] = readInfo(line);
		}
		for (int i = 0; i < n; i++) {
			perArr[i].printInfo();
		}
		sc.close();

	}

}
