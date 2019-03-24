package FileSystem;

public class DocumentContentFile extends ContentFile {

	public DocumentContentFile(String name, String location, String content) {
		super(name, location, content);
	}

	@Override
	public void execute() {
		System.out.println("\u2713 \u2713 \u2713 " + this.getLocation() + "/" + this.getName());
		super.execute();
	}

}
