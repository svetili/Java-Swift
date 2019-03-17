import java.util.Calendar;
import java.util.Scanner;

public class Person {
	private String firstName;
	private String lastName;
	private char gender;
	private int birthYear;
	private double weight;
	private int height;
	private String profession;
	private double[] grades;
	
	public Person(String firstName, String lastName, char gender, int birthYear, double weight, int height,
			String profession, double[] grades) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.birthYear = birthYear;
		this.weight = weight;
		this.height = height;
		this.profession = profession;
		this.grades = grades;
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

	public void setGender(char gender) {
		this.gender = gender;
	}

	public int getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(int birthYear) {
		this.birthYear = birthYear;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public double[] getGrades() {
		return grades;
	}

	public void setGrades(double[] grades) {
		this.grades = grades;
	}
	
	public int getAge() {
		Calendar today = Calendar.getInstance();
		int age = today.get(Calendar.YEAR) - this.getBirthYear();
		return age;
	}
	
	public String[] getGenderArr() {
		String[] strArr = new String[3];
		if (this.getGender() == 'F') {
			String[] strArrTemp = { "Her", "she", "She" };
			strArr = strArrTemp;
		} else {
			String[] strArrTemp = { "His", "he", "he" };
			strArr = strArrTemp;
		}
		return strArr;
	}
	
	public double getAverage() {
		double sum = 0;
		for(int i = 0; i < this.getGrades().length; i++) {
			sum+=this.getGrades()[i];
		}
		return sum/this.getGrades().length;
	}
	
	public void printInfo() {
		System.out.printf(
				"%s %s is %d years old. " + "%s weight is %.1f and %s is %d cm tall. "
						+ "%s is a %s with an average grade of %.3f.",
				this.getFirstName(), this.getLastName(), this.getAge(), this.getGenderArr()[0], this.getWeight(), 
				this.getGenderArr()[1], this.getHeight(),
				this.getGenderArr()[2], this.getProfession(), this.getAverage());
		if (this.getAge() <= 16) {
			System.out.printf("%s %s is under-aged.\n", this.getFirstName(), this.getLastName());
		} else {
			System.out.println();
		}
	}
	
	public static Person readInfo(String line) {
		String[] perArr = line.trim().split(",");
		String firstName = perArr[0].trim();
		String lastName = perArr[1].trim();
		char gender = perArr[2].trim().charAt(0);
		int birthYear = Integer.parseInt(perArr[3].trim());
		double weight = Double.parseDouble(perArr[4].trim());
		int height = Integer.parseInt(perArr[5].trim());
		String profession = perArr[6].trim();
		double[] grades = new double[4];
		for(int i = 0; i < 4; i++) {
			grades[i] = Double.parseDouble(perArr[7+i].trim());
		}
		Person person = new Person(firstName, lastName, gender, birthYear, weight, height, profession, grades);
		
		return person;
	}
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("n = ");
		int n = sc.nextInt();
		sc.nextLine();
		System.out.printf(
				"Enter %d lines with information in format: <първо_име>,<последно_име>,<пол>,<година_на_раждане>,<тегло>,<височина>,<професия>,<оценка1>,<оценка2>,<оценка3>,<оценка4> \n",
				n);
		Person[] perArr = new Person[n];
		for (int i = 0; i < n; i++) {
			String line = sc.nextLine();
			perArr[i] = readInfo(line);
		}
		for(int i = 0; i < n; i++) {
			perArr[i].printInfo();
		}
		sc.close();
		
	}

}
