/*
 * Created on 27-nov-2004
 *
 */
package es.ucm.fdi.si;


import java.util.List;
import es.ucm.fdi.si.modelo.ListaElementosContenido;
import es.ucm.fdi.si.modelo.ListaElementosDise�o;
import es.ucm.fdi.si.modelo.Nodo;
import es.ucm.fdi.si.modelo.Punto;

/**
 * @author Alejandro Blanco, David Curieses Chamon, Oscar Ortega
 *
 * Proyecto Sistemas Informaticos: 
 * 	
 * Herramienta CASE para dise�o y prototipado de aplicaciones hipermedia
 */
public interface ICase {
    
    //FUNCIONALIDADES DE FACHADA CASE
	
	//Funcionalidades asociadas a la "pesta�a" Dise�o
	public void setElementoSeleccionadoDise�o(int x, int y);
	public void setElementoSeleccionadoDise�o(String nombre);
	public ListaElementosDise�o getElementosSeleccionadosDise�o();
	public boolean existeElementoDise�o(String nombre);
	public boolean a�adeElementoDise�o(int tipo, String nombre, Punto puntoInicio, Punto puntoFin);
	public boolean a�adeElementoDise�o(int tipo, String nombre, Nodo nodoInicio, Nodo nodoFin, List listaPuntos, int tiempo);
	public void setTipoSeleccionadoDise�o(int tipo);
    public int getTipoSeleccionadoDise�o();
    public void a�adirElementoSeleccionado(int posX, int posY);
    public void deleteElementosDise�o(ListaElementosDise�o elementosDise�o);
    /**
	 * @return
	 */
	public int getNumElementosDise�o();
	public void actualizaNodoDise�o(String nombre, Punto puntoInicio , Punto puntoFin, String nuevoNombre);
    
    //********************************************************************************
    
    // Funcionalidades asociadas a la "pesta�a" Contenido 
    
    public int getTipoSeleccionadoContenido();
	public boolean existeElementoContenido(String nombre);
	public void setTipoSeleccionadoContenido(int tipoSeleccionadoContenido); 
	public ListaElementosContenido getElementosSeleccionadosContenido();
	public void deleteElementoContenido(ListaElementosContenido elementos);
	/**
	 * @param posX
	 * @param posY
	 */
	public void setElementoSeleccionadoContenido(int posX, int posY);
	/**
	 * @param tipoSeleccionadoContenido
	 * @param nombre
	 * @param nodoInicio
	 * @param nodoFin
	 * @param listaPuntos
	 * @param tiempo
	 * @return
	 */
	public boolean a�adeElementoContenido(int tipoSeleccionadoContenido, String nombre, Nodo nodoInicio, Nodo nodoFin, List listaPuntos);
	/**
	 * @param tipoSeleccionadoContenido
	 * @param nombre
	 * @param puntoInicio
	 * @param puntoFin
	 * @return
	 */
	public boolean a�adeElementoContenido(int tipoSeleccionadoContenido, String nombre, Punto puntoInicio, Punto puntoFin);
	
	/**
	 * @param posX
	 * @param posY
	 */
	public void a�adirElementoSeleccionadoContenido(int posX, int posY);
	/**
	 * @return
	 */
	public int getNumElementosContenido();
	public void actualizaNodoContenido(String nombre, Punto puntoInicio , Punto puntoFin, String nuevoNombre);
	
	
	//********************************************************************************
    
    //Funciones auxiliares
	
	
    /** Guarda en el modelo la posicion sobre la que se pincho */
    public void setPosXY(int x, int y);
    public int getActualX();
    public int getActualY();
    public boolean estaDentro(int x, int y);
    
    /**
	 * @param b
	 */
    public void setPulsadoControl(boolean b);
	/**
	 * @return
	 */
	public boolean isPulsadoControl();
	
	
}
