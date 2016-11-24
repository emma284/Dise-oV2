package Interfaces;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Logica.Grafo;
/**
 *Abre una nueva ventana que permite al usuario carga un red o inicializar una nueva. 
 * @author CAROLINA developers.
 *
 */
public class VentanaPrincipalSinDatos extends JFrame implements ActionListener {
	private JMenuBar menuBar = new JMenuBar();
	private JMenu menuArchivo = new JMenu();
	private JMenuItem itemNuevosDatos = new JMenuItem();
	private JMenuItem itemCargarDatos = new JMenuItem();
	private JMenuItem itemSalir = new JMenuItem();
	private JMenuItem itemBorrar = new JMenuItem();
	private JMenuItem itemAyuda = new JMenuItem();
	private JMenuItem itemAcercaDe = new JMenuItem();
	private JPanel cartas = new JPanel(new CardLayout());
	private JFrame ventana = new JFrame();
	private JPanel panelBotones = new JPanel();
	private JButton anadirPunto = new JButton();
	private JButton anadirTramo = new JButton();
	private JButton realizarConsultas = new JButton();
	private JButton modificarPunto = new JButton();
	private JButton modificarTramo = new JButton();
	Grafo grafoLocal = new Grafo();
	
	public VentanaPrincipalSinDatos(){
		PanelImagen imagen = new PanelImagen("/imagen/Peaje.png");
		ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
		ventana.setJMenuBar(menuBar);
		menuBar.add(menuArchivo);
		menuArchivo.add(itemNuevosDatos);
		menuArchivo.add(itemCargarDatos);
		menuArchivo.add(itemBorrar);
		menuArchivo.add(itemAyuda);
		menuArchivo.add(itemAcercaDe);
		menuArchivo.addSeparator();
		menuArchivo.add(itemSalir);
		
		menuArchivo.setText("Archivo");
		itemNuevosDatos.setText("Nueva red");
		itemCargarDatos.setText("Cargar configuración");
		itemBorrar.setText("Limpiar");
		itemBorrar.setEnabled(false);
		itemAyuda.setText("Ayuda");
		itemAcercaDe.setText("Acerca de");
		itemSalir.setText("Salir");
		
		ventana.add(cartas);
		anadirPunto.setText("Añadir Punto");
		anadirTramo.setText("Añadir Tramo");
		realizarConsultas.setText("Consultas");
		modificarPunto.setText("Modificar Punto");
		modificarTramo.setText("Modificar Tramo");
		anadirPunto.setEnabled(false);
		anadirTramo.setEnabled(false);
		realizarConsultas.setEnabled(false);
		modificarPunto.setEnabled(false);
		modificarTramo.setEnabled(false);
		
		
		panelBotones.add(anadirPunto);
		panelBotones.add(anadirTramo);
		panelBotones.add(realizarConsultas);
		panelBotones.add(modificarPunto);
		panelBotones.add(modificarTramo);
		ventana.add(panelBotones);
		ventana.add(imagen);
		ventana.setSize(800, 600);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		ventana.setLayout(null);
		ventana.setResizable(false);
		panelBotones.setOpaque(false);
		panelBotones.setBounds(200,25,350,70);
		
		itemCargarDatos.addActionListener(this);
		itemSalir.addActionListener(this);
		itemNuevosDatos.addActionListener(this);
		itemAyuda.addActionListener(this);
		itemAcercaDe.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == itemCargarDatos){
			JFileChooser cargar = new JFileChooser();
			int opcion = cargar.showOpenDialog(this);
			if (opcion == 0){
				if(obtenerExtension(cargar.getSelectedFile()).compareTo(".csv") == 0){
					grafoLocal.cargarDatos(cargar.getSelectedFile().getAbsolutePath());
					JOptionPane.showMessageDialog(ventana,"Los datos han sido cargados exitosamente.","Éxito",JOptionPane.INFORMATION_MESSAGE);
					ventana.dispose();
					VentanaPrincipal nuevaVentana = new VentanaPrincipal(grafoLocal);
				}
				else {
					JOptionPane.showMessageDialog(null, "Tipo de archivo invalido.", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		if (e.getSource() == itemSalir){
			int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro que desea salir?", "Salida", JOptionPane.YES_NO_OPTION);
			if (resp == 0){
				System.exit(0);
			}
		}
		
		if (e.getSource() == itemNuevosDatos){
			ventana.dispose();
			VentanaPrincipal newVentana = new VentanaPrincipal(grafoLocal);
		}
		if (e.getSource() == itemAyuda){
			try {
				MenuAyuda nuevo = new MenuAyuda();
			} catch (IOException e1) {
				JOptionPane.showConfirmDialog(null, "Ocurrióo un problema al inicializar el menu ayuda", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (e.getSource() == itemAcercaDe){
			MenuAcercaDe nuevo = new MenuAcercaDe();
		}
		
	}
	private String obtenerExtension(File file) {
	    String name = file.getName();
	    try {
	        return name.substring(name.lastIndexOf("."));

	    } catch (Exception e) {
	        return "";
	    }
}
}