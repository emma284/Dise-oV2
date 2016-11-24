package Interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Logica.Grafo;
/**
 * Permite inicializar la ventana para añadir un punto
 * @author CAROLINA developers.
 *
 */
public class AñadirPunto extends JFrame implements ActionListener{
	private JFrame ventana = new JFrame();
	private JPanel panelNombrePeaje = new JPanel();
	private JLabel nombreLabel = new JLabel("Nombre del Peaje: ");
	private JTextField nombre = new JTextField(10);
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
	

	public AñadirPunto(Grafo grafo){
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
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == cancelar){
			ventana.dispose();
			VentanaPrincipal nuevaVentana = new VentanaPrincipal(grafoLocal);
		}
		if (e.getSource() == aceptar){
			String nombreFinal = nombre.getText();
			String textoError = "";
			boolean error = false;
			try{
				if (nombreFinal.charAt(0)!= 'p'){
					error = true;
					textoError += "El nombre debe empezar con la letra \"p\" seguido de un numero entero. ";
				}
				else{
					int contadorP = 1;
					for(int i = 1; i<nombreFinal.length(); i++){
						if(nombreFinal.charAt(i) == 'p'){
							contadorP ++;
						}
					}
					if (contadorP > 1){
						error = true;
						textoError += "El nombre debe empezar con una única letra \"p\" seguido de un numero entero. ";
					}
					int prueba = Integer.parseInt(nombreFinal.replace("p",""));
				}
			}
			catch(NumberFormatException nfe){
				error = true;
				textoError += "El nombre debe empezar con la letra \"p\" seguido de un numero entero. ";
				}
			catch(StringIndexOutOfBoundsException siobe){
					error = true;
					textoError += "Nombre Requerido. ";
			}
			int costoFinal = 0;
			try{
				costoFinal = Integer.parseInt(costo.getText());
			} catch (NumberFormatException e1){
				error = true;
				textoError += "Costo invalido. ";
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
						textoError += "Debe seleccionar un acceso. ";
					}
				}
			}
			if (!error){
			grafoLocal.añadirPunto(nombreFinal, costoFinal, esNorte,esSur);
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
