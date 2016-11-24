package Interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
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
 * Permite abrir la ventana en la cual el usuario podrá crear una nueva Avenida.
  * @author CAROLINA developers.
 *
 */
public class AñadirTramo extends JFrame implements ActionListener{
	private JFrame ventana = new JFrame();
	private JPanel panelPeajeSalida = new JPanel();
	private JPanel panelPeajeLlegada = new JPanel();
	private JPanel panelOpcionesAvenida = new JPanel();
	private JPanel panelEstado = new JPanel();
	private JLabel nombrePeaje1 = new JLabel();
	private JComboBox <String> peajes1 = new JComboBox();
	private JLabel nombrePeaje2 = new JLabel();
	private JComboBox <String> peajes2 = new JComboBox();
	private JPanel panelBotones = new JPanel();
	private PanelImagen imagen = new PanelImagen("/imagen/Peaje.png");
	private JButton aceptar = new JButton();
	private JButton cancelar = new JButton();
	private JLabel capacidadLabel = new JLabel("Capacidad: ");
	private JTextField capacidad = new JTextField(3);
	private JLabel longituLabel = new JLabel("Longitud: ");
	private JTextField longitud = new JTextField(4);
	private JLabel estadoLabel = new JLabel("Estado: ");
	private JComboBox <String> estado = new JComboBox();
	Grafo localGrafo;
	
	public AñadirTramo(Grafo grafo){
		
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		localGrafo = grafo;
		ventana.setTitle("Añadir Nueva Avenida");
		nombrePeaje1.setText("Elija un peaje de salida: ");
		nombrePeaje2.setText("Elija un peaje de llegada: ");
		panelPeajeSalida.add(nombrePeaje1);
		panelPeajeSalida.add(peajes1);
		panelPeajeLlegada.add(nombrePeaje2);
		panelPeajeLlegada.add(peajes2);
		panelOpcionesAvenida.add(capacidadLabel);
		panelOpcionesAvenida.add(capacidad);
		panelOpcionesAvenida.add(longituLabel);
		panelOpcionesAvenida.add(longitud);
		panelEstado.add(estadoLabel);
		panelEstado.add(estado);
		aceptar.setText("Aceptar");
		cancelar.setText("Cancelar");
		panelBotones.add(aceptar);
		panelBotones.add(cancelar);
		peajes1.addItem("Seleccione uno");
		peajes2.addItem("Seleccione uno");
		estado.addItem("Seleccione uno");
		estado.addItem("Habilitada");
		estado.addItem("Deshabilitada");
		agregarPeajesVista(peajes1, peajes2);
		

		
		
		ventana.add(panelPeajeSalida);
		ventana.add(panelPeajeLlegada);
		ventana.add(panelBotones);
		ventana.add(panelOpcionesAvenida);
		ventana.add(panelEstado);
		ventana.setSize(860, 500);
		ventana.add(imagen);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		ventana.setLayout(null);
		ventana.setResizable(false);
		panelPeajeSalida.setOpaque(false);
		panelPeajeLlegada.setOpaque(false);
		panelBotones.setOpaque(false);
		panelOpcionesAvenida.setOpaque(false);
		panelEstado.setOpaque(false);
		panelPeajeSalida.setBounds(100,100,350,35);
		panelPeajeLlegada.setBounds(400,100,350,35);
		panelOpcionesAvenida.setBounds(250,150,350,35);
		panelEstado.setBounds(250,200,350,35);
		panelBotones.setBounds(500,400,200,35);
		aceptar.addActionListener(this);
		cancelar.addActionListener(this);	
		
	}

	public void agregarPeajesVista(JComboBox<String> peajes12, JComboBox<String> peajes22) {
		List<Peaje> lista = localGrafo.getListaPeajes();
		for (Peaje p : lista){
			peajes12.addItem(p.getNombre());
			peajes22.addItem(p.getNombre());
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == cancelar){
			ventana.dispose();
			VentanaPrincipal nuevaVentana = new VentanaPrincipal(localGrafo);
		}
		if(e.getSource() == aceptar){
			String newsalida = (String)peajes1.getSelectedItem();
			String newentrada = (String)peajes2.getSelectedItem();
			String newCapacidad = capacidad.getText();
			String newLongitud = longitud.getText();
			boolean estadoFinal = false;
			int longitudInt = 0, capacidadInt=0;
			boolean error = false;
			String textoError = "";
			if (newsalida.equals("Seleccione uno")){
				error = true;
				textoError += "Debe Ingresar ambos peajes ";
			}
			else{
			if(newentrada.equals("Seleccione uno")){
				error = true;
				textoError += "Debe Ingresar ambos peajes ";
			}
			else{
				if (newsalida.equals(newentrada)){
					error = true;
					textoError += "Debe ingresar dos peajes distintos.";
				}
			}
			}
			if (newCapacidad.equals("")){
				error = true;
				textoError += " Debe Ingresar una capacidad ";
			}
			else{
				try{
				capacidadInt = Integer.parseInt(capacidad.getText());
			}
				catch (NumberFormatException eC){
					error = true;
					textoError += "Debe ingresar una capacidad valida ";
				}
			}
			if (newLongitud.equals("")){
				error = true;
				textoError += "Debe Ingresar una longitud ";
			}
			else{
				try{
					longitudInt = Integer.parseInt(longitud.getText());
				}
				catch (NumberFormatException eN){
					error = true;
					textoError += "Debe Ingresar una longitud valida ";
				}
			}
			String newEstado = (String) estado.getSelectedItem();
			if (longitudInt <0){
				error = true;
				textoError += "Debe Ingresar una longitud valida ";
			}
			if (capacidadInt <0){
				error = true;
				textoError += "Debe Ingresar una capacidad valida ";
			}
 			if (newEstado.equals("Habilitada")){
				estadoFinal = true;
			}
			else{
				if (newEstado.equals("Deshabilitada")){
					estadoFinal = false;
				}
				else{
					error = true;
					textoError += "Debe Ingresar un Estado ";
				}
			}
 			if (!error){
 				localGrafo.añadirTramo(newsalida, newentrada, capacidadInt, longitudInt,estadoFinal);
 				JOptionPane.showMessageDialog(null, "Operacion Realizada con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
 				ventana.dispose();
 				VentanaPrincipal newVentana = new VentanaPrincipal(localGrafo);
			}
 			else{
 				JOptionPane.showMessageDialog(null, textoError, "Error", JOptionPane.ERROR_MESSAGE);
 			}
		}
	}
	
}
