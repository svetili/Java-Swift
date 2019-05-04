import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IsCorrectSQLInsert {

	static boolean checkLine(String line) {
		Pattern pattern = Pattern.compile("^INSERT\\sINTO\\s[a-zA-Z][\\w_]*\\s\\(([a-zA-Z][\\w_]*\\,?)+\\)\\sVALUES\\s\\((\\'?[\\w_\\.]*\\'?\\,?)+\\)$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(line);
		boolean b = false;
		if (matcher.find()) {
			b = true;
		}
		System.out.println(b);
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
