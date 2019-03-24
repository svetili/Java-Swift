package person;

import java.time.LocalDate;
import java.time.Period;
import education.*;

public class Person {
	private String firstName;
	private String lastName;
	private char gender;
	private LocalDate birthDate;
	private int height;
	private Object education;

	public Person(String firstName, String lastName, char gender, int height, LocalDate birthDate, char educationType,
			String institutionName, LocalDate enrollmentDate, LocalDate graduationDate, float finalGrade) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.height = height;
		this.birthDate = birthDate;
		switch (educationType) {
		case 'P':
			this.education = new PrimaryEducation(enrollmentDate, graduationDate, institutionName, -1);
			break;
		case 'S':
			this.education = new SecondaryEducation(enrollmentDate, graduationDate, institutionName, finalGrade);
			break;
		default:
			this.education = new HigherEducation(enrollmentDate, graduationDate, institutionName, educationType,
					finalGrade);
		}

	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
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

	public int getAge() {
		int age = Period.between(this.getBirthDate(), LocalDate.now()).getYears();
		return age;
	}

	public String[] getGenderArr() {
		String[] strArr = new String[3];
		if (this.getGender() == 'F') {
			String[] strArrTemp = { "She", "She", "Her" };
			strArr = strArrTemp;
		} else {
			String[] strArrTemp = { "He", "He", "His" };
			strArr = strArrTemp;
		}
		return strArr;
	}

	public void printInfo() {
		Education ed = (Education) this.education;
		System.out.printf("%s %s is %d years old. %s was born in %d. %s started %s degree in %s on %s",
				this.getFirstName(), this.getLastName(), this.getAge(), this.getGenderArr()[0],
				this.getBirthDate().getYear(), this.getGenderArr()[1], ed.getDegree(), ed.getInstitutionName(),
				ed.getEnrollmentDate());
		if (ed.isGraduated()) {
			System.out.printf(" and finished on %s.", ed.getGraduationDate());
			if (ed.gotGraduated()) {
				GradedEducation gradedEd = (GradedEducation) ed;
				System.out.printf("%s grade was %.2f.", this.getGenderArr()[2], gradedEd.getFinalGrade());
			}

		} else {
			System.out.printf(" and is supposed to graduate on %s.", ed.getGraduationDate());
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
		char educationType = perArr[5].trim().charAt(0);
		String institutionName = perArr[6].trim();
		String[] dateArr2 = (perArr[7].trim().split("\\."));
		LocalDate enrollDate = LocalDate.of(Integer.parseInt(dateArr2[2]), Integer.parseInt(dateArr2[1]),
				Integer.parseInt(dateArr2[0]));
		String[] dateArr3 = (perArr[8].trim().split("\\."));
		LocalDate gradDate = LocalDate.of(Integer.parseInt(dateArr3[2]), Integer.parseInt(dateArr3[1]),
				Integer.parseInt(dateArr3[0]));
		float finalGrade = -1;
		if (perArr.length > 9) {
			finalGrade = Float.parseFloat(perArr[9].trim());
		}
		Person person = new Person(firstName, lastName, gender, height, birthDate, educationType, institutionName,
				enrollDate, gradDate, finalGrade);

		return person;
	}

}
