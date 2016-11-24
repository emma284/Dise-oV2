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
 * Abre la ventana para que el usuario pueda modificar un punto específico del sistema.
 * @author CAROLINA developers.
 *
 */
public class ModificarPunto extends JFrame implements ActionListener{
	private JFrame ventana = new JFrame();
	private JPanel panelNombrePeaje = new JPanel();
	private JLabel nombreLabel = new JLabel("Nombre del Peaje: ");
	private JComboBox <String> nombre = new JComboBox();
	private JPanel panelCostoPeaje = new JPanel();
	private JLabel costoLabel = new JLabel("Costo del Peaje: ");
	private JTextField costo = new JTextField(3);
	private JPanel panelBotones = new JPanel();
	private JPanel panelAcceso = new JPanel();
	private JComboBox <String> acceso = new JComboBox();
	private JButton aceptar = new JButton("Aceptar");
	private JButton cancelar = new JButton("Cancelar");
	private PanelImagen imagen = new PanelImagen("/imagen/Peaje.png");
	private Grafo grafoLocal;
	
	public ModificarPunto(Grafo grafo){
		grafoLocal = grafo;
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setTitle("Añadir un nuevo Peaje");
		panelNombrePeaje.add(nombreLabel);
		panelNombrePeaje.add(nombre);
		panelCostoPeaje.add(costoLabel);
		panelCostoPeaje.add(costo);
		panelBotones.add(aceptar);
		panelBotones.add(cancelar);
		panelAcceso.add(acceso);
		agregarPeajesVista(nombre);
		
		acceso.addItem("Seleccione uno");
		acceso.addItem("Acceso Norte");
		acceso.addItem("Acceso Sur");
		acceso.addItem("Interno");
		ventana.add(panelNombrePeaje);
		ventana.add(panelCostoPeaje);
		ventana.add(panelAcceso);
		ventana.add(panelBotones);
		ventana.add(imagen);
		ventana.setSize(600, 500);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		ventana.setLayout(null);
		ventana.setResizable(false);
		panelNombrePeaje.setOpaque(false);
		panelCostoPeaje.setOpaque(false);
		panelBotones.setOpaque(false);
		panelAcceso.setOpaque(false);
		panelNombrePeaje.setBounds(100,100,350,35);
		panelCostoPeaje.setBounds(100,150,350,35);
		panelAcceso.setBounds(150,200,350,35);
		panelBotones.setBounds(300,300,350,35);
		cancelar.addActionListener(this);
		aceptar.addActionListener(this);
		
		
		
	}
	public void agregarPeajesVista(JComboBox<String> peajes) {
		List<Peaje> lista = grafoLocal.getListaPeajes();
		for (Peaje p : lista){
			peajes.addItem(p.getNombre());
		}
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cancelar){
			ventana.dispose();
			VentanaPrincipal nuevaVentana = new VentanaPrincipal(grafoLocal);
		}
		if (e.getSource() == aceptar){
			String peaje = (String)nombre.getSelectedItem();
			String textoError = "";
			boolean error = false;
			if (peaje.equals("")){
				error = true;
				textoError += "Nombre Requerido ";
				
			}
			int costoFinal = 0;
			try{
				costoFinal = Integer.parseInt(costo.getText());
			} catch (NumberFormatException e1){
				error = true;
				textoError += "Numero invalido ";
			}
			boolean esNorte = false, esSur = false;
			if (acceso.getSelectedItem().equals("Acceso Sur")){
				esSur = true;
			}
			else {
				if (acceso.getSelectedItem().equals("Acceso Norte")){
					esNorte = true;
				}
				else{
					if (acceso.getSelectedItem().equals("Seleccione uno")){
						error = true;
						textoError += "Debe seleccionar un acceso ";
					}
				}
			}
			if (!error){
				grafoLocal.modificarPunto(peaje, costoFinal, esNorte,esSur);
				JOptionPane.showMessageDialog(null, "Operacion realizada con éxito", "Éxito", JOptionPane.INFORMATION_MESSAGE);
				ventana.dispose();
				VentanaPrincipal newVentan = new VentanaPrincipal(grafoLocal);
		}
			else{
				JOptionPane.showMessageDialog(null, textoError, "Error", JOptionPane.ERROR_MESSAGE);
				
			}
		}
		
	}
	
	

}
