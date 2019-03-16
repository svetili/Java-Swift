import java.util.Scanner;

public class LongestCommonSubstrin {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter something:");
		String str1 = sc.nextLine();
		System.out.println("Enter something:");
		String str2 = sc.nextLine();
		char[] Arr1 = str1.toCharArray();
		char[] Arr2 = str2.toCharArray();
		int lengthMax = 0;
		int indexMax = 0;
		int i1 = 0;
		int i2 = 0;
		while (i1 < Arr1.length - lengthMax) {

			while (i2 < Arr2.length - lengthMax) {
				int lengthTmp = 0;
				int index1Tmp = i1;
				int index2Tmp = i2;
				while (index1Tmp < Arr1.length && index2Tmp < Arr2.length && Arr1[index1Tmp] == Arr2[index2Tmp]) {
					index1Tmp++;
					index2Tmp++;
					lengthTmp++;
				}
				if (lengthTmp > lengthMax) {
					lengthMax = lengthTmp;
					indexMax = i1;
				}
				i2++;
			}
			i1++;
			i2 = 0;
		}
		System.out.println("The longest common substring is: ");
		for(int i = indexMax; i < indexMax + lengthMax; i++) {
			System.out.print(Arr1[i]);
		}
		sc.close();
	}

}
