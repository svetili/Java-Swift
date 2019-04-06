package replace;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class WordReplacement {

	//for each word in the initial text compare and replace it, if there is a match in replaceList
	public static void replaceAll(List<String> text, List<Replace> replaceList) {
		Iterator<String> iterT = text.iterator();
		Iterator<Replace> iterR;

		for (int i = 0; i < text.size(); i++) {
			String strTmp = iterT.next();
			iterR = replaceList.iterator();

			while (iterR.hasNext()) {
				Replace replace = iterR.next();

				if (strTmp.equalsIgnoreCase(replace.getOldWord())) {
					text.set(i, replace.getNewWord());
				}
			}
		}
	}

	public static void printInfo(List<String> text) {
		Iterator<String> iter = text.iterator();
		while (iter.hasNext()) {
			String strTmp = iter.next();
			System.out.print(strTmp + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		//normally I would use String[] ,List<String> text is only for exercise purposes 
		List<String> text = new ArrayList<>();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a text:");
		
//		String strTmp;
//		do {
//			strTmp = sc.next();
//			text.add(strTmp);
//		} while (!strTmp.endsWith("."));
		
		String str = sc.nextLine();
		String[] strArr = str.split(" ");
		
		for (int i = 0; i < strArr.length; i++) {
			text.add(strArr[i]);
		}

		System.out.println("Enter how many replacement rules will be used:");
		int n = sc.nextInt();
		sc.nextLine();

		System.out.printf("Enter replacement rules on %d lines (<replaced word> <new word>):\n", n);
		List<Replace> listReplace = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			String oldWord = sc.next();
			String newWord = sc.next();
			sc.nextLine();
			Replace newItem = new Replace(oldWord, newWord);
			listReplace.add(newItem);
		}

		replaceAll(text, listReplace);

		printInfo(text);
		sc.close();
	}

}
