package May;


import java.io.IOException;

public class Ex1Main {

	public static void main(String[] args) throws IOException{	
		//Зчитуємо файл і записуємо в строку text1
		Ex1Reader r = new Ex1Reader("c:\\ttr\\text.txt");
		String text1 = r.reader();
		System.out.println(text1);
		
		//Парсимо строку
		Ex1Parser p = new Ex1Parser(text1);
		p.parserN();
		p.parserM();
		
		//Записуємо результати
		Ex1Saver s = new Ex1Saver("c:\\ttr\\number.txt", "c:\\ttr\\mail.txt");
		s.saver();
	}
}
