package Logica;
/**
 * Permite manejar la logica de los Peaje.
 * Los set y get obtienen los datos própios de Peaje.
 * @author CAROLINA developers.
 *
 */
public class Peaje {
	
	private String nombre;
	private int costo;
	private boolean esAccesoNorte;
	private boolean esAccesoSur;
	
	public Peaje(String nombre, int costo, boolean accesoNorte, boolean accesoSur){
		this.setNombre(nombre);
		this.setCosto(costo);
		this.setEsAccesoNorte(accesoNorte);
		this.setEsAccesoSur(accesoSur);
	}
	
	public void modificarPeaje(int costo, boolean accesoNorte, boolean accesoSur){
		this.setCosto(costo);
		this.setEsAccesoNorte(accesoNorte);
		this.setEsAccesoSur(accesoSur);
	}
	
	public String getNombre(){
		return this.nombre;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public int getCosto(){
		return this.costo;
	}
	
	public void setCosto(int costo){
		this.costo = costo;
	}
	
	public boolean getEsAccesoNorte(){
		return this.esAccesoNorte;
	}
	
	public void setEsAccesoNorte(boolean acceso){
		this.esAccesoNorte = acceso;
	}
	
	public boolean getEsAccesoSur(){
		return this.esAccesoSur;
	}
	
	public void setEsAccesoSur(boolean acceso){
		this.esAccesoSur = acceso;
	}
	
	
}
