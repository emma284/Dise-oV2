package Interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.JList;

public class AltaPuesto {

	private JFrame frame;
	private JTextField campo1;
	private JTextField campo2;
	private JTextField campo3;
	private JTextField campo4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaPuesto window = new AltaPuesto();
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
	public AltaPuesto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel texto1 = new JLabel("Alta Puesto");
		texto1.setFont(new Font("Arial", Font.BOLD, 14));
		texto1.setBounds(10, 30, 86, 14);
		frame.getContentPane().add(texto1);
		
		JLabel texto2 = new JLabel("C\u00F3digo:");
		texto2.setFont(new Font("Arial", Font.BOLD, 14));
		texto2.setBounds(10, 65, 54, 14);
		frame.getContentPane().add(texto2);
		
		JLabel texto3 = new JLabel("Nombre del Puesto:");
		texto3.setFont(new Font("Arial", Font.BOLD, 14));
		texto3.setBounds(10, 100, 138, 14);
		frame.getContentPane().add(texto3);
		
		JLabel texto4 = new JLabel("Descripci\u00F3n:");
		texto4.setFont(new Font("Arial", Font.BOLD, 14));
		texto4.setBounds(10, 138, 95, 14);
		frame.getContentPane().add(texto4);
		
		JLabel texto5 = new JLabel("Empresa:");
		texto5.setFont(new Font("Arial", Font.BOLD, 14));
		texto5.setBounds(10, 170, 65, 14);
		frame.getContentPane().add(texto5);
		
		JLabel texto6 = new JLabel("Caracter\u00EDsticas del Puesto:");
		texto6.setFont(new Font("Arial", Font.BOLD, 14));
		texto6.setBounds(10, 205, 188, 14);
		frame.getContentPane().add(texto6);
		
		JLabel texto7 = new JLabel("* (Campos obligatorios)");
		texto7.setFont(new Font("Arial", Font.BOLD, 14));
		texto7.setBounds(10, 278, 163, 14);
		frame.getContentPane().add(texto7);
		
		JLabel texto8 = new JLabel("*");
		texto8.setFont(new Font("Arial", Font.BOLD, 14));
		texto8.setBounds(410, 100, 46, 14);
		frame.getContentPane().add(texto8);
		
		JLabel texto9 = new JLabel("*");
		texto9.setFont(new Font("Arial", Font.BOLD, 14));
		texto9.setBounds(410, 135, 46, 14);
		frame.getContentPane().add(texto9);
		
		JLabel texto10 = new JLabel("*");
		texto10.setFont(new Font("Arial", Font.BOLD, 14));
		texto10.setBounds(410, 65, 46, 14);
		frame.getContentPane().add(texto10);
		
		JLabel texto11 = new JLabel("*");
		texto11.setFont(new Font("Arial", Font.BOLD, 14));
		texto11.setBounds(410, 170, 46, 14);
		frame.getContentPane().add(texto11);
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.setFont(new Font("Arial", Font.BOLD, 14));
		cancelar.setBounds(679, 527, 95, 23);
		frame.getContentPane().add(cancelar);
		
		JButton aceptar = new JButton("Aceptar");
		aceptar.setFont(new Font("Arial", Font.BOLD, 14));
		aceptar.setBounds(580, 527, 89, 23);
		frame.getContentPane().add(aceptar);
		
		campo1 = new JTextField();
		campo1.setFont(new Font("Arial", Font.BOLD, 14));
		campo1.setBounds(205, 65, 188, 20);
		frame.getContentPane().add(campo1);
		campo1.setColumns(10);
		
		campo2 = new JTextField();
		campo2.setFont(new Font("Arial", Font.BOLD, 14));
		campo2.setBounds(205, 100, 188, 20);
		frame.getContentPane().add(campo2);
		campo2.setColumns(10);
		
		campo3 = new JTextField();
		campo3.setFont(new Font("Arial", Font.BOLD, 14));
		campo3.setBounds(205, 135, 188, 20);
		frame.getContentPane().add(campo3);
		campo3.setColumns(10);
		
		campo4 = new JTextField();
		campo4.setFont(new Font("Arial", Font.BOLD, 14));
		campo4.setBounds(205, 170, 188, 20);
		frame.getContentPane().add(campo4);
		campo4.setColumns(10);
	}
}
