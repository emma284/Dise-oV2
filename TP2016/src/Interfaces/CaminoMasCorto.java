package Interfaces;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Logica.Grafo;
import Logica.Peaje;

/**
 *Abre la ventana que permitirá al usuario ingresar los datos para obtener el camino mas corto en km.  
 * @author CAROLINA developers.
 *
 */
public class CaminoMasCorto extends JFrame implements ActionListener{
	
	
	private JFrame ventana = new JFrame();
	private JPanel panelNombrePeaje1 = new JPanel();
	private JLabel nombreLabelPeaje1 = new JLabel("Ingrese el peaje de inicio: ");
	private JComboBox <String> peaje1 = new JComboBox();
	private JPanel panelnombrePeaje2 = new JPanel();
	private JLabel nombreLabelPeaje2 = new JLabel("Ingrese el peaje a destino: ");
	private JComboBox <String> peaje2 = new JComboBox();
	private JPanel panelBotones = new JPanel();
	private JButton aceptar = new JButton("Aceptar");
	private JButton cancelar = new JButton("Cancelar");
	private Grafo grafoLocal;
	private MapaGrafo mapa;
	
	
	public  CaminoMasCorto(Grafo grafo){
	
		this.grafoLocal = grafo;
		
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setTitle("Camino mas corto ");
		peaje1.addItem("Seleccione uno");
		peaje2.addItem("Seleccione uno");
		agregarPeajesVista(peaje1,peaje2);
		panelNombrePeaje1.add(nombreLabelPeaje1);
		panelNombrePeaje1.add(peaje1);
		
		PanelImagen imagen = new PanelImagen("/imagen/Peaje.png");
		mapa = new MapaGrafo(grafoLocal.getListaPeajes(), grafoLocal.getListaAvenida());
		
		panelnombrePeaje2.add(nombreLabelPeaje2);
		panelnombrePeaje2.add(peaje2);
		panelBotones.add(aceptar);
		panelBotones.add(cancelar);
		ventana.add(panelNombrePeaje1 );
		ventana.add(panelnombrePeaje2);
		ventana.add(panelBotones);
		ventana.add(mapa);
		ventana.add(imagen);
		ventana.setSize(800, 600);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		ventana.setLayout(null);
		ventana.setResizable(false);
	
		
		panelNombrePeaje1.setBounds(10,50, 300, 100);
		panelNombrePeaje1.setOpaque(false);
		panelnombrePeaje2.setBounds(300,50, 300,100);
		panelnombrePeaje2.setOpaque(false);
		panelBotones.setBounds(550,490,200,35);
		panelBotones.setOpaque(false);
		mapa.setBounds(120,50,500,500);
		ventana.setVisible(true);
		aceptar.addActionListener(this);
		cancelar.addActionListener(this);
		
	

	}
	
	public void agregarPeajesVista(JComboBox<String> peaje1, JComboBox<String> peaje2) {
		List<Peaje> lista = grafoLocal.getListaPeajes();
		for (Peaje p : lista){
			peaje1.addItem(p.getNombre());
			peaje2.addItem(p.getNombre());
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cancelar){
			ventana.dispose();
			VentanaConsultas nuevaVentana = new VentanaConsultas(grafoLocal);
		}
		if(e.getSource() == aceptar){
			if(peaje1.getSelectedItem().equals("Seleccione uno") || peaje2.getSelectedItem().equals("Seleccione uno") ){
				JOptionPane.showMessageDialog(null, "Seleccione ambos peajes", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else{
				try{
					CaminoCorto c = new CaminoCorto(grafoLocal,(String)peaje1.getSelectedItem(), (String)peaje2.getSelectedItem());
				}
				catch(ArrayIndexOutOfBoundsException eN){
				JOptionPane.showMessageDialog(null, "No existen caminos que unan estos peajes", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
	
	
}
