package file;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;

public class SaveObjectsToFiles {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//make object
		String[] actors = {"Downey", "Evans", "Hemsworth"};
		Movie movie = new Movie("Avengers", "Russo", actors, LocalDate.of(2019,04,26));
		
		//create if not found directory
		Path outputDir = Paths.get("output");
		if (!Files.exists(outputDir)) {
			Files.createDirectories(outputDir);
		}
		
		//create if not found file
		String filePath = "output/movies.txt";
		File file = new File(filePath);
		if (!file.exists()) {
			file.createNewFile();
		}
		
		//open file and object output streams
		FileOutputStream fop = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fop);
		
		//write the object in the file
		oos.writeObject(movie);
		
		//close object and file output streams
		oos.close();
		fop.close();
		
		System.out.println("Write in file completed!");
		
		//open file and object input streams 
		FileInputStream fis = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		//read the object and write in the console the result
		Movie movieRead = (Movie) ois.readObject();
		System.out.println(movieRead);
		
		//close file and object input streams
		ois.close();
		fis.close();
	}

}
