package Interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Logica.Grafo;
import Logica.Peaje;
/**
 * Permite abrir la ventana en la cual el usuario podr� ver el camino mas corto de acuerdo a lo que antes seleccion�.
 * @author CAROLINA developers.
 *
 */
public class CaminoCorto extends JFrame implements ActionListener{
	private JFrame ventana = new JFrame();
	private JLabel longitud; 
	private JPanel panelBoton = new JPanel();
	private JButton volver = new JButton("Volver");
	private MapaGrafo mapa;
	private Grafo grafoLocal;
	private PanelImagen imagen = new PanelImagen("/imagen/Peaje.png");
	
	public CaminoCorto(Grafo grafo, String p1, String p2) {
		grafoLocal = grafo;
		List <Peaje> listaPj = grafoLocal.caminoMasCortoKm(p1, p2);
		List listaAv = new ArrayList();
		for(int i=0; i<(listaPj.size())-1; i++){
			listaAv.add(grafoLocal.obtenerAvenida(listaPj.get(i), listaPj.get(i+1)));
		}
		longitud = new JLabel("Longitud: " + grafoLocal.longCamino(listaAv) + " Km.");
		mapa = new MapaGrafo(listaPj, listaAv);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setTitle("Camino mas corto");
		panelBoton.add(volver);
		ventana.add(longitud);
		ventana.add(panelBoton);
		ventana.add(mapa);
		ventana.add(imagen);
		ventana.setSize(800, 600);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		ventana.setLayout(null);
		ventana.setResizable(false);
		
		longitud.setBounds(333, 50, 680, 35);
		panelBoton.setBounds(650,500,100,35);
		panelBoton.setOpaque(false);
		mapa.setBounds(120,50,500,500);
		ventana.setVisible(true);
		volver.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == volver){
			ventana.dispose();
		}
	}

}
