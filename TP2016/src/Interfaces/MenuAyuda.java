package Interfaces;
import java.awt.Component;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.*;

import Logica.Grafo;
import javafx.scene.control.ScrollBar;
import javafx.stage.FileChooser;
 /**
  * Brinda un espacio de ayuda en los aspectos mas importantes del sistema al usuario.
  * @author CAROLINA developers.
  *
  */
public class MenuAyuda extends JFrame implements ActionListener{
	private JFrame ventana = new JFrame();
	private PanelImagen imagen = new PanelImagen("/imagen/Peaje.png");
	private JButton volver = new JButton("volver");
	private JPanel panelVolver = new JPanel();
	private JPanel panelAyuda = new JPanel();

	
	public MenuAyuda() throws IOException{
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setTitle("Ayuda");
 
        JTabbedPane pestañas=new JTabbedPane();
        
        //Componente panel 1
        JPanel panel1 = new JPanel();
        File ficheroDestino1 = new File("Nuevo");
        InputStream inputStream1 = getClass().getResource("/texto/ayudaFuncionPrincipal.txt").openStream();			
        OutputStream outputStream1 = new FileOutputStream(ficheroDestino1);
        byte[] b1 = new byte[2048];
        int longitud1;
        while ((longitud1 = inputStream1.read(b1)) != -1) {
           outputStream1.write(b1, 0, longitud1);
        }
        inputStream1.close();
        outputStream1.close();
        FileReader fr1 = new FileReader(ficheroDestino1);
        BufferedReader br1 = new BufferedReader(fr1);
        String linea1 = "";
        int numero1 = 1;
        String palabra1= "<html><body>";
        while((linea1 = br1.readLine()) != null){
        	palabra1 += linea1 + "<br>";
        }
        palabra1 += "</body></html>";
        JLabel ayuda1 = new JLabel(palabra1);
        panel1.add(ayuda1);
        fr1.close();
        pestañas.addTab("Función Principal", panel1);
        
        //Componentes Panel 2
        JPanel panel2=new JPanel();
        File ficheroDestino2 = new File("Nuevo");
        InputStream inputStream2 = getClass().getResource("/texto/cargaDeDatos.txt").openStream();			
        OutputStream outputStream2 = new FileOutputStream(ficheroDestino2);
        byte[] b2 = new byte[2048];
        int longitud2;
        while ((longitud2 = inputStream2.read(b2)) != -1) {
           outputStream2.write(b2, 0, longitud2);
        }
        inputStream2.close();
        outputStream2.close();
        FileReader fr = new FileReader(ficheroDestino2);
        BufferedReader br = new BufferedReader(fr);
        String linea = "";
        int numero = 1;
        String palabra= "<html><body>";
        while((linea = br.readLine()) != null){
        	palabra += linea + "<br>";
        }
        palabra += "</body></html>";
        JLabel ayuda = new JLabel(palabra);
        panel2.add(ayuda);
        fr.close();
        pestañas.addTab("Carga de Datos", panel2);
        
        //Componentes del panel3
        JPanel panel3=new JPanel();
        File ficheroDestino3 = new File("Nuevo");
        InputStream inputStream3 = getClass().getResource("/texto/ayudaConsultas.txt").openStream();			
        OutputStream outputStream3 = new FileOutputStream(ficheroDestino3);
        byte[] b3 = new byte[2048];
        int longitud3;
        while ((longitud3 = inputStream3.read(b3)) != -1) {
           outputStream3.write(b3, 0, longitud3);
        }
        inputStream3.close();
        outputStream3.close();
        FileReader fr3 = new FileReader(ficheroDestino3);
        BufferedReader br3 = new BufferedReader(fr3);
        String linea3 = "";
        int numero3 = 1;
        String palabra3= "<html><body>";
        while((linea3 = br3.readLine()) != null){
        	palabra3 += linea3 + "<br>";
        }
        palabra3 += "</body></html>";
        JLabel ayuda3 = new JLabel(palabra3);
        panel3.add(ayuda3);
        fr3.close();
        pestañas.addTab("Consultas", panel3);
        
        

        panelAyuda.add(pestañas);
        panelAyuda.add(imagen);
        panelVolver.add(volver);
        JScrollPane barraPanel = new JScrollPane(panelAyuda);
        ventana.add(volver);
        ventana.add(barraPanel);
        ventana.add(imagen);
	    ventana.setSize(1000, 700);
	    ventana.setLocationRelativeTo(null);
	    ventana.setVisible(true);
	    ventana.setResizable(false);
	    barraPanel.setBounds(10,10,800,650);
	    volver.setBounds(850, 620, 100, 35);
	    volver.addActionListener(this);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == volver){
			ventana.dispose();
				
			}
		}
	}