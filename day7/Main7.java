import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.collections4.iterators.PermutationIterator;

public class Main7 {

	public static void main(String[] args) {


        try {
            FileInputStream fstream = new FileInputStream("day7\\resources\\in.txt");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine = br.readLine();

            PermutationIterator iterator = new PermutationIterator(Arrays.asList(0,1,2,3,4));
            List<Integer> phases = iterator.next();
            
            LinkedList<Amplifier> amps = new LinkedList<>();
            
            //Init amps
            for(int i = 0; i < 5; i++) {
            	amps.add(new Amplifier(phases.get(i), strLine));
            }
            
            amps.get(0).setInput(0);	//Initial input at start of chain
            
            int max = Integer.MIN_VALUE;
            
            while(iterator.hasNext()) {
            	phases = iterator.next();
            	int output = 0;
            	
            	for(int i = 0; i < amps.size(); i++) {
            		amps.get(i).setPhase(phases.get(i));	//Reload phases and memory
            		amps.get(i).getComputer().resetMemory();
            		
            		//Execute their program
            		amps.get(i).setInput(output);
            		output = amps.get(i).getComputer().execute();
            	}
            	
            	//final output in chain, store if highest
            	if(output > max) {
            		max = output;
            	}
            	output = 0;
            }
            
            System.out.println(String.format("Max output: %d", max));
            
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }
	
}
