package May;

import java.util.Random;
import java.util.Scanner;


public class Ex6TryToGues {

	public static void main(String[] args) {
		//Загадуємо число;
		Random rnd = new Random();
		int x = rnd.nextInt(6);	
		System.out.println("Число загадане");
		
		Scanner sc = new Scanner(System.in);
		//Кількість спроб;
		int m = 3;
		
		//Цикл для кожної спроби;
	ww: while(m != 0){
			System.out.println("Введіть число від 0 до 6 залишилось спроб: " +m);
			
			//Перевіряємо введено число чи символ;
			while(!sc.hasNextInt()){
				System.out.println("Введіть число від 0 до 6 залишилось спроб: " +m);
				sc.next();
			}
			int a = sc.nextInt();
			
			//Перевіряємо чи введено число в діапазоні від 0 включно до 7 виключно;
			if(a > -1 && a < 7){
				//Умова Перемоги;
				if(a == x){
					System.out.println("Ви перемогли");
					break ww;
				}
				//Зменшуємо кількість кроків;
				else
					m--;
				//Умова Програшу
				if(m == 0){
					System.out.println("Ви програли");
					break ww;
				}
			}
			//Повторюємо цикл при введені числа не з діапазону від 0 включно до 7 виключно;
			else
				continue ww;
		}		
	}
}

