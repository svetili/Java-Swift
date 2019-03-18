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

	public boolean setPassword(String oldPassword, String password) {
		if (this.isAuthPassword(oldPassword) && this.isNewPassword(password)) {
			this.password = password;
			this.passCounter++;
			this.passArr[this.passCounter] = password;
			return true;
		} else {
			return false;
		}
	}

	public boolean isNewPassword(String password) {
		for (int i = 0; i < 100; i++) {
			if (password.equals(passArr[i])) {
				return false;
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

	public static boolean enrollUser(Credentials[] credArr, int num, String username, String password) {
		credArr[num] = new Credentials(username, password);
		return true;
	}

	public static boolean changePassword(Credentials[] credArr, String username, String password, String passwordNew) {
		int num = getUser(credArr, username, password);
		if (num == -1) {
			return false;
		} else {
			return credArr[num].setPassword(password, passwordNew);
		}
	}

	public static int getUser(Credentials[] credArr, String username, String password) {
		int num = 0;
		while (num < credArr.length && !credArr[num].isAuthUsername(username)) {
			num++;
		}
		if (num == credArr.length || !credArr[num].isAuthPassword(password)) {
			return -1;
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
			String[] strArr = line.split(" ");
			boolean b = true;
			switch (strArr[0]) {
			case "ENROLL":
				b = enrollUser(credArr, num, strArr[1], strArr[2]);
				if (b) {
					num++;
				}
				break;
			case "CHPASS":
				b = changePassword(credArr, strArr[1], strArr[2], strArr[3]);
				break;
			case "AUTH":
				int n = getUser(credArr, strArr[1], strArr[2]);
				b = (n != -1) ? true : false;
				break;
			}
			if (b) {
				System.out.println(strArr[0] + " success");
			} else {
				System.out.println(strArr[0] + " fail");
			}
			line = sc.nextLine();
		}
		sc.close();
	}

}
