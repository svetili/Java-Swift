package account;

import customer.*;

public class LoanAccount extends Account {

	public LoanAccount(Customer owner, double balance, double montlyInterestRate) {
		super(owner, balance, montlyInterestRate);
	}

	@Override
	protected int getSpecialPeriod() {
		if (this.getOwner() instanceof IndividualCustomer) {
			return 3;
		} else {
			return 6;
		}
	}

	@Override
	protected double getSpecialRate() {
		return 0;
	}
	
	

}
