/*
 * Created on 28-nov-2004
 *
 */
package es.ucm.fdi.si.vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

import es.ucm.fdi.si.controlador.FactoriaControladores;
import es.ucm.fdi.si.modelo.Elemento;
import es.ucm.fdi.si.modelo.ListaElementosContenido;
import es.ucm.fdi.si.modelo.Modelo;

/**
 * @author Alejandro Blanco, David Curieses Chamon, Oscar Ortega
 *
 * Proyecto Sistemas Informaticos: 
 * 	
 * Herramienta CASE para diseño y prototipado de aplicaciones hipermedia
 */
public class PizarraContenido extends JPanel implements Observer, FocusListener {
    
    private FactoriaControladores factoriaControladores;
    private Modelo modelo;
    
    public PizarraContenido(FactoriaControladores factoriaControladores) {
        this.factoriaControladores=factoriaControladores;
        this.addMouseListener(factoriaControladores.getControladorMouseListenerContenido(this));
        this.addMouseMotionListener(factoriaControladores.getControladorMouseDragContenido());
        this.addKeyListener(factoriaControladores.getControladorTeclado());
    }

    /* (non-Javadoc)
     * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
     */
    public void update(Observable arg0, Object arg1) {
        this.modelo=(Modelo)arg0;
        repaint();
    }
    
    protected void paintComponent( Graphics g ) {
        super.paintComponent(g);
        if (modelo!=null) {
            ListaElementosContenido listaElementosContenido=modelo.getListaElementosContenido();
            Iterator iterador=listaElementosContenido.getLista().iterator();
            while (iterador.hasNext()) {
                Elemento elemento=(Elemento)iterador.next();
                if (modelo.getElementosSeleccionadosContenido().contiene(elemento))
                	g.setColor(Color.RED);
    	  	    else g.setColor(Color.BLACK);
                elemento.pintate(g);
            }
        }
    }

	/* (non-Javadoc)
	 * @see java.awt.event.FocusListener#focusGained(java.awt.event.FocusEvent)
	 */
	public void focusGained(FocusEvent arg0) {
		System.out.println("Se gano el foco");		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.FocusListener#focusLost(java.awt.event.FocusEvent)
	 */
	public void focusLost(FocusEvent arg0) {
		System.out.println("Se perdio el foco");		
	}
	
	public boolean isFocusable()  {
		return true;
	}
	
}
