import java.util.HashSet;
import java.util.Set;

public class Asteroid {

	private Set<Asteroid> canSee;
	private int x;
	private int y;
	
	public Asteroid(int x, int y) {
		canSee = new HashSet<Asteroid>();
		this.x = x;
		this.y = y;
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
	
//	@Override
//	public boolean equals(Object o) {
//		if(o == null) return false;
//		if(!(o instanceof Asteroid)) return false;
//		Asteroid a = (Asteroid)o;
//		return a.getX() == this.getX() && a.getY() == this.getY();
//	}
	
}
