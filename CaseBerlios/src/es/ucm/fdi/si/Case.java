/*
 * Created on 27-nov-2004
 *
 */
package es.ucm.fdi.si;

import java.util.List;
import es.ucm.fdi.si.modelo.ListaElementosContenido;
import es.ucm.fdi.si.modelo.ListaElementosDiseño;
import es.ucm.fdi.si.modelo.Nodo;
import es.ucm.fdi.si.modelo.Punto;


/**
 * @author Alejandro Blanco, David Curieses Chamon, Oscar Ortega
 *
 * Proyecto Sistemas Informaticos: 
 * 	
 * Herramienta CASE para diseño y prototipado de aplicaciones hipermedia
 */
public class Case implements ICase {
    
    private FactoriaModulos factoriaModulos;
    
    public Case(FactoriaModulos factoriaModulos) {
        this.factoriaModulos=factoriaModulos;
        
    }

    public void setElementoSeleccionadoDiseño(int x, int y) {
        factoriaModulos.getModuloDibujo().setElementoSeleccionadoDiseño(x, y);
    }
    
    public void setElementoSeleccionadoDiseño(String nombre) {
		factoriaModulos.getModuloDibujo().setElementoSeleccionadoDiseño(nombre);
		
	}
    
    public ListaElementosDiseño getElementosSeleccionadosDiseño() {
    	return factoriaModulos.getModuloDibujo().getElementosSeleccionadosDiseño();
    }
    
    public void setTipoSeleccionadoDiseño(int tipo) {
        factoriaModulos.getModuloDibujo().setTipoSeleccionadoDiseño(tipo);
    }

    public int getTipoSeleccionadoDiseño() {
        return factoriaModulos.getModuloDibujo().getTipoSeleccionadoDiseño();
    }
    
    public boolean existeElementoDiseño(String nombre) {
    	return factoriaModulos.getModuloDibujo().existeElementoDiseño(nombre);
    }
    
    public boolean añadeElementoDiseño(int tipo, String nombre, Punto puntoInicio, Punto puntoFin) {
        return factoriaModulos.getModuloDibujo().añadeElementoDiseño(tipo, nombre, puntoInicio, puntoFin);
    }

	
	public boolean añadeElementoDiseño(int tipo, String nombre, Nodo nodoInicio, Nodo nodoFin, List listaPuntos, int tiempo) {
		return factoriaModulos.getModuloDibujo().añadeElementoDiseño(tipo, nombre, nodoInicio, nodoFin, listaPuntos, tiempo);
		
	}
	
	public void actualizaNodoDiseño(String nombre, Punto puntoInicio , Punto puntoFin, String nuevoNombre) {
	    factoriaModulos.getModuloDibujo().actualizaNodo(nombre, puntoInicio, puntoFin, nuevoNombre);
	}
    
	public void setPosXY(int x, int y) {
	    factoriaModulos.getModuloDibujo().setPosXY(x,y);
	}
	
    public int getActualX() {
        return factoriaModulos.getModuloDibujo().getActualX();
    }
    
    public int getActualY() {
        return factoriaModulos.getModuloDibujo().getActualY();
    }

	
	
   
    public boolean estaDentro(int x, int y){
    	return factoriaModulos.getModuloDibujo().estaDentro(x,y);
    }

	public void deleteElementosDiseño(ListaElementosDiseño elementos) {
		factoriaModulos.getModuloDibujo().deleteElementosDiseño(elementos);
	}

	/* Contenido
	 */
	public int getTipoSeleccionadoContenido() {
		return factoriaModulos.getModuloDibujo().getTipoSeleccionadoContenido();
	}

	public void setTipoSeleccionadoContenido(int tipoSeleccionadoContenido) {
		factoriaModulos.getModuloDibujo().setTipoSeleccionadoContenido(tipoSeleccionadoContenido);
	}

	public ListaElementosContenido getElementosSeleccionadosContenido() {
		return factoriaModulos.getModuloDibujo().getElementosSeleccionadosContenido();
	}

