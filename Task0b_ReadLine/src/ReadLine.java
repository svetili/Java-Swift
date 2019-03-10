import java.util.Scanner;

public class ReadLine {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Type something: ");
		String s = sc.nextLine();
		System.out.println("You typed: " + s);	
		sc.close();
	}

}
