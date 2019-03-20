
public class Person {
	private String name;
	private double balance;
	private String purchases;

	public Person(String name, double blance) {
		this.name = name;
		this.balance = blance;
		this.purchases = "";
	}

	public String getName() {
		return name;
	}

	public double getBalance() {
		return balance;
	}

	private void setBalance(double blance) {
		this.balance = blance;
	}
	
	public String getPurchases() {
		return purchases;
	}

	protected void setPurchases(String prodName) {
		this.purchases += " " + prodName;
	}

	protected void changeBalance(double price) {
		this.setBalance(this.getBalance() - price);
	}
}
