package bank;

import java.util.Scanner;
import credentials.Credentials;

public class Bank {
	private static final String END = "END";
	private Account[] accArr;
	private double asset;

	public Bank() {
		this.accArr = new Account[5];
		this.asset = 0.0;
	}

	public double getAsset() {
		return asset;
	}

	private void setAsset(double asset) {
		this.asset = asset;
	}

	public boolean openAccount(String name, String govId, String username, String password) {
		Credentials credential = new Credentials(username, password);
		Account acc = new Account(name, govId, 0, credential);
		int i = 0;
		while (i < 5 && !(this.accArr[i] == null)) {
			i++;
		}
		if (i < 5) {
			accArr[i] = acc;
			return true;

		} else {
			return false;
		}

	}

	private int identifyAccount(String username) {
		int i = 0;
		while (i < this.accArr.length && !this.accArr[i].getCredential().isAuthUsername(username)) {
			i++;
		}
		if (i == this.accArr.length) {
			return -1;
		} else {
			return i;
		}
	}

	public boolean closeAccount(String username, String password) {
		int i = this.identifyAccount(username);
		if (i != -1 && this.accArr[i].getCredential().isAuthPassword(password)) {
			this.accArr[i] = null;
			return true;
		} else {
			return false;
		}
	}

	public boolean deposit(String username, double amount) {
		int i = this.identifyAccount(username);
		if (i != -1 && amount > 0) {
			this.accArr[i].deposit(amount);
			this.setAsset(this.getAsset() + amount);
			return true;
		} else {
			return false;
		}

	}

	public boolean withdraw(String username, String password, double amount) {
		int i = this.identifyAccount(username);
		if (i != -1 && this.accArr[i].getCredential().isAuthPassword(password)
				&& this.accArr[i].getBalance() > amount) {
			this.accArr[i].withdraw(amount);
			this.setAsset(this.getAsset() - amount);
			return true;
		} else {
			return false;
		}

	}

	public boolean transfer(String username, String password, double amount, String recipient) {
		int i = this.identifyAccount(username);
		if (i != -1 && this.accArr[i].getBalance() > amount && this.withdraw(username, password, amount)
				&& this.deposit(recipient, amount)) {
			return true;
		} else {
			return false;
		}
	}

	public void printInfo() {
		System.out.printf("%.2f\n", this.getAsset());
		for (int i = 0; i < 5; i++) {
			if (this.accArr[i] != null) {
				System.out.printf("%s, %s, %.2f\n", this.accArr[i].getName(), this.accArr[i].getGovId(),
						this.accArr[i].getBalance());
			}
		}
	}

	public static void print(String op, boolean b) {
		if (b) {
			System.out.println(op + " success");
		} else {
			System.out.println(op + " fail");
		}
	}

	public static void main(String[] args) {
		Bank bank = new Bank();
		Scanner sc = new Scanner(System.in);
		System.out.println("START");
		String line = sc.nextLine();
		while (!line.equals(END)) {
			String[] strArr = line.split(" ");
			boolean b = true;
			switch (strArr[0]) {
			case "OPEN":
				b = bank.openAccount(strArr[3], strArr[4], strArr[1], strArr[2]);
				break;
			case "CLOSE":
				b = bank.closeAccount(strArr[1], strArr[2]);
				break;
			case "DEPOSIT":
				b = bank.deposit(strArr[1], Double.parseDouble(strArr[2]));
				break;
			case "WITHDRAW":
				b = bank.withdraw(strArr[1], strArr[2], Double.parseDouble(strArr[3]));
				break;
			case "TRANSFER":
				b = bank.transfer(strArr[1], strArr[2], Double.parseDouble(strArr[3]), strArr[4]);
			}
			print(strArr[0], b);
			line = sc.nextLine();
		}
		sc.close();
		bank.printInfo();
	}

}
