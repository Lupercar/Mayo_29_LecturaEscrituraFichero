package consola;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class App {

	public static void main(String[] args) throws IOException {
//		trabajar a nivel de bytes.
//		==========================
		
//		FileInputStream fin = new FileInputStream("c:/Temp/demo.txt"); 
//		BufferedInputStream bfin = new BufferedInputStream(fin);
		
		BufferedInputStream bfin = new BufferedInputStream(
				new FileInputStream("c:/Temp/demo.txt"));
		
		int acabar; 
		while( (acabar = bfin.read()) != -1) 
			System.out.println( (char)acabar); 
		
		bfin.close();
		
//		trabajar a nivel de carácter
//		============================
		BufferedReader bfr = new BufferedReader(
				new FileReader("c:/Temp/demo.txt"));
		
		String linea = ""; 
		while( (linea = bfr.readLine() ) != null)
			System.out.println(linea);
		
		bfr.close();
		
//		trabajar a nivel de tipos primitivo
//		===================================
		DataInputStream dfin = new DataInputStream(
				new BufferedInputStream(
						new FileInputStream("c:/Temp/demo.txt")));
		
//		long valor = dfin.readLong(); //permite tipos primitivos
		
		dfin.close();
	}
}//fin class consola.App
