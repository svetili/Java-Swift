package FileSystem;

import java.time.LocalDateTime;

public class File implements FileOperations {
	String name;
	String location;
	LocalDateTime creationDate;
	boolean isDeleted;

	public File(String name, String location) {
		this.name = name;
		this.location = location;
		this.creationDate = LocalDateTime.now();
		this.isDeleted = false;
	}

	public String getLocation() {
		return location;
	}

	protected void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	protected boolean isDeleted() {
		return isDeleted;
	}

	@Override
	public void move(String newLocation) {
		this.setLocation(newLocation);

	}

	@Override
	public File copy(String newLocation) {
		File fileNew = new File(this.getName(), newLocation);
		return fileNew;
	}

	@Override
	public void execute() {
		System.out.println(this.getLocation() + "/" + this.getName());
	}

	@Override
	public void delete() {
		this.isDeleted = true;

	}

	@Override
	public void getInfo() {
		System.out.printf("Name: %s/%s", this.getLocation(), this.getName());
		if (this.isDeleted()) {
			System.out.println("[DELETED]");
		} else {
			System.out.println();
		}
		System.out.printf("Creation date: %s\n", this.getCreationDate(), this.isDeleted());
	}

}
