package Interfaces;

import java.util.List;

import Logica.Grafo;

public class main {
	public static void main(String [] agcv){
		Grafo sistema = new Grafo();
		sistema.aņadirPunto("p1", 20, true, false);
		sistema.aņadirPunto("p2", 18, false, false);
		sistema.aņadirPunto("p3", 16, false, false);
		sistema.aņadirPunto("p4", 20, false, false);
		sistema.aņadirPunto("p5", 5, false, false);
		sistema.aņadirPunto("p6", 15, false, false);
		sistema.aņadirPunto("p7", 12, false, true);
		sistema.aņadirPunto("p8", 40, false, false);
		sistema.aņadirPunto("p9", 20, false, false);
		
		sistema.aņadirTramo("p1", "p5", 52, 150, true);
		sistema.aņadirTramo("p2", "p6", 2, 50, true);
		sistema.aņadirTramo("p3", "p2", 2, 45, true);
		sistema.aņadirTramo("p4", "p3", 3, 86, true);
		sistema.aņadirTramo("p2", "p4", 4, 35, true);
		sistema.aņadirTramo("p5", "p2", 2, 16, true);
		sistema.aņadirTramo("p6", "p5", 8, 24, true);
		sistema.aņadirTramo("p6", "p7", 10, 63, true);
		sistema.aņadirTramo("p5", "p8", 20, 10, true);
		sistema.aņadirTramo("p8", "p6", 10, 20, true);
		sistema.aņadirTramo("p6", "p9", 2, 10, true);
		sistema.aņadirTramo("p9", "p7", 2, 20, true);
//		System.out.println(sistema.cantidadMaximaAuto());
		VentanaPrincipalSinDatos principal = new VentanaPrincipalSinDatos();
//		CaminoMasCorto p = new CaminoMasCorto(sistema);
//		List l = sistema.caminoMasCortoKm("p1", "p7");
//		System.out.println(l);
//		CaminoPeajes c = new CaminoPeajes(sistema,"p2","p7");
	}
}
