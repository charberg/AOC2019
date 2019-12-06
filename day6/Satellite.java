import java.util.ArrayList;
import java.util.List;

public class Satellite {

	private String name;
	private int depth;
	private List<Satellite> children;
	
	public Satellite(String name) {
		this.name = name;
		children = new ArrayList<Satellite>();
	}
	
	public int getDepth() {
		return depth;
	}
	public void setDepth(int depth) {
		this.depth = depth;
	}
	public List<Satellite> getChildren() {
		return children;
	}
	public void setChildren(List<Satellite> children) {
		this.children = children;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void addChild(Satellite sat) {
		this.children.add(sat);
	}
	
	public void findDepth(int depth) {
		this.depth = depth;
		if(children == null || children.isEmpty()) {
			return;
		}
		for(Satellite child : children) {
			child.findDepth(depth+1);
		}
	}
	
	public int findSanta() {	//Return total distance between YOU and SAN
		
		if(this.name.equals("YOU") || this.name.equals("SAN")) {
			return 0;	//This is good, and the "base depth", we're counting backwards
		}
		
		if(children == null || children.isEmpty()) {
			return Integer.MIN_VALUE;
		}
		
		//if I am not YOU or SAN, and I have children, keep looking.
		int total = 0;	//Did we find both?
		int totalDepth = 0;
		for(Satellite child : children) {
			int result = child.findSanta();
			if(result > -1) {
				totalDepth = totalDepth + result;
				total++;
				if(total == 2) {	//If we've found TWO good results, this is a common node between Santa/You. Might need to -2 solution
					System.out.println(totalDepth);
					System.exit(1);
				}
			}
		}
		
		if(total == 1) return totalDepth + 1;	//if we found only one, return the depth to that
		
		return Integer.MIN_VALUE;	//Shouldn't get here I guess, but if we didn't find it return a fail.
	}
	
}
