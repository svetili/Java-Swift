package account;

import customer.Customer;

public class DepositAccount extends Account {

	public DepositAccount(Customer owner, double balance, double montlyInterestRate) {
		super(owner, balance, montlyInterestRate);
	}

	@Override
	protected int getSpecialPeriod() {
		return 0;
	}

	@Override
	protected double getSpecialRate() {
		return 0;
	}
	
	

}
