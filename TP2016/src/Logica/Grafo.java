package Logica;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JOptionPane;
/**
 * Permite manejar la red de Peajes y Avenidas
 * Los set y get obtienen los datos própios de Grafo.
 * @author CAROLINA developers.
 *
 */
public class Grafo {
	
	List<Peaje> listaPeajes;
	List<Avenida> listaAvenidas;
	
	public Grafo(){
		this.listaAvenidas = new ArrayList();
		this.listaPeajes = new ArrayList();
	}
	/**
     * Añade nuevos Peajes al sistema
     * @param nombre nobre del peaje
     * @param costo costo del peaje
     * @param accesoNorte true si es acceso Norte
     * @param accesoSur true si es acceso Sur
     */
	public void añadirPunto(String nombre, int costo, boolean accesoNorte, boolean accesoSur){
		Peaje nuevo = new Peaje(nombre, costo, accesoNorte, accesoSur);
		listaPeajes.add(nuevo);	
	}
	/**
	 * Modifica algun peaje ya ingresado en el sistema.
	 * @param peaje Nombre del peaje
	 * @param costo costo del peaje
	 * @param accesoNorte true si es acceso Norte
	 * @param accesoSur true si es Acceso Sur
	 */
	public void modificarPunto(String peaje, int costo, boolean accesoNorte, boolean accesoSur){
		for (Peaje pj : this.listaPeajes){
			if(pj.getNombre().equals(peaje)){
				pj.modificarPeaje(costo, accesoNorte, accesoSur);
			}
			
		}
	}
	/**
	 * Ingresando el nombre de dos peajes, crea una Avenida que una ambos puntos.
	 * @param p1 Nombre del Peaje de salida
	 * @param p2 Nombre del Peaje de llegada
	 * @param capacidad Cantidad de vehiculos que pueden circular por día (en miles).
	 * @param longitud Longitud de la Avenida en Km.
	 * @param estado True si está Habilitada, false en caso contrario.
	 */
	public void añadirTramo(String p1, String p2, int capacidad, int longitud, boolean estado){
		Peaje pEntrada = this.obtenerPeaje(p1);
		Peaje pSalida = this.obtenerPeaje(p2);
		
		Avenida nuevo = new Avenida(pEntrada, pSalida, capacidad, longitud, estado);
		listaAvenidas.add(nuevo);
	}
	
	/**
	 * Permite modificar una Avenida ingresada en el sistema.
	 * @param a Avenida a modificar
	 * @param capacidad Nueva capacidad de la Avenida
	 * @param longitud Nueva Longitud de la Avenida
	 * @param estado Nuevo Estado de la Avenida
	 */
	public void modificarTramo(Avenida a, int capacidad, int longitud, boolean estado){
		for(Avenida av: this.listaAvenidas){
			if(av.getPeajeEntrada().equals(a.getPeajeEntrada()) && av.getPeajeSalida().equals(a.getPeajeSalida())){
				a.modificarAvenida(capacidad, longitud, estado);
			}
		}
	}
	/**
	 * Obtiene la lista de avenidas del sistema.
	 * @return Lista de Avenidas
	 */
	public List getListaAvenida(){
		return this.listaAvenidas;
	}
	/**
	 * Obtiene la lista de peajes del sistema.
	 * @return Lista de Peajes.
	 */
	public List getListaPeajes(){
		return this.listaPeajes;
	}
	/**
	 * Dado dos Peajes retorna una lista de Peajes para ir de un punto al otro.
	 * @param pInicio Peaje de salida.
	 * @param pFinal Peaje de llegada.
	 * @return Lista de Peajes
	 */
	public List caminos(Peaje pInicio, Peaje pFinal){
		Vector <Peaje> salida =  new Vector();
		Vector <Peaje> marcados = new Vector();
		Vector <Peaje> marcadosDoble = new Vector();
		marcados.add(pInicio);
		buscarCaminosAux(pInicio, pFinal,marcados, marcadosDoble, salida);
		return salida;
		
	}
	/**
	 * Metodo auxiliar para camino, sirve para encontrar todos los caminos desde un peaje a otro. 
	 * @param p1 Peaje de salida,
	 * @param p2 Peaje de llegada.
	 * @param marcados Lista de Peajes para poner los Peajes que ya se visitaron.
	 * @param marcadosDoble Lista para colocar los Peajes que se volvieron a visitar y que no van a visitarse mas.
	 * @param todos Lista resultante, con todos los caminos.
	 */
	public void buscarCaminosAux(Peaje p1, Peaje p2, Vector marcados, Vector marcadosDoble, Vector todos){
		Vector <Peaje> adyacentes = (Vector<Peaje>) buscarAdyacentes(p1);
		Vector <Peaje> copiaMarcados = new <Peaje> Vector();
		Vector <Peaje> copiaMarcadosDoble = new <Peaje> Vector();
		for(int indice=0;indice < adyacentes.size(); indice ++){
			if (!marcadosDoble.contains((Peaje) adyacentes.elementAt(indice))){
				if(p2.equals(((Peaje)adyacentes.elementAt(indice))))
					{ copiaMarcados = (Vector)marcados.clone();
						copiaMarcados.addElement(p2);
						todos.addElement(copiaMarcados);
					}
				else {
					if( !marcados.contains(((Peaje)adyacentes.elementAt(indice)))){
						copiaMarcados = (Vector)marcados.clone();
						copiaMarcados.addElement(((Peaje)adyacentes.elementAt(indice)));
						this.buscarCaminosAux(((Peaje)adyacentes.elementAt(indice)), p2,copiaMarcados, marcadosDoble,todos);
					}
					else{
						if(marcados.contains((Peaje) adyacentes.elementAt(indice)) && !marcadosDoble.contains((Peaje)adyacentes.elementAt(indice))){
							copiaMarcados = (Vector)marcados.clone();
							copiaMarcados.addElement(((Peaje)adyacentes.elementAt(indice)));
							copiaMarcadosDoble = (Vector)marcadosDoble.clone();
							copiaMarcadosDoble.addElement(((Peaje)adyacentes.elementAt(indice)));
							this.buscarCaminosAux(((Peaje)adyacentes.elementAt(indice)), p2,copiaMarcados, copiaMarcadosDoble,todos);
						}
					}
	}
					}}}
		
