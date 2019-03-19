package credentials;

public class Credentials {
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

}
