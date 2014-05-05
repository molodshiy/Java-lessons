package May;


import java.util.Arrays;

public class Ex2Main {

	public static void main(String[] args) {
		
		String [] arr = {" ", "@", "ww", "34", "rr", "t", "17", "r", "0", "Ania", " 7"};
		
		double [] result = Ex2Parser.pars(arr);
		
		System.out.println(Arrays.toString(result));
	}
}
