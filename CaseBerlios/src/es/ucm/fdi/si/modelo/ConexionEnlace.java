/*
 * Created on 28-nov-2004
 *
 */
package es.ucm.fdi.si.modelo;

import java.awt.Graphics;
import java.util.List;

/**
 * @author Alejandro Blanco, David Curieses Chamon, Oscar Ortega
 *
 * Proyecto Sistemas Informaticos: 
 * 	
 * Herramienta CASE para diseño y prototipado de aplicaciones hipermedia
 */
public abstract class ConexionEnlace extends Elemento {

    protected Nodo nodoInicio;
    protected Nodo nodoFin;
    protected List listaPuntos;
    
    /**
     * @param nombre
     * @param id
     */
    public ConexionEnlace(String nombre, Nodo nodoInicio, Nodo nodoFin, List listaPuntos) {
        super(nombre);
        this.nodoInicio=nodoInicio;
        this.nodoFin=nodoFin;
        this.listaPuntos=listaPuntos;
    }
    
    public boolean esRelacion(){
    	return true;
    }
    
    /**
	 * @return Returns the nodoInicio.
	 */
    public Nodo getNodoInicio(){
    	return nodoInicio;
    }
	/**
	 * @return Returns the nodoFin.
	 */
	public Nodo getNodoFin() {
		return nodoFin;
	}
	/**
	 * @param nodoFin The nodoFin to set.
	 */
	public void setNodoFin(Nodo nodoFin) {
		this.nodoFin = nodoFin;
	}
	/**
	 * @param nodoInicio The nodoInicio to set.
	 */
	public void setNodoInicio(Nodo nodoInicio) {
		this.nodoInicio = nodoInicio;
	}
    /* (non-Javadoc)
     * @see es.ucm.fdi.si.modelo.Elemento#pintate(java.awt.Graphics)
     */
    public void pintate(Graphics g) {}
    
}
