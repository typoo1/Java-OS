import java.io.PrintWriter;
import java.io.*;



public class VSystem {
	REG register = new REG();
	public int PC = 0;
	File file = new File("C:\\Test.txt");
	static PrintWriter pw ;
	static {
	   try{
	     pw = new PrintWriter("Results.txt", "UTF-8");
	     }
	     catch(IOException e){
	        e.printStackTrace();
	        throw new RuntimeException(e);  
	    }
	}
 public static void main(String[] args){
	 pw.println("begin document");
	 Loader.begin();
 }
}
