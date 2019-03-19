package bank;

import credentials.Credentials;

public class Account {
	private String name;
	private String govId;
	private double balance;
	Credentials credential;

	public Account(String name, String govId, double balance, Credentials credential) {
		this.name = name;
		this.govId = govId;
		this.balance = balance;
		this.credential = credential;
	}

	public String getName() {
		return name;
	}

	public String getGovId() {
		return govId;
	}

	public double getBalance() {
		return balance;
	}

	private void setBalance(double balance) {
		this.balance = balance;
	}

	
	protected Credentials getCredential() {
		return credential;
	}

	public void deposit(double amount) {
		this.setBalance(this.getBalance() + amount);
	}

	public void withdraw(double amount) {
		this.setBalance(this.getBalance() - amount);
	}

	boolean hasAccess(String password) {
		if (this.credential.isAuthPassword(password)) {
			return true;
		} else {
			return false;
		}
	}

}