	public void setElementoSeleccionadoContenido(int posX, int posY) {
		factoriaModulos.getModuloDibujo().setElementoSeleccionadoContenido(posX, posY);
		
	}

	/* (non-Javadoc)
	 * @see es.ucm.fdi.si.ICase#añadeElementoContenido(int, java.lang.String, es.ucm.fdi.si.modelo.Nodo, es.ucm.fdi.si.modelo.Nodo, java.util.List, int)
	 */
	public boolean añadeElementoContenido(int tipo, String nombre, Nodo nodoInicio, Nodo nodoFin, List listaPuntos) {
		return factoriaModulos.getModuloDibujo().añadeElementoContenido(tipo, nombre, nodoInicio, nodoFin, listaPuntos);
	}

	/* (non-Javadoc)
	 * @see es.ucm.fdi.si.ICase#añadeElementoContenido(int, java.lang.String, es.ucm.fdi.si.modelo.Punto, es.ucm.fdi.si.modelo.Punto)
	 */
	public boolean añadeElementoContenido(int tipo, String nombre, Punto puntoInicio, Punto puntoFin) {
		return factoriaModulos.getModuloDibujo().añadeElementoContenido(tipo, nombre, puntoInicio, puntoFin);
	}

	/* (non-Javadoc)
	 * @see es.ucm.fdi.si.ICase#setPulsadoControl(boolean)
	 */
	public void setPulsadoControl(boolean b) {
		factoriaModulos.getModuloDibujo().setPulsadoControl(b);
		
	}

	/* (non-Javadoc)
	 * @see es.ucm.fdi.si.ICase#isPulsadoControl()
	 */
	public boolean isPulsadoControl() {
		return factoriaModulos.getModuloDibujo().isPulsadoControl();
	}

	/* (non-Javadoc)
	 * @see es.ucm.fdi.si.ICase#añadirElementoSeleccionado(int, int)
	 */
	public void añadirElementoSeleccionado(int posX, int posY) {
		factoriaModulos.getModuloDibujo().añadeElementoSeleccionadoDiseño(posX, posY);
	}

	/* (non-Javadoc)
	 * @see es.ucm.fdi.si.ICase#añadirElementoSeleccionadoContenido(int, int)
	 */
	public void añadirElementoSeleccionadoContenido(int posX, int posY) {
		factoriaModulos.getModuloDibujo().añadeElementoSeleccionadoContenido(posX, posY);
		
	}

	/* (non-Javadoc)
	 * @see es.ucm.fdi.si.ICase#deleteElementoContenido(es.ucm.fdi.si.modelo.ListaElementosContenido)
	 */
	public void deleteElementoContenido(ListaElementosContenido elementos) {
		factoriaModulos.getModuloDibujo().deleteElementosContenido(elementos);
		
	}

	/* (non-Javadoc)
	 * @see es.ucm.fdi.si.ICase#getNumElementosDiseño()
	 */
	public int getNumElementosDiseño(){
		return factoriaModulos.getModuloDibujo().getNumElementosDiseño();
	}

	/* (non-Javadoc)
	 * @see es.ucm.fdi.si.ICase#getNumElementosContenido()
	 */
	public int getNumElementosContenido() {
		return factoriaModulos.getModuloDibujo().getNumElementosContenido();
	}

	/* (non-Javadoc)
	 * @see es.ucm.fdi.si.ICase#existeElementoContenido(java.lang.String)
	 */
	public boolean existeElementoContenido(String nombre) {
		return factoriaModulos.getModuloDibujo().existeElementoContenido(nombre);
	}

	
	public void actualizaNodoContenido(String nombre, Punto puntoInicio, Punto puntoFin, String nuevoNombre) {
		factoriaModulos.getModuloDibujo().actualizaNodoContenido(nombre,puntoInicio,puntoFin,nuevoNombre);
	}

}
