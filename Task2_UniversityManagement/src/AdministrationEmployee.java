
public class AdministrationEmployee extends Employee {
	String[] subjects;

	public AdministrationEmployee(String name, String phone, String[] subjects) {
		super(name, phone, 19);
		this.subjects = subjects;
	}

	public String[] getSubjects() {
		return subjects;
	}

	public static AdministrationEmployee manageNew(String[] strArr) {
		String name = strArr[2];
		String phone = strArr[3];
		String[] subjects = new String[strArr.length - 4];
		for (int i = 0; i < strArr.length - 4; i++) {
			subjects[i] = strArr[i + 4];
		}
		AdministrationEmployee adminEmployee = new AdministrationEmployee(name, phone, subjects);
		return adminEmployee;
	}

	public int setTolerance(MainUniversity uni) {
		for (int i = 0; i < uni.getPersonIndex(); i++) {
			Person p = uni.getPerson(i);
			if (!(p instanceof AdministrationEmployee)) {
				if (p instanceof Student || p instanceof Teacher) {
					uni.getPerson(i).setTolerance(3);
				} else {
					uni.getPerson(i).setTolerance(1);
				}
			}
		}
		return -1;
	}

}
