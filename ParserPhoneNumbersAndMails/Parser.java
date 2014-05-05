package May;

import java.util.HashSet;
import java.util.Set;


public class Ex1Parser {
	private String text;
	public static Set<String> number = new HashSet<String>();
	public static Set<String> mail = new HashSet<String>();

	public Ex1Parser(String text) {
		this.text = text;
	}
	
	public void parserN(){
		int n1 = 0;
		int index1 = 0;
		
		while(true){
			index1 = text.indexOf("+", n1);
			if(index1 == -1)
				break;
			
			int n = 0;
			String numb = "+";
			
			while(true){
				index1 += 1;
				try{
					String d = String.valueOf(text.charAt(index1));
					n = Integer.valueOf(d);
				}
				catch(NumberFormatException ex){
					break;
				}
						/*if(n == -1)
						break;*/
				
				numb = numb +n;
			}
			number.add(numb);
			n1 = index1;
		}
		System.out.println(number.toString());	
	}
	
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
