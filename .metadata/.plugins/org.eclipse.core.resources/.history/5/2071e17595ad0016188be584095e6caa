package Interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GestionDePuestos {

	private JFrame frame;
	private JTextField campo1;
	private JTextField campo2;
	private JTextField campo3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestionDePuestos window = new GestionDePuestos();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GestionDePuestos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel texto1 = new JLabel("Complete al menos uno de los campos de b\u00FAsqueda.");
		texto1.setBounds(36, 22, 250, 14);
		frame.getContentPane().add(texto1);
		
		JLabel texto2 = new JLabel("C\u00F3digo:");
		texto2.setBounds(36, 62, 46, 14);
		frame.getContentPane().add(texto2);
		
		JLabel texto3 = new JLabel("Nombre de Puesto:");
		texto3.setBounds(36, 104, 88, 14);
		frame.getContentPane().add(texto3);
		
		JLabel texto4 = new JLabel("Empresa:");
		texto4.setBounds(36, 155, 46, 14);
		frame.getContentPane().add(texto4);
		
		campo1 = new JTextField();
		campo1.setBounds(200, 59, 148, 20);
		frame.getContentPane().add(campo1);
		campo1.setColumns(10);
		
		campo2 = new JTextField();
		campo2.setColumns(10);
		campo2.setBounds(200, 101, 148, 20);
		frame.getContentPane().add(campo2);
		
		campo3 = new JTextField();
		campo3.setColumns(10);
		campo3.setBounds(200, 152, 148, 20);
		frame.getContentPane().add(campo3);
		
		JButton nuevo = new JButton("Nuevo");
		nuevo.setBounds(155, 216, 89, 23);
		frame.getContentPane().add(nuevo);
		
		JButton modificar = new JButton("Modificar");
		modificar.setBounds(259, 216, 89, 23);
		frame.getContentPane().add(modificar);
		
		JButton eliminar = new JButton("Eliminar");
		eliminar.setBounds(358, 216, 89, 23);
		frame.getContentPane().add(eliminar);
		
		JButton volver = new JButton("Volver");
		volver.setBounds(10, 427, 89, 23);
		frame.getContentPane().add(volver);
		
		JButton salir = new JButton("Salir");
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		salir.setBounds(435, 427, 89, 23);
		frame.getContentPane().add(salir);
		
		JButton buscar = new JButton("Buscar");
		buscar.setBounds(336, 427, 89, 23);
		frame.getContentPane().add(buscar);
	}
}
