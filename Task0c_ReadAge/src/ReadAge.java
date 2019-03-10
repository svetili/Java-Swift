import java.util.Scanner;

public class ReadAge {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your age: ");
		int n = sc.nextInt();
		System.out.println(n < 18 ? "You are under-age!" : "You are adult!");
		sc.close();
	}
}
