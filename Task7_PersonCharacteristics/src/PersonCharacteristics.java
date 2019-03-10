
import java.util.Calendar;

public class PersonCharacteristics {

	public static void main(String[] args) {
		//set person values
		String firstName = "Georgi";
		String lastName = "Georgiev";
		short birthYear = 2002;
		float weight = 48.3f;
		short height = 156;
		String profession = "student";
		
		//get age 
		Calendar today = Calendar.getInstance();
		byte age = (byte) (today.get(Calendar.YEAR) - birthYear);
		
		//print
		System.out.printf("%s %s is %d years old. His weight is %.1f and he is %d cm tall. He is a %s.", firstName,
				lastName, age, weight, height, profession);
	}

}
