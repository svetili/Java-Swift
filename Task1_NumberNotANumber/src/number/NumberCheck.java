package number;

import java.util.Scanner;

public class NumberCheck {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		while(!"END".equals(s)) {
			try {
				Integer.parseInt(s);
				System.out.println("Number");
			} catch (Exception e) {
				System.out.println("Not a number");
			}
			s = sc.nextLine();
		}
		sc.close();
	}

}
