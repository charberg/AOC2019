import java.util.Scanner;

public class Computer {

	private String[] strMem;
	private Long[] mem;
	private Integer i = 0;
	private Integer relativeBase = 0;
	
	public void loadMem(String input) {
		strMem = input.split(",");
		mem = new Long[999999];
		for(int i = 0; i < mem.length; i++) {
			if(i < strMem.length) {
				mem[i] = Long.parseLong(strMem[i]);
			} else {
				mem[i] = 0L;
			}
		}
	}
	
	public void execute() {
		
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
				
				Long p1 = getP(params, 2);
				Long p2 = getP(params, 1);
				Long p3 = getOutputP(params, 0);
				
				mem[p3.intValue()] = p1 + p2;
				i = i+4;
			}
			
			//Opcode 2: Multiply
			
			else if(opCode == 2) {

				Long p1 = getP(params, 2);
				Long p2 = getP(params, 1);
				Long p3 = getOutputP(params, 0);
				
				mem[p3.intValue()] = p1 * p2;
				i = i+4;
			} 
			
			//Opcode 3: Save input
			
			else if(opCode == 3) {
				
				Long p1 = getOutputP(params, 2);
				
				Scanner scan = new Scanner(System.in);
				System.out.println("User input requested");
				Long in = Long.parseLong(scan.nextLine());
				
				mem[p1.intValue()] = in;
				i = i+2;
			} 
			
			//Opcode 4: Output
			
			else if(opCode == 4) {
				Long p1 = getP(params, 2);
				
				System.out.println(String.format("Output: %d", p1));
				i = i+2;
			} 
			
			//Opcode 5: jump if true
			
			else if(opCode == 5) {
				
				Long p1 = getP(params, 2);
				Long p2 = getP(params, 1);
				
				if(!p1.equals(0L)) {
					i = p2.intValue();
				} else {
					i = i+3;
				}
			} 
			
			//Opcode 6: jump if false
			
			else if(opCode == 6) {

				Long p1 = getP(params, 2);
				Long p2 = getP(params, 1);
				
				
				if(p1.equals(0L)) {
					i = p2.intValue();
				} else {
					i = i+3;
				}
			} 
			
			//Opcode 7: less than
			
			else if(opCode == 7) {
				Long p1 = getP(params, 2);
				Long p2 = getP(params, 1);
				Long p3 = getOutputP(params, 0);
				
				if(p1 < p2) {
					mem[p3.intValue()] = 1L;
				} else {
					mem[p3.intValue()] = 0L;
				}
				
				i = i+4;
			} 
			
			//Opcode 8: equals
			
			else if(opCode == 8) {
				Long p1 = getP(params, 2);
				Long p2 = getP(params, 1);
				Long p3 = getOutputP(params, 0);
				
				if(p1.equals(p2)) {
					mem[p3.intValue()] = 1L;
				} else {
					mem[p3.intValue()] = 0L;
				}
				
				i = i+4;
			} 
			
			//Opcode 9: relative base change
			
			else if(opCode == 9) {
				Long p1 = getP(params, 2);
				
				relativeBase = relativeBase + p1.intValue();
				
				i = i+2;
			} 
			
			//OPcode 99: Return
			
			else if(opCode == 99) {
				System.out.println("Program Complete");
				return;
			}
			
			else {
				System.out.print(String.format("Unknown opcode: %d", mem[i]));
				return;
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
	
	private Long getP(Integer[] params, int pPos) {
		Long p = null;
		int pNum = 3-pPos;
		if(params[pPos] == 0) {
			p = mem[mem[i+pNum].intValue()];
		} else if(params[pPos] == 1) {
			p = mem[i+pNum];
		} else if(params[pPos] == 2) {
			p = mem[mem[i+pNum].intValue() + relativeBase];
		}
		
		return p;
		
	}
	
	private Long getOutputP(Integer[] params, int pPos) {
		Long p = null;
		int pNum = 3-pPos;
		if(params[pPos] == 0) {
			p = mem[i+pNum];
		} else if(params[pPos] == 2) {
			p = mem[i+pNum] + relativeBase;
		} else {
			System.out.println("Invalid param 1 for output");
		}
		
		return p;
		
	}
	
}
