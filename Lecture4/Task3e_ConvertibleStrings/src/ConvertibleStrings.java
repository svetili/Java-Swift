import java.util.Scanner;

public class ConvertibleStrings {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter something:");
		String str1 = sc.nextLine();
		System.out.println("Enter something:");
		String str2 = sc.nextLine();
		char[] Arr1 = str1.toCharArray();
		char[] Arr2 = str2.toCharArray();
		int i1 = 0;
		int i2 = 0;
		while (i2 < Arr2.length && i1 < Arr1.length) {
			if (Arr1[i1] == Arr2[i2]) {
				i1++;
				i2++;
			} else {
				i1++;
			}
		}
		if (i2 < Arr2.length) {
			System.out.println(false);
		} else {
			System.out.println(true);
		}
		sc.close();
	}

}
