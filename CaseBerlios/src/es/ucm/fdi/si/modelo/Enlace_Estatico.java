/*
 * Created on 16-feb-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package es.ucm.fdi.si.modelo;

import java.awt.Graphics;
import java.util.Iterator;
import java.util.List;

/**
 * @author usuario
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class Enlace_Estatico extends ConexionEnlace {

	public Enlace_Estatico(Nodo nodoInicio, Nodo nodoFin, List listaPuntos) {
		super("Enlace_Estatico "+nodoInicio.toString()+" "+nodoFin.toString(), nodoInicio, nodoFin, listaPuntos);
	}
	
	public void pintate(Graphics g){
		
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
		
		int xAnterior=xInicio;
		int yAnterior=yInicio;
		Iterator iteradorPuntos=listaPuntos.iterator();
		while (iteradorPuntos.hasNext()) {
			Punto aux=(Punto)iteradorPuntos.next();
			int xNuevo=aux.getX();
			int yNuevo=aux.getY();
			g.drawLine(xAnterior,yAnterior,xNuevo,yNuevo);
			xAnterior=xNuevo;
			yAnterior=yNuevo;
		}
		g.drawLine(xAnterior,yAnterior,xFin,yFin);
		
		int auxX=((xFin-xAnterior)*9)/10;
		int auxY=((yFin-yAnterior)*9)/10;
		int xMedio=xAnterior+auxX;
		int yMedio=yAnterior+auxY;
		int arriba=yMedio+10;
		int abajo=yMedio-10;
		g.drawLine(xMedio, arriba, xFin, yFin);
		g.drawLine(xMedio, abajo, xFin, yFin);
		 
	}

	/* (non-Javadoc)
	 * @see es.ucm.fdi.si.modelo.Elemento#estaDentro(int, int)
	 */
	public boolean estaDentro(int x, int y) {
		// 
		return false;
	}
	
    public String toString() {
        return "Enlace_Estatico "+nodoInicio.toString()+" "+nodoFin.toString();
    	
    }

}
