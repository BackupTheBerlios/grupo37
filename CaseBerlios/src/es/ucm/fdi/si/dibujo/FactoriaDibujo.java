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
	private Diseño diseño;
	private Contenido contenido;
	
	public FactoriaDibujo(IModelo modelo) {
		this.modelo=modelo;
		diseño=new Diseño(modelo);
		contenido=new Contenido(modelo);
	}

	public Diseño getDiseño() {
		return diseño;
	}
	
	public Contenido getContenido() {
		return contenido;
	}
	
}
