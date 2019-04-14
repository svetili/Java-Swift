package relativeFileStructure;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Scanner;

public class ListRelativeFileStructure {

	public static void printDir(File directory, File directoryNew) throws IOException {
		
		//get path
		Path path = Paths.get(directory.toURI());
		
		//get current subtree
		File[] filesInDir = directoryNew.listFiles();
		
		for (File file : filesInDir) {
			
			//for each file get path and relativize it according to the main directory
			Path pathNew = Paths.get(file.toURI());
			Path pathRel = path.relativize(pathNew);
			
			//print relative path
			System.out.println(pathRel);
			
			//recursively get the directory subtree
			if (file.isDirectory()) {
				printDir(directory, file);
			}
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//read path
		System.out.println("Enter full path to directory: ");
		String path = sc.nextLine();
		
		try {
			File directory = new File(path);
			if (!directory.isDirectory()) {
				System.out.println("Directory not found!");
			} else {
				//print subtree
				System.out.println("Subtree: ");
				printDir(directory, directory);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		sc.close();
	}

}
