import java.util.Scanner;

public class MainUniversity {
	int universityBalance;
	Person[] personArr;
	int personIndex;

//constructor
	public MainUniversity() {
		this.universityBalance = 500;
		this.personArr = new Person[500];
		this.personIndex = 0;
	}

//getters, setters
	public int getUniversityBalance() {
		return universityBalance;
	}

	protected void setUniversityBalance(int universityBalance) {
		this.universityBalance = universityBalance;
	}

	public Person[] getPersonArr() {
		return personArr;
	}

	public int getPersonIndex() {
		return personIndex;
	}

	protected void setPersonIndex(int personIndex) {
		this.personIndex = personIndex;
	}

//specific methods
	public Person getPerson(int index) {
		return this.getPersonArr()[index];
	}

	protected void setPerson(Person person) {
		this.personArr[this.getPersonIndex()] = person;
		this.setPersonIndex(this.getPersonIndex() + 1);
	}

	public Person findPerson(String name) {
		int i = 0;
		while (i < this.getPersonIndex() && !name.equals(this.getPerson(i).getName())) {
			i++;
		}
		if (i == this.getPersonIndex())
			return null;
		else {
			return this.getPerson(i);
		}
	}

	protected boolean changeBalance(Person p) {
		int salary = p.getSalaryPerHour();
		int balance = this.getUniversityBalance();
		if (balance > salary) {
			this.setUniversityBalance(balance - salary);
			return true;
		} else {
			this.setUniversityBalance(0);
			return false;
		}
	}

	public void manageNew(String[] arr) {
		switch (arr[1]) {
		case "MAINT":
			this.setPerson(MaintenanceEmployee.manageNew(arr));
			break;
		case "ADMIN":
			this.setPerson(AdministrationEmployee.manageNew(arr));
			break;
		case "TEACH":
			this.setPerson(Teacher.manageNew(arr));
			break;
		case "STUD":
			this.setPerson(Student.manageNew(arr));
		}
	}

	public int manageIdle() {
		int index = this.getPersonIndex();
		int i = 0;
		while (i < index && this.getPerson(i).manageIdle()) {
			i++;
		}
		if (i == index) {
			return -1;
		} else {
			return i;
		}
	}

	public int manageWork(String[] arr) {
		String name = arr[1];
		Person p = this.findPerson(name);
		if (p != null) {
			boolean b = this.changeBalance(p);
			if (!b) {
				return -2;
			}
			int i = p.setTolerance(this);
			return i;
		} else {
			return -3;
		}

	}
	
	public void printInfo() {
		System.out.println("University balance: " + this.getUniversityBalance());
		for(int i = 0; i < this.getPersonIndex(); i++) {
			System.out.println(this.getPerson(i).getName() + " has tolerance " + this.getPerson(i).getTolerance());
		}
	}

	public static void main(String[] args) {
		MainUniversity uni = new MainUniversity();

		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		int i;

		while (!"END".equals(s)) {
			String[] arr = s.split(" ");
			switch (arr[0]) {
			case "NEW":
				uni.manageNew(arr);
				break;
			case "IDLE":
				i = uni.manageIdle();
				if (i != -1) {
					System.out.println(uni.getPerson(i).getName() + " is not happy!");
					return;
				}
				break;
			case "WORK":
				i = uni.manageWork(arr);
				if (i == -2) {
					System.out.println("Bankrupcy");
					return;
				} else if (i == -3) {
					System.out.println("Person with that name is not found");
					return;
				} else if (i != -1) {
					System.out.println(uni.getPerson(i).getName() + " is not happy!");
					return;
				}
			}
			s = sc.nextLine();
		}
		uni.printInfo();
		sc.close();
	}

}
