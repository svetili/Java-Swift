import java.util.Calendar;
import java.util.Scanner;
import java.lang.Double;

public class PersonCharacteristics3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("n = ");
		int n = sc.nextInt();
		System.out.printf(
				"Enter %d lines with information in format: <първо_име>;<последно_име>;<пол>;<година_на_раждане>;<тегло>;<височина>;<професия>;<оценка1>;<оценка2>;<оценка3>; <оценка4> \n",
				n);
		String[] strArr = new String[n];
		for (int i = 0; i < n; i++) {
			strArr[i] = sc.next();
		}
		for (int i = 0; i < n; i++) {
			String str = strArr[i];
			String[] strArrTemp = str.split(";");

			// get average grade
			double sum = 0;
			for (int j = strArrTemp.length - 1; j > strArrTemp.length - 5; j--) {
				double d = Double.parseDouble(strArrTemp[j]);
				sum += d;
			}
			double average = sum / 4;

			// get age
			Calendar today = Calendar.getInstance();
			byte age = (byte) (today.get(Calendar.YEAR) - Integer.parseInt(strArrTemp[3]));

			// gender management
			String[] genderArr = new String[3];
			if (strArrTemp[2].contentEquals("F")) {
				String[] genderArrTemp = { "Her", "she", "She" };
				genderArr = genderArrTemp;
			} else {
				String[] genderArrTemp = { "His", "he", "he" };
				genderArr = genderArrTemp;
			}

			// print
			System.out.printf(
					"%s %s is %d years old. " + "%s weight is %.1f and %s is %d cm tall. "
							+ "%s is a %s with an average grade of %.3f.",
					strArrTemp[0], strArrTemp[1], age, genderArr[0], Double.parseDouble(strArrTemp[4]), 
					genderArr[1], Integer.parseInt(strArrTemp[5]),
					genderArr[2], strArrTemp[6], average);
			if (age <= 16) {
				System.out.printf("%s %s is under-aged.\n", strArrTemp[0], strArrTemp[1]);
			} else {
				System.out.println();
			}
		}
		sc.close();
	}
}
