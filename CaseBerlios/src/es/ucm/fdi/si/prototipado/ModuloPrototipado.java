/*
 * Created on 27-nov-2004
 *
 */
package es.ucm.fdi.si.prototipado;

import es.ucm.fdi.si.modelo.IModelo;

/**
 * @author Alejandro Blanco, David Curieses Chamon, Oscar Ortega
 *
 * Proyecto Sistemas Informaticos: 
 * 	
 * Herramienta CASE para diseño y prototipado de aplicaciones hipermedia
 */
public class ModuloPrototipado implements IModuloPrototipado {
    
    private IModelo modelo;
    
    public ModuloPrototipado(IModelo modelo) {
        this.modelo=modelo;
    }
}
