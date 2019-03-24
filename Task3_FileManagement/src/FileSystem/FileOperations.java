package FileSystem;

public interface FileOperations {

	public void move(String newLocation);

	public FileOperations copy(String newLocation);

	public void execute();

	public void delete();

	public void getInfo();

}
