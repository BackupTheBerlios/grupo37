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
public class Ancla_Dinamica extends Nodo {

    /**
     * @param nombre
     * @param id
     * @param puntoInicio
     * @param puntoFin
     */
    public Ancla_Dinamica(int tipo, String nombre, Punto puntoInicio, Punto puntoFin) {
        super(tipo, nombre, puntoInicio, puntoFin);
    }

    /* (non-Javadoc)
     * @see es.ucm.fdi.si.modelo.Elemento#pintate()
     */
    public void pintate(Graphics g) {
        Punto puntoInicio=getPuntoInicio();
        Punto puntoFin=getPuntoFin();
        int x1=puntoInicio.getX();
        int y1=puntoInicio.getY();
        int x2=puntoFin.getX();
        int y2=puntoFin.getY();
  		g.drawLine(x1,y1, x2,y1);
  		g.drawLine(x2,y1, x2,y2);
  		g.drawLine(x2,y2, x1,y2);
  		g.drawLine(x1,y2, x1,y1);
  		g.drawString(nombre, x1, y1);
    }
    
    public boolean estaDentro(int x, int y){
    	boolean resultadoX;
	    if (puntoFin.getX()> puntoInicio.getX()) {
	        resultadoX=( (x > puntoInicio.getX()) && (x < puntoFin.getX()) );
	    } else 
	        resultadoX=( (x > puntoFin.getX()) && (x < puntoInicio.getX()) );
	    
	    boolean resultadoY;
	    if (puntoFin.getY()> puntoInicio.getY()) {
	        resultadoY=( (y > puntoInicio.getY()) && (y < puntoFin.getY()) );
	    } else 
	        resultadoY=( (y > puntoFin.getY()) && (y < puntoInicio.getY()) );
	    
	    boolean resultado=resultadoX && resultadoY;
	    return resultado;
    }
    
    public String toString() {
        return getNombre();
    }

}
