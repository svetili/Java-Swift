package snake;

public class Point {
	int x;
	int y;
	char ch;
	
	public Point(int y, int x) {
		this.x = x;
		this.y = y;
		this.ch = ' ';
	}
	
	public Point(int y, int x, char ch) {
		this.x = x;
		this.y = y;
		this.ch = ch;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public char getCh() {
		return ch;
	}

	protected void setCh(char ch) {
		this.ch = ch;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Point) {
			Point point = (Point)obj;
			return this.x == point.x && this.y == point.y;
		}
		return false;
	}
	
	

}
