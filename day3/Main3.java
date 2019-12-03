import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main3 {

    public static void main(String[] args) {


        try {
            FileInputStream fstream = new FileInputStream("day3\\resources\\in.txt");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String wire1str = br.readLine();
            String wire2str = br.readLine();

            List<Coord> wire1 = getWirePath(wire1str);
            List<Coord> wire2 = getWirePath(wire2str);
            
            Set<Coord> crosses = wire1.stream().distinct().filter(wire2::contains).collect(Collectors.toSet());
            
            //Get max distance crossing
            int min = Integer.MAX_VALUE;
            
            for(Coord c : crosses) {
            	if(c.getDistance() < min) {
            		min = c.getDistance();
            	}
            }
            
            System.out.println(min);
            
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }
    
    public static List<Coord> getWirePath(String wireInput) {

    	ArrayList<Coord> coords = new ArrayList<>();
    	String[] commands = wireInput.split(",");
    	int x = 0;
    	int y = 0;
    	
    	for(String command : commands) {
    		
    		int distance = Integer.parseInt(command.substring(1));	//Get the number after the char direction value
    		char direction = command.charAt(0);
    		
    		for(int i = 0; i < distance; i++) {
	    		if(direction == 'R') {
	    			x++;
	    		} else if(direction == 'L') {
	    			x--;
	    		} else if(direction == 'U') {
	    			y++;
	    		} else if(direction == 'D') {
	    			y--;
	    		}
	    		coords.add(new Coord(x, y));	//At end of loop, to not add the initial 0,0 coord
    		}
    		
    	}
    	
    	return coords;
    	
    }
    
    public static void resetMemory(Integer[] mem, String[] reset) {
    	for(int i = 0; i < reset.length; i++) {
            mem[i] = Integer.parseInt(reset[i]);
        }
    }
    
}