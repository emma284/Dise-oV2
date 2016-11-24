package Interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Logica.Grafo;
/**
 * Abre una nueva ventana que permite al usuario elegir que consulta desea realizar.
 * @author CAROLINA developers.
 *
 */
public class VentanaConsultas extends JFrame implements ActionListener {
	private JFrame ventana = new JFrame();
	private JPanel panelConsultas = new JPanel(); 
	private JPanel panelVuelta = new JPanel();
	private JButton botonCaminoMasCorto = new JButton("Camino más Corto");
	private JButton botonCaminoMenosPeajes = new JButton("Camino menos Peajes");
	private JButton botonPuntosAccesibles = new JButton("Puntos Accesibles");
	private JButton botonTraficoMaximo = new JButton("Tráfico Máximo");
	private JButton botonPuntosAccesiblesN = new JButton("Puntos Accesibles N");
	private JButton volver = new JButton("Volver");
	Grafo localGrafo;
	private PanelImagen imagen = new PanelImagen("/imagen/Peaje.png"); 
	private MapaGrafo mapa;
	
	public VentanaConsultas(Grafo grafo){
		localGrafo = grafo;
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setTitle("Consulta");
		try{ 
			localGrafo.getAccesoNorte().equals(null);
			localGrafo.getAccesoSur().equals(null);
		}
		catch(NullPointerException f){
			botonTraficoMaximo.setEnabled(false);
		}
		panelConsultas.add(botonCaminoMasCorto);
		panelConsultas.add(botonCaminoMenosPeajes);
		panelConsultas.add(botonPuntosAccesibles);
		panelConsultas.add(botonTraficoMaximo);
		panelConsultas.add(botonPuntosAccesiblesN);
		panelVuelta.add(volver);
		mapa = new MapaGrafo(localGrafo.getListaPeajes(),localGrafo.getListaAvenida());
		ventana.add(mapa);
		ventana.add(panelConsultas);
		ventana.add(panelVuelta);
		ventana.setSize(860, 600);
		ventana.add(imagen);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		ventana.setLayout(null);
		ventana.setResizable(false);
		panelConsultas.setBounds(10,25,800,35);
		panelConsultas.setOpaque(false);
		panelVuelta.setBounds(700,490,100,35);
		panelVuelta.setOpaque(false);
		mapa.setBounds(150,50,500,500);
		volver.addActionListener(this);
		botonPuntosAccesibles.addActionListener(this);
		botonTraficoMaximo.addActionListener(this);
		botonCaminoMasCorto.addActionListener(this);
		botonCaminoMenosPeajes.addActionListener(this);
		botonPuntosAccesiblesN.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == volver){
			ventana.dispose();
			VentanaPrincipal nuevaVentana = new VentanaPrincipal(localGrafo);
		}
		if(e.getSource() == botonCaminoMasCorto){
			ventana.dispose();
			CaminoMasCorto nuevaVentana = new CaminoMasCorto(localGrafo);
		}
		if(e.getSource() == botonCaminoMenosPeajes){
			ventana.dispose();
			CaminoMenosPeajes nuevaVentana = new CaminoMenosPeajes(localGrafo);
		}
		if(e.getSource() == botonPuntosAccesibles){
			ventana.dispose();
			JLabel nuevo = new JLabel();
			nuevo.setOpaque(false);
			MapaGrafo nuevoMapa = null;
			PuntosAccesibles nuevaVentana = new PuntosAccesibles(localGrafo, nuevo, nuevoMapa);
		}
		if(e.getSource() == botonTraficoMaximo){
			TraficoMaximo nuevaVentana = new TraficoMaximo(localGrafo);
		}
		if(e.getSource() == botonPuntosAccesiblesN){
			ventana.dispose();
			JLabel nuevo = new JLabel();
			nuevo.setOpaque(false);
			MapaGrafo nuevoMapa = null;
			PuntosAccesiblesN nuevaVentana = new PuntosAccesiblesN(localGrafo,nuevo, nuevoMapa);		}
	}
}
