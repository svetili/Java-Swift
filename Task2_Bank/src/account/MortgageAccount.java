package account;

import customer.Customer;
import customer.IndividualCustomer;

public class MortgageAccount extends Account {

	public MortgageAccount(Customer owner, double balance, double montlyInterestRate) {
		super(owner, balance, montlyInterestRate);
	}

	@Override
	protected int getSpecialPeriod() {
		if (this.getOwner() instanceof IndividualCustomer) {
			return 6;
		} else {
			return 12;
		}
	}

	@Override
	protected double getSpecialRate() {
		if (this.getOwner() instanceof IndividualCustomer) {
			return 0;
		} else {
			return 0.5;
		}
	}
	
}
