
public class Coord {

	private int x;
	private int y;
	
	@Override
	public boolean equals(Object o) {
		if(o == null) return false;
		if(!(o instanceof Coord)) return false;
		
		Coord co = (Coord) o;
		
		return (x == co.getX() && y == co.getY());
		
	}
	
	public Coord(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getDistance() {
		return Math.abs(x) + Math.abs(y);
	}
	
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

}
