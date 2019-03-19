import java.util.Scanner;

public class Calculator {
	private static final String END = "END";

	public static double sum(double a, double b) {
		return a + b;
	}

	public static double subtract(double a, double b) {
		return a - b;
	}

	public static double multiply(double a, double b) {
		return a * b;
	}

	public static double divide(double a, double b) {
		return a / b;
	}

	public static double percentage(double a, double b) {
		return a * b / 100;
	}

	public static void readwriteInfo() {
		Scanner sc = new Scanner(System.in);
		System.out.println("START");
		String line = sc.nextLine();
		while (!line.equals(END)) {
			String[] strArr = line.split(" ");
			double a = Double.parseDouble(strArr[1]);
			double b = Double.parseDouble(strArr[2]);
			double res = 0.0;
			switch (strArr[0]) {
			case "SUM":
				res = sum(a, b);
				break;
			case "SUB":
				res = subtract(a, b);
				break;
			case "MUL":
				res = multiply(a, b);
				break;
			case "DIV":
				res = divide(a, b);
				break;
			case "PER":
				res = percentage(a, b);
				break;
			}
			System.out.printf("%.3f\n", res);
			line = sc.nextLine();

		}
		sc.close();
	}

	public static void main(String[] args) {
		Calculator.readwriteInfo();
	}

}
