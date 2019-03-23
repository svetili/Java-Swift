
public abstract class Person {
	String name;
	String phone;
	int tolerance;

	//constructors
	public Person(String name, String phone) {
		this.name = name;
		this.phone = phone;
		this.tolerance = 20;
	}
	
	//getters and setters
	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}
	
	public int getTolerance() {
		return tolerance;
	}

	protected boolean setTolerance(int tolerance) {
		if (this.tolerance > tolerance) {
			this.tolerance += tolerance;
			return true;
		} else {
			this.tolerance = 0;
			return false;
		}
	}

	//all child classes manage idle in similar way
	protected boolean manageIdle() {
		if (this.tolerance > 5) {
			this.tolerance -= 5;
			return true;
		} else {
			this.tolerance = 0;
			return false;
		}
	}

	//all child classes can add or subtract (in case of student) "salary" from the University
	abstract public int getSalaryPerHour();
	//method that will implement tolerance behavior in the child classes
	abstract protected int setTolerance(MainUniversity uni) ;
}
