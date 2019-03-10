import java.util.Scanner;

public class PrintCountOfWords {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter text: ");
		String text = sc.nextLine();
		char[] chPunct = { '.', '!', '?', ',', ':', ';', '\'', '’', '\"', '-', '(', ')' };
		boolean isWord = true;
		int count = 0;
		for (char ch : text.toCharArray()) {
			// check the character is not alphabet
			if (ch < 'A' || ch > 'z') {
				// if we reached ' ' and the word is valid then count it 
				if (ch == ' ' && isWord) {
					count++;
					// if we reached ' ' but the word is not valid reset the word flag 
				} else if (ch == ' ') {
					isWord = true;
				} else {
					// check the symbol if it is punctuation character
					boolean isPunct = false;
					int i = 0;
					while (!isPunct && i < chPunct.length) {
						if (ch == chPunct[i]) {
							isPunct = true;
						}
						i++;
					}
					if (!isPunct) {
						isWord = false;
					}
				}
			}
		}
		if (isWord) {
			count++;
		}
		System.out.println("Word number: " + count);
		sc.close();
	}

}
