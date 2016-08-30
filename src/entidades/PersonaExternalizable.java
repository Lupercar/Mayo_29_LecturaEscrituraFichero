package entidades;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class PersonaExternalizable implements Serializable{
	
	private static final long serialVersionUID = -7849462454739765129L;
	private int codigo;
	private String nombre;
	private LocalDate fechaNacimiento; 
	
//	Habr� veces que tendremos propiedades que no interesa  Serializar o guardar.
//	Poniendo el modificador transient
	private transient LocalDateTime ultimaActualiacion = LocalDateTime.now(); 
	
//	propiedad est�tica
	static private int valor = 0; 
	static private int valor2 = 0; 
	
	public PersonaExternalizable(){
		this(0, "", LocalDate.now()); 
	}
	
	public PersonaExternalizable(int codigo, String nombre, LocalDate fechaNacimiento){
		super();
		setCodigo(codigo);
		setNombre(nombre);
		setFechaNacimiento(fechaNacimiento);
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public LocalDateTime getUltimaActualiacion() {
		return ultimaActualiacion;
	}

	public void setUltimaActualiacion(LocalDateTime ultimaActualiacion) {
		this.ultimaActualiacion = ultimaActualiacion;
	}

	public static int getValor() {
		return valor;
	}

	public static void setValor(int valor) {
		PersonaExternalizable.valor = valor;
	}

	@Override
	public String toString() {
		return "Persona [Codigo=" + getCodigo() + 
				", Nombre=" + getNombre() + 
				", FechaNacimiento=" + getFechaNacimiento() + 
				", UltimaActualizaci�n=" + this.ultimaActualiacion +
				", valor=" + valor +
				", valor2=" + valor2 +
				"]";
	}
	
//	Personalizar la lectura/escritura de la interfaz serializable
//	=============================================================
	private void writeObject(ObjectOutputStream out) throws IOException{
//		Este m�todo se encarga de la escritura de la serializaci�n
		//se realiza la escritura por defecto de la serializaci�n.
		out.defaultWriteObject(); 
//		Guarda cosas extra
		out.writeInt(valor);
		out.writeInt(valor2);
	}
	
	private void readObject(ObjectInputStream in) throws ClassNotFoundException, IOException{
//		Este m�todo se encarga de la lectura de la serializaci�n
		//se realiza la lectura por defecto de la serializaci�n.
		in.defaultReadObject();
//		Se guardan en el mismo orden en que se han escrito
		valor = in.readInt(); 
		valor2 = in.readInt(); 
		
		this.ultimaActualiacion = LocalDateTime.now(); 
	}
}//fin class entidades.Persona
