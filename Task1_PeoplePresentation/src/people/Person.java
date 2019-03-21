package people;

public class Person {
	private String firstName;
	private String lastName;

	public Person(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public static boolean isValidName(String name, String parameter) {
		if (name.length() < 2 || name.length() > 30) {
			System.out.printf("Expected length for %s is between 2 and 30 symbols.\n", parameter);
			return false;
		}
		char[] chArr = name.toCharArray();
		for (int i = 0; i < chArr.length; i++) {
			if (chArr[i] < 'A' || chArr[i] > 'z') {
				System.out.printf("Expected only Latin letters in %s\n", parameter);
				return false;
			}
		}
		if (chArr[0] < 'A' || chArr[0] > 'Z') {
			System.out.printf("Expected upper case letter at first position of %s\n", parameter);
			return false;
		}
		return true;
	}
	
	public static boolean isValidNumber(String number, String parameter) {
		if("-".equals(number.subSequence(0, 0))) {
			System.out.printf("Expected positive number.\n", parameter);
			return false;
		}
		return true;
	}
	
	public void printInfo() {
		System.out.println("First name: " + this.getFirstName());
		System.out.println("Last name: " + this.getLastName());
	}

}


