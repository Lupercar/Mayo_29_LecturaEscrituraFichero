package entidades;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class PersonaExternalizable implements Externalizable, Serializable{
	
	private static final long serialVersionUID = -7849462454739765129L;
	private int codigo;
	private String nombre;
	private LocalDate fechaNacimiento; 
	
//	Habrá veces que tendremos propiedades que no interesa  Serializar o guardar.
//	Poniendo el modificador transient
	private transient LocalDateTime ultimaActualiacion = LocalDateTime.now(); 
	
//	propiedad estática
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
				", UltimaActualización=" + this.ultimaActualiacion +
				", valor=" + valor +
				", valor2=" + valor2 +
				"]";
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(codigo);
		out.writeUTF(nombre);
		out.writeLong(fechaNacimiento.toEpochDay()); //convertimos a long
		out.writeLong(ultimaActualiacion.toEpochSecond(ZoneOffset.UTC)); //convertimos a long
		out.writeInt(valor);
		out.writeInt(valor2);
	}
	
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		codigo = in.readInt(); 
		nombre = in.readUTF();
		fechaNacimiento.ofEpochDay( in.readLong() ); 
		ultimaActualiacion.ofEpochSecond( in.readLong(), 0, ZoneOffset.UTC); 
		valor = in.readInt(); 
		valor2 = in.readInt(); 
	}
}//fin class entidades.Persona
