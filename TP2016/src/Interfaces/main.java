package Interfaces;

import java.util.List;

import Logica.Grafo;

public class main {
	public static void main(String [] agcv){
		Grafo sistema = new Grafo();
		sistema.a�adirPunto("p1", 20, true, false);
		sistema.a�adirPunto("p2", 18, false, false);
		sistema.a�adirPunto("p3", 16, false, false);
		sistema.a�adirPunto("p4", 20, false, false);
		sistema.a�adirPunto("p5", 5, false, false);
		sistema.a�adirPunto("p6", 15, false, false);
		sistema.a�adirPunto("p7", 12, false, true);
		sistema.a�adirPunto("p8", 40, false, false);
		sistema.a�adirPunto("p9", 20, false, false);
		
		sistema.a�adirTramo("p1", "p5", 52, 150, true);
		sistema.a�adirTramo("p2", "p6", 2, 50, true);
		sistema.a�adirTramo("p3", "p2", 2, 45, true);
		sistema.a�adirTramo("p4", "p3", 3, 86, true);
		sistema.a�adirTramo("p2", "p4", 4, 35, true);
		sistema.a�adirTramo("p5", "p2", 2, 16, true);
		sistema.a�adirTramo("p6", "p5", 8, 24, true);
		sistema.a�adirTramo("p6", "p7", 10, 63, true);
		sistema.a�adirTramo("p5", "p8", 20, 10, true);
		sistema.a�adirTramo("p8", "p6", 10, 20, true);
		sistema.a�adirTramo("p6", "p9", 2, 10, true);
		sistema.a�adirTramo("p9", "p7", 2, 20, true);
//		System.out.println(sistema.cantidadMaximaAuto());
		VentanaPrincipalSinDatos principal = new VentanaPrincipalSinDatos();
//		CaminoMasCorto p = new CaminoMasCorto(sistema);
//		List l = sistema.caminoMasCortoKm("p1", "p7");
//		System.out.println(l);
//		CaminoPeajes c = new CaminoPeajes(sistema,"p2","p7");
	}
}
