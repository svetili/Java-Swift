
public class Employee extends Person {
	int salaryPerHour;

	public Employee(String name, String phone, int salaryPerHour) {
		super(name, phone);
		this.salaryPerHour = salaryPerHour;
	}
	

	@Override
	public int getSalaryPerHour() {
		return this.salaryPerHour;
	}
	
	@Override
	protected int setTolerance(MainUniversity uni) {
		// TODO Auto-generated method stub
		return -1;
	}

}
