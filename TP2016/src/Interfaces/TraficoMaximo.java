package Interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Logica.Grafo;

/**
 * Abre una nueva ventana que permite ver al usuario el Grafo total del sistema y el tráfico máimo que puede ir desde el Acceso Norte al Acceso Sur(en miles) por día.
  * @author CAROLINA developers.
 *
 */
public class TraficoMaximo extends JFrame implements ActionListener{
	private JFrame ventana = new JFrame();
	private JPanel panel = new JPanel();
	private JPanel panelBoton = new JPanel();
	private JButton aceptar = new JButton("Aceptar");
	Grafo localGrafo;
	private JLabel msj1 = new JLabel("Pueden circular un total de: ");
	private JLabel msj2 = new JLabel(" miles de autos por día desde el peaje ");
	private JLabel cant = new JLabel();
	private JLabel msj3;
	private PanelImagen imagen = new PanelImagen("/imagen/Peaje.png");
	private MapaGrafo mapa;
	
	public TraficoMaximo(Grafo grafo){
		localGrafo = grafo;
		mapa = new MapaGrafo(localGrafo.getListaPeajes(), localGrafo.getListaAvenida());
		msj3 = new JLabel(localGrafo.getAccesoNorte().getNombre() + " (acceso norte) hasta el peaje " + localGrafo.getAccesoSur().getNombre() + " (acceso sur).");
		Integer num = localGrafo.cantidadMaximaAuto();
		cant.setText(num.toString());
		ventana.setTitle("Cantidad máxima de vehículos por día");
		panel.add(msj1);
		panel.add(cant);
		panel.add(msj2);
		panel.add(msj3);
		panelBoton.add(aceptar);
		
		ventana.add(panel);
		ventana.add(panelBoton);
		ventana.setSize(800, 600);
		ventana.add(mapa);
		ventana.add(imagen);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		ventana.setLayout(null);
		ventana.setResizable(false);
		panel.setBounds(250, 10, 300, 100);
		panel.setOpaque(true);
		mapa.setBounds(200,100,400,400);
		panelBoton.setBounds(350,500, 100, 35);
		panelBoton.setOpaque(false);
		aceptar.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == aceptar){
			ventana.dispose();
		}
	}
}
