package FileSystem;

import java.time.LocalDateTime;

public class ContentFile extends File {
	private String content;
	private LocalDateTime lastModifiedDate;

	public ContentFile(String name, String location, String content) {
		super(name, location);
		this.content = content;
		this.lastModifiedDate = LocalDateTime.now();
	}

	public String getContent() {
		return content;
	}

	protected void setContent(String content) {
		this.content = content;
		this.setLastModifiedDate();
	}

	public LocalDateTime getLastModifiedDate() {
		return lastModifiedDate;
	}

	protected void setLastModifiedDate() {
		this.lastModifiedDate = LocalDateTime.now();
	}

	public void modifyData(String content) {
		this.setContent(content);
	}

	@Override
	public ContentFile copy(String newLocation) {
		ContentFile fileNew = new ContentFile(this.getName(), newLocation, this.getContent());
		return fileNew;
	}

	@Override
	public void getInfo() {
		super.getInfo();
		System.out.println("Last modification date: " + this.getLastModifiedDate());
	}

	@Override
	public void execute() {
		System.out.println(this.getContent());
	}

}
