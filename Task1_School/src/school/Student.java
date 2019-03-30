package school;

public class Student extends Item {
	private static byte numberGeneratior = 0;
	private byte numberInClass;

	public Student(String name) {
		super(name);
		Student.numberGeneratior++;
		this.numberInClass = numberGeneratior;
	}

	public byte getNumberInClass() {
		return numberInClass;
	}

	protected static void setNumberGeneratior(byte numberGeneratior) {
		Student.numberGeneratior = numberGeneratior;
	}

	@Override
	public String toString() {
		return "\n		Student's " + super.toString() + "; numberInClass=" + numberInClass+ "/" + this.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Student) {
			return super.equals(obj) && this.getNumberInClass() == ((Student) obj).getNumberInClass();
		}
		return false;
	}

	@Override
	public int hashCode() {
		return super.hashCode() + this.getNumberInClass();
	}

}
