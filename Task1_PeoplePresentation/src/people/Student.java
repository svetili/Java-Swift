package people;

public class Student extends Person {
	private String facultyNumber;
	private int lectureCount;
	private int exerciseCount;

	public Student(String firstName, String lastName, String facultyNumber, int lectureCount, int exerciseCount) {
		super(firstName, lastName);
		this.facultyNumber = facultyNumber;
		this.lectureCount = lectureCount;
		this.exerciseCount = exerciseCount;
	}

	public String getFacultyNumber() {
		return facultyNumber;
	}

	public int getLectureCount() {
		return lectureCount;
	}

	public int getExerciseCount() {
		return exerciseCount;
	}

	public static boolean isValidFacultyNumber(String number) {
		if (number.length() > 10 || number.length() < 5) {
			System.out.println("Expected length for faculty number is between 5 and 10 symbols.");
			return false;
		}
		return true;
	}

	public static boolean isValidNumber(String number, String param) {
		boolean b = Person.isValidNumber(number, param);
		if (!b) {
			return false;
		}
		try {
			Integer.parseInt(number);
			return true;
		} catch (NumberFormatException ex) {
			System.out.printf("Expected integer for %s.\n", param);
			return false;
		}

	}

	public void printInfo() {
		super.printInfo();
		System.out.println("Occupation: Student");
		System.out.println("Faculty number: " + this.getFacultyNumber());
		System.out.printf("Hours per day: %.2f\n", (this.getLectureCount() * 2 + this.getExerciseCount() * 1.5) / 5.0);
		System.out.println();
	}

}
