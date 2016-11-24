package Interfaces;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Permite Mostrar al usuario los detalles del software.
  * @author CAROLINA developers.
 *
 */

public class MenuAcercaDe extends JFrame implements ActionListener {
	private JFrame ventana = new JFrame();
	private JPanel panel1 = new JPanel();
	private JLabel label1;
	private JPanel panelAutores = new JPanel();
	private JPanel panelMails = new JPanel();
	private JLabel label2;
	private JLabel label3;
	private JButton botonAceptar = new JButton("Aceptar");
	private JPanel boton = new JPanel();
	
	
	public MenuAcercaDe() {
		PanelImagen imagen = new PanelImagen("/imagen/Peaje.png");
		ventana.setTitle("Acerca de");
		ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
		String palabra1 = "<html><body>";
		palabra1 += "Fecha de realización: 28 de julio de 2016" + "<br>" + "<br>" + "Versión: 4.3" + "<br>" + "<br>" + "Autores del sistema: " + "<br>";
		label1 = new JLabel(palabra1);
		panel1.add(label1);
		String palabra2 = "<html><body>";
		palabra2 += "Ábrego, Emmanuel" + "<br>" + "Blanco, Matías" + "<br>" + "Nattero, Luciano" + "<br>" + "Príncipe, Matías" + "<br>";
		label2 = new JLabel(palabra2);
		panelAutores.add(label2);
		String palabra3 = "<html><body>";
		palabra3 += "emma_a284@hotmail.com" + "<br>" + "blanco.mati1@gmail.com" + "<br>" + "luchonatter23@gmail.com" + "<br>" + "matiprincipe_10@hotmail.com" + "<br>";
		label3 = new JLabel(palabra3);
		panelMails.add(label3);
		ventana.add(panel1); 
		ventana.add(panelAutores);
		ventana.add(panelMails);
		ventana.add(boton);
		ventana.add(imagen);
		ventana.setSize(500, 350);
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		ventana.setLayout(null);
		ventana.setResizable(false);
		panel1.setOpaque(false);
		panel1.setBounds(50,50,300,500);
		
		panelAutores.setOpaque(false);
		panelAutores.setBounds(100,135,125,105);
		
		panelMails.setOpaque(false);
		panelMails.setBounds(250, 135, 200, 105);
		boton.add(botonAceptar);
		boton.setBounds(200,250,100,35);
		boton.setOpaque(false);
		botonAceptar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e){
		if(e.getSource() == botonAceptar){
			ventana.dispose();
		}
	}

}