/*
 * Created on 28-nov-2004
 *
 */
package es.ucm.fdi.si.modelo;

import java.awt.Graphics;

/**
 * @author Alejandro Blanco, David Curieses Chamon, Oscar Ortega
 *
 * Proyecto Sistemas Informaticos: 
 * 	
 * Herramienta CASE para diseño y prototipado de aplicaciones hipermedia
 */
public abstract class Elemento implements Comparable{
    
	public static final int RESIZE = -2;
	public static final int NINGUNO=-1;
	public static final int SELECCION=0;
    public static final int NEXO=1;
    public static final int CONTENEDOR=2;
    public static final int ACTIVADOR_NEXO=3;
    public static final int CONEXION=4;
    public static final int ENLACE=5;
    public static final int CONEXION_SINCRO=6;
    public static final int ENLACE_SINCRO=7;
    
//  contenido
	public static final int CONTENIDO_ESTATICO_GRANDE=8;
	public static final int CONTENIDO_ESTATICO_PEQUEÑO=9;
	public static final int CONTENIDO_DINAMICO_GRANDE=10;
	public static final int CONTENIDO_DINAMICO_PEQUEÑO=11;
    public static final int ANCLA_ESTATICA=12;
    public static final int ANCLA_DINAMICA=13;
    public static final int ENLACE_ESTATICO=14;
    public static final int ENLACE_DINAMICO=15;
    public static final int ENLACE_ESTATICO_NARIO=16;
    public static final int ENLACE_DINAMICO_NARIO=17;
    
    protected String nombre;
	    
    public Elemento(String nombre) {
    this.nombre=nombre;
    }       
    
    public abstract void pintate(Graphics g);
    
    public abstract boolean estaDentro(int x, int y);
    
    public abstract boolean esRelacion();

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public boolean equals(Object otro) {
    	return this.nombre.equals(((Elemento)otro).getNombre());
    }
    
    public int compareTo(Object otro) {
    	return this.nombre.compareTo(((Elemento)otro).getNombre());
    }	
	
}
