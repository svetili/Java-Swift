package inventory;

public class Marker extends Writable {
	String inkType;
	float fillerThickness;
	boolean permanent;
	
	public Marker(Color color, String brand, float weight, InkColor inkColor, String inkType, float fillerThickness, boolean permanent) throws Exception {
		super(color, brand, weight, inkColor);
		if (weight>500.0)
		       throw new Exception("Weight should be under 500.0 grams");
		this.inkType = inkType;
		this.fillerThickness= fillerThickness;
		this.permanent = permanent;
	}

	protected String getInkType() {
		return inkType;
	}

	protected float getFillerThickness() {
		return fillerThickness;
	}

	protected boolean isPermanent() {
		return permanent;
	}
	
	

}