	/**
	 * Obtiene los Peajes adyacentes, o sea, a los que se puede llegar desde el peaje mandado como parametro.
	 * @param p Peaje del cual se busca los Peajes adyacentes.
	 * @return Lista de Peajes.
	 */
	public List buscarAdyacentes(Peaje p){
		Vector <Peaje> nuevo = new <Peaje> Vector();
		List <Avenida> listaAvenidas = this.getListaAvenida();
		for(Avenida av : listaAvenidas){
			if (av.getEstado()){
				if (av.getPeajeEntrada().equals(p)){
					nuevo.add(av.getPeajeSalida());
				}
			}
		}
		return nuevo;
	}
	/**
	 * Busca en el sistema todos los caminos desde el Peaje con nombre p1 al peaje con nombre p2 y devuelve el que tenga menos kilometros.
	 * @param p1 Nombre del Peaje de salida.
	 * @param p2 Nombre del Peaje de llegada.
	 * @return Lista de Peajes.
	 */
	public List caminoMasCortoKm(String p1, String p2){
		Peaje pInicio = this.obtenerPeaje(p1);
		Peaje pFinal = this.obtenerPeaje(p2);
		Vector listaCaminos = (Vector) this.caminos(pInicio, pFinal);
		int suma = 0;
		int indiceFinal = 0;
		int nuevaSuma;
		for (int indice = 0; indice<listaCaminos.size(); indice ++){
		 	Vector listaPeajes = (Vector) listaCaminos.get(indice);
		 	nuevaSuma = 0;
		 	for (int peaj = 0; peaj<listaPeajes.size()-1; peaj++){
		 		Avenida av = this.obtenerAvenida((Peaje)listaPeajes.get(peaj), (Peaje)listaPeajes.get(peaj+1));
		 		nuevaSuma += av.getLongitud();
		 	}
		 	if (indice == 0){
		 		suma = nuevaSuma;
		 	}
		 	else{
		 		if (nuevaSuma < suma){
		 		suma = nuevaSuma;
		 		indiceFinal = indice;
		 	}}
		}
		return (List) listaCaminos.get(indiceFinal);
	}
	
