package Logica;

public class Puesto {

	private String codigo;
	private String nombre;
	private String empresa;
	private String descripcion;
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	

	public Puesto(String cod, String nomb, String emp, String descrip) {
		this.codigo=cod;
		this.nombre=nomb;
		this.empresa=emp;
		this.descripcion=descrip;

		
	}
}
