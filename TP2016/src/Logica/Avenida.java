package Logica;
/**
 * Maneja la logica de las Avenidas del sistema. 
 * Los set y get obtienen los datos própios de Avenida.
 * @author CAROLINA developers.
 *
 */
public class Avenida {
	
	private int longitud;
	private boolean estado;
	private int capacidad;
	Peaje entrada;
	Peaje salida;
	
	public Avenida(Peaje peajeEntrada, Peaje peajeSalida, int capacidad, int longitud, boolean estado){
		this.setPeajeEntrada(peajeEntrada);
		this.setPeajeSalida(peajeSalida);
		this.setCapacidad(capacidad);
		this.setLongitud(longitud);
		this.setEstado(estado);
		
	}
	
	public void modificarAvenida(int capacidad, int longitud, boolean estado){
		this.setCapacidad(capacidad);
		this.setLongitud(longitud);
		this.setEstado(estado);
	}
	
	public void setPeajeSalida(Peaje peajeSalida) {
		this.salida = peajeSalida;
		
	}
	
	public Peaje getPeajeSalida(){
		return this.salida;
	}

	public Peaje getPeajeEntrada(){
		return this.entrada;
	}
	
	public void setPeajeEntrada(Peaje peajeEntrada) {
		this.entrada = peajeEntrada;
		
	}

	public int getLongitud(){
		return this.longitud;
	}
	public void setLongitud(int longi){
		this.longitud = longi;
	}
	
	public boolean getEstado(){
		return this.estado;
	}
	
	public void setEstado( boolean condicion){
		this.estado = condicion;
	}
	
	public int getCapacidad(){
		return this.capacidad;
	}
	
	public void setCapacidad(int capacidad){
		this.capacidad = capacidad;
	}

	
	
	
}
