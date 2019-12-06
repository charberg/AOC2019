import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main6 {

	public static void main(String[] args) {


        try {
            FileInputStream fstream = new FileInputStream("day6\\resources\\in.txt");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            //Init satellites
            
            Satellite base = null;	//Top of the tree, COM
            Map<String, Satellite> satMap = new HashMap<>();	//Name to Sat map
            
            while ((strLine = br.readLine()) != null) {
	            String[] sats = strLine.split("\\)");
	            
	            if(satMap.get(sats[0]) == null) {
	            	satMap.put(sats[0], new Satellite(sats[0]));
	            }
	
	            if(satMap.get(sats[1]) == null) {
	            	satMap.put(sats[1], new Satellite(sats[1]));
	            }
	            
	            satMap.get(sats[0]).addChild(satMap.get(sats[1]));
            }
            
            base = satMap.get("COM");
//            base.findDepth(0);	//Recursive call, set depth val for whole system
//            
//            //Get part 1 answer
//            int total = 0;
//            for(Satellite sat : satMap.values()) {
//            	total = total + sat.getDepth();
//            }
            
            base.findSanta();
            
            //System.out.println(total);
            
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }
	
}
