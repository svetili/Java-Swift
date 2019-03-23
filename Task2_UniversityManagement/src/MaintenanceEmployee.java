
public class MaintenanceEmployee extends Employee {

	public MaintenanceEmployee(String name, String phone) {
		super(name, phone, 15);
	}

	public static MaintenanceEmployee manageNew(String[] strArr) {
		String name = strArr[2];
		String phone = strArr[3];
		MaintenanceEmployee maintEmployee = new MaintenanceEmployee(name, phone);
		return maintEmployee;
	}

	public int setTolerance(MainUniversity uni) {
		for (int i = 0; i < uni.getPersonIndex(); i++) {
			if (this.getName() != uni.getPerson(i).getName()) {
				uni.getPerson(i).setTolerance(2);
			}
		}
		return -1;
	}

}
