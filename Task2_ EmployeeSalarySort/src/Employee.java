import java.util.Scanner;

public class Employee {
	private String name;
	private double salary;
	private String position;
	private String department;
	private int age;
	private String email;

	public Employee(String name, double salary, String position, String department) {
		this.name = name;
		this.salary = salary;
		this.position = position;
		this.department = department;
		this.age = -1;
		this.email = "";
	}

	public Employee(String name, double salary, String position, String department, int age, String email) {
		this.name = name;
		this.salary = salary;
		this.position = position;
		this.department = department;
		this.age = age;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void printInfo() {
		System.out.printf("%s, %s, %s", this.getName(), this.getDepartment(), this.getPosition());
		if (!this.getEmail().isEmpty()) {
			System.out.printf(", %s\n", this.getEmail());
		} else {
			System.out.println();
		}

	}

	public static Employee readInfo(String line) {
		String[] empArr = line.trim().split(",");
		String name = empArr[0].trim();
		double salary = Double.parseDouble(empArr[1].trim());
		String position = empArr[2].trim();
		String department = empArr[3].trim();
		Employee employee;
		if (empArr.length == 6) {
			int age = Integer.parseInt(empArr[4].trim());
			String email = empArr[5].trim();
			employee = new Employee(name, salary, position, department, age, email);
		} else {
			employee = new Employee(name, salary, position, department);
		}
		return employee;
	}

	public static void sortEmployee(Employee[] empArr) {
		int n = empArr.length;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				if (empArr[i].getSalary() < empArr[j].getSalary()) {
					Employee swap = empArr[i];
					empArr[i] = empArr[j];
					empArr[j] = swap;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("n = ");
		//int n = 5;
		int n = sc.nextInt();
		sc.nextLine(); //if you press Enter after the first input this line is needed
		Employee[] empArr = new Employee[n];
		for (int i = 0; i < n; i++) {
			String line = sc.nextLine();
			empArr[i] = readInfo(line);
		}
		sortEmployee(empArr);
		for (int i = 0; i < Math.min(3, n); i++) {
			empArr[i].printInfo();
		}
		sc.close();
	}

}
