
public class Memory extends VSystem {
	private static String MEM[] = new String[256];
	
	

	public static REG load() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void Store(int reg) {
		// TODO Auto-generated method stub
		
	}

	public static  void dump() {
		// TODO Auto-generated method stub
		// public dump function, begins dumping process
		PerfMem(2, 0, null);
	}

	public static String get(int pC) {
		// TODO Auto-generated method stub
		// returns the string form of the opCode for the appropriate memory address
		return "00";
	}
	
	public static boolean fillMem(int start, int length, String[] x){
		for(int i = start ; i < x.length; i ++){
			MEM[i] = x[i+1];
		}
		return true;
	}
	
	public static int PerfMem(int x, int y, String z){
		if(y > 255 ||  x < 0 || x > 2)
			return -1;
		else if(x == 0) {
			z = MEM[y];
			return 1;
		}
		else if(x == 1) {
			MEM[y] = z;
			return 1;
		}
		else dumpL();
		return 2;
		
	}

	private static void dumpL() {
		// TODO Auto-generated method stub
		// handles the actual dumping operation
	}

	public static void Store(REG register) {
		// TODO Auto-generated method stub
		
	}

}
