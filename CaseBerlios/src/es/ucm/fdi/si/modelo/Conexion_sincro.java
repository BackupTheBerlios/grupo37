/*
 * Created on 04-dic-2004
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
package es.ucm.fdi.si.modelo;

import java.awt.Graphics;
import java.util.List;

/**
 * @author Oscar Ortega
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Conexion_sincro extends ConexionEnlace {
	
	int tiempo;

	/**
	 * @param nombre
	 * @param nodoInicio
	 * @param nodoFin
	 */
	public Conexion_sincro(Nodo nodoInicio, Nodo nodoFin, List listaPuntos, int tiempo) {
		super("Conexion_Sincro "+nodoInicio.toString()+" "+nodoFin.toString(), nodoInicio, nodoFin, listaPuntos);
		this.tiempo=tiempo;
	}
	
	public void pintate (Graphics g){
		int xFin, xInicio, alturaInicio, anchuraInicio, yInicio, yFin, anchuraFin, alturaFin;
		
		xInicio = nodoInicio.getPuntoInicio().getX();
		yInicio = nodoInicio.getPuntoInicio().getY();
		
		// Punto medio del inicio
		anchuraInicio = nodoInicio.getPuntoFin().getX() - xInicio;
		alturaInicio = nodoInicio.getPuntoFin().getY() - yInicio;
		
		anchuraInicio = anchuraInicio/2;
		alturaInicio = alturaInicio/2;
		
		xInicio = xInicio + anchuraInicio;
		yInicio = yInicio + alturaInicio;
		
		xFin = nodoFin.getPuntoInicio().getX();
		yFin = nodoFin.getPuntoInicio().getY();
		
		//Punto medio del fin
		anchuraFin = nodoFin.getPuntoFin().getX() - xFin;
		alturaFin = nodoFin.getPuntoFin().getY() - yFin;
		
		anchuraFin = anchuraFin / 2;
		alturaFin = alturaFin / 2;
		
		xFin = xFin + anchuraFin;
		yFin = yFin + alturaFin;
		
		g.drawLine(xInicio,yInicio,xFin,yFin);
		int xPuntoMedio = (xFin - xInicio)/2 -15;
		int yPuntoMedio = (yFin - yInicio)/2 - 10;
		g.drawString(""+tiempo,xInicio + xPuntoMedio,yInicio + yPuntoMedio);
		g.drawLine(xInicio,yInicio,xFin,yFin);
		

	}

	/* (non-Javadoc)
	 * @see es.ucm.fdi.si.modelo.Elemento#estaDentro(int, int)
	 */
	public boolean estaDentro(int x, int y) {
		return false;
	}

    public String toString() {
        return "Conexion_Sincro "+nodoInicio.toString()+" "+nodoFin.toString();
    }

}
