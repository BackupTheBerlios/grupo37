/*
 * Created on 27-nov-2004
 *
 */
package es.ucm.fdi.si.dibujo;

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
public interface IModuloDibujo {
	
	public void setElementoSeleccionadoDiseño(int x, int y);
	public void setElementoSeleccionadoDiseño(String nombre);
	public void deleteElementosDiseño(ListaElementosDiseño elementosDiseño);
	public ListaElementosDiseño getElementosSeleccionadosDiseño();
	public void setTipoSeleccionadoDiseño(int tipo);
    public int getTipoSeleccionadoDiseño();
    public boolean añadeElementoDiseño(int tipo, String nombre, Punto puntoInicio, Punto puntoFin);
    public boolean añadeElementoDiseño(int tipo, String nombre, Nodo nodoInicio, Nodo nodoFin, List listaPuntos, int tiempo);
    public boolean existeElementoDiseño(String nombre);
    public void actualizaNodo(String nombre, Punto puntoInicio , Punto puntoFin, String nuevoNombre);
    public void setPosXY(int x, int y);
    public int getActualX();
    public int getActualY();
    public boolean estaDentro(int x, int y);
    public int getNumElementosDiseño();
    
    //contenido
    public boolean existeElementoContenido(String nombre);
    public int getTipoSeleccionadoContenido();
    public void setTipoSeleccionadoContenido(int tipoSeleccionadoContenido);
    public ListaElementosContenido getElementosSeleccionadosContenido();
	/**
	 * @param tipo
	 * @param nombre
	 * @param nodoInicio
	 * @param nodoFin
	 * @param listaPuntos
	 * @return
	 */
	public boolean añadeElementoContenido(int tipo, String nombre, Nodo nodoInicio, Nodo nodoFin, List listaPuntos);
	/**
	 * @param tipo
	 * @param nombre
	 * @param puntoInicio
	 * @param puntoFin
	 * @return
	 */
	public boolean añadeElementoContenido(int tipo, String nombre, Punto puntoInicio, Punto puntoFin);
	/**
	 * @param posX
	 * @param posY
	 */
	public void setElementoSeleccionadoContenido(int posX, int posY);
	/**
	 * @param b
	 */
	public void setPulsadoControl(boolean b);
	/**
	 * @return
	 */
	public boolean isPulsadoControl();
	/**
	 * @param posX
	 * @param posY
	 */
	public void añadeElementoSeleccionadoDiseño(int posX, int posY);
	/**
	 * @param posX
	 * @param posY
	 */
	public void añadeElementoSeleccionadoContenido(int posX, int posY);
	/**
	 * @param elementos
	 */
	public void deleteElementosContenido(ListaElementosContenido elementos);
	public int getNumElementosContenido();
	/**
	 * @param nombre
	 * @param puntoInicio
	 * @param puntoFin
	 * @param nuevoNombre
	 */
	public void actualizaNodoContenido(String nombre, Punto puntoInicio, Punto puntoFin, String nuevoNombre);
}