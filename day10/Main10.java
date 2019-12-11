import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main10 {

	public static void main(String[] args) throws Exception {
	
		try {
			
	        FileInputStream fstream = new FileInputStream("day10\\resources\\in.txt");
	        DataInputStream in = new DataInputStream(fstream);
	        BufferedReader br = new BufferedReader(new InputStreamReader(in));
	        String strLine;
	        int edge = 41;	//Square space of 42x42
	        List<List<Asteroid>> space = new ArrayList<>();
	        List<Asteroid> asteroids = new ArrayList<>();
	        
	        //Init space
	        for(int i = 0; i <= edge; i++) {
	        	space.add(new ArrayList<Asteroid>());
	        }
	        
	        int lineCount = 0;
	        while ((strLine = br.readLine()) != null) {
	        	String[] line = strLine.split("");
	        	for(int i = 0; i < strLine.length(); i++) {
	        		if(line[i].equals("#")) {
	        			Asteroid a = new Asteroid(i, lineCount, 0);
	        			space.get(i).add(a);
	        			asteroids.add(a);
	        		} else {
	        			space.get(i).add(null);	//In space no one can hear your NPEs
	        		}
	        	}
	        	lineCount++;
	        }
	        
	        
	        
	        //Every x/y loop pair represents an angle.
    		//We want to "hop" along this angle, collecting the first android we find.
    		//Also, store angle as already visited - Any "perfect multiple" of a seen angle should be ignored.
	        
	        for(Asteroid base : asteroids) {
	        	HashMap<Double, Asteroid> astMap = new HashMap<>();
	        	for(Asteroid target : asteroids) {
	        		Double angle = getAngle(target, base.getX(), base.getY());
	        		double distance = Math.sqrt((target.getY() - base.getY()) * (target.getY() - base.getY()) + (target.getX() - base.getX()) * (target.getX() - base.getX()));
	        		if(astMap.get(angle) == null) {
	        			astMap.put(angle, new Asteroid(target.getX(), target.getY(), distance));
	        		} else if(astMap.get(angle).getDistance() > distance){
	        			astMap.put(angle, new Asteroid(target.getX(), target.getY(), distance));
	        		}
	        	}
	        	base.getCanSee().addAll(astMap.values());
	        }
	        
	        int max = 0;
	        
	        for(Asteroid asteroid : asteroids) {
	        	if(asteroid.getCanSee().size() > max) {
	        		System.out.println(asteroid.getCanSee().size());
	        		max = asteroid.getCanSee().size();
	        	}
	        }
	        
	        System.out.println(max);
	        
	    } catch(Exception e) {
	        System.out.println(e.getMessage());
	        throw e;
	    }
	}
	
	public static Double getAngle(Asteroid target, int x, int y) {
	    Double angle = (double) Math.toDegrees(Math.atan2(target.getY() - y, target.getX() - x));

	    if(angle < 0){
	        angle += 360;
	    }

	    return (double)Math.round(angle * 100000d) / 100000d;	//5 point precision
	}
	
}
