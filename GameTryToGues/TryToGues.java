package May;

import java.util.Random;
import java.util.Scanner;


public class Ex6TryToGues {

	private static Scanner sc;

	public static void main(String[] args) {
		Random rnd = new Random();
		int x = rnd.nextInt(6);
		
		System.out.println("Число загадане");
		
		sc = new Scanner(System.in);
		int m = 3;
		
	ww: while(m != 0){
		
			System.out.println("Введіть число від 0 до 6 залишилось спроб: " +m);
			
			while(!sc.hasNextInt()){
				System.out.println("Введіть число від 0 до 6 залишилось спроб: " +m);
				sc.next();
			}
			int a = sc.nextInt();
			
			if(a > -1 && a < 7){
				
				if(a == x){
					System.out.println("Ви перемогли");
					break ww;
				}
				else
					m--;
				
				if(m == 0){
					System.out.println("Ви програли");
					break ww;
				}
			}
			else
				continue ww;
		}		
	}
}
