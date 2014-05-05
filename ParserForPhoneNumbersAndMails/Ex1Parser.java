package May;

import java.util.HashSet;
import java.util.Set;


public class Ex1Parser {
	private String text;
	//Списки з найденими номерамі і ел-поштами
	public static Set<String> number = new HashSet<String>();
	public static Set<String> mail = new HashSet<String>();

	public Ex1Parser(String text) {
		this.text = text;
	}
	
	//Метод пошуку номерів телефонів які починаються з "+"
	public void parserN(){
		//Вказує де встановлений флажок пошуку
		int n1 = 0;
		int index1 = 0;
		
		//Цикл пошуку "+"
		while(true){
			//Вказує де знаходиться "+"
			index1 = text.indexOf("+", n1);
			//Умова зупинки циклу
			if(index1 == -1)
				break;
			
			int n = 0;
			//Номер
			String numb = "+";
			//Цикл для знаходження повного номеру після "+"
			while(true){
				index1 += 1;
				try{
					String d = String.valueOf(text.charAt(index1));
					n = Integer.valueOf(d);
				}
				//Умова зупинки циклу
				catch(NumberFormatException ex){
					break;
				}
				//Умова зупинки циклу №2
				if(n == -1)
					break;
				
				numb = numb +n;
			}
			//Додаємо знайдений номер в список
			number.add(numb);
			//переставляємо флажок пошуку
			n1 = index1;
		}
		System.out.println(number.toString());	
	}
	
	//Метод пошуку електроних пошт з вмістом "mail"
	public void parserM(){
		int n1 = 0;
		int index1 = 0;
		
		while(true){
			index1 = text.indexOf("mail", n1);
			if(index1 == -1)
				break;
			
			int index2 = index1;
			index1 += 3;
			String email = "mail";
			String str1 = "";
			String str2 = "";
			
			boolean s2 = true;
			boolean s1 = true;
			
			while( s1 == true || s2 == true){		
				index1 += 1;
				index2 -= 1;
				
				//Умова запису строки після mail
				if(s1 == true){
					try{
						str1 = String.valueOf(text.charAt(index1));
						if(str1.equals(" ")){
							s1 = false;
							str1 = "";
						}
					}
					catch(StringIndexOutOfBoundsException ex1){
						s1 = false;
						str1 = "";
					}
				}
				//Умова запису строки до mail
				if(s2 == true){
					str2 = String.valueOf(text.charAt(index2));
					if(str2.equals(" ")){
						s2 = false;
						str2 = "";
					}
				}
				email ="" +str2 +email +str1;
			}
			mail.add(email);
			n1 = index1;
		}
		System.out.println(mail.toString());
	}	
}
