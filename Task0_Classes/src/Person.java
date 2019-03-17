
public class Person {

	private String name;
	private int age;

	public Person() {
		this.name = "No name";
		this.age = -1;
	}

	public Person(String name) {
		this.name = name;
		this.age = -1;
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public void setName(String name) {
		if (!name.isEmpty()) {
			this.name = name;
		}
	}

	public String getName() {
		return this.name;
	}

	public void setAge(int age) {
		if (age > 0) {
			this.age = age;
		}
	}

	public int getAge() {
		return this.age;
	}

	public void printInfo() {
		String name = this.getName();
		int age = this.getAge();
		if (name.contentEquals("No name")) {
			System.out.print("I am John Doe.");
		} else {
			System.out.printf("Hello, I am %s.", name);
		}
		if (age != -1) {
			System.out.printf(" I  am %d years old.\n", age);
		} else {
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Person mitko = new Person("Mitko", 32);
		mitko.printInfo();
		Person svetla = new Person("Svetla");
		svetla.printInfo();
		Person x = new Person();
		x.printInfo();
		// try to set wrong name
		x.setName("");
		x.printInfo();
		
		//set a name and wrong age
		x.setName("x");
		x.setAge(-5);
		x.printInfo();
		
		//set age
		x.setAge(12);
		x.printInfo();
	}

}
