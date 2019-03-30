package school;

public abstract class Item {
	private String name;

	public Item(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "name=" + name;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Item) {
			return this.getName().equals(((Item) obj).getName());
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		int n = 0;
		for(int i = 0; i < this.getName().length(); i++) {
			n += i*2 + this.getName().charAt(i);
		}
		return n;
	}

}
