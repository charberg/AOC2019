
public class Amplifier {	//I guess this doesnt do a whole lot, in part 1 at least.

	AmpComputer computer;
	int input;
	int phase;
	
	public Amplifier(int phase, String compInput) {
		this.computer = new AmpComputer();
		this.computer.loadMem(compInput);
		this.computer.setPhase(phase);
		this.phase = phase;
	}

	public AmpComputer getComputer() {
		return computer;
	}

	public void setComputer(AmpComputer computer) {
		this.computer = computer;
	}

	public int getInput() {
		return input;
	}

	public void setInput(int input) {
		this.input = input;
		this.computer.setAmpInput(input);
	}

	public int getPhase() {
		return phase;
	}

	public void setPhase(int phase) {
		this.phase = phase;
		this.getComputer().setPhase(phase);
	}
	
	
	
}
