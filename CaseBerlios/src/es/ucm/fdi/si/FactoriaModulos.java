/*
 * Created on 27-nov-2004
 *
 */
package es.ucm.fdi.si;

import es.ucm.fdi.si.dibujo.IModuloDibujo;
import es.ucm.fdi.si.dibujo.ModuloDibujo;
import es.ucm.fdi.si.modelo.IModelo;
import es.ucm.fdi.si.persistencia.IModuloPersistencia;
import es.ucm.fdi.si.persistencia.ModuloPersistencia;
import es.ucm.fdi.si.prototipado.IModuloPrototipado;
import es.ucm.fdi.si.prototipado.ModuloPrototipado;

/**
 * @author Alejandro Blanco, David Curieses Chamon, Oscar Ortega
 *
 * Proyecto Sistemas Informaticos: 
 * 	
 * Herramienta CASE para diseño y prototipado de aplicaciones hipermedia
 */
public class FactoriaModulos {
    
    private IModelo modelo;
    private IModuloDibujo moduloDibujo;
    private IModuloPersistencia moduloPersistencia;
    private IModuloPrototipado moduloPrototipado;
    
    public FactoriaModulos(IModelo modelo) {
        this.modelo=modelo;
        moduloDibujo= new ModuloDibujo(modelo);
        moduloPersistencia = new ModuloPersistencia(modelo);
        moduloPrototipado = new ModuloPrototipado(modelo);
    }
    
    public IModuloDibujo getModuloDibujo() {
        return moduloDibujo;
    }

}