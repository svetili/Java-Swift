package account;

import customer.*;

public abstract class Account {
	private static int iBANCounter = 0;
	private String iBAN;
	private Customer owner;
	private double balance;
	private double montlyInterestRate;

	public Account(Customer owner, double balance, double montlyInterestRate) {
		iBANCounter++;
		this.iBAN = String.format("%08d", iBANCounter);
		this.owner = owner;
		this.balance = balance;
		this.montlyInterestRate = montlyInterestRate;
	}

	public double getBalance() {
		return balance;
	}

	protected void setBalance(double balance) {
		this.balance = balance;
	}

	public int getiBANCounter() {
		return iBANCounter;
	}

	public String getiBAN() {
		return iBAN;
	}

	public Customer getOwner() {
		return owner;
	}

	public double getMontlyInterestRate() {
		return montlyInterestRate;
	}

	public void put(double amount) {
		this.setBalance(this.getBalance() + amount);
		System.out.println("New balance: " + this.getBalance());
	}

	public void get(double amount) {
		if (this.getBalance() > amount) {
			this.setBalance(this.getBalance() - amount);
			System.out.println("New balance: " + this.getBalance());
		} else {
			System.out.println("Not enough money in the account balance!");
		}
	}

	public double info(int period) {

		int specialPeriod = this.getSpecialPeriod();
		double specialDiscount = this.getSpecialRate();
		double balance = this.getBalance();
		double rate = this.getMontlyInterestRate();
		double firstPrdAmnt = 0;
		if (period < specialPeriod) {
			firstPrdAmnt = specialDiscount * period * balance * rate / 100;
		} else {
			firstPrdAmnt = specialDiscount * specialPeriod * balance * rate / 100;
		}

		double secondPrdAmnt = 0;
		if (period > specialPeriod) {
			secondPrdAmnt = (period - specialPeriod) * balance * rate / 100;
		} else {
			secondPrdAmnt = 0;
		}
		System.out.printf("Expected rate accumulation for the first %d months is %.2f\n", period,
				(firstPrdAmnt + secondPrdAmnt));
		return firstPrdAmnt + secondPrdAmnt;

	}

	@Override
	public String toString() {
		return "Account [iBAN=" + iBAN + "]";
	}

	abstract protected int getSpecialPeriod();

	abstract protected double getSpecialRate();

}
