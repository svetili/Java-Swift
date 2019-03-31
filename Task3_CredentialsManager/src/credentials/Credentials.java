package credentials;

import java.util.Scanner;

public class Credentials {
	private static final String END = "END";
	private String username;
	private String password;
	private String[] passArr;
	private int passCounter;

	// constructor
	public Credentials(String username, String password) {
		this.username = username;
		this.password = password;
		this.passArr = new String[100];
		this.passArr[0] = password;
		this.passCounter = 0;
	}

	// only getUsername
	public String getUsername() {
		return username;
	}

	// getter and setter for password
	public String getPassword() {
		return password;
	}

	public void setPassword(String oldPassword, String password) throws Exception {
		if (this.isAuthPassword(oldPassword) && this.isNewPassword(password)) {
			this.password = password;
			this.passCounter++;
			this.passArr[this.passCounter] = password;
		} else {
			throw new Exception("CHPASS fail!");
		}
	}

	public boolean isNewPassword(String password) throws OldPasswordConflictException {
		for (int i = 0; i <= this.passCounter; i++) {
			if (password.equals(passArr[i])) {
				throw new OldPasswordConflictException("CHPASS fail!", passCounter-i);
			}
		}
		return true;
	}

	public boolean isAuthPassword(String password) {
		return this.getPassword().equals(password);
	}

	public boolean isAuthUsername(String username) {
		return this.getUsername().equals(username);
	}

	// commands

	public static void enrollUser(Credentials[] credArr, int num, String username, String password) {
		credArr[num] = new Credentials(username, password);
	}

	public static void changePassword(Credentials[] credArr, String username, String password, String passwordNew)
			throws Exception {
		int num = getUser(credArr, username, password);
		credArr[num].setPassword(password, passwordNew);
	}

	public static int getUser(Credentials[] credArr, String username, String password) throws Exception {
		int num = 0;
		while (num < credArr.length && !credArr[num].isAuthUsername(username)) {
			num++;
		}
		if (num == credArr.length || !credArr[num].isAuthPassword(password)) {
			throw new Exception("AUTH fail!");
		} else {
			return num;
		}
	}

	public static void main(String[] args) {
		Credentials[] credArr = new Credentials[200];
		int num = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("START");
		String line = sc.nextLine();
		while (!line.equals(END)) {
			try {
				String[] strArr = line.split(" ");
				switch (strArr[0]) {
				case "ENROLL":
					enrollUser(credArr, num, strArr[1], strArr[2]);
					num++;
					break;
				case "CHPASS":
					changePassword(credArr, strArr[1], strArr[2], strArr[3]);
					break;
				case "AUTH":
					getUser(credArr, strArr[1], strArr[2]);
					break;
				}
				System.out.println(strArr[0] + " success!");
			} catch (Exception e) {
				System.out.print(e.getMessage());
				if (e instanceof OldPasswordConflictException) {
					int i = ((OldPasswordConflictException) e).getPasswordConflictIndex();
					System.out.print("[Password matches a recently used one: " + i + "]");
				}
				System.out.println();
			}
			line = sc.nextLine();
		}
		sc.close();
	}

}
