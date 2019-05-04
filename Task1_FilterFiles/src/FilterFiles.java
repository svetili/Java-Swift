import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FilterFiles {

	public static void fillArray(List<String> array) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of files: ");
		int n = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter " + n + " files on different lines: ");
		for (int i = 0; i < n; i++) {
			String file = sc.nextLine();
			array.add(file);
		}
		sc.close();
	}
	public static List<String> manageArray(List<String> array){
		List<String> arrayRes = new ArrayList<String>();
		array
		.stream()
		.filter(elem -> elem.endsWith(".jpg")||elem.endsWith(".gif")||elem.endsWith(".png"))
		.forEach((elem) -> arrayRes.add(elem));

		arrayRes
		.stream()
		.forEach((elem) -> System.out.println(elem.substring(0, elem.length() - 4) + " " + elem.subSequence(elem.length() - 3, elem.length())));
		return arrayRes;
	}

	public static void main(String[] args) {
		List<String> array = new ArrayList<String>();
		fillArray(array);
		System.out.println("The graphic files are:");
		System.out.println("<name> <extention>");
		
		manageArray(array);
		}

}
