package May;

import java.io.*;

public class Ex1Reader {
	private String pathText;
	public String text = "";
	
	Ex1Reader(String pathText){
		this.pathText = pathText;
	}
	
	//Метод зчитування файла і запису в строку text
	public String reader() throws IOException {
		FileInputStream fis = new FileInputStream(pathText);
		try{
			byte [] buf = new byte [1];
			int r;
			
			do {
				r = fis.read(buf, 0, buf.length);
				if (r > 0){		
					text += new String (buf, "US-ASCII");
				}
			}
			while(r > 0);	
		}
		finally {
			fis.close();
		}
		return text;
	}
}
