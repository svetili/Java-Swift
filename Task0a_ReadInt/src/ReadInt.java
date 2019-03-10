import java.util.Scanner;

public class ReadInt {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Type number: ");
		int n = sc.nextInt();
		System.out.println("number + 1: " + (n+1));	
		sc.close();
	}

}
