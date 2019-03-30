package account;

import java.util.Scanner;

import customer.*;

public class Main {
	private Account[] accounts;
	private int index;

	public Main() {
		this.accounts = new Account[500];
		this.index = 0;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Account[] getAccounts() {
		return accounts;
	}

	public int findAccount(String name) {
		int i = 0;
		while (!name.equals(this.getAccounts()[i].getOwner().getName()) && !name.contentEquals(this.getAccounts()[i].getiBAN())) {
			i++;
		}
		if (i < this.getAccounts().length) {
			return i;
		} else {
			return -1;
		}
	}

	public void open(String[] arr) {
		int i = 1;

		String name = arr[i];
		i++;

		byte typeCustomer = Byte.parseByte(arr[i]);
		i++;

		byte typeAccount = Byte.parseByte(arr[i]);
		i++;

		double balance = Double.parseDouble(arr[i]);
		i++;

		double rate = Double.parseDouble(arr[i]);

		Customer customer = null;
		switch (typeCustomer) {
		case 1:
			customer = new IndividualCustomer(name);
			break;
		case 2:
			customer = new CompanyCustomer(name);
			break;
		default:
			System.out.println("Wrong customer type!");
			return;
		}

		Account account = null;
		switch (typeAccount) {
		case 1:
			account = new DepositAccount(customer, balance, rate);
			break;
		case 2:
			account = new LoanAccount(customer, balance, rate);
			break;
		case 3:
			account = new MortgageAccount(customer, balance, rate);
			break;
		default:
			System.out.println("Wrong account type!");
			return;
		}

		this.getAccounts()[index] = account;
		this.setIndex(++index);
		System.out.println(account);
	}

	public void change(String[] arr) {
		int i = 0;

		String type = arr[i];
		i++;

		String name = arr[i];
		i++;

		double amount = Double.parseDouble(arr[i]);
		if (amount <= 0) {
			System.out.println("The amount should be a positive number!");
		}

		int index = this.findAccount(name);
		if (index != -1) {
			if ("PUT".equals(type)) {
				this.getAccounts()[index].put(amount);
			} else {
				this.getAccounts()[index].get(amount);
			}
		} else {
			System.out.println("The owner is not found!");
		}
	}
	
	public void info(String[] arr) {
		int i = 1;


		String name = arr[i];
		i++;

		int period = Integer.parseInt(arr[i]);
		
		int index = this.findAccount(name);
		if (index != -1) {
				this.getAccounts()[index].info(period);
		} else {
			System.out.println("The owner is not found!");
		}
	}

	public static void main(String[] args) {
		Main intrfc = new Main();
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		while (!"END".equals(s)) {
			String[] arr = s.split(" ");
			switch (arr[0]) {
			case "OPEN":
				intrfc.open(arr);
				break;
			case "PUT":
				intrfc.change(arr);
				break;
			case "GET":
				intrfc.change(arr);
				break;
			case "INFO":
				intrfc.info(arr);
			}
			s = sc.nextLine();
		}
		sc.close();

	}

}