	/**
	 * Calcula la longitud de un camino.
	 * @param l Lista de Avenidas del cual se deséa sumar las longitudes.
	 * @return longitu de un camino.
	 */
	public int longCamino(List <Avenida> l){
		int retorno=0;
		for(Avenida a : l){
			retorno+=a.getLongitud();
		}
		return retorno;
		
	}
	/**
	 * Obtiene la Avenida que une p1 y p2
	 * @param p1 Peaje de salida.
	 * @param p2 Peaje de llegada.
	 * @return Avenida
	 */
	public Avenida obtenerAvenida(Peaje p1, Peaje p2){
		List<Avenida> listaAvenidas = this.getListaAvenida();
		for (Avenida avs : listaAvenidas){
			if (avs.getPeajeEntrada().equals(p1) && avs.getPeajeSalida().equals(p2)){
				return avs;
			}
		}
		return null;
	}
	/**
	 * Obtiene el camino mas corto desde el peaje con nombre p1 al p2
	 * @param p1 Nombre del Peaje de salida del cual se deséa saber el camino mas corto en Peaje.
	 * @param p2 Nombre del Peaje de llegada al cual se quiere llegar con menos Peajes.
	 * @return Lista de Peajes
	 */
	
	public List caminoMasCortoPeaje(String p1, String p2){
		Peaje pInicio = this.obtenerPeaje(p1);
		Peaje pFinal = this.obtenerPeaje(p2);
		Vector listaCaminos = (Vector)this.caminos(pInicio, pFinal);
		int totalPeajes = 0;
		int indiceFinal = 0;
		for (int indice = 0; indice < listaCaminos.size(); indice ++){
			List listaPeajes = (List) listaCaminos.get(indice);
			int cantidadPeajes = listaPeajes.size();
			if (indice == 0){
				totalPeajes = cantidadPeajes;
			}
			else{
				if (cantidadPeajes < totalPeajes){
					totalPeajes = cantidadPeajes;
					indiceFinal = indice;
				}
			}
		}
		return (List) listaCaminos.get(indiceFinal);		
	}
	/**
	 * Dada una cadena de String busca el Peaje con éste nombre.
	 * @param peajeEntrada Nombre del Peaje buscado
	 * @return Peaje
	 */
	public Peaje obtenerPeaje(String peajeEntrada){
		Peaje peaje = null;
		for (Peaje p : this.listaPeajes){
			if(p.getNombre().equals(peajeEntrada)){
				peaje = p;
			}
			
		}
		return peaje;
	}
	
	/**
	 * Permite ver hasta que Peaje se puede llegar recorriendo el Grafo desde el peaje mandado como parámetro.
	 * @param peaje Nombre del Peaje del cual se desea saber a donde llegar.
	 * @return Lista de Peajes
	 */
	public List alcance(String peaje){
		Peaje pEntrada = this.obtenerPeaje(peaje);
		List <Peaje> nuevaLista = new Vector();
		return this.alcanceAux(pEntrada, nuevaLista);
	}
	
	
	
	public List alcanceAux(Peaje p1, List marcados){
		List<Peaje> listaAlcance = new Vector();
		listaAlcance.addAll(this.buscarAdyacentes(p1));
		for (Peaje pj : listaAlcance){
			if(!marcados.contains(pj)){
				marcados.add(pj);
				this.alcanceAux(pj, marcados);
			}
		}
		return marcados;	
	}
	/**
	 * Permite obtener la cantidad maxima de autos que van desde el acceso Norte al acceso Sur.
	 * @return Cantidad máxima de autos.
	 */
	public int cantidadMaximaAuto(){
		Peaje accNorte = this.getAccesoNorte();
		Peaje accSur = this.getAccesoSur();
		Vector caminos = (Vector) this.caminos(accNorte, accSur);
		int [] cantidades = new int [caminos.size()];
		for (int indice = 0; indice< caminos.size(); indice ++){
			cantidades[indice] = this.minimaDeAvenida((Vector<Peaje>) caminos.elementAt(indice));
			}
		int maximo = 0;
		for (int i = 0; i < cantidades.length; i++){
			if (i == 0){
				maximo = cantidades[0];
			}
			else {
				if (cantidades[i]> maximo){
					maximo = cantidades[i];
				}
			}
		}
		return maximo;
	}
	/**
	 * Obtiene la menor capacidad de entre una lista de Avenidas, que se obtienen con una lista de Peajes.
	 * @param camino Lista de Avenidas de la cual se deséa obtener la minima capacidad.
	 * @return Menor capacidad de circulacion.
	 */
	public int minimaDeAvenida(Vector<Peaje> camino){
		int menor=0;
		for(Avenida a : listaAvenidas){
			if(a.getPeajeEntrada()==camino.get(0) && a.getPeajeSalida()==camino.get(1)){
				menor=a.getCapacidad();
			}
		}
		for(int i=1;i<camino.size()-1;i++){
			for(Avenida a : listaAvenidas){
				if(a.getPeajeEntrada()==camino.get(i) && a.getPeajeSalida()==camino.get(i+1)){
					if(a.getCapacidad()<menor){
						menor=a.getCapacidad();
					}
				}
			}
		}
		return menor;
	}
	
