import java.io.*;

public class ReversedBinaryNumbers {
	/**
	 * @throws IOException 
	 * @Author: Du Huang
	 */
	public static void main(String[] args) throws IOException {
	    BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
	    String input; 
	    int num;
	    //System.out.print ("Enter the Number: ");
	    input = stdin.readLine();
	    num = Integer.parseInt(input);
	    System.out.println(getDecimal(getReversedBinary(num)));
	}
	
	public static int[] getReversedBinary(int oriDeci){
		/*It tells the length of int[] we need*/
		int[] revBi = new int[(int)Math.floor(Math.log(oriDeci)/Math.log(2) + 1)]; 
		for(int i = 0; oriDeci > 0; i++){
			revBi[i] = oriDeci%2;
			oriDeci = oriDeci/2;
		}
		return revBi;
	}
	
	public static int getDecimal(int[] bi){
		int dec = 0;
		for(int i = 0; i < bi.length; i++){
			dec += bi[i]*Math.pow(2, bi.length - i - 1);
		}
		return dec;
	}
}
