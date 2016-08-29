package entidades;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Persona implements Serializable{
	
	private static final long serialVersionUID = -7849462454739765129L;
	private int codigo;
	private String nombre;
	private LocalDate fechaNacimiento; 
	
//	Habrá veces que tendremos propiedades que no interesa  Serializar o guardar.
//	Poniendo el modificador transient
	private transient LocalDateTime ultimaActualiacion = LocalDateTime.now(); 
	
	public Persona(){
		this(0, "", LocalDate.now()); 
	}
	
	public Persona(int codigo, String nombre, LocalDate fechaNacimiento){
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

	@Override
	public String toString() {
		return "Persona [Codigo=" + getCodigo() + 
				", Nombre=" + getNombre() + 
				", FechaNacimiento=" + getFechaNacimiento() + 
				", UltimaActualización" + ultimaActualiacion +
				"]";
	}
}//fin class entidades.Persona
