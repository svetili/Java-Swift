package school;

public class School extends Item {
	Clss[] classes;

	public School(String name, Clss[] classes) {
		super(name);
		this.classes = classes;
	}

	public Clss[] getClasses() {
		return classes;
	}

	public int findClass(Clss clss) {
		int i = 0;
		while (!clss.equals(this.getClasses()[i])) {
			i++;
		}
		if (i < this.getClasses().length) {
			return i;
		}
		return -1;
	}

	@Override
	public String toString() {
		String s = "\nSchool's " + super.toString() + "/" + this.hashCode();
		for (int i = 0; i < this.getClasses().length; i++) {
			s += this.getClasses()[i].toString();
		}
		return s;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof School && super.equals(obj)) {
			int i = 0;
			while (((School) obj).getClasses()[i].equals(this.getClasses()[i])) {
				i++;
			}
			if (i == this.getClasses().length) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		int n = super.hashCode();
		for (int i = 0; i < this.getClasses().length; i++) {
			n += this.getClasses()[i].hashCode();
		}
		return n;
	}

	public static void main(String[] args) {
		Student[] students1 = { new Student("Ivan"), new Student("Dimitar"), new Student("Maria") };
		Discipline[] discipline11 = { new Discipline("history", (byte) 4), new Discipline("geography", (byte) 2) };
		Discipline[] discipline12 = { new Discipline("mathematic", (byte) 6) };
		Discipline[] discipline13 = { new Discipline("literature", (byte) 6) };
		Teacher[] teachers1 = { new Teacher("Ivanov", discipline11), new Teacher("Marinova", discipline12),
				new Teacher("Kostova", discipline13) };
		Student.setNumberGeneratior((byte)0);
		Student[] students2 = { new Student("Peter"), new Student("Dimitar"), new Student("Katia") };
		Discipline[] discipline21 = { new Discipline("history", (byte) 4), new Discipline("geography", (byte) 2) };
		Discipline[] discipline22 = { new Discipline("mathematic", (byte) 6) };
		Discipline[] discipline23 = { new Discipline("literature", (byte) 6) };
		Teacher[] teachers2 = { new Teacher("Tetkov", discipline21), new Teacher("Marinova", discipline22),
				new Teacher("Popova", discipline23) };
		Clss[] classes = { new Clss("1A", students1, teachers1), new Clss("1B", students2, teachers2) };
		School school = new School("My school", classes);
		System.out.println(school);
		//System.out.println(classes[0].getStudents()[0].equals(classes[1].getStudents()[0]));
		//System.out.println(classes[0].getStudents()[1].equals(classes[1].getStudents()[1]));
	}

}
