/*
 * Created on 27-nov-2004
 *
 */
package es.ucm.fdi.si;

import es.ucm.fdi.si.controlador.FactoriaControladores;
import es.ucm.fdi.si.modelo.Modelo;
import es.ucm.fdi.si.vista.Vista;

/**
 * @author Alejandro Blanco, David Curieses Chamon, Oscar Ortega
 *
 * Proyecto Sistemas Informaticos: 
 * 	
 * Herramienta CASE para diseño y prototipado de aplicaciones hipermedia
 */
public class Principal {
    public static void main(String[] args) {
        Modelo modelo=new Modelo();
        FactoriaModulos factoriaModulos=new FactoriaModulos(modelo);
        ICase fachada=new Case(factoriaModulos);
        FactoriaControladores factoriaControladores=new FactoriaControladores(fachada);
        Vista vista=new Vista(factoriaControladores,fachada);
        modelo.addObserver(vista);
        modelo.iniciar();
    }
}
