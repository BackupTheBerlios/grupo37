/*
 * Created on 27-nov-2004
 *
 */
package es.ucm.fdi.si.persistencia;

import es.ucm.fdi.si.modelo.IModelo;

/**
 * @author Alejandro Blanco, David Curieses Chamon, Oscar Ortega
 *
 * Proyecto Sistemas Informaticos: 
 * 	
 * Herramienta CASE para diseño y prototipado de aplicaciones hipermedia
 */
public class ModuloPersistencia implements IModuloPersistencia{
    
    private IModelo modelo;
    
    public ModuloPersistencia(IModelo modelo) {
        this.modelo=modelo;
    }

}
