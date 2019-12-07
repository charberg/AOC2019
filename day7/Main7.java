import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.collections4.iterators.PermutationIterator;

public class Main7 {

	public static void main(String[] args) {



            FileInputStream fstream;
			try {
				fstream = new FileInputStream("day7\\resources\\in.txt");
			
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine = br.readLine();

            PermutationIterator iterator = new PermutationIterator(Arrays.asList(5,6,7,8,9));
            List<Integer> phases = iterator.next();
            List<AmpComputer> amps = new ArrayList<>();
            
            //Init amps
            for(int i = 0; i < phases.size(); i++) {
            	amps.add(new AmpComputer(phases.get(i), strLine));
            	if(i > 0) {
            		amps.get(i-1).setNext(amps.get(i));
            	}
            }
            
            amps.get(amps.size()-1).setNext(amps.get(0));	//Circular linked list
            
            amps.get(0).setAmpInput(0);	//Initial input at start of chain
            amps.get(amps.size()-1).setE(true);//Last
            
            int max = Integer.MIN_VALUE;
            
            while(iterator.hasNext()) {
            	int output = 0;
            	
            	for(int i = 0; i < amps.size(); i++) {
            		amps.get(i).setPhase(phases.get(i));	//Reload phases and memory each permutation
            		amps.get(i).resetMemory();
            	}
            	
            	//Execute their program
        		output = amps.get(0).execute();
        		
            	if(output > max) {
            		max = output;
            	}
            	
            	output = 0;
            	phases = iterator.next();
            }
            
            System.out.println(String.format("Max output: %d", max));
            
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

    }
	
}
