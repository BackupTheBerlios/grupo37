/*
 * Created on 03-dic-2004
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
package es.ucm.fdi.si.dibujo;

import es.ucm.fdi.si.modelo.IModelo;


/**
 * @author Alejandro Blanco, David Curieses, Oscar Ortega
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class FactoriaDibujo {
	
	private IModelo modelo;
	private Dise�o dise�o;
	private Contenido contenido;
	
	public FactoriaDibujo(IModelo modelo) {
		this.modelo=modelo;
		dise�o=new Dise�o(modelo);
		contenido=new Contenido(modelo);
	}

	public Dise�o getDise�o() {
		return dise�o;
	}
	
	public Contenido getContenido() {
		return contenido;
	}
	
}
