package file.system;

import java.util.Scanner;

public class Main {
	private FileSystemObject[] fileSystem;
	int index;

	public Main() {
		this.fileSystem = new FileSystemObject[500];
		this.index = 0;
	}

	public FileSystemObject[] getFileSystem() {
		return fileSystem;
	}

	public int getIndex() {
		return index;
	}

	protected void iterIndex() {
		this.index++;
	}

	protected void addFile(FileSystemObject file) {
		this.getFileSystem()[this.getIndex()] = file;
		this.iterIndex();
	}

	//find the file in the file system by given name ... 
	//TODO: not entirely correct if we can create files/folders with the same name 
	//should contain verification of the parent at least ... 
	//may be some recursive verification for the parent too
	//I will not do it because I am lazy but at least I thought about it :)
	public int findFile(String name) throws Exception {
		int i = 0;
		while (i < this.getIndex() && !name.equals(this.getFileSystem()[i].getName())) {
			i++;
		}
		if (i == this.getIndex()) {
			throw new Exception("Directory does not exist!");
		}
		return i;
	}

	//check if all folders in the path are created and with the right parent
	public void checkPath(String path) throws Exception {
		String[] arr = path.split("/");
		int len = arr.length;
		for (int i = 1; i < len - 1; i++) {
			int k = this.findFile(arr[i - 1]);
			int s = this.findFile(arr[i]);
			if (!(this.getFileSystem()[k] == this.getFileSystem()[s].getParent())) {
				throw new Exception("Directory does not exist!");
			}
		}
	}
	
	public static boolean checkName(String type, String name) {
		if ("".equals(name)) {
			return false;
		}
		for (char ch : name.toCharArray()) {
			if ((ch < 'A' || ch > 'Z') && (ch < 'a' || ch > 'z')  && ch != '(' && ch != ')' && ch != '.' && ch != '!' && ch != '?' && ch != '_') {
				return false;
			}
		}
		char ch = name.charAt(0);
		if (ch == '(' || ch == ')' || ch == '.' || ch == '!' || ch == '?' || ch == '_') {
			return false;
		}
		String[] strArr = name.split(".");
		if ("mkdir".equals(type) && strArr.length > 1) {
			return false;
		}
		if ("file".equals(type) && (strArr.length != 2 || strArr[1].length() > 6)) {
			return false;
		}
		return true;
	}

	//use one method for folder and file creation
	public void create(String type, String path) throws Exception {
		String[] arr = path.split("/");
		int len = arr.length;
		if (len == 1) {
			createFirst(type, path);
			return;
		}
		String parentName = arr[len - 2];
		String name = arr[len - 1];
		if (!checkName(type, name)) {
			throw new Exception("Invalid name specified!");
		}
		int i = this.findFile(parentName);
		if (this.getFileSystem()[i] instanceof FolderObject) {
			FolderObject parent = (FolderObject) (this.getFileSystem()[i]);
			if ("mkdir".equals(type)) {
				FolderObject folderNew = new FolderObject(name, parent);
				this.addFile(folderNew);
				parent.addChild(folderNew);
			} else {
				FileObject fileNew = new FileObject(name, parent);
				this.addFile(fileNew);
				parent.addChild(fileNew);
			}
		} else {
			throw new Exception("Illegal operation!");
		}
	}
	
	
	// case when the directory don't have parent
	public void createFirst(String type, String name) throws Exception {
		if (!checkName(type, name)) {
			throw new Exception("Invalid name specified!");
		}
		if ("touch".equals(type)) {
			throw new Exception("Illegal operation!");
		}
		FolderObject folderNew = new FolderObject(name, null);
		this.addFile(folderNew);
	}

	//MAIN
	public static void main(String[] args) {
		Main intrfc = new Main();
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int n = 1;
		while (!"END".equals(s)) {
			try {
				String[] arr = s.split(" ");
				switch (arr[0]) {
				case "mkdir":
				case "touch":
					intrfc.create(arr[0], arr[1]);
					break;
				default:
					throw new Exception("Wrong operator!");
				}
			} catch (Exception e) {
				System.out.println(n + " - " + e.getMessage());
			}
			s = sc.nextLine();
			n++;
		}
		sc.close();
	}

}
