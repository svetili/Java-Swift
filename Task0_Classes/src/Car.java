import java.util.Calendar;

public class Car {

	private String brand;
	private String model;
	private int year;
	private int engineForce;

	public Car() {
		this.brand = "x";
		this.model = "x";
		this.year = 0;
		this.engineForce = 0;
	}

	public Car(String brand, String model, int year, int engineForce) {
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.engineForce = engineForce;
	}

	// brand
	public String getBrand() {
		return this.brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	// model
	public String getModel() {
		return this.model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	// year
	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	// engine
	public int getEngineForce() {
		return this.engineForce;
	}

	public void setEngineForce(int engineForce) {
		this.engineForce = engineForce;
	}

	public int insuranceCategory() {
		int year = this.getYear();
		Calendar today = Calendar.getInstance();
		byte age = (byte) (today.get(Calendar.YEAR) - year);
		int category = 0;
		if (age < 8) {
			category = 1;
		} else if (age >= 8 && age < 15) {
			category = 2;
		} else if (age >= 15 && age < 25) {
			category = 3;
		} else {
			category = 4;
		}
		return category;
	}

	public void printTax() {
		int category = this.insuranceCategory();
		double tax = 0;
		switch (category) {
		case 1:
			tax = 150;
			break;
		case 2:
			tax = 200;
			break;
		case 3:
			tax = 300;
			break;
		default:
			tax = 500;
		}
		int force = this.getEngineForce();
		if (force < 80) {
			tax = tax * 1.2;
		}
		if (force > 140) {
			tax = tax * 1.45;
		}
		System.out.println(tax);
	}

	public static void main(String[] args) {
		Car car1 = new Car("Mercedes-Benz", "S220", 2012, 160);
		car1.printTax();
		Car car2 = new Car("Opel", "Astra", 1996, 85);
		car2.printTax();
		Car car3 = new Car("Bugatti", "Veyron", 2015, 612);
		car3.printTax();
		Car car4 = new Car("Lada", "5", 1989, 75);
		car4.printTax();
	}

}
