import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindIntegers {

	public static boolean checkLine(String line) {
		Pattern pattern = Pattern.compile("-?\\d+");
		Matcher matcher = pattern.matcher(line);
		System.out.println("Integer numbers found:");
		boolean b = false;
		while (matcher.find()) {
			b = true;
			System.out.println(matcher.group());
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
