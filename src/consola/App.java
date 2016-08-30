package consola;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import entidades.Persona;

public class App {

	public static void main(String[] args) throws IOException {
		
//		LECTURA
//		==============================================================
//		==============================================================
		
		
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
		
//		forma nueva de abrir un canal de entrada o salida que se cierre sólo
//		a partir de Java7 ---> Try-Catch con recurso
//		sólo se permiten objetos que implementan la interfaz Closeable.
//		====================================================================
		try(BufferedReader bfr2 = new BufferedReader(new FileReader("c:/Temp/demo.txt"));) {
			
			String linea2 = ""; 
			while( (linea2 = bfr2.readLine() ) != null)
				System.out.println(linea2);
			
		} catch (IOException ex) {
			ex.getStackTrace(); 
		}
		
//		ESCRITURA
//		=======================================================================
//		=======================================================================

//		trabajar a nivel de tipos primitivo escritura
//		=============================================
		try(DataOutputStream dfout = new DataOutputStream(new BufferedOutputStream(
				new FileOutputStream("c:/Temp/escribir_byte.txt")))
				){
			dfout.writeUTF("cadena"); 
			dfout.writeInt(3); 
			dfout.writeLong(22222222L); 
			dfout.writeBoolean(true); 
		}catch(IOException ex){
			ex.getStackTrace(); 
		}
		
//		trabajar a nivel de carácter
//		============================
		try(BufferedWriter bfw = new BufferedWriter(
				new FileWriter("c:/Temp/escribir_caracteres.txt"))
				){
			
			bfw.write("cadena 1");
			bfw.write("cadena 2");
		}catch (IOException ex) {
			ex.getStackTrace(); 
		}
		
//		trabajar a nivel de objetos
//		============================================
//		============================================
		
////		Crear fichero con el contenido de un objeto Persona
////		===================================================
//		Persona p1 = new Persona(1, "Pepito", LocalDate.of(1990, Month.FEBRUARY, 5)); 
//		p1.setValor(100);
//		
//		try( ObjectOutputStream dfout = new ObjectOutputStream( 
//				new BufferedOutputStream(new FileOutputStream("c:/Temp/escribir_objetos.txt"))) 
//				){
//			
////		Tiene que implementar la interfaz Serializable
////		guarda automáticamente todas las propiedades no estáticas de un objeto, 
////		entonces las propiedades estáticas no se guardan.
////		No guarda las propiedades marcadas con el modificador transient
//			dfout.writeObject(p1); //
//		}catch(IOException ex){
//			ex.getStackTrace(); 
//		}
//		
////		Leer fichero el contenido de un objeto Persona
////		==============================================
//		try(ObjectInputStream ofin = new ObjectInputStream( 
//				new BufferedInputStream( 
//						new FileInputStream("c:/Temp/escribir_objetos.txt")))
//				){
//			
//			Persona p = (Persona) ofin.readObject();
//			System.out.println(p); 
//			
//		}catch(IOException ex){
//			ex.getStackTrace(); 
//		} catch (ClassNotFoundException ex) {
//			ex.printStackTrace();
//		}
		
//		Guardar una lista Persona
//		=========================
		List<Persona> personas = new ArrayList<>(); 
		personas.add(new Persona(1, "Pepito", LocalDate.of(1990, 1, 1)));
		personas.add(new Persona(2, "Juanito", LocalDate.of(1991, 2, 2)));
		personas.add(new Persona(3, "Menganito", LocalDate.of(1992, 3, 3)));
		
////		Serializamos
////		============
//		
//////	Crear fichero con el contenido de lista de Persona
//////	==================================================
//		try( ObjectOutputStream dfout = new ObjectOutputStream( 
//				new BufferedOutputStream(
//						new FileOutputStream(
//								"c:/Temp/escribir_lista_objetos.txt"))) 
//				){
//			
//			dfout.writeObject(personas); 
//		}catch(IOException ex){
//			ex.getStackTrace(); 
//		}
//		
////		Leer fichero el contenido de un objeto Persona
////		==============================================
//		try(ObjectInputStream ofin = new ObjectInputStream( 
//				new BufferedInputStream( 
//						new FileInputStream(
//								"c:/Temp/escribir_lista_objetos.txt")))
//				){
//			
//			List<Persona> p = (List<Persona>) ofin.readObject();
//			System.out.println(p); 
//			
//		}catch(IOException ex){
//			ex.getStackTrace(); 
//		} catch (ClassNotFoundException ex) {
//			ex.printStackTrace();
//		}
	
////		Escritura en Formato XML
////		========================
//		try(XMLEncoder xmlOut = new XMLEncoder(
//				new BufferedOutputStream( 
//						new FileOutputStream(
//								"c:/Temp/escribir_xml.txt")
//						))){
//			
//			xmlOut.writeObject(personas);
//			
//		}catch(IOException ex){
//			ex.getLocalizedMessage(); 
//		}
//		
////		Lectura en formato XML
////		======================
//		try(XMLDecoder xmlIn = new XMLDecoder(
//				new BufferedInputStream(
//						new FileInputStream(
//								"c:/Temp/escribir_xml.txt")
//						))){
//			
//			System.out.println( (List<Persona>) xmlIn.readObject() ); 
//			
//		}catch(IOException ex){
//			ex.getStackTrace(); 
//		}
		
//		Formato JSON
//		============
		ObjectMapper mapper = new ObjectMapper();
		
//		Escritura JSON
		try(BufferedOutputStream out = new BufferedOutputStream( 
				new FileOutputStream(
						"c:/Temp/escribir_json.txt")
				) ){
			
			mapper.writeValue(out, personas); 
			
		}catch(IOException ex){
			ex.getLocalizedMessage(); 
		}
		
//		Lectura JSON
		try(BufferedInputStream in = new BufferedInputStream(
				new FileInputStream(
						"c:/Temp/escribir_json.txt")
				)){
			
			List<Persona> p = (List<Persona>) mapper.readValue(in, List.class); 
			System.out.println(p);
			
		}catch(IOException ex){
			ex.getStackTrace(); 
		}
	}
}//fin class consola.App
