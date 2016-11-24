package Interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginConsultor {

	private JFrame frame;
	private JTextField campo1;
	private JPasswordField campo2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginConsultor window = new LoginConsultor();
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
	public LoginConsultor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Arial", Font.BOLD, 14));
		frame.setBounds(100, 100, 550, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel texto1 = new JLabel("Ingrese los siguientes datos:");
		texto1.setFont(new Font("Arial", Font.BOLD, 14));
		texto1.setBounds(41, 41, 204, 14);
		frame.getContentPane().add(texto1);
		
		JLabel texto2 = new JLabel("Nombre de usuario:");
		texto2.setFont(new Font("Arial", Font.BOLD, 14));
		texto2.setBounds(93, 114, 138, 14);
		frame.getContentPane().add(texto2);
		
		JLabel texto3 = new JLabel("Contrase\u00F1a:");
		texto3.setFont(new Font("Arial", Font.BOLD, 14));
		texto3.setBounds(93, 169, 89, 14);
		frame.getContentPane().add(texto3);
		
		campo1 = new JTextField();
		campo1.setFont(new Font("Arial", Font.BOLD, 14));
		campo1.setBounds(242, 111, 180, 20);
		frame.getContentPane().add(campo1);
		campo1.setColumns(10);
		
		campo2 = new JPasswordField();
		campo2.setFont(new Font("Arial", Font.BOLD, 14));
		campo2.setColumns(10);
		campo2.setBounds(242, 166, 180, 20);
		frame.getContentPane().add(campo2);
		
		JButton volver = new JButton("Volver");
		volver.setFont(new Font("Arial", Font.BOLD, 14));
		volver.setBounds(10, 327, 89, 23);
		frame.getContentPane().add(volver);
		
		JButton salir = new JButton("Salir");
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		salir.setFont(new Font("Arial", Font.BOLD, 14));
		salir.setBounds(435, 327, 89, 23);
		frame.getContentPane().add(salir);
		
		JButton siguiente = new JButton("Siguiente");
		siguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		siguiente.setFont(new Font("Arial", Font.BOLD, 14));
		siguiente.setBounds(320, 327, 105, 23);
		frame.getContentPane().add(siguiente);
	}
}
