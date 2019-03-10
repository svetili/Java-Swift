import java.util.Calendar;
import java.util.Scanner;

public class PersonCharacteristics {

	public static void main(String[] args) {
		int number;
		String firstName;
		String lastName;
		short birthYear;
		float weight;
		short height;
		String profession;
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter a positive number:");
		while (!sc.hasNextInt()) {
			System.out.println("That's not a number!");
			sc.next();
		}
		number = sc.nextInt();
		for (int i = 0; i < number; i++) {
			System.out.print("First name: ");
			firstName = sc.next();
			System.out.print("Last name: ");
			lastName = sc.next();
			System.out.print("Birth year: ");
			while (!sc.hasNextShort()) {
				System.out.println("That's not a proper year!");
				sc.next();
			}
			birthYear = sc.nextShort();
			System.out.print("Weight: ");
			while (!sc.hasNextFloat()) {
				System.out.println("That's not a floating point number!");
				sc.next();
			}
			weight = sc.nextFloat();
			System.out.print("Height: ");
			while (!sc.hasNextShort()) {
				System.out.println("That's not a number!");
				sc.next();
			}
			height = sc.nextShort();
			System.out.print("Profession: ");
			profession = sc.next();

			// get age
			Calendar today = Calendar.getInstance();
			byte age = (byte) (today.get(Calendar.YEAR) - birthYear);

			// print
			System.out.printf("%s %s is %d years old. His/her weight is %.1f and he/she is %d cm tall. He/She is a %s. ", firstName,
					lastName, age, weight, height, profession);
			
			if (age < 16) {
				System.out.printf("%s %s is under-aged.\n", firstName, lastName);
			} else {
				System.out.println();
			}		
		}
		sc.close();
	}

}
