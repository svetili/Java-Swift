package FileSystem;

import java.util.Scanner;

public class MainIntrfc {
	private File[] fileList;
	private int fileListLength;

	public MainIntrfc() {
		this.fileList = new File[500];
		this.fileListLength = 0;
	}

	public File[] getFileList() {
		return fileList;
	}

	public int getFileListLength() {
		return fileListLength;
	}

	protected void setFileListLength(int fileListLength) {
		this.fileListLength = fileListLength;
	}

	protected void setFile(File file) {
		int i = this.getFileListLength();
		this.getFileList()[i] = file;
		this.setFileListLength(i + 1);
	}

	public File findFile(String name) {
		int i = 0;
		while (i < this.getFileListLength() && !name.equals(this.getFileList()[i].getName())) {
			i++;
		}
		if (i == this.getFileListLength()) {
			return null;
		} else {
			return this.getFileList()[i];
		}
	}

	public void makeNew(String[] strArr) {
		String name = strArr[1];
		String path = strArr[2];
		String[] s = strArr[3].split("=");
		File file;
		if ("CONTENT".equals(s[0])) {
			if (".avi".equals(name.subSequence(name.length() - 4, name.length()))
					|| ".mp3".equals(name.subSequence(name.length() - 4, name.length()))) {
				file = new MediaContentFile(name, path, s[1]);
			} else {
				file = new DocumentContentFile(name, path, s[1]);
			}
		} else {
			File[] fileLs = new File[strArr.length - 3];
			for (int i = 3; i < strArr.length; i++) {
				fileLs[i - 3] = this.findFile(strArr[i]);
			}
			file = new ExecutableFile(name, path, fileLs);
		}
		this.setFile(file);
	}

	public void moveFile(String[] strArr) {
		this.findFile(strArr[1]).move(strArr[2]);
	}

	public static void main(String[] args) {
		MainIntrfc intrfc = new MainIntrfc();
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		while (!"END".equals(s)) {
			String[] arr = s.split(" ");
			switch (arr[0]) {
			case "MAKE":
				intrfc.makeNew(arr);
				break;
			case "MOVE":
				intrfc.moveFile(arr);
				break;
			case "INFO":
				intrfc.findFile(arr[1]).getInfo();
				System.out.println();
				break;
			case "EXEC":
				File f = intrfc.findFile(arr[1]);
				if (!f.isDeleted()) {
					f.execute();
					System.out.println();
				}
				break;
			case "DEL":
				intrfc.findFile(arr[1]).delete();
			}
			s = sc.nextLine();
		}
		sc.close();
	}

}
