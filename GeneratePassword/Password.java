package May;


import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Ex5 {
	
	public static String passavord(int length, int[] arr) throws NoSuchAlgorithmException {
		
	   SecureRandom sr1 = SecureRandom.getInstance("SHA1PRNG");
	   String alg = sr1.getAlgorithm();
	   SecureRandom sr = SecureRandom.getInstance(alg);
	   
	   String elements = "";
	   int diapazone = 0;
	   
	   //Створюємо діапозон можливих елементів
	   if(arr[0] == 1){
		   for(char j = 'a'; j <= 'z'; j++)
			   elements += (String.valueOf(j)).toUpperCase();   
	   }
	   
	   if(arr[1] == 1){
		   for(char j = 'a'; j <= 'z'; j++)
			   elements += String.valueOf(j);
	   }
	   
	   if(arr[2] == 1){
		   for(byte g = 0; g < 10; g++)
			   elements += String.valueOf(g);  
	   }
	   diapazone += elements.length();
	   
	   //Генерація пароля
	   String passaword = "";
	   for (int i = 0; i < length; i++){
		   int f = sr.nextInt(diapazone);
		  passaword += elements.charAt(f);
	   }	        
		return passaword; 		
	}
}