	public Peaje getAccesoNorte(){
		for (Peaje pj : this.listaPeajes){
			if (pj.getEsAccesoNorte()){
				return pj;
			}
		}
		return null;
	}
	public Peaje getAccesoSur(){
		for (Peaje pj : this.listaPeajes){
			if (pj.getEsAccesoSur()){
				return pj;
			}
		}
		return null;
	}
	/**
	 * Obtiene los Peajes a los que se puede llegar desde un Peaje especifico pasando por no mas de n Peajes.
	 * @param peaje Nombre del peaje del cual se parte para llegar a todos los peajes sin pasar por mas de n Peajes.
	 * @param n Cantidad máima de Peajes por los cuales se puede pasar.
	 * @return Lista de Peajes.
	 */
	public List alcanceN(String peaje, int n){
		Peaje pEntrada = this.obtenerPeaje(peaje);
		List <Peaje> nuevaLista = new Vector();
		return this.alcanceNAux(pEntrada, nuevaLista, n);
	}
	
	
	
	public List alcanceNAux(Peaje p1, List marcados, int n){
		List<Peaje> listaAlcance = new Vector();
		listaAlcance.addAll(this.buscarAdyacentes(p1));
		if (n>0){
			for (Peaje pj : listaAlcance){
				if(!marcados.contains(pj)){
					marcados.add(pj);
					n--;
					this.alcanceNAux(pj, marcados, n);
				}
			}
		}
		return marcados;
		
		
	}
	/**
	 * Carga los datos al sistema.
	 * @param datosEntrada String con todas las lineas del archivo de entrada.
	 */
	public void cargarDatos(String datosEntrada) {
		BufferedReader buff = null;
		String line = "";
		String token = ",";
		this.clear();
		try{
			buff = new BufferedReader(new FileReader(datosEntrada));
			while((line = buff.readLine()) != null){
				String[] datos = line.split(token);
				switch(datos[0]){
					case "P":
						int costo = Integer.parseInt(datos[2]);
						boolean accesoNorte = false;
						boolean accesoSur = false;
						if (datos[3].equals("acceso norte")){
							accesoNorte = true;
						}
						if (datos[4].equals("acceso sur")){
							accesoSur = true;
						}
						this.añadirPunto(datos[1], costo, accesoNorte, accesoSur);
						break;
					case "A":
						int capacidad = Integer.parseInt(datos[3]);
						int longitud = Integer.parseInt(datos[4]);
						boolean estado = false;
						if (datos[5].equals("Habilitada")){
							estado = true;
						}
						this.añadirTramo(datos[1], datos[2], capacidad, longitud, estado);
						break;
				}
			}
			
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Ocurrió un problema al cargar algunos datos. Verifique el archivo.", "Error", JOptionPane.ERROR_MESSAGE);
		}
		finally {
			if (buff != null) {
				try {
					buff.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		
	}
	}
	public void clear() {
		this.listaAvenidas.clear();
		this.listaPeajes.clear();
	}
	public void setListaPeaje(List<Peaje> listaPeajes2) {
		this.listaPeajes = listaPeajes2;
	}
	
	public void setListaAvenidas(List<Avenida> listaAvenidas){
		this.listaAvenidas = listaAvenidas;
	}
	/**
	 * Obtiene todas las Avenidas que unen todos los Peajes contenidos en miLista
	 * @param miLista Lista de Peajes que se deséa saber el camino que los une.
	 * @return Lista de Avenidas.
	 */
	public List<Avenida> obtenerTodasAvenidas(List<Peaje> miLista) {
		List<Avenida> nueva = this.getListaAvenida();
		List resultado = new ArrayList();
		for (Avenida av : nueva){
			if (av.getEstado()){
			if (miLista.contains(av.getPeajeEntrada()) && miLista.contains(av.getPeajeSalida())){
				resultado.add(av);
			}
			}
		}
		return resultado;
	}
}
