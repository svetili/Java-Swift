import java.util.Calendar;
import java.util.Scanner;

public class Vehicle {
	static private int counter = 0;
	private String type;
	private String model;
	private int power;
	private double fuelConsumption;
	private int yearProduced;
	private int licenseNo;
	private int weight;
	private String color;
	private int distance;

//constructors
	public Vehicle(String type, String model, int power, double fuelConsumption, int yearProduced, int distance, 
			int weight, String color) {
		this.type = type;
		this.model = model;
		this.power = power;
		this.fuelConsumption = fuelConsumption;
		this.yearProduced = yearProduced;
		this.licenseNo = counter;
		this.distance = distance;
		this.weight = weight;
		this.color = color;
		counter++;
	}

	public Vehicle(String type, String model, int power, double fuelConsumption, int yearProduced, int distance) {
		super();
		this.type = type;
		this.model = model;
		this.power = power;
		this.fuelConsumption = fuelConsumption;
		this.yearProduced = yearProduced;
		this.licenseNo = counter;
		this.distance = distance;
		this.weight = -1;
		this.color = "N/A";
		counter++;
	}
	
	public Vehicle(String type, String model, int power, double fuelConsumption, int yearProduced) {
		super();
		this.type = type;
		this.model = model;
		this.power = power;
		this.fuelConsumption = fuelConsumption;
		this.yearProduced = yearProduced;
		this.licenseNo = counter;
		this.distance = 0;
		this.weight = -1;
		this.color = "N/A";
		counter++;
	}

//getters and setters

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public double getFuelConsumption() {
		return fuelConsumption;
	}

	public void setFuelConsumption(double fuelConsumption) {
		this.fuelConsumption = fuelConsumption;
	}

	public int getYearProduced() {
		return yearProduced;
	}

	public void setYearProduced(int yearProduced) {
		this.yearProduced = yearProduced;
	}

	public int getLicenseNo() {
		return licenseNo;
	}

	public void setLicenseNo(int licenseNo) {
		this.licenseNo = licenseNo;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	// specifics start here

	// calculate car age
	public int getCarAge() {
		int year = this.getYearProduced();
		Calendar today = Calendar.getInstance();
		return today.get(Calendar.YEAR) - year;
	}

	public double getTypeCoefficient() {
		double res = 0.0;
		switch (this.getType()) {
		case "suv":
			res = 1.12;
			break;
		case "truck":
			res = 1.2;
			break;
		case "motorcycle":
			res = 1.5;
			break;
		default:
			res = 1.0;
		}
		return res;
	}

	public double calculateTripPrice(double fuelPrice, double distance) {
		return (distance / 100) * fuelPrice * this.getFuelConsumption();
	}

	public double getInsurancePrice() {
		double res = (0.16 * this.getPower()) * (1.25 * this.getCarAge()) * (0.05 * this.getFuelConsumption())
				* this.getTypeCoefficient();
		return res;

	}

	public void printInfo(double fuelPrice) {
		System.out.printf("%04d-%s, %s, %s\n", this.getLicenseNo(), this.getModel(), this.getYearProduced(),
				this.getColor());
		System.out.printf("Insurance cost: %.2f - Travel cost: %.2f %n", this.getInsurancePrice(),
				this.calculateTripPrice(fuelPrice, this.getDistance()));
	}

	public static Vehicle readInfo(double fuelPrice, String line) {
		String[] vArr = line.trim().split(",");
		String type = vArr[0].trim();
		String model = vArr[1];
		int power = Integer.parseInt(vArr[2].trim());
		double fuelConsumption = Double.parseDouble(vArr[3].trim());
		int year = Integer.parseInt(vArr[4].trim());
		int distance = Integer.parseInt(vArr[5].trim());
		Vehicle vehicle;
		if (vArr.length == 8) {
			int weight = Integer.parseInt(vArr[6].trim());
			String color = vArr[7].trim();
			vehicle = new Vehicle(type, model, power, fuelConsumption, year, distance, weight, color);
		} else {
			vehicle = new Vehicle(type, model, power, fuelConsumption, year, distance);
		}
		return vehicle;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("n = ");
		int n = sc.nextInt();
		sc.nextLine();
		
		System.out.print("fuel price = ");
		double fuelPrice = sc.nextDouble();
		sc.nextLine();
		
		Vehicle[] vArr = new Vehicle[n];
		for (int i = 0; i < n; i++) {
			String line = sc.nextLine();
			vArr[i] = readInfo(fuelPrice, line);
		}
		for(int i = 0; i < n; i++) {
			vArr[i].printInfo(fuelPrice);
		}
		sc.close();

	}

}
