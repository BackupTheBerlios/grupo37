/*
 * Created on 28-nov-2004
 *
 */
package es.ucm.fdi.si.modelo;

import java.awt.Graphics;
import java.util.List;
import java.util.LinkedList;

/**
 * @author Alejandro Blanco, David Curieses Chamon, Oscar Ortega
 *
 * Proyecto Sistemas Informaticos: 
 * 	
 * Herramienta CASE para diseño y prototipado de aplicaciones hipermedia
 */
public abstract class Nodo extends Elemento {

    protected Punto puntoInicio;
    protected Punto puntoFin;
    protected int tipo;
    /** Lista de enlaces y conexiones en las que se ve involucrado un Nodo */
    protected List enlaces_conexiones;
    
	public Nodo(int tipo,String nombre, Punto puntoInicio, Punto puntoFin) {
        super(nombre);
        this.puntoInicio=puntoInicio;
        this.puntoFin=puntoFin;
        this.tipo = tipo;
        // Inicialmente el nodo no se encuentra formando parte de ningun enlace ni conexion
        this.enlaces_conexiones = new LinkedList();
    }
	
	public boolean esRelacion() {
		return false;
	}    

    public Punto getPuntoFin() {
        return puntoFin;
    }
    public void setPuntoFin(Punto puntoFin) {
        this.puntoFin = puntoFin;
    }
    public Punto getPuntoInicio() {
        return puntoInicio;
    }
    public void setPuntoInicio(Punto puntoInicio) {
        this.puntoInicio = puntoInicio;
    }
    
    public int getTipo() {
		return tipo;
	}
	
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	
	public List getEnlaces_conexiones(){
		return this.enlaces_conexiones;
	}

	public void setEnlaces_conexiones(List lista){
		this.enlaces_conexiones = lista;
	}
	
	/** Añade el enlace o la conexion de la que forma parte el Nodo*/
	public void addEnlace_conexion(Elemento elemento) {
		this.enlaces_conexiones.add(elemento);		
	}
    
    public void pintate(Graphics g) {}
    
    public String toString() {
        return nombre;
    }
}
