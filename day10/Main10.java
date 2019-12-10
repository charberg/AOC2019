import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main10 {

	public static void main(String[] args) {
	
		try {
	        FileInputStream fstream = new FileInputStream("day10\\resources\\in.txt");
	        DataInputStream in = new DataInputStream(fstream);
	        BufferedReader br = new BufferedReader(new InputStreamReader(in));
	        String strLine;
	        int edge = 41;	//Square space of 42x42
	        List<List<Asteroid>> space = new ArrayList<>();
	        
	        //Init space
	        for(int i = 0; i <= edge; i++) {
	        	space.add(new ArrayList<Asteroid>());
	        }
	        
	        int lineCount = 0;
	        while ((strLine = br.readLine()) != null) {
	        	String[] line = strLine.split("");
	        	for(int i = 0; i < strLine.length(); i++) {
	        		if(line[i].equals("#")) {
	        			space.get(i).add(new Asteroid(i, lineCount));
	        		} else {
	        			space.get(i).add(null);	//In space no one can hear your NPEs
	        		}
	        	}
	        }
	        
	        //Iterate through angle ranges, in all directions. Work your way outside in, most recent asteroid gets added to current's "seen"
	        //Can also add current to other ast's seen list
	        //Iterate through angle, but have to be careful of 'perfect multiples', i.e. +3,+9 is behind +1, +3.
	        //Does every asteroid out have a unique angle? I guess so.
	        //
	        
	    } catch(Exception e) {
	        System.out.println(e.getMessage());
	    }
	}
}
