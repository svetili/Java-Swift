
public class Student extends Person {
	String[] subjects;
	String facultyNumber;

	public Student(String name, String phone, String facultyNumber, String[] subjects) {
		super(name, phone);
		this.facultyNumber = facultyNumber;
		this.subjects = subjects;
	}

	public String[] getSubjects() {
		return subjects;
	}

	public String getFacultyNumber() {
		return facultyNumber;
	}
	
	public static Student manageNew(String[] strArr) {
		String name = strArr[2];
		String phone = strArr[3];
		String facNum = strArr[4];
		String[] subjects = new String[strArr.length - 5];
		for (int i = 0; i < strArr.length - 5; i++) {
			subjects[i] = strArr[i + 5];
		}
		Student student = new Student(name, phone, facNum, subjects);
		return student;
	}

	@Override
	public int getSalaryPerHour() {
		if (this.getTolerance() > 50) {
			return -10;
		} else {
			return 0;
		}
	}

	@Override
	public int setTolerance(MainUniversity uni) {
		boolean b = true;
		for (int i = 0; i < uni.getPersonIndex(); i++) {
			Person p = uni.getPerson(i);
			if (p == this) {
				uni.getPerson(i).setTolerance(2);
			} else if (p instanceof MaintenanceEmployee) {
				b = uni.getPerson(i).setTolerance(-1);
			}
			if (!b) {
				return i;
			}
		}
		return -1;
	}
}
