/*
 * Created on 04-dic-2004
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
package es.ucm.fdi.si.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import es.ucm.fdi.si.ICase;
import es.ucm.fdi.si.modelo.Elemento;

/**
 * @author Alejandro Blanco, David Curieses Chamon, Oscar Ortega
 *
 * Proyecto Sistemas Informaticos: 
 * 	
 * Herramienta CASE para diseño y prototipado de aplicaciones hipermedia
 */
public class ControladorSeleccionContenido implements ActionListener {
    private ICase fachada;
    
    public ControladorSeleccionContenido(ICase fachada) {
        this.fachada=fachada;
    }
    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    public void actionPerformed(ActionEvent arg0) {
        fachada.setTipoSeleccionadoContenido(Elemento.SELECCION);
    }

}
