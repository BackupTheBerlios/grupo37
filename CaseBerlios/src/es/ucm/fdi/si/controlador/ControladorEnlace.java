/*
 * Created on 28-nov-2004
 *
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
public class ControladorEnlace implements ActionListener {
    private ICase fachada;
    
    public ControladorEnlace(ICase fachada) {
        this.fachada=fachada;
    }

    /* (non-Javadoc)
     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
     */
    public void actionPerformed(ActionEvent arg0) {
        fachada.setTipoSeleccionadoDiseño(Elemento.ENLACE);
        
    }
}
