/*
 * Created on 27-nov-2004
 *
 */
package es.ucm.fdi.si.dibujo;

import java.util.List;

import es.ucm.fdi.si.modelo.ListaElementosContenido;
import es.ucm.fdi.si.modelo.Nodo;
import es.ucm.fdi.si.modelo.Punto;

/**
 * @author Alejandro Blanco, David Curieses Chamon, Oscar Ortega
 *
 * Proyecto Sistemas Informaticos: 
 * 	
 * Herramienta CASE para diseño y prototipado de aplicaciones hipermedia
 */
public interface IContenido {
	
	public int getTipoSeleccionadoContenido();
	public void setTipoSeleccionadoContenido(int tipoSeleccionadoContenido); 
	public ListaElementosContenido getElementosSeleccionados();
	public void setElementoSeleccionado(int x, int y);
	public boolean añadeElementoContenido(int tipo, String nombre, Punto puntoInicio, Punto puntoFin);
	public boolean añadeElementoContenido(int tipo, String nombre, Nodo nodoInicio, Nodo nodoFin, List listaPuntos);
	public void añadeElementoSeleccionado(int posX, int posY);
	public int getNumElementosContenido();
	public void deleteElementos(ListaElementosContenido elementosContenido);
	public boolean existeElementoContenido(String nombre);
	public void actualizaNodoContenido(String nombre, Punto puntoInicio, Punto puntoFin, String nuevoNombre);
}
