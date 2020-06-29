import java.util.Scanner;

public class Test {
	static int i[] = new int[8];
	static Scanner scan = new Scanner(System.in);
	static String program[] = new String[64];
	static Boolean inputDone = false;
	static String temp;
	static int length;
	static REG reg = new REG();
	static String Fprogram[] = new String[256];
	public static void main(String[] args) {

			System.out.println("Please input your code one line at a time. enter \"done\" when complete");
			System.out.println("Each \"line\" of your program should contain no more than 32 characters");
			System.out.println("Each \"line\" should contain either 5, 32, or 4 characters including spaces");
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
				Fprogram[(4*i)+ 1] = program[i+1].substring(0, 8);
				Fprogram[(4*i)+ 2] = program[i+1].substring(8, 16);
				Fprogram[(4*i)+ 3] = program[i+1].substring(16, 24);
				Fprogram[(4*i)+ 4] = program[i+1].substring(24, 32);
			}
			Fprogram[length*4-7] = program[length-1];
			for(int i = 0; i < Fprogram.length; i ++){
				System.out.print(i + " ");
				System.out.println(Fprogram[i]);
			}
			int start = Support.HEXDEC(Fprogram[0].substring(0, 1));
			Memory.fillMem(start, length, Fprogram);
	}

}
