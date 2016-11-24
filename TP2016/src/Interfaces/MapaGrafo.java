package Interfaces;

import java.awt.*;
import java.awt.geom.*;

import javax.swing.*;

import Logica.Avenida;
import Logica.Peaje;

import java.util.ArrayList;
import java.util.List;

/**
 * Permite Dibujar el grafo
 * @author CAROLINA developers.
 *
 */
public class MapaGrafo extends JComponent {
    private static final int SIZE = 500;
    private int a = SIZE / 2;
    private int b = a;
    private int r = 4 * SIZE / 5;
    
    private int numeroPeajes;
    private List<Peaje> listaPeajes;
    private int numeroAvenidas;
    private List<Avenida> listaAvenidas;
    private List<Ellipse2D> dibujoPeajes = new ArrayList<Ellipse2D>();    
    private Ellipse2D peajeSeleccionado;
    private List<Avenida> caminosMapa;
    

    public MapaGrafo(List<Peaje> listaPeajes, List<Avenida> listaAvenidas) {
    	this(listaPeajes, listaAvenidas, null);
    }
    

    public MapaGrafo(List<Peaje> listaPeajes, List<Avenida> listaAvenidas, List<Avenida> caminosMapa) {
    	this.setPreferredSize(new Dimension(500, 500));
    	this.listaPeajes = listaPeajes;
        this.numeroPeajes = listaPeajes.size();
        this.listaAvenidas = listaAvenidas;
        this.numeroAvenidas = listaAvenidas.size();
        this.caminosMapa = caminosMapa;
    }
    /**
     * Permite ponerle a las lineas, flechas en las puntas, para identificar el peaje destino y el peaje inicio.
     * @param g2
     * @param tip
     * @param tail
     * @param color
     * @param radio
     */
    private void drawArrowHead(Graphics2D g2, Point tip, Point tail, Color color, int radio)
    {
    	double phi = Math.toRadians(20);
    	int barb = 15;
        g2.setPaint(color);
        double dy = tip.y - tail.y;
        double dx = tip.x - tail.x;
        double theta = Math.atan2(dy, dx);
        double x, y, rho = theta + phi;
        for(int j = 0; j < 2; j++)
        {
            x = tip.x - radio*Math.cos(theta) - barb * Math.cos(rho);
            y = tip.y - radio*Math.sin(theta) - barb * Math.sin(rho);
            g2.draw(new Line2D.Double(tip.x - radio*Math.cos(theta), tip.y - radio*Math.sin(theta), x, y));
            rho = theta - phi;
        }
    }
    protected void paintComponent(Graphics g) {
    	Graphics2D gPeaje = (Graphics2D) g;
        gPeaje.setRenderingHint(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);
        
        a = getWidth() / 2;
        b = getHeight() / 2;
        int m = Math.min(a, b);
        r = 4 * m / 5;
        int r2 = Math.round(Math.abs(m - r) / 2.5f);
        
        int[][] positions = new int[numeroPeajes][3];
        
        List<Peaje> listaPeajeesAux = new ArrayList<Peaje>();
        listaPeajeesAux.addAll(listaPeajes);
        for (int i = 0; i < numeroPeajes; i++) {
        	Peaje peajeActual = listaPeajeesAux.remove(0);
        	String nombre = peajeActual.getNombre();
            double t = 2 * Math.PI * i / numeroPeajes;
            int x = (int) Math.round(a + r * Math.cos(t));
            int y = (int) Math.round(b + r * Math.sin(t));
            Ellipse2D oval = new Ellipse2D.Double(x - r2, y - r2, 2 * r2, 2 * r2);
            
            gPeaje.setStroke(new BasicStroke(3));
            gPeaje.setColor(Color.black);
            gPeaje.draw(oval);
            if(peajeActual.getEsAccesoNorte()){
            	gPeaje.setPaint(new GradientPaint(x, y-r2, Color.red, x, y+r2, Color.red));
            }
            else{
            	if(peajeActual.getEsAccesoSur()){
            		gPeaje.setPaint(new GradientPaint(x, y-r2, Color.blue, x, y+r2, Color.blue));
            	}
            	else{
            		gPeaje.setPaint(new GradientPaint(x, y-r2, Color.yellow, x, y+r2, Color.yellow));
            }
            }
            gPeaje.fill(oval);
            
            gPeaje.setColor(Color.black);
            gPeaje.drawString(nombre, x-r2/3, y+r2/4);
            
            positions[i][0]=Integer.parseInt(nombre.replace("p",""));
            positions[i][1]=x;
            positions[i][2]=y;
            
            dibujoPeajes.add(oval);
        }
        
        List<Avenida> listaAvenidasAux = new ArrayList<Avenida>();
        listaAvenidasAux.addAll(listaAvenidas);
        
        for (int j = 0; j < numeroAvenidas; j++) {

        	Avenida tramoActual = listaAvenidasAux.get(j);
        	int Peaje1 = Integer.parseInt(tramoActual.getPeajeEntrada().getNombre().replace("p",""));
        	int Peaje2 = Integer.parseInt(tramoActual.getPeajeSalida().getNombre().replace("p",""));
        	int fila1 = 0, fila2 = 0, x1,x2,y1,y2;

        	for (int l = 0; l < numeroPeajes; l++){
        		if (Peaje1 == positions[l][0]){
        			fila1 = l;
        		}
        		if (Peaje2 == positions[l][0]){
        			fila2 = l;
        		}
        	}
        			
            x1 = positions[fila1][1];
            y1 = positions[fila1][2];
            x2 = positions[fila2][1];
            y2 = positions[fila2][2];
            
            Point xy1 = new Point(x1,y1);
            Point xy2 = new Point(x2,y2);
            
            double dy = xy1.y - xy2.y;
            double dx = xy1.x - xy2.x;
            double theta = Math.atan2(dy, dx);    
            
            gPeaje.setStroke(new BasicStroke(0.5f, BasicStroke.CAP_BUTT,
								BasicStroke.JOIN_MITER, 15.0f, new float[]{15.0f}, 0.0f));
        	gPeaje.setColor(Color.BLACK);
            if(tramoActual.getEstado()){  
            	gPeaje.setStroke(new BasicStroke(0.5f));
            	
            	drawArrowHead(gPeaje, xy2, xy1, Color.black, r2);
            }
          
            Line2D linea = new Line2D.Double(
            		xy1.x - r2*Math.cos(theta),
            		xy1.y - r2*Math.sin(theta),
            		xy2.x + r2*Math.cos(theta),
                    xy2.y + r2*Math.sin(theta));
            		gPeaje.draw(linea);

        }
        }
        
    public List<Ellipse2D> getDibujosPeajes(){
    	return dibujoPeajes;
    }
    public Ellipse2D getpeajeSeleccionado(){
    	return peajeSeleccionado;
    }
    public void setPeajeSeleccionada(Ellipse2D peajeSeleccionada){
    	this.peajeSeleccionado = peajeSeleccionada;
    }
    
}