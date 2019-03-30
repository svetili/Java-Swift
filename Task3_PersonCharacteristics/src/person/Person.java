package person;

import java.time.LocalDate;
import java.time.Period;
import education.*;

public class Person {
	private String firstName;
	private String middleName;
	private String lastName;
	private char gender;
	private LocalDate birthDate;
	private int height;
	private Address address;
	private Education education;

	public Person(String firstName, String middleName, String lastName, char gender, int height, LocalDate birthDate,
			String country, String city, String municipality, String postalCode, String street, String number,
			String floor, String apartmentNo, char educationType, String institutionName, LocalDate enrollmentDate,
			LocalDate graduationDate, float finalGrade) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gender = gender;
		this.height = height;
		this.birthDate = birthDate;
		this.address = new Address(country, city, municipality, postalCode, street, number, floor, apartmentNo);
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

	public String getMiddleName() {
		return middleName;
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

	public Address getAddress() {
		return address;
	}

	public Education getEducation() {
		return education;
	}

	public int getAge() {
		int age = Period.between(this.getBirthDate(), LocalDate.now()).getYears();
		return age;
	}

	public String[] getGenderArr() {
		String[] strArr = new String[2];
		if (this.getGender() == 'F') {
			String[] strArrTemp = { "She", "Her" };
			strArr = strArrTemp;
		} else {
			String[] strArrTemp = { "He", "His" };
			strArr = strArrTemp;
		}
		return strArr;
	}

	@Override
	public String toString() {
		String s = String.format("%s %s %s is %d years old. %s was born in %d.\n", this.getFirstName(),
				this.getMiddleName(), this.getLastName(), this.getAge(), this.getGenderArr()[0],
				this.getBirthDate().getYear());
		if (this.getAge() <= 16) {
			s += String.format("%s %s %s is under-aged.\n", this.getFirstName(), this.getMiddleName(),
					this.getLastName());
		} else {
			System.out.println();
		}
		s += String.format("%s lives at:\n", this.getGenderArr()[0]);
		s += this.getAddress().toString();
		Education ed = this.getEducation();
		s += String.format("%s started %s degree in %s on %s and ", this.getGenderArr()[0], ed.getDegree(),
				ed.getInstitutionName(), ed.getEnrollmentDate());
		if (ed.isGraduated()) {
			s+=String.format("finished on %s.", ed.getGraduationDate());
			if (ed.gotGraduated()) {
				GradedEducation gradedEd = (GradedEducation) ed;
				s+=String.format("%s grade was %.2f.", this.getGenderArr()[1], gradedEd.getFinalGrade());
			}

		} else {
			s+=String.format("is supposed to graduate on %s.", ed.getGraduationDate());
		}
		return s;
	}

	public static Person readInfo(String line) {
		String[] perArr = line.trim().split(";");
		
		int i = 0;
		String firstName = perArr[i].trim();
		i++;
		
		String middleName = perArr[i].trim();
		i++;
		
		String lastName = perArr[i].trim();
		i++;
		
		char gender = perArr[i].trim().charAt(0);
		i++;
		
		String[] dateArr1 = (perArr[i].trim().split("\\."));
		LocalDate birthDate = LocalDate.of(Integer.parseInt(dateArr1[2]), Integer.parseInt(dateArr1[1]),
				Integer.parseInt(dateArr1[0]));
		i++;
		
		int height = Integer.parseInt(perArr[i].trim());
		i++;
		
		String country = perArr[i].trim();
		i++;
		
		String city = perArr[i].trim();
		i++;
		
		String municipality = perArr[i].trim();
		i++;
		
		String postalCode = perArr[i].trim();
		i++;
		
		String street = perArr[i].trim();
		i++;
		
		String number = perArr[i].trim();
		i++;
		
		String floor = perArr[i].trim();
		i++;
		
		String apartmentNo = perArr[i].trim();
		i++;
		
		char educationType = perArr[i].trim().charAt(0);
		i++;
		
		String institutionName = perArr[i].trim();
		i++;
		
		String[] dateArr2 = (perArr[i].trim().split("\\."));
		LocalDate enrollDate = LocalDate.of(Integer.parseInt(dateArr2[2]), Integer.parseInt(dateArr2[1]),
				Integer.parseInt(dateArr2[0]));
		i++;
		
		String[] dateArr3 = (perArr[i].trim().split("\\."));
		LocalDate gradDate = LocalDate.of(Integer.parseInt(dateArr3[2]), Integer.parseInt(dateArr3[1]),
				Integer.parseInt(dateArr3[0]));
		i++;
		
		float finalGrade = -1;
		if (perArr.length > i) {
			finalGrade = Float.parseFloat(perArr[i].trim());
		}
		Person person = new Person(firstName, middleName, lastName, gender, height, birthDate,  
				country, city, municipality, postalCode, street, number, floor, apartmentNo,
				educationType, institutionName,
				enrollDate, gradDate, finalGrade);

		return person;
	}

}
