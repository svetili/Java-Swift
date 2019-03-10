import java.util.Scanner;

public class SumOfNumbersInString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter text: ");
		String text = sc.nextLine();
		int sum = 0;
		int number = 0;
		int prevNumber = 0;
		boolean estimateNumber = false;
		for (char ch : text.toCharArray()) {
			int digit = ch - '0';
			if (digit >= 0 && digit <= 9) {
				estimateNumber = true;
				number = prevNumber * 10 + digit;
				prevNumber = number;
			} else if (estimateNumber) {
				sum += number;
				number = 0;
				prevNumber = 0;
				estimateNumber = false;
			}
		}
		sum += number;
		System.out.println("sum = " + sum);
		sc.close();
	}

}
