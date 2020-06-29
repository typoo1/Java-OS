
public class CPU extends VSystem{

	private boolean halt = false;
	private int CLOCK =0;
	private int reg = 0;
	
	public void OpCode(String op){
		if(op.equals("00")){
			halt = true;
			CLOCK++;
		}
		if(op.equals("01")){
			register = Memory.load();
			CLOCK++;
		}
		if(op.equals("02")){
			Memory.Store(register);
			CLOCK++;
		}
		if(op.equals("03")){
			register.rStore(Support.DECHEX((Support.HEXDEC(register.rLoad()) + Support.HEXDEC(Memory.load().rLoad()))));
			CLOCK++;
		}
		if(op.equals("04")){
			register.rStore(Support.DECHEX((Support.HEXDEC(register.rLoad()) - Support.HEXDEC(Memory.load().rLoad()))));
			CLOCK++;
		}
		if(op.equals("05")){
			register.rStore(Support.DECHEX((Support.HEXDEC(register.rLoad()) * Support.HEXDEC(Memory.load().rLoad()))));
			CLOCK++; CLOCK++;
		}
		if(op.equals("06")){
			register.rStore(Support.DECHEX((Support.HEXDEC(register.rLoad()) / Support.HEXDEC(Memory.load().rLoad()))));
			CLOCK++; CLOCK++;
		}
		if(op.equals("07")){
			Support.BitL(register);
			CLOCK++;
		}			
		if(op.equals("08")){
			Support.BitR(register);
			CLOCK++;
		}
		if(op.equals("09")){
			CLOCK++;
			if(register < 0){
				
			}
				
		}
		if(op.equals("0A")){
			CLOCK++;
			if(register > 0){
				
			}
		}
		if(op.equals("0B")){
			CLOCK++;
			if(register == 0){
				
			}
		}
		if(op.equals("0C")){
			CLOCK++; CLOCK++;
		}
		if(op.equals("0D")){
			CLOCK++;
		}
		if(op.equals("0E")){
			CLOCK++;
		}
		if(op.equals("0F")){
			CLOCK = CLOCK + 8;;
			
			//read 32 chars of data into MEM
		}
		if(op.equals("10")){
			CLOCK++;
		}
		if(op.equals("11")){
			Memory.dump();
		}
	}
	/**
	 * Continually runs the cpu process until halt or an I/O command is prompted (both called halt)
	 * 
	 * @return returns the PC variable for easier transference between subSystems
	 */
	public int runCPU(){
		halt = false;
		while (halt == false){
			OpCode(Memory.get(PC));
		}
		return PC;
	}
}
