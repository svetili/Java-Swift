package education;

public enum Degree {
	None('N'), Primary('P'), Secondary('S'), Bachelor('B'), Master('M'), Doctorate('D');
	private final char value;

	private Degree(char value) {
		this.value = value;
	}

	public char getValue() {
		return value;
	}

}
