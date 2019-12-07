import java.util.Scanner;

public class AmpComputer {	//Differs slightly from our day5 computer, in how it gets input

	private String[] strMem;
	private Integer[] mem;
	private Integer pointer = 0;
	private int ampInput;
	private int phase;
	private int inputCount = 0;
	
	public void loadMem(String input) {
		strMem = input.split(",");
		resetMemory();
	}
	
	public int execute() {
		
		int i = 0;
		
		while(true) {
		
			Integer[] params = getParamModes(i);
			
			String opStr = mem[i].toString();
			Integer opCode = null;
			if(opStr.length() == 1){
				opCode = Integer.parseInt(opStr);	//Redundant, but let's just call it careful
			} else {
			opCode = Integer.parseInt(opStr.substring(opStr.length() - 2));
			}
			
			//Opcode 1 : Add
			
			if(opCode == 1) {
				
				Integer p1 = params[2] == 0 ? mem[mem[i+1]] : mem[i+1];
				Integer p2 = params[1] == 0 ? mem[mem[i+2]] : mem[i+2];
				
				mem[mem[i+3]] = p1 + p2;
				i = i+4;
			}
			
			//Opcode 2: Multiply
			
			else if(opCode == 2) {
				
				Integer p1 = params[2] == 0 ? mem[mem[i+1]] : mem[i+1];
				Integer p2 = params[1] == 0 ? mem[mem[i+2]] : mem[i+2];
				
				mem[mem[i+3]] = p1 * p2;
				i = i+4;
			} 
			
			//Opcode 3: Save input
			
			else if(opCode == 3) {
				
				//First call, use phase. Second call, use input.
				if(inputCount == 0) {
					mem[mem[i+1]] = phase;
				} else if(inputCount == 1){
					mem[mem[i+1]] = ampInput;
				} else {
					System.out.println(String.format("TOO MANY INPUTS: %d", inputCount));
				}
				inputCount++;
				i = i+2;
			} 
			
			//Opcode 4: Output
			
			else if(opCode == 4) {
				
				return mem[mem[i+1]];
				
				//System.out.println(String.format("Output: %d", mem[mem[i+1]]));
				//i = i+2;
			} 
			
			//Opcode 5: jump if true
			
			else if(opCode == 5) {
				Integer p1 = params[2] == 0 ? mem[mem[i+1]] : mem[i+1];
				Integer p2 = params[1] == 0 ? mem[mem[i+2]] : mem[i+2];
				if(!p1.equals(Integer.valueOf(0))) {
					i = p2;
				} else {
					i = i+3;
				}
			} 
			
			//Opcode 6: jump if false
			
			else if(opCode == 6) {
				Integer p1 = params[2] == 0 ? mem[mem[i+1]] : mem[i+1];
				Integer p2 = params[1] == 0 ? mem[mem[i+2]] : mem[i+2];
				if(p1.equals(Integer.valueOf(0))) {
					i = p2;
				} else {
					i = i+3;
				}
			} 
			
			//Opcode 7: less than
			
			else if(opCode == 7) {
				Integer p1 = params[2] == 0 ? mem[mem[i+1]] : mem[i+1];
				Integer p2 = params[1] == 0 ? mem[mem[i+2]] : mem[i+2];
				
				if(p1 < p2) {
					mem[mem[i+3]] = 1;
				} else {
					mem[mem[i+3]] = 0;
				}
				
				i = i+4;
			} 
			
			//Opcode 8: equals
			
			else if(opCode == 8) {
				Integer p1 = params[2] == 0 ? mem[mem[i+1]] : mem[i+1];
				Integer p2 = params[1] == 0 ? mem[mem[i+2]] : mem[i+2];
				
				if(p1.equals(p2)) {
					mem[mem[i+3]] = 1;
				} else {
					mem[mem[i+3]] = 0;
				}
				
				i = i+4;
			} 
			
			//OPcode 99: Return
			
			else if(opCode == 99) {
				System.out.println("Program Complete");
				return Integer.MIN_VALUE;
			}
			
			else {
				System.out.print(String.format("Unknown opcode: %d", mem[i]));
				return Integer.MIN_VALUE;
			}
		}
		
	}
	
	//Remember to read these in "backwards" when params use them
	private Integer[] getParamModes(int i) {
		
		//Just always return an array of size 3, let opcodes use as needed
		
		Integer[] params = new Integer[3];
		
		String arg = mem[i].toString();
		
		while(arg.length() < 5) {	//0 padding for param modes
			arg = "0" + arg;
		}
		
		params[0] = Integer.parseInt(arg.substring(0, 1));
		params[1] = Integer.parseInt(arg.substring(1, 2));
		params[2] = Integer.parseInt(arg.substring(2, 3));
		
		return params;
	}

	public void resetMemory() {
		mem = new Integer[strMem.length];
		for(int i = 0; i < strMem.length; i++) {
			mem[i] = Integer.parseInt(strMem[i]);
		}
		inputCount = 0;
    }
	
	public int getAmpInput() {
		return ampInput;
	}

	public void setAmpInput(int ampInput) {
		this.ampInput = ampInput;
	}

	public int getPhase() {
		return phase;
	}

	public void setPhase(int phase) {
		this.phase = phase;
	}

	
	
}
