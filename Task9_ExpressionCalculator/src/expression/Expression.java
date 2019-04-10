package expression;

public class Expression {
	private double value;
	private Operator operator;
	private Expression left;
	private Expression right;

	public Expression(double value) {
		this.operator = Operator.None;
		this.left = null;
		this.right = null;
		this.value = value;
	}

	public Expression(Operator operator, Expression left, Expression right) {
		this.operator = operator;
		this.left = left;
		this.right = right;
		this.setValue();
	}

	public double getValue() {
		return value;
	}

	protected void setValue(double value) {
		this.value = value;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public Expression getLeft() {
		return left;
	}

	protected void setLeft(Expression left) {
		this.left = left;
		this.setValue();
	}

	public Expression getRight() {
		return right;
	}

	protected void setRight(Expression right) {
		this.right = right;
		this.setValue();
	}

	protected void setValue() {
		if (this.left != null && this.right != null) {
			double res = 0;
			switch (this.getOperator()) {
			case Plus:
				res = this.left.getValue() + this.right.getValue();
				break;
			case Minus:
				res = this.left.getValue() - this.right.getValue();
				break;
			case Multiply:
				res = this.left.getValue() * this.right.getValue();
				break;
			case Division:
				res = this.left.getValue() / this.right.getValue();
				break;
			case Power:
				res = Math.pow(this.left.getValue(), this.right.getValue());
				break;
			default:
				res = 0;
			}
			this.setValue(res);
		}
	}

}
