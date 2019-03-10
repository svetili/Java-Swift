import java.util.Scanner;

public class ToBinaryAndHexa {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("n = ");
		int n = sc.nextInt();

		// binary conversion
		int nBin = n;
		String binaryStr = "";
		do {
			binaryStr = nBin % 2 + binaryStr;
			nBin /= 2;
		} while (nBin != 0);
		System.out.println("Binary: " + binaryStr);

		// hexadecimal conversion
		int nHex = n;
		String hexStr = "";
		do {
			String hexS = convertHex(nHex % 16);
			hexStr = hexS + hexStr;
			nHex /= 16;
		} while (nHex != 0);
		System.out.println("Hexadecimal: " + hexStr);

		sc.close();
	}
/**
 * For given decimal digit returns its Hexadecimal equivalent
 * @param nHex
 * @return String
 */
	public static String convertHex(int nHex) {
		String res;
		switch (nHex) {
		case 1:
			res = "1";
			break;
		case 2:
			res = "2";
			break;
		case 3:
			res = "3";
			break;
		case 4:
			res = "4";
			break;
		case 5:
			res = "5";
			break;
		case 6:
			res = "6";
			break;
		case 7:
			res = "7";
			break;
		case 8:
			res = "8";
			break;
		case 9:
			res = "9";
			break;
		case 10:
			res = "A";
			break;
		case 11:
			res = "B";
			break;
		case 12:
			res = "C";
			break;
		case 13:
			res = "D";
			break;
		case 14:
			res = "E";
			break;
		case 15:
			res = "F";
			break;
		default:
			res = "0";
		}
		return res;
	}

}
