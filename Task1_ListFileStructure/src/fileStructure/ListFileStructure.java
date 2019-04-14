package fileStructure;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ListFileStructure {

	public static void printDir(File directory) throws IOException {
		File[] filesInDir = directory.listFiles();
		for (File file : filesInDir) {
			System.out.println(file);
			if (file.isDirectory()) {
				printDir(file);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("Enter full path to directory: ");
		Scanner sc = new Scanner(System.in);
		String path = sc.nextLine();
		try {
			File directory = new File(path);
			if (!directory.isDirectory()) {
				System.out.println("Directory not found!");
			} else {
				printDir(directory);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}

}
