package people;

public class Worker extends Person {
	private double weekSalary;
	private double workHoursPerDay;

	public Worker(String firstName, String lastName, double weekSalary, double workHoursPerDay) {
		super(firstName, lastName);
		this.weekSalary = weekSalary;
		this.workHoursPerDay = workHoursPerDay;
	}

	public double getWeekSalary() {
		return weekSalary;
	}

	public double getWorkHoursPerDay() {
		return workHoursPerDay;
	}

	public void printInfo() {
		super.printInfo();
		System.out.println("Occupation: Worker");
		System.out.println("Week salary: " + this.getWeekSalary());
		System.out.println("Hours per day: " + this.getWorkHoursPerDay());
		System.out.println();
	}

}
