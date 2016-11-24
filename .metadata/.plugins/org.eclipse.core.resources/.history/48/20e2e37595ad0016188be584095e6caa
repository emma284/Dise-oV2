package Interfaces;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Window.Type;
import javax.swing.ButtonGroup;

public class MenuPrincipal {

	private JFrame frmCapitlHumano;
	private final JPanel panel = new JPanel();
	private final JButton siguiente = new JButton("Siguiente");
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal window = new MenuPrincipal();
					window.frmCapitlHumano.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MenuPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCapitlHumano = new JFrame();
		frmCapitlHumano.setTitle("Capit@l Humano");
		frmCapitlHumano.setBounds(100, 100, 550, 400);
		frmCapitlHumano.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCapitlHumano.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel texto1 = new JLabel("Bienvenido al sistema Capit@l Humano");
		texto1.setFont(new Font("Arial", Font.BOLD, 14));
		texto1.setBounds(54, 37, 274, 18);
		texto1.setHorizontalAlignment(SwingConstants.LEFT);
		texto1.setVerticalAlignment(SwingConstants.TOP);
		panel.add(texto1);
		
		JLabel label = new JLabel("\u00BFQu\u00E9 acci\u00F3n desea realizar?");
		label.setFont(new Font("Arial", Font.BOLD, 14));
		label.setBounds(54, 80, 206, 14);
		label.setVerticalAlignment(SwingConstants.BOTTOM);
		panel.add(label);
		
		JRadioButton opcion1 = new JRadioButton("Ingresar como usuario consultor.");
		buttonGroup.add(opcion1);
		opcion1.setFont(new Font("Arial", Font.BOLD, 14));
		opcion1.setBounds(124, 145, 259, 23);
		panel.add(opcion1);
		
		JRadioButton opcion2 = new JRadioButton("Realizar cuestionario.");
		buttonGroup.add(opcion2);
		opcion2.setFont(new Font("Arial", Font.BOLD, 14));
		opcion2.setBounds(124, 199, 177, 23);
		opcion2.setEnabled(false);
		panel.add(opcion2);
		siguiente.setFont(new Font("Arial", Font.BOLD, 14));
		siguiente.setBounds(318, 327, 105, 23);
		siguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel.add(siguiente);
		
		JButton salir = new JButton("Salir");
		salir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		salir.setFont(new Font("Arial", Font.BOLD, 14));
		salir.setBounds(433, 327, 91, 23);
		panel.add(salir);
	}

}
