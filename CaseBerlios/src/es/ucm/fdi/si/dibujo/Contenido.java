/*
 * Created on 26-dic-2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package es.ucm.fdi.si.dibujo;

import java.util.List;

import es.ucm.fdi.si.modelo.IModeloContenido;
import es.ucm.fdi.si.modelo.ListaElementosContenido;
import es.ucm.fdi.si.modelo.Nodo;
import es.ucm.fdi.si.modelo.Punto;

/**
 * @author Alejandro
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Contenido implements IContenido {

	private IModeloContenido modeloContenido;
	
	public Contenido(IModeloContenido modeloContenido) {
		this.modeloContenido=modeloContenido;
	}
	
	/* (non-Javadoc)
	 * @see es.ucm.fdi.si.dibujo.IContenido#getTipoSeleccionadoContenido()
	 */
	public int getTipoSeleccionadoContenido() {
		return modeloContenido.getTipoSeleccionadoContenido();
	}

	/* (non-Javadoc)
	 * @see es.ucm.fdi.si.dibujo.IContenido#setTipoSeleccionadoContenido(int)
	 */
	public void setTipoSeleccionadoContenido(int tipoSeleccionadoContenido) {
		modeloContenido.setTipoSeleccionadoContenido(tipoSeleccionadoContenido);
	}

	/* (non-Javadoc)
	 * @see es.ucm.fdi.si.dibujo.IContenido#getElementoSeleccionado()
	 */
	public ListaElementosContenido getElementosSeleccionados() {
		return modeloContenido.getElementosSeleccionadosContenido();
	}

	/**
	 * @param tipo
	 * @param nombre
	 * @param nodoInicio
	 * @param nodoFin
	 * @param listaPuntos
	 * @param tiempo
	 * @return
	 */
	public boolean añadeElementoContenido(int tipo, String nombre, Nodo nodoInicio, Nodo nodoFin, List listaPuntos) {
		return modeloContenido.añadirElementoContenido(tipo,nombre,nodoInicio,nodoFin, listaPuntos);
	}

	/**
	 * @param tipo
	 * @param nombre
	 * @param puntoInicio
	 * @param puntoFin
	 * @return
	 */
	public boolean añadeElementoContenido(int tipo, String nombre, Punto puntoInicio, Punto puntoFin) {
		return modeloContenido.añadirElementoContenido(tipo,nombre,puntoInicio,puntoFin);
	}

	/**
	 * @param x
	 * @param y
	 */
	public void setElementoSeleccionado(int x, int y) {
		modeloContenido.setElementoSeleccionadoContenido(x, y);
		
	}

	/**
	 * @param posX
	 * @param posY
	 */
	public void añadeElementoSeleccionado(int posX, int posY) {
		modeloContenido.añadeElementoSeleccionadoContenido(posX, posY);
		
	}

	/* (non-Javadoc)
	 * @see es.ucm.fdi.si.dibujo.IContenido#getNumElementosContenido()
	 */
	public int getNumElementosContenido() {
		return modeloContenido.getNumElementosContenido();
	}

	/* (non-Javadoc)
	 * @see es.ucm.fdi.si.dibujo.IContenido#deleteElementos(es.ucm.fdi.si.modelo.ListaElementosContenido)
	 */
	public void deleteElementos(ListaElementosContenido elementosContenido) {
		modeloContenido.deleteElementosContenido(elementosContenido);
		
	}

	/* (non-Javadoc)
	 * @see es.ucm.fdi.si.dibujo.IContenido#existeElementoContenido(java.lang.String)
	 */
	public boolean existeElementoContenido(String nombre) {
		return modeloContenido.existeElementoContenido(nombre);
	}

	/* (non-Javadoc)
	 * @see es.ucm.fdi.si.dibujo.IContenido#actualizaNodoContenido(java.lang.String, es.ucm.fdi.si.modelo.Punto, es.ucm.fdi.si.modelo.Punto, java.lang.String)
	 */
	public void actualizaNodoContenido(String nombre, Punto puntoInicio, Punto puntoFin, String nuevoNombre) {
		modeloContenido.actualizaNodoContenido(nombre,puntoInicio,puntoFin,nuevoNombre);
		
	}

}
