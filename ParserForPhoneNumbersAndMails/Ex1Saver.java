package May;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;

public class Ex1Saver {
	
	private Set<String> number = Ex1Parser.number;
	private Set<String> mail = Ex1Parser.mail;
	private String pathNumber;
	private String pathMail;
	
	public Ex1Saver (String pathNumber, String pathMail){
		this.pathNumber = pathNumber;
		this.pathMail = pathMail;
	}
	//Метод запису знайдених даних в файли
	public void saver() throws IOException{
		
		File number1 = new File(pathNumber);
		//При відсутності файла створюємо новий
		if(!number1.exists())
			number1.createNewFile();
		OutputStream os1 = new FileOutputStream(number1);
		byte[] numbers = number.toString().getBytes();
		os1.write(numbers);
		os1.close();
		
		File mail1 = new File(pathMail);
		if(!mail1.exists())
			mail1.createNewFile();
		OutputStream os2 = new FileOutputStream(mail1);
		byte[] mails = mail.toString().getBytes();
		os2.write(mails);
		os2.close();
	}
}
