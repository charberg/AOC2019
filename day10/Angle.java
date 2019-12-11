
public class Angle {

	private int x;
	private int y;
	
	public Angle(int x, int y) {
		this.x = x;
		this.y = y;
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
	
	@Override
	public boolean equals(Object o) {
		if(o == null) return false;
		if(!(o instanceof Angle)) return false;
		Angle a = (Angle)o;
		return a.getX() == this.getX() && a.getY() == this.getY();
	}
	
	@Override
	public int hashCode() {
	    return Integer.valueOf(x + y).hashCode();
	}
	
}
