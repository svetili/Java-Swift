import java.util.Scanner;

public class PrintLetterCount {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter something:");
		String str = sc.nextLine();
		String strTemp = str.toLowerCase();
		for (int i = 0; i < strTemp.length(); i++) {
			char[] chArr = strTemp.toCharArray();
			if (chArr[i] != '@') {
				int num = 0;
				for (char chTmp : chArr) {
					if (chArr[i] == chTmp) {
						num++;
					}
				}
				System.out.println(chArr[i] + "(" + num + ")");
				strTemp = strTemp.replace(chArr[i], '@');
			}
		}
		sc.close();
	}

}
