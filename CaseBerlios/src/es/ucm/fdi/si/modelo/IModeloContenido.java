/*
 * Created on 26-dic-2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package es.ucm.fdi.si.modelo;

import java.util.List;

/**
 * @author Alejandro
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public interface IModeloContenido {
	
	public ListaElementosContenido getListaElementosContenido();
	public int getTipoSeleccionadoContenido();
	public void setTipoSeleccionadoContenido(int tipoSeleccionadoContenido);
	public ListaElementosContenido getElementosSeleccionadosContenido();
	/**
	 * @param tipo
	 * @param nombre
	 * @param nodoInicio
	 * @param nodoFin
	 * @param listaPuntos
	 * @param tiempo
	 * @return
	 */
	public boolean añadirElementoDiseño(int tipo, String nombre, Nodo nodoInicio, Nodo nodoFin, List listaPuntos, int tiempo);
	/**
	 * @param tipo
	 * @param nombre
	 * @param nodoInicio
	 * @param nodoFin
	 * @param listaPuntos
	 * @return
	 */
	public boolean añadirElementoContenido(int tipo, String nombre, Nodo nodoInicio, Nodo nodoFin, List listaPuntos);
	/**
	 * @param tipo
	 * @param nombre
	 * @param puntoInicio
	 * @param puntoFin
	 * @return
	 */
	public boolean añadirElementoContenido(int tipo, String nombre, Punto puntoInicio, Punto puntoFin);
	/**
	 * @param x
	 * @param y
	 */
	public void setElementoSeleccionadoContenido(int x, int y);
	/**
	 * @param posX
	 * @param posY
	 */
	public void añadeElementoSeleccionadoContenido(int posX, int posY);
	public int getNumElementosContenido();
	public void deleteElementosContenido(ListaElementosContenido elementosContenido);
	public boolean existeElementoContenido(String nombre);
	public void actualizaNodoContenido(String nombre, Punto puntoInicio , Punto puntoFin, String nuevoNombre);
}
