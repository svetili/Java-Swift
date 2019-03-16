import java.util.Scanner;

public class PrintString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter something:");
		String str = sc.nextLine();
		for (char ch : str.toCharArray()) {
			System.out.println(ch);
		}
		sc.close();
	}

}
