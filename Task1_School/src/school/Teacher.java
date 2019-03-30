package school;

public class Teacher extends Item {
	private Discipline[] disciplines;

	public Teacher(String name, Discipline[] disciplines) {
		super(name);
		this.disciplines = disciplines;
	}

	public Discipline[] getDisciplines() {
		return disciplines;
	}

	public int findDiscipline(Discipline discipline) {
		int i = 0;
		while (!discipline.equals(this.getDisciplines()[i])) {
			i++;
		}
		if (i < this.getDisciplines().length) {
			return i;
		}
		return -1;
	}

	@Override
	public String toString() {
		String s = "\n		Teacher's " + super.toString()+ "/" + this.hashCode();
		for (int i = 0; i < this.getDisciplines().length; i++) {
			s += this.getDisciplines()[i].toString();
		}
		return s;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Teacher && super.equals(obj)) {
			int i = 0;
			while (((Teacher) obj).getDisciplines()[i].equals(this.getDisciplines()[i])) {
				i++;
			}
			if (i == this.getDisciplines().length) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		int n = super.hashCode();
		for (int i = 0; i < this.getDisciplines().length; i++) {
			n += this.getDisciplines()[i].hashCode();
		}
		return n;
	}

}
