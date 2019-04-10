package person;

import java.time.LocalDate;
import java.time.Period;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import education.*;

public class Person {
	private String firstName;
	private String middleName;
	private String lastName;
	private Gender gender;
	private LocalDate birthDate;
	private int height;
	private Address currentAddress;
	private List<Address> pastAddresses;
	private List<Education> educations;

	public Person(String firstName, String middleName, String lastName, Gender gender, int height,
			LocalDate birthDate) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.gender = gender;
		this.height = height;
		this.birthDate = birthDate;
		this.pastAddresses = new LinkedList<Address>();
		this.educations = new LinkedList<Education>();
	}

	public void addEducation(Degree educationType, String institutionName, LocalDate enrollmentDate,
			LocalDate graduationDate, float finalGrade) {
		Education ed;
		switch (educationType) {
		case Primary:
			ed = new PrimaryEducation(enrollmentDate, graduationDate, institutionName, -1);
			this.educations.add(ed);
			break;
		case Secondary:
			ed = new SecondaryEducation(enrollmentDate, graduationDate, institutionName, finalGrade);
			this.educations.add(ed);
			break;
		default:
			ed = new HigherEducation(enrollmentDate, graduationDate, institutionName, educationType, finalGrade);
			this.educations.add(ed);
		}
	}

	public void newAddress(String country, String city, String municipality, String postalCode, String street,
			String number, String floor, String apartmentNo) {
		Address address = new Address(country, city, municipality, postalCode, street, number, floor, apartmentNo);
		this.currentAddress = address;
		pastAddresses.add(address);
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

	public Gender getGender() {
		return gender;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public int getHeight() {
		return height;
	}

	public Address getAddress() {
		return currentAddress;
	}

	public List<Education> getEducation() {
		return educations;
	}

	public int getAge() {
		int age = Period.between(this.getBirthDate(), LocalDate.now()).getYears();
		return age;
	}

	public String[] getGenderArr() {
		String[] strArr = new String[2];
		if (this.getGender() == Gender.Female) {
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
		List<Education> edList = this.getEducation();
		Education ed;
		Iterator<Education> iter = edList.iterator();
		while (iter.hasNext()) {
			ed = iter.next();
			s += String.format("%s started %s degree in %s on %s and ", this.getGenderArr()[0], ed.getDegree(),
					ed.getInstitutionName(), ed.getEnrollmentDate());
			if (ed.isGraduated()) {
				s += String.format("finished on %s.", ed.getGraduationDate());
				try {
					if (ed.gotGraduated()) {
						GradedEducation gradedEd = (GradedEducation) ed;
						s += String.format("%s grade was %.2f.", this.getGenderArr()[1], gradedEd.getFinalGrade());
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

			} else {
				s += String.format("is supposed to graduate on %s.", ed.getGraduationDate());
			}
		}
		return s;
	}

	public static Person readInfo(String line) throws Exception {
		String[] perArr = line.trim().split(";");

		int i = 0;
		String firstName = perArr[i].trim();
		if ("".contentEquals(firstName)) {
			throw new Exception("Expected non-empty first name.");
		}
		i++;

		String middleName = perArr[i].trim();
		if ("".contentEquals(middleName)) {
			throw new Exception("Expected non-empty middle name.");
		}
		i++;

		String lastName = perArr[i].trim();
		if ("".contentEquals(lastName)) {
			throw new Exception("Expected non-empty last name.");
		}
		i++;

		char genderChar = perArr[i].trim().charAt(0);
		if (genderChar != 'F' && genderChar != 'M') {
			throw new Exception("Expected M or F for gender.");
		}
		Gender gender;
		if (genderChar == 'F') {
			gender = Gender.Female;
		} else {
			gender = Gender.Male;
		}
		i++;

		String[] dateArr1 = (perArr[i].trim().split("\\."));
		LocalDate birthDate = LocalDate.of(Integer.parseInt(dateArr1[2]), Integer.parseInt(dateArr1[1]),
				Integer.parseInt(dateArr1[0]));
		if (birthDate.isAfter(LocalDate.now()) || birthDate.isBefore(LocalDate.of(1900, 1, 1))) {
			throw new Exception("Date of birth is expected to be after 01.01.1900 and before now.");
		}
		i++;

		int height = Integer.parseInt(perArr[i].trim());
		if (height < 40 || height > 300) {
			throw new Exception("Expected height is between 40 and 300 cm.");
		}
		i++;

		Person person = new Person(firstName, middleName, lastName, gender, height, birthDate);

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

		person.newAddress(country, city, municipality, postalCode, street, number, floor, apartmentNo);

		while (i < perArr.length) {
			char educationTypeChar = perArr[i].trim().charAt(0);
			i++;
			Degree degree;
			switch (educationTypeChar) {
			case 'P':
				degree = Degree.Primary;
				break;
			case 'S':
				degree = Degree.Secondary;
				break;
			case 'B':
				degree = Degree.Bachelor;
				break;
			case 'M':
				degree = Degree.Master;
				break;
			case 'D':
				degree = Degree.Doctorate;
				break;
			default:
				degree = Degree.None;
			}

			String institutionName = perArr[i].trim();
			i++;
			if ("".contentEquals(institutionName)) {
				throw new Exception("Expected non-empty institutionName.");
			}

			String[] dateArr2 = (perArr[i].trim().split("\\."));
			LocalDate enrollDate = LocalDate.of(Integer.parseInt(dateArr2[2]), Integer.parseInt(dateArr2[1]),
					Integer.parseInt(dateArr2[0]));
			i++;

			String[] dateArr3 = (perArr[i].trim().split("\\."));
			LocalDate gradDate = LocalDate.of(Integer.parseInt(dateArr3[2]), Integer.parseInt(dateArr3[1]),
					Integer.parseInt(dateArr3[0]));
			i++;
			if (enrollDate.isAfter(gradDate)) {
				throw new Exception("Graduation date is expected to be after enrollment date.");
			}

			float finalGrade = -1;
			try {
				finalGrade = Float.parseFloat(perArr[i].trim());
			} catch (Exception e) {
			}
			i++;
			if ((finalGrade > 6.0 || finalGrade < 2.0) && finalGrade != -1) {
				throw new Exception("Graduation grade is expected to be between 2 and 6.");
			}
			if (finalGrade != -1 && gradDate.isAfter(LocalDate.now())) {
				throw new Exception("Graduation date is expected to be a date in the past.");
			}
			person.addEducation(degree, institutionName, enrollDate, gradDate, finalGrade);
		}
		return person;
	}

}
