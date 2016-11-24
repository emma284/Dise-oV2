package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Vector;

import com.sun.javafx.collections.MappingChange.Map;

import Logica.gestorCompetencias;
import Logica.gestorPuestos;

public class gestorCaracteristicas {

public Vector<Caracteristica> cargarCaracteristicas(){
		
		Vector<Caracteristica> salida= new Vector<Caracteristica>();
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/dbgrupo6b", "root", "grupo6b");
        Statement st = conexion.createStatement();
        
        ResultSet rs = st.executeQuery("SELECT * FROM Caracteristica;");
        
        if (rs != null) {
           

            while (rs.next()) {
            	
            	String competencia= (String) rs.getObject("id_competencia");
            	String codigo= (String) rs.getObject("codigo");
            	Integer ponderacion= (Integer) rs.getObject("ponderacion");
            	
            	gestorCompetencias gc= new gestorCompetencias();
            	gestorPuestos gp= new gestorPuestos();
            	
            	Competencia comp = gc.competenciaNombre(competencia);
            	Puesto p= gp.getPuesto(codigo);
            	
            	
            	Caracteristica c= new Caracteristica(comp,p,ponderacion);
            	
            	salida.add(c);
             
            }
            rs.close();
        }
        st.close();
        
        
        return salida;
		}
		catch(SQLException s)
        {
            System.out.println("Error: SQL.");
            System.out.println("SQLException: " + s.getMessage());
        }
        catch(Exception s)
        {
            System.out.println("Error: Varios.");
            System.out.println("SQLException: " + s.getMessage());
        }
		return null;
	}

}
