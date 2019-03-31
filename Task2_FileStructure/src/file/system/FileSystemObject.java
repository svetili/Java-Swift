package file.system;

public class FileSystemObject {
	private String name;
	private FileSystemObject parent;

	public FileSystemObject(String name, FileSystemObject parent) {
		this.name = name;
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public FileSystemObject getParent() {
		return parent;
	}

}