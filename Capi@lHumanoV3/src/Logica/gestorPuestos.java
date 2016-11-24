package Logica;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import Logica.Puesto;

public class gestorPuestos {


	public Vector<Puesto> cargarPuestos(){
		
		Vector<Puesto> salida= new Vector<Puesto>();
		
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/dbgrupo6b", "root", "grupo6b");
        Statement st = conexion.createStatement();
        
        ResultSet rs = st.executeQuery("SELECT * FROM Puesto;");
        
        if (rs != null) {
           

            while (rs.next()) {
            	
            	String codigo= (String) rs.getObject("codigo");
            	String nombre= (String) rs.getObject("nombre");
            	String empresa= (String) rs.getObject("empresa");
            	String descripcion= (String) rs.getObject("descripcion");
            	
            	Puesto p= new Puesto(codigo,nombre,empresa,descripcion);
            	
            	salida.add(p);
             
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
	
	public void agregarPuestoABase(Puesto p){
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/dbgrupo6b", "root", "grupo6b");
	        Statement st = conexion.createStatement();
	        
	        st.executeUpdate("INSERT INTO Puesto (codigo, nombre, descripcion, empresa) VALUES (\""+p.getCodigo()+"\", \""+p.getNombre()+"\", \""+p.getDescripcion()+"\", \""+p.getEmpresa()+"\");");
	        st.close();
	        
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
		
	}

	public Puesto getPuesto(String pu){
		for(Puesto puestos : cargarPuestos()){
			if(puestos.getCodigo()==pu){
				return puestos;
			}
		}
		return null;
	}
	
	public Boolean codigoExistente(String cod){
		
		Vector <Puesto> puestos=this.cargarPuestos();
		
		for(Puesto p : puestos)
			if((((String)p.getCodigo()).equals(cod)))
				return false;
				
		return true;
	}
	
	public Boolean nombreExistente(String nomb){
	
	Vector <Puesto> puestos=this.cargarPuestos();
		
	for(Puesto p : puestos)
		if((((String)p.getNombre()).equals(nomb)))
			return false;
			
	return true;
	}

}

