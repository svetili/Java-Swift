package school;

public class Clss extends Item {
	private Student[] students;
	private Teacher[] teachers;

	public Clss(String name, Student[] students, Teacher[] teachers) {
		super(name);
		this.students = students;
		this.teachers = teachers;
	}

	public Student[] getStudents() {
		return students;
	}

	public Teacher[] getTeachers() {
		return teachers;
	}
	
	public int findStudent(Student student) {
		int i = 0;
		while (!student.equals(this.getStudents()[i])) {
			i++;
		}
		if (i < this.getStudents().length) {
			return i;
		}
		return -1;
	}
	
	public int findTeacher(Teacher teacher) {
		int i = 0;
		while (!teacher.equals(this.getTeachers()[i])) {
			i++;
		}
		if (i < this.getTeachers().length) {
			return i;
		}
		return -1;
	}
	
	@Override
	public String toString() {
		String s = "\n	Class " + super.toString()+ "/" + this.hashCode();
		for (int i = 0; i < this.getStudents().length; i++) {
			s += this.getStudents()[i].toString();
		}
		for (int i = 0; i < this.getTeachers().length; i++) {
			s += this.getTeachers()[i].toString();
		}
		return s;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Clss && this.getName().equals(((Clss)obj).getName())) {
			int i = 0;
			while (((Clss) obj).getStudents()[i].equals(this.getStudents()[i])) {
				i++;
			}
			int j = 0;
			while (((Clss) obj).getTeachers()[j].equals(this.getTeachers()[j])) {
				j++;
			}
			if (i == this.getStudents().length && j == this.getTeachers().length) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		int n = super.hashCode();
		for (int i = 0; i < this.getStudents().length; i++) {
			n += this.getStudents()[i].hashCode();
		}
		for (int i = 0; i < this.getTeachers().length; i++) {
			n += this.getTeachers()[i].hashCode();
		}
		return n;
	}

}
