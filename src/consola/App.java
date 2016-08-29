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
		
//		trabajar a nivel de car�cter
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
		
//		forma nueva de abrir un canal de entrada o salida que se cierre s�lo
//		a partir de Java7 ---> Try-Catch con recurso
//		s�lo se permiten objetos que implementan la interfaz Closeable.
//		====================================================================
		try(BufferedReader bfr2 = new BufferedReader(new FileReader("c:/Temp/demo.txt"));) {
			
			String linea2 = ""; 
			while( (linea2 = bfr2.readLine() ) != null)
				System.out.println(linea2);
			
		} catch (IOException ex) {
			ex.getStackTrace(); 
		}
	}
}//fin class consola.App
