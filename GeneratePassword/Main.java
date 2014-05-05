package May;

import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;

public class Ex5Main {
	
	//Метод для виведення текстових підказок на консоль
	private static void pr(byte r){
		if (r == 1)
			System.out.println("Введіть 1 для використання заголовочних букв або 0 для не використання");
		if (r == 2)
			System.out.println("Введіть 1 для використання строкових букв або 0 для не використання");
		if (r == 3)
			System.out.println("Введіть 1 для використання цифр або 0 для не використання");
	}

	public static void main(String[] args) {	
		Scanner s = new Scanner(System.in);
		//Масив де зберігаються введені параметри для створення пароля;
		int [] param = new int [3];
		// довжина пароля;
		int length;
		
		System.out.println("Введіть довжину пароля від 1 до 32767");
		//Перевіряємо чи введено число;
	ww:	while(true){
		while(!s.hasNextShort()){
			System.out.println("Введіть довжину пароля від 1 до 32767");
			s.next();
		}
		//Записуємо довжину пароля;
		length = s.nextShort();
		//Перевіряємо чи довжина більна 0;
		if (length > 0)
			break ww;
		System.out.println("Введіть довжину пароля від 1 до 32767");
		}
		System.out.println(length);
		
		//Кількість кроків для утворення параметрів пароля;
		byte r = 3;
		//Цикл для кожного кроку
		ww:	while(r != 0){
			pr(r);
			//Перевіряємо чи введене число(byte);
			while(!s.hasNextByte()){
				pr(r);
				s.next();
			}
			//Записуємо число в змінну;
			byte point = s.nextByte();
			//Перевіряємо чи число введене число від 1 до 0 і записуємо значення в масив;
			if (point == 1 || point == 0){
				param[r - 1] = point;
				--r;
			}
			//Умова виконується коли не вибрано жодного параметру;
			if (r == 0 && param[0] == 0 && param[1] == 0 && param[2] == 0){
				System.out.println("Ви не вибрали жодного параметру попробуйте ЗАНОВО!!!");
				r = 3;
			}
				continue ww;
			}
			
		System.out.println(Arrays.toString(param));
		//Визиваємо метед passavord в класі Ex5;	
		try {
			System.out.print(Ex5.passavord(length, param));
		} catch (NoSuchAlgorithmException e1) {
			e1.printStackTrace();
		}	
	}
}
