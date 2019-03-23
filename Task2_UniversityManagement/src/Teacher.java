
public class Teacher extends Employee {
	String[] subjects;

	public Teacher(String name, String phone, String[] subjects) {
		super(name, phone, 25);
		this.subjects = subjects;
	}
	
	public String[] getSubjects() {
		return subjects;
	}
	
	public static Teacher manageNew(String[] strArr) {
		String name = strArr[2];
		String phone = strArr[3];
		String[] subjects = new String[strArr.length - 4];
		for(int i = 0; i < strArr.length - 4; i++) {
			subjects[i] = strArr[i+4];
		}
		Teacher teacher = new Teacher(name, phone, subjects);
		return teacher;
	}
	
	public int setTolerance(MainUniversity uni) {
		boolean b = true;
		for (int i = 0; i < uni.getPersonIndex(); i++) {
			Person p = uni.getPerson(i);
			if (!(p instanceof Teacher)) {
				if (p instanceof Student) {
					uni.getPerson(i).setTolerance(3);
				} else if (p instanceof AdministrationEmployee){
					b = uni.getPerson(i).setTolerance(-1);
					
				} else if (p instanceof MaintenanceEmployee) {
					b = uni.getPerson(i).setTolerance(-3);
				}
			}
			if (!b) {
				return i;
			}
		}
		return -1;
	}

}
