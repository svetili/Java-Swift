package person;

public enum Gender {
	Male('M'), Female('F');
	private final char value;

	private Gender(char value) {
		this.value = value;
	}

	public char getValue() {
		return value;
	}
	
}
