/*
 * Created on 27-nov-2004
 *
 */
package es.ucm.fdi.si.controlador;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.event.TableModelListener;
import javax.swing.event.TreeSelectionListener;

import es.ucm.fdi.si.ICase;
import es.ucm.fdi.si.vista.PizarraContenido;
import es.ucm.fdi.si.vista.PizarraDise�o;

/**
 * @author Alejandro Blanco, David Curieses Chamon, Oscar Ortega
 *
 * Proyecto Sistemas Informaticos: 
 * 	
 * Herramienta CASE para dise�o y prototipado de aplicaciones hipermedia
 */
public class FactoriaControladores {
    private ICase fachada;
    
    private ControladorTeclado controladorTeclado;
    
    public FactoriaControladores(ICase fachada) {
        this.fachada=fachada;
    }
    
    public ActionListener getControladorNexo() {
        return new ControladorNexo(fachada);
    }
    public ActionListener getControladorContenedor() {
        return new ControladorContenedor(fachada);
    }
    public ActionListener getControladorActivadorNexo() {
        return new ControladorActivadorNexo(fachada);
    }
    public ActionListener getControladorConexion() {
        return new ControladorConexion(fachada);
    }
    public ActionListener getControladorEnlace() {
        return new ControladorEnlace(fachada);
    }
    public ActionListener getControladorConexionSinco() {
        return new ControladorConexionSincro(fachada);
    }
    public ActionListener getControladorEnlaceSincro() {
        return new ControladorEnlaceSincro(fachada);
    }
    
    public ActionListener getControladorSeleccion() {
        return new ControladorSeleccionDise�o(fachada);
    }
    
    public MouseListener getControladorMouseListenerDise�o(PizarraDise�o pizarraDise�o) {
        return new ControladorMouseListenerDise�o(fachada, pizarraDise�o);
    }
    
    public MouseListener getControladorMouseListenerContenido(PizarraContenido pizarraContenido) {
        return new ControladorMouseListenerContenido(fachada, pizarraContenido);
    }
    
    public TableModelListener getControladorTableModel(){
    	return new ControladorTableModel(fachada);
    }
    
    public MouseMotionListener getControladorMouseDragDise�o() {
        return new ControladorMouseDragDise�o(fachada);
    }
    
    public MouseMotionListener getControladorMouseDragContenido() {
        return new ControladorMouseDragContenido(fachada);
    }
    
    public TreeSelectionListener getControladorArbolDise�o() {
    	return new ControladorArbolDise�o(fachada);
    }
    
    public KeyListener getControladorTeclado(){
    	if (controladorTeclado==null)
    		controladorTeclado=new ControladorTeclado(fachada);
    	return controladorTeclado;
    }
    
    public ActionListener getControladorDelete(){
    	return new ControladorDeleteDise�o(fachada);
    }
    
    public ActionListener getControladorDeleteContenido(){
    	return new ControladorDeleteContenido(fachada);
    }
    
    // Contenido
    public ActionListener getControladorContenidoEstaticoGrande() {
    	return new ControladorContenidoEstaticoGrande(fachada);
    }
    
    public ActionListener getControladorContenidoDinamicoPeque�o() {
    	return new ControladorContenidoDinamicoPeque�o(fachada);
    }
    
    public ActionListener getControladorContenidoEstaticoPeque�o() {
    	return new ControladorContenidoEstaticoPeque�o(fachada);
    }
    
    public ActionListener getControladorContenidoDinamicoGrande() {
    	return new ControladorContenidoDinamicoGrande(fachada);
    }

    public ActionListener getControladorAnclaDinamica() {
    	return new ControladorAnclaDinamica(fachada);
    }

    public ActionListener getControladorAnclaEstatica() {
    	return new ControladorAnclaEstatica(fachada);
    }

    public ActionListener getControladorEnlaceEstatico() {
    	return new ControladorEnlaceEstatico(fachada);
    }

    public ActionListener getControladorEnlaceEstaticoNArio() {
    	return new ControladorEnlaceEstaticoNArio(fachada);
    }
    
    public ActionListener getControladorEnlaceDinamico() {
    	return new ControladorEnlaceDinamico(fachada);
    }

    public ActionListener getControladorEnlaceDinamicoNArio() {
    	return new ControladorEnlaceDinamicoNArio(fachada);
    }

	public ActionListener getControladorSeleccionContenido() {
		return new ControladorSeleccionContenido(fachada);
	}
    
}
