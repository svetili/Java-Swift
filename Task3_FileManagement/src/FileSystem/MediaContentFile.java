﻿package FileSystem;

public class MediaContentFile extends ContentFile {

	public MediaContentFile(String name, String location, String content) {
		super(name, location, content);
	}

	@Override
	public void execute() {
		System.out.println("\u266B \u266B \u266B " + this.getLocation() + "/" + this.getName());
		super.execute();
	}

}
