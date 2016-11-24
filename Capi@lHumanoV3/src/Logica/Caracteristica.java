package Logica;

import com.sun.javafx.collections.MappingChange.Map;

public class Caracteristica {
	
	private Competencia competencia;
	private Puesto puesto;
	private Integer ponderacion;
	
	public Caracteristica(Competencia competencia, Puesto puesto, Integer ponderacion) {
		
		this.competencia=competencia;
		this.puesto=puesto;
		this.ponderacion=ponderacion;
		
	}
	public Competencia getCompetencia() {
		return competencia;
	}
	public void setCompetencia(Competencia competencia) {
		this.competencia = competencia;
	}
	public Puesto getPuesto() {
		return puesto;
	}
	public void setPuesto(Puesto puesto) {
		this.puesto = puesto;
	}
	public Integer getPonderacion() {
		return ponderacion;
	}
	public void setPonderacion(Integer ponderacion) {
		this.ponderacion = ponderacion;
	}
	
	

}
