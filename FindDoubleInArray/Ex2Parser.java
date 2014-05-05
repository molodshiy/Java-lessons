package May;


public class Ex2Parser {

	public static double[] pars(String[] s) {
		
		double [] ar = new double [s.length];
		int v = 0;
		
	w:	for(String k: s){
			//Перевіряємо чи число тоді записуємо в масив ar;
			try{
				double d = Double.valueOf(k);
				ar[v] = d;
				v++;
			}
			//Якщо не число;
			catch(NumberFormatException ex){
				continue w;
			}
		}
		double [] arr = new double [v];
		//Перезаписуємо в масив arr(для видалення елементів масиву які = null)
		while(v > 0){
			arr[v - 1] = ar[v - 1];
			v--;
		}
		return arr;
	}
}
