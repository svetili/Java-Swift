package file.system;

public class FolderObject extends FileSystemObject {
	private FileSystemObject[] children;
	private int index;
	
	public FolderObject(String name, FileSystemObject parent) {
		super(name, parent);
		this.children = new FileSystemObject[200];
		this.index = 0;
	}	

	public FileSystemObject[] getChildren() {
		return children;
	}

	public int getIndex() {
		return index;
	}

	protected void iterIndex() {
		this.index++;
	}

	protected void addChild(FileSystemObject child) {
		this.getChildren()[index] = child;
		this.iterIndex();
	}
	
}
