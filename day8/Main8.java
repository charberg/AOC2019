import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

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
        
        //Part 2: Layers of 25*6 = 150
        //So, 2d doesnt actually matter until the very final output - Might as well keep it one dimensional until final output.
        //Read in lines of 150, create a "final" line of 150 (our end visible layer), apply see through logic to that
        //Do transparents even matter? Other than being not black pixel
        
        List<Integer[]> layers = new ArrayList<>();
        List<Integer> finalLayer = new ArrayList<>();
        
        for(int i = 0; i < strInput.length; i++) {	//Set up layers
        	
        	if(layers.size() <= i/150) {
        		layers.add(new Integer[150]);
        	}
        	
        	layers.get(i/150)[i%150] = numbers[i];
        	
        	
        }
        
        //Write to final layer
        for(int i = 0; i < 150; i++) {
        	finalLayer.add(compareLayers(layers, i));
        }
        
        printLayer(finalLayer);
        
		} catch(Exception e) {
			System.out.println("Exception");
		}
		
	}
	
	public static int compareLayers(List<Integer[]> layers, int i) {
		
		for(Integer[] layer : layers) {
			if(layer[i] == 0) {
				return 0;	//Black overrides, return now
			} else if(layer[i] == 1) {
				return 1;
			}
		}
		return 2;	//Only return transparent if it is all the way down	
		
	}
	
	public static void printLayer(List<Integer> layer) {
		for(int i = 0; i < layer.size(); i++) {
			if(i != 0 && i%25 == 0) {
				System.out.print("\n");
			}
			System.out.print(layer.get(i));
		}
	}
	
}
