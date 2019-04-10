package expression;

public enum Operator {
	None(0), Plus(1), Minus(1), Multiply(2), Division(2), Power(3);
	private final int value;

	private Operator(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

}
