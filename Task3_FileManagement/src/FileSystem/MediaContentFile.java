package FileSystem;

public class MediaContentFile extends ContentFile {

	public MediaContentFile(String name, String location, String content) {
		super(name, location, content);
	}

	@Override
	public void execute() {
		char ch = '♫';
		String s = ch + " ";
		System.out.println(s + s + s + this.getLocation() + "/" + this.getName());
		super.execute();
	}

}
