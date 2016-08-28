package consola;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class App {

	public static void main(String[] args) throws IOException {
//		FileInputStream fin = new FileInputStream("c:/Temp/demo.txt"); 
//		BufferedInputStream bfin = new BufferedInputStream(fin);
		
		BufferedInputStream bfin = new BufferedInputStream(
				new FileInputStream("c:/Temp/demo.txt"));
		
		int acabar; 
		while( (acabar = bfin.read()) != -1) 
			System.out.println( (char)acabar); 
		
		bfin.close();
	}
}//fin class consola.App
