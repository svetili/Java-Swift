import java.util.Scanner;

public class IsPalindrome {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter something:");
		String str1 = sc.nextLine();
		String str2 = "";
		for (char ch : str1.toCharArray()) {
			str2 = ch + str2;
		}
		if (str2.equals(str1)) {
			System.out.println("The string is palindrome!");
		} else {
			System.out.println("The string is NOT palindrome!");
		}
		sc.close();
	}

}
