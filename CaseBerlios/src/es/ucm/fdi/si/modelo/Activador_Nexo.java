/*
 * Created on 03-dic-2004
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
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
public class Activador_Nexo extends Nodo {

    /**
     * @param nombre
     * @param id
     * @param puntoInicio
     * @param puntoFin
     */
    public Activador_Nexo(int tipo,String nombre, Punto puntoInicio, Punto puntoFin) {
        super(tipo,nombre, puntoInicio, puntoFin);
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
        g.drawLine(x1,y2,x2,y2);
        int xMedio=(x2+x1)/2;
        g.drawLine(x1,y2,xMedio,y1);
        g.drawLine(xMedio,y1,x2,y2);
        g.drawString(nombre, x1, y1);
    }
    
    public String toString() {
        return getNombre();
    }

	/* (non-Javadoc)
	 * @see es.ucm.fdi.si.modelo.Elemento#estaDentro(int, int)
	 */
	public boolean estaDentro(int x, int y) {
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

}









