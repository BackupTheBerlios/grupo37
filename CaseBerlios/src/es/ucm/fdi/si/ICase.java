/*
 * Created on 27-nov-2004
 *
 */
package es.ucm.fdi.si;


import java.util.List;
import es.ucm.fdi.si.modelo.ListaElementosContenido;
import es.ucm.fdi.si.modelo.ListaElementosDiseño;
import es.ucm.fdi.si.modelo.Nodo;
import es.ucm.fdi.si.modelo.Punto;

/**
 * @author Alejandro Blanco, David Curieses Chamon, Oscar Ortega
 *
 * Proyecto Sistemas Informaticos: 
 * 	
 * Herramienta CASE para diseño y prototipado de aplicaciones hipermedia
 */
public interface ICase {
    
    //FUNCIONALIDADES DE FACHADA CASE
	
	//Funcionalidades asociadas a la "pestaña" Diseño
	public void setElementoSeleccionadoDiseño(int x, int y);
	public void setElementoSeleccionadoDiseño(String nombre);
	public ListaElementosDiseño getElementosSeleccionadosDiseño();
	public boolean existeElementoDiseño(String nombre);
	public boolean añadeElementoDiseño(int tipo, String nombre, Punto puntoInicio, Punto puntoFin);
	public boolean añadeElementoDiseño(int tipo, String nombre, Nodo nodoInicio, Nodo nodoFin, List listaPuntos, int tiempo);
	public void setTipoSeleccionadoDiseño(int tipo);
    public int getTipoSeleccionadoDiseño();
    public void añadirElementoSeleccionado(int posX, int posY);
    public void deleteElementosDiseño(ListaElementosDiseño elementosDiseño);
    /**
	 * @return
	 */
	public int getNumElementosDiseño();
	public void actualizaNodoDiseño(String nombre, Punto puntoInicio , Punto puntoFin, String nuevoNombre);
    
    //********************************************************************************
    
    // Funcionalidades asociadas a la "pestaña" Contenido 
    
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
	public boolean añadeElementoContenido(int tipoSeleccionadoContenido, String nombre, Nodo nodoInicio, Nodo nodoFin, List listaPuntos);
	/**
	 * @param tipoSeleccionadoContenido
	 * @param nombre
	 * @param puntoInicio
	 * @param puntoFin
	 * @return
	 */
	public boolean añadeElementoContenido(int tipoSeleccionadoContenido, String nombre, Punto puntoInicio, Punto puntoFin);
	
	/**
	 * @param posX
	 * @param posY
	 */
	public void añadirElementoSeleccionadoContenido(int posX, int posY);
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
