import java.util.Scanner;

public class Loader extends VSystem {
	static Scanner scan = new Scanner(System.in);
	static String program[] = new String[64];
	static Boolean inputDone = false;
	static String temp;
	static int length;
	static String Fprogram[] = new String[256];
	
	
	public static void begin(){
		System.out.println("Please input your code one line at a time. enter \"done\" when complete");
		System.out.println("Each \"line\" of your program should contain no more than 32 characters");
		System.out.println("The first line should be 5 characters, and the last 4. All others should be 32 characters");
		for(int i = 0; !inputDone; i++){
			temp = scan.nextLine();
			if(temp.equals("done")){
				inputDone = true;
				length = i;
			} else{
				program[i] = temp;
			}
		}
		Fprogram[0] = program[0];
		for(int i = 0; i < length-2; i++){
			Fprogram[(4*i)+ 1] = program[i+1].substring(0, 7);
			Fprogram[(4*i)+ 2] = program[i+1].substring(8, 15);
			Fprogram[(4*i)+ 3] = program[i+1].substring(16, 23);
			Fprogram[(4*i)+ 4] = program[i+1].substring(24, 31);
		}
		Fprogram[length*4-7] = program[length-1];
		for(int i = 0; i < Fprogram.length; i ++)
			System.out.println(Fprogram[i]);
		
		int start = Support.HEXDEC(Fprogram[0].substring(0, 1));
		int length = Support.HEXDEC(Fprogram[0].substring(3, 5));
		Memory.fillMem(start, length, Fprogram);
	}
	
	public static String[] parse(String x){
		String op = x.substring(0, 2);
		String Addr = x.substring(4, 9);
		String artReg = x.substring(2, 3);
		String indexReg = x.substring(3, 4);
		String net[] = new String[4];
		net[0] = op;
		net[1] = Addr;
		net[2] = artReg;
		net[3] = indexReg;
		return net;
		
		
	}
}
