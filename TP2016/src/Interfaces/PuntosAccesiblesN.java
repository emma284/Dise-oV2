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
 * Permite al usuario ingresar los datos necesarios y luego visualizar los puntos a los que se puede llegar desde el punto seleccionado pasnado por no mas de N Peajes.
 * @author CAROLINA developers.
 *
 */
public class PuntosAccesiblesN extends JFrame implements ActionListener{
	private JFrame ventana = new JFrame();
	private JPanel panelFiltro = new JPanel();
	private JPanel panelBotones = new JPanel();
	private JPanel panelCantidad = new JPanel();
	private JLabel texCantidad = new JLabel("Ingrese Cantidad de Peajes: ");
	private JTextField cantidad = new JTextField(3);
	private JLabel txtPeaje = new JLabel("Peaje de partida"); 
	private JComboBox<String> listaPeajes = new JComboBox();
	private JButton buscar = new JButton("Buscar");
	private JButton volver = new JButton("Volver");
	Grafo localGrafo = new Grafo();
	private PanelImagen imagen = new PanelImagen("/imagen/Peaje.png");
	private MapaGrafo mapa;
	private JLabel resultado;
	private MapaGrafo mapaResultado;
	private JLabel textoMapaTotal = new JLabel("Camino Total");
	private JLabel textoMapaResultado = new JLabel("Camino Resultante");
	
	public PuntosAccesiblesN(Grafo grafo, JLabel label, MapaGrafo nuevoMapa){
		localGrafo = grafo;
		resultado = label;
		mapaResultado = nuevoMapa;
		mapa = new MapaGrafo(localGrafo.getListaPeajes(), localGrafo.getListaAvenida());
		
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setTitle("Puntos Accesibles desde peaje");
		panelFiltro.add(txtPeaje);
		panelFiltro.add(listaPeajes);
		panelBotones.add(buscar);
		panelBotones.add(volver);
		panelCantidad.add(texCantidad);
		panelCantidad.add(cantidad);
		listaPeajes.addItem("Seleccione uno");
		agregarPeajesVista(listaPeajes);
		
		ventana.add(panelFiltro);
		ventana.add(panelCantidad);
		ventana.add(panelBotones);
		ventana.add(resultado);
		ventana.setSize(800, 600);
		ventana.add(textoMapaTotal);
		ventana.add(mapa);
		if (!(mapaResultado == null)){
			ventana.add(textoMapaResultado);
			ventana.add(mapaResultado);
		}
		ventana.add(imagen);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		ventana.setLayout(null);
		ventana.setResizable(false);
		panelFiltro.setBounds(10,10,500,35);
		panelFiltro.setOpaque(false);
		panelCantidad.setBounds(300,10,500,35);
		panelCantidad.setOpaque(false);
		resultado.setBounds(10, 450, 700, 35);
		if (!(mapaResultado == null)){
			textoMapaResultado.setBounds(500,50,150,35);
			textoMapaTotal.setBounds(200,50,100,35);
			mapa.setBounds(100,60,300,300);
			mapaResultado.setBounds(400,60,300,300);
			}
			else{
				textoMapaTotal.setBounds(350,50,150,35);
				mapa.setBounds(200,60,400,400);
			}
		panelBotones.setBounds(600,490,200,35);
		panelBotones.setOpaque(false);
		volver.addActionListener(this);
		buscar.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == volver){
			ventana.dispose();
			VentanaConsultas nuevaVentana = new VentanaConsultas(localGrafo);
		}
		if(e.getSource() == buscar){
			if(listaPeajes.getSelectedItem().equals("Seleccione uno") || cantidad.getText().equals("")){
				JOptionPane.showMessageDialog(null, "Debe seleccionar un peaje y una cantidad de peajes.", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else{
				try{
					List <Peaje> miLista = localGrafo.alcanceN((String)listaPeajes.getSelectedItem(), Integer.parseInt(cantidad.getText()));
					String texto = "Se puede acceder a los siguientes puntos: ";
					for(Peaje p : miLista){
						texto+= p.getNombre() + ", ";
					}
					texto += "desde el punto " + listaPeajes.getSelectedItem() + " pasando por no mas de " + cantidad.getText()+ " peajes.";
					ventana.dispose();
					JLabel nuevo = new JLabel(texto);
					Peaje actual = localGrafo.getAccesoNorte();
					List <Peaje>auxiliar = localGrafo.getListaPeajes();
					for (Peaje p : auxiliar){
						if(p.getNombre().equals(listaPeajes.getSelectedItem())){
							actual = p;
						}
					}
					nuevo.setOpaque(true);if (!(miLista.contains(actual))){
						miLista.add(actual);
					}
					List listaAvenidas = localGrafo.obtenerTodasAvenidas(miLista);
					mapaResultado = new MapaGrafo(miLista, listaAvenidas);
					PuntosAccesiblesN ventana = new PuntosAccesiblesN(localGrafo, nuevo, mapaResultado);
				}
				catch(NumberFormatException er){
					JOptionPane.showMessageDialog(null, "Seleccione un numero v�lido", "Error", JOptionPane.ERROR_MESSAGE);
				}
		}}
	}
	
	public void agregarPeajesVista(JComboBox<String> peajes) {
		List<Peaje> lista = localGrafo.getListaPeajes();
		for (Peaje p : lista){
			peajes.addItem(p.getNombre());
		}
		
	}
	
}