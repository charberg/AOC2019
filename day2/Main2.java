import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main2 {

    public static void main(String[] args) {


        try {
            FileInputStream fstream = new FileInputStream("day2\\resources\\in.txt");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine = br.readLine();

			String[] strArray = strLine.split(",");
            Integer[] input = new Integer[strArray.length];
            
            for(int i = 0; i < 100; i++) {
            	for(int j = 0; j < 100; j++) {
            		
		            Main2.resetMemory(input, strArray);
		            input[1] = i;
		            input[2] = j;
		            Main2.calculate(input);
		            if(input[0] == 19690720) {
		            	System.out.println(i);
		            	System.out.println(j);
		            }
            	}
            }
            
            System.out.println(input[0]);
            
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }
    
    public static void calculate(Integer[] in) {
    	int cursor = 0;
    	
    	while(cursor < in.length) {
    		if(in[cursor] == 1) {
    			in[in[cursor+3]] = in[in[cursor+1]] + in[in[cursor+2]];
    		} else if(in[cursor] == 2) {
    			in[in[cursor+3]] = in[in[cursor+1]] * in[in[cursor+2]];
    		} else if(in[cursor] == 99) {
    			return;
    		}
    		
    		cursor = cursor + 4;
    		
    	}
    	
    }
    
    public static void resetMemory(Integer[] mem, String[] reset) {
    	for(int i = 0; i < reset.length; i++) {
            mem[i] = Integer.parseInt(reset[i]);
        }
    }
    
}