package inventory;

public class Writable extends Articule {
	
	private InkColor inkColor;
	
	public Writable(Color color, String brand, float weight, InkColor inkColor) {
		super(color, brand, weight, true);
		this.inkColor = inkColor;
	}
	
	protected InkColor getInkColor() {
		return inkColor;
	}
	
}
