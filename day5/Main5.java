import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Main5 {

    public static void main(String[] args) {


        try {
            FileInputStream fstream = new FileInputStream("day5\\resources\\in.txt");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine = br.readLine();

			Computer computer = new Computer();
			computer.loadMem(strLine);
			computer.execute();
            
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

    }
    
}