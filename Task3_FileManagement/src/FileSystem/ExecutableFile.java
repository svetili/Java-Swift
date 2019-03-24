package FileSystem;

import java.time.LocalDateTime;

public class ExecutableFile extends File {
	private LocalDateTime lastExecutionDate;
	private File[] requiredResources;

	public ExecutableFile(String name, String location, File[] requiredResources) {
		super(name, location);
		this.lastExecutionDate = LocalDateTime.MIN;
		this.requiredResources = requiredResources;
	}

	public LocalDateTime getLastExecutionDate() {
		return this.lastExecutionDate;
	}

	protected void setLastExecutionDate() {
		this.lastExecutionDate = LocalDateTime.now();
	}

	public File[] getRequiredResources() {
		return requiredResources;
	}

	@Override
	public void execute() {
		this.setLastExecutionDate();
		System.out.print("Executing ");
		super.execute();
		for (int i = 0; i < this.getRequiredResources().length; i++) {
			if (!this.getRequiredResources()[i].isDeleted()) {
				this.getRequiredResources()[i].execute();
			}
		}
	}

	@Override
	public void getInfo() {
		super.getInfo();
		System.out.println("Last execution date:  " + this.getLastExecutionDate());
		System.out.println("Required resoures: ");
		for (int i = 0; i < this.getRequiredResources().length; i++) {
			File f = this.getRequiredResources()[i];
			System.out.print("        ");
			System.out.println(f.getName());
		}
	}

}
