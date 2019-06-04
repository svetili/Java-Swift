package inventory;

public class Articule {
	private Color color;
	private String brand;
	private float weight;
	private boolean writable;

	public Articule(Color color, String brand, float weight, boolean writable) {
		this.color = color;
		this.brand = brand;
		this.weight = weight;
		this.writable = writable;
	}

	protected Color getColor() {
		return color;
	}

	protected String getBrand() {
		return brand;
	}

	protected float getWeight() {
		return weight;
	}

	protected boolean isWritable() {
		return writable;
	}

	public void print() {
		System.out
				.println("Type: " + this.getClass() + "\t Color: " + this.getColor() + "\t Brand: " + this.getBrand());
	}

}
