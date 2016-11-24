package Logica;

public class Competencia {

	private String id_competencia;
	private String nombre;
	private String descripcion;
	
	public Competencia(String id,String n,String d) {
		this.id_competencia=id;
		this.nombre=n;
		this.descripcion=d;
	}
	public String getId_competencia() {
		return id_competencia;
	}
	public void setId_competencia(String id_competencia) {
		this.id_competencia = id_competencia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
