/*
 * Created on 28-nov-2004
 *
 */
package es.ucm.fdi.si.modelo;

/**
 * @author Alejandro Blanco, David Curieses Chamon, Oscar Ortega
 *
 * Proyecto Sistemas Informaticos: 
 * 	
 * Herramienta CASE para diseño y prototipado de aplicaciones hipermedia
 */
public class FactoriaElementos {

    public Nexo getNexo(int tipo, String nombre, Punto puntoInicio, Punto puntoFin) {
        return new Nexo(tipo, nombre, puntoInicio, puntoFin);
    }
    public Contenedor getContenedor(int tipo, String nombre, Punto puntoInicio, Punto puntoFin) {
        return new Contenedor(tipo,nombre,puntoInicio, puntoFin);
    }

}
