import java.util.HashSet;
import java.util.Set;

public class Asteroid {

	private Set<Asteroid> canSee;
	private double distance;
	private int x;
	private int y;
	
	public Asteroid(int x, int y, double distance) {
		canSee = new HashSet<Asteroid>();
		this.x = x;
		this.y = y;
		this.distance = distance;
	}

	public Set<Asteroid> getCanSee() {
		return canSee;
	}

	public void setCanSee(Set<Asteroid> canSee) {
		this.canSee = canSee;
	}
	public void addCanSee(Asteroid asteroid) {
		canSee.add(asteroid);
	}
	public boolean canSee(Asteroid asteroid) {
		return canSee.contains(asteroid);
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

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	
	
//	@Override
//	public boolean equals(Object o) {
//		if(o == null) return false;
//		if(!(o instanceof Asteroid)) return false;
//		Asteroid a = (Asteroid)o;
//		return a.getX() == this.getX() && a.getY() == this.getY();
//	}
	
}
