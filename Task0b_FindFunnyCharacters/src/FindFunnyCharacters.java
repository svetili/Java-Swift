import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindFunnyCharacters {

	public static boolean checkLine(String line) {
		Pattern pattern = Pattern.compile("[^a-zA-Z0-9~!@#$%^&*()_+=/\\-\\\\]");
		Matcher matcher = pattern.matcher(line);
		boolean b = false;
		if (matcher.find()) {
			b = true;
			System.out.println("Funny Characters found.");
		} else {
			System.out.println("No funny characters found.");
		}
		return b;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter expressions to check. Enter \"END\" to exit.");
		String line = sc.nextLine();
		while (!"END".contentEquals(line)) {
			checkLine(line);
			line = sc.nextLine();
		}
		sc.close();
	}

}
