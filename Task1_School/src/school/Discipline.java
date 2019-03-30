package school;

public class Discipline extends Item {
	private byte hoursPerWeek;

	public Discipline(String name, byte hoursPerWeek) {
		super(name);
		this.hoursPerWeek = hoursPerWeek;
	}

	public byte getHoursPerWeek() {
		return hoursPerWeek;
	}

	@Override
	public String toString() {
		return "\n			Discipline's " + super.toString() + "; hoursPerWeek=" + hoursPerWeek + "/" + this.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Discipline) {
			return super.equals(obj) && this.getHoursPerWeek() == ((Discipline) obj).getHoursPerWeek();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return super.hashCode() + this.getHoursPerWeek();
	}
	
	

}
