import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main8 {

	public static void main(String[] args) {



        FileInputStream fstream;
		try {
			fstream = new FileInputStream("day8\\resources\\in.txt");
		
        DataInputStream in = new DataInputStream(fstream);
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        String strLine = br.readLine();
        String[] strInput = strLine.split("");
        
        Integer[] numbers = new Integer[strInput.length];
        for(int i = 0; i < strInput.length; i++) {
        	numbers[i] = Integer.parseInt(strInput[i]);
        }
        
        //Part 1: Layers of 25*6 = 150
        int minZ = 200;
        int minOne = 0;
        int minTwo = 0;
        int zeros = 0;
        int ones = 0;
        int twos = 0;
        
        for(int i = 0; i < strInput.length; i++) {	//I know this could be done in previous loop, but this won't stick around to part 2 I think
        	
        	int num = numbers[i];
        	if(num == 0) {
        		zeros++;
        	} else if(num == 1) {
        		ones++;
        	} else {
        		twos++;
        	}
        	
        	if(i != 0 && i%150 == 0) {
        		//end of layer
        		if(zeros < minZ) {	//Save
        			minZ = zeros;
        			minOne = ones;
        			minTwo = twos;
        		}
    			zeros = 0;	//Reset
    			ones = 0;
    			twos = 0;
        	}
        	
        }
        
        System.out.println(minOne*minTwo);
        
		} catch(Exception e) {
			System.out.println("Exception");
		}
		
	}
	
}
