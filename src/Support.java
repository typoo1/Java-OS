/**
 * Provides an assortment of support utilities for the virtual operating system
 * @author TyeG
 *
 */
public class Support {

	public static int[] dec2bin(int x){
		int p = 0;
		int[] temp = new int[17];
		int[] fin = new int[16];
		for(int n = 2; x >= 1; p++){
			temp[p] = x%n;
			x = x/2;		
		}
		for(int i = 0; i < 16; i++){
			fin[i] = temp[15-i];
			System.out.print(fin[i]);
		}
		return fin;
	}

	public static void BitL(REG x) {
		int z[] = HEXBIN(x.rLoad());
		int i = 0;
		for(int a = 1; a != z.length; a++){
			z[i] = z[a];
			i = a;
		}
		z[i] = 0;
		String s = BINHEX(z);
		x.rStore(s);
	}

	public static void BitR(REG x) {
		int z[] = HEXBIN(x.rLoad());
		int i = z.length-1;
		for(int a = z.length-2; a != z.length; a--){
			z[i] = z[a];
			i = a;
		}
		z[i] = 0;
		String s = BINHEX(z);
		x.rStore(s);
	}
	
	public static int bin2dec(int x[]){
		int i = 1;
		int fin = 0;
		for(int a = 0; x.length - a > 0; a++){
			if(x[x.length-a-1] == 1)
				fin = fin + i;
			i = i*2;
		}
		return fin;
	}
	
//	@SuppressWarnings("unused")
//	public static int HEX2DEC(String x){
//		int fin[] = new int[8];
//		int temp =0;
//		for(int i = 0; i < x.length(); i++){
//			if(x.charAt(i) >= 48 || x.charAt(i) <= 57)
//				fin[i] = x.charAt(i) - 48;
//			else if(x.charAt(i) == 97 || x.charAt(i) == 65)
//				fin[i] = 10;
//			else if(x.charAt(i) == 98 || x.charAt(i) == 66)
//				fin[i] = 11;
//			else if(x.charAt(i) == 99 || x.charAt(i) == 67)
//				fin[i] = 12;
//			else if(x.charAt(i) == 100 || x.charAt(i) == 68)
//				fin[i] = 13;
//			else if(x.charAt(i) == 101 || x.charAt(i) == 69)
//				fin[i] = 14;
//			else if(x.charAt(i) == 102 || x.charAt(i) == 70)
//				fin[i] = 15;
//			return -1;
//		}
//		for(int i = 0; i <fin.length; i++){
//			temp =  (int) (fin[7-i]*Math.pow(16, i));
//		}
//		return temp;
	
	public static int[] HEXBIN(String x) {
		int fin[] = new int[x.length()*4];
		int temp = 0;
		int p[] = new int[4];
		for(int i = 0; i < x.length(); i++){
			if((int)(x.charAt(i)) >= 48 &&((int)(x.charAt(i)) <= 57)){
				temp = x.charAt(i)-48;
			}	
			else if(x.charAt(i) == 'a' || x.charAt(i) == 'A')
				temp = 10;
			else if(x.charAt(i) == 'b' || x.charAt(i) == 'B')
				temp = 11;
			else if(x.charAt(i) == 'c' || x.charAt(i) == 'C')
				temp = 12;
			else if(x.charAt(i) == 'd' || x.charAt(i) == 'D')
				temp = 13;
			else if(x.charAt(i) == 'e' || x.charAt(i) == 'E')
				temp = 14;
			else if(x.charAt(i) == 'f' || x.charAt(i) == 'F')
				temp = 15;
			for(int z = 0; z < 4; z++){
				p[3-z] = temp%2;
				temp = temp/2;
			}
			for(int z = 0; z < 4; z++){
				fin[z + 4*i] = p[z];
			}
		}
		return fin;
	}
	
	public static int HEXDEC(String x) {
		int d[] =HEXBIN(x);
		return bin2dec(d);		
	}
	
	public static String DECHEX(int x) {
		int p = 0;
		char[] temp = new char[8];
		String fin = "";
		for(int n = 16; x >= 1; p++){
			if(x%n < 10)
				temp[p] = (char) (x%n + 48);
			else if (x%n == 10)
				temp[p] = 'a';
			else if (x%n == 11)
				temp[p] = 'b';
			else if (x%n == 12)
				temp[p] = 'c';
			else if (x%n == 13)
				temp[p] = 'd';
			else if (x%n == 14)
				temp[p] = 'e';
			else if (x%n == 15)
				temp[p] = 'f';
			x = x/n;
		}
		for(int i = 0; i < p; i++){
			if((temp[i]) != 0)
				fin = temp[i] + fin;
		}
		return fin;
	}
	public static String BINHEX(int[] x){
		int s = bin2dec(x);
		String q = DECHEX(s);
		return q;
	}
}