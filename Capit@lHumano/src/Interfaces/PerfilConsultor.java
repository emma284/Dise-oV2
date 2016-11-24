package Interfaces;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

public class PerfilConsultor {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PerfilConsultor window = new PerfilConsultor();
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
	public PerfilConsultor() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton volver = new JButton("Volver");
		volver.setFont(new Font("Arial", Font.BOLD, 14));
		volver.setBounds(10, 327, 89, 23);
		frame.getContentPane().add(volver);
		
		JButton siguiente = new JButton("Siguiente");
		siguiente.setFont(new Font("Arial", Font.BOLD, 14));
		siguiente.setBounds(320, 327, 105, 23);
		frame.getContentPane().add(siguiente);
		
		JButton salir = new JButton("Salir");
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		salir.setFont(new Font("Arial", Font.BOLD, 14));
		salir.setBounds(435, 327, 89, 23);
		frame.getContentPane().add(salir);
		
		JLabel texto1 = new JLabel("Bienvenido, \u00BFqu\u00E9 acci\u00F3n desea realizar?");
		texto1.setFont(new Font("Arial", Font.BOLD, 14));
		texto1.setBounds(53, 25, 287, 14);
		frame.getContentPane().add(texto1);
		
		JRadioButton opcion1 = new JRadioButton("Gestionar Puestos");
		buttonGroup.add(opcion1);
		opcion1.setFont(new Font("Arial", Font.BOLD, 14));
		opcion1.setBounds(53, 58, 155, 23);
		frame.getContentPane().add(opcion1);
		
		JRadioButton opcion2 = new JRadioButton("Gestionar Competencias");
		buttonGroup.add(opcion2);
		opcion2.setFont(new Font("Arial", Font.BOLD, 14));
		opcion2.setBounds(53, 93, 199, 23);
		frame.getContentPane().add(opcion2);
		
		JRadioButton opcion3 = new JRadioButton("Gestionar Factores");
		buttonGroup.add(opcion3);
		opcion3.setFont(new Font("Arial", Font.BOLD, 14));
		opcion3.setBounds(53, 128, 161, 23);
		frame.getContentPane().add(opcion3);
		
		JRadioButton opcion4 = new JRadioButton("Gestionar Preguntas");
		buttonGroup.add(opcion4);
		opcion4.setFont(new Font("Arial", Font.BOLD, 14));
		opcion4.setBounds(53, 163, 171, 23);
		frame.getContentPane().add(opcion4);
		
		JRadioButton opcion5 = new JRadioButton("Gestionar Opciones de Respuesta");
		buttonGroup.add(opcion5);
		opcion5.setFont(new Font("Arial", Font.BOLD, 14));
		opcion5.setBounds(53, 198, 267, 23);
		frame.getContentPane().add(opcion5);
		
		JRadioButton opcion6 = new JRadioButton("Evaluar Candidatos");
		buttonGroup.add(opcion6);
		opcion6.setFont(new Font("Arial", Font.BOLD, 14));
		opcion6.setBounds(53, 233, 161, 23);
		frame.getContentPane().add(opcion6);
		
		JRadioButton opcion7 = new JRadioButton("Emitir Orden de M\u00E9rito");
		buttonGroup.add(opcion7);
		opcion7.setFont(new Font("Arial", Font.BOLD, 14));
		opcion7.setBounds(53, 268, 185, 23);
		frame.getContentPane().add(opcion7);
		
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
