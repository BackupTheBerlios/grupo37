/*
 * Created on 27-nov-2004
 *
 */
package es.ucm.fdi.si;

import java.util.List;
import es.ucm.fdi.si.modelo.ListaElementosContenido;
import es.ucm.fdi.si.modelo.ListaElementosDise�o;
import es.ucm.fdi.si.modelo.Nodo;
import es.ucm.fdi.si.modelo.Punto;


/**
 * @author Alejandro Blanco, David Curieses Chamon, Oscar Ortega
 *
 * Proyecto Sistemas Informaticos: 
 * 	
 * Herramienta CASE para dise�o y prototipado de aplicaciones hipermedia
 */
public class Case implements ICase {
    
    private FactoriaModulos factoriaModulos;
    
    public Case(FactoriaModulos factoriaModulos) {
        this.factoriaModulos=factoriaModulos;
        
    }

    public void setElementoSeleccionadoDise�o(int x, int y) {
        factoriaModulos.getModuloDibujo().setElementoSeleccionadoDise�o(x, y);
    }
    
    public void setElementoSeleccionadoDise�o(String nombre) {
		factoriaModulos.getModuloDibujo().setElementoSeleccionadoDise�o(nombre);
		
	}
    
    public ListaElementosDise�o getElementosSeleccionadosDise�o() {
    	return factoriaModulos.getModuloDibujo().getElementosSeleccionadosDise�o();
    }
    
    public void setTipoSeleccionadoDise�o(int tipo) {
        factoriaModulos.getModuloDibujo().setTipoSeleccionadoDise�o(tipo);
    }

    public int getTipoSeleccionadoDise�o() {
        return factoriaModulos.getModuloDibujo().getTipoSeleccionadoDise�o();
    }
    
    public boolean existeElementoDise�o(String nombre) {
    	return factoriaModulos.getModuloDibujo().existeElementoDise�o(nombre);
    }
    
    public boolean a�adeElementoDise�o(int tipo, String nombre, Punto puntoInicio, Punto puntoFin) {
        return factoriaModulos.getModuloDibujo().a�adeElementoDise�o(tipo, nombre, puntoInicio, puntoFin);
    }

	
	public boolean a�adeElementoDise�o(int tipo, String nombre, Nodo nodoInicio, Nodo nodoFin, List listaPuntos, int tiempo) {
		return factoriaModulos.getModuloDibujo().a�adeElementoDise�o(tipo, nombre, nodoInicio, nodoFin, listaPuntos, tiempo);
		
	}
	
	public void actualizaNodoDise�o(String nombre, Punto puntoInicio , Punto puntoFin, String nuevoNombre) {
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

	public void deleteElementosDise�o(ListaElementosDise�o elementos) {
		factoriaModulos.getModuloDibujo().deleteElementosDise�o(elementos);
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
	 * @see es.ucm.fdi.si.ICase#a�adeElementoContenido(int, java.lang.String, es.ucm.fdi.si.modelo.Nodo, es.ucm.fdi.si.modelo.Nodo, java.util.List, int)
	 */
	public boolean a�adeElementoContenido(int tipo, String nombre, Nodo nodoInicio, Nodo nodoFin, List listaPuntos) {
		return factoriaModulos.getModuloDibujo().a�adeElementoContenido(tipo, nombre, nodoInicio, nodoFin, listaPuntos);
	}

	/* (non-Javadoc)
	 * @see es.ucm.fdi.si.ICase#a�adeElementoContenido(int, java.lang.String, es.ucm.fdi.si.modelo.Punto, es.ucm.fdi.si.modelo.Punto)
	 */
	public boolean a�adeElementoContenido(int tipo, String nombre, Punto puntoInicio, Punto puntoFin) {
		return factoriaModulos.getModuloDibujo().a�adeElementoContenido(tipo, nombre, puntoInicio, puntoFin);
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
	 * @see es.ucm.fdi.si.ICase#a�adirElementoSeleccionado(int, int)
	 */
	public void a�adirElementoSeleccionado(int posX, int posY) {
		factoriaModulos.getModuloDibujo().a�adeElementoSeleccionadoDise�o(posX, posY);
	}

	/* (non-Javadoc)
	 * @see es.ucm.fdi.si.ICase#a�adirElementoSeleccionadoContenido(int, int)
	 */
	public void a�adirElementoSeleccionadoContenido(int posX, int posY) {
		factoriaModulos.getModuloDibujo().a�adeElementoSeleccionadoContenido(posX, posY);
		
	}

	/* (non-Javadoc)
	 * @see es.ucm.fdi.si.ICase#deleteElementoContenido(es.ucm.fdi.si.modelo.ListaElementosContenido)
	 */
	public void deleteElementoContenido(ListaElementosContenido elementos) {
		factoriaModulos.getModuloDibujo().deleteElementosContenido(elementos);
		
	}

	/* (non-Javadoc)
	 * @see es.ucm.fdi.si.ICase#getNumElementosDise�o()
	 */
	public int getNumElementosDise�o(){
		return factoriaModulos.getModuloDibujo().getNumElementosDise�o();
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
