import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main1 {

    public static void main(String[] args) {


        try {
            FileInputStream fstream = new FileInputStream("day1\\resources\\in.txt");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            
            Integer totalMass = 0;
            Integer totalFuelNeeded = 0;
            
            while ((strLine = br.readLine()) != null) {

                Integer mass = Integer.parseInt(strLine);
                totalMass = totalMass + mass;
                
                Integer fuel = Main1.countFuel(mass);
                while(fuel > 0) {
                	totalFuelNeeded = totalFuelNeeded + fuel;
                	fuel = Main1.countFuel(fuel);
                }
                

            }
            
            System.out.println(totalFuelNeeded);
            
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }
    
    public static Integer countFuel(Integer mass) {
    	return (mass/3) - 2;
    }
    
}