/*
 * Created on 27-nov-2004
 *
 */
package es.ucm.fdi.si.dibujo;

import java.util.List;

import es.ucm.fdi.si.modelo.IModelo;
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
public class ModuloDibujo implements IModuloDibujo {
    
    private IModelo modelo; //Deberá desaparecer en realidad
    private FactoriaDibujo factoriaDibujo;
    
    public ModuloDibujo(IModelo modelo) {
        this.modelo=modelo;
        this.factoriaDibujo = new FactoriaDibujo(modelo);
    }
    
    public void setElementoSeleccionadoDiseño(int x, int y) {
    	factoriaDibujo.getDiseño().setElementoSeleccionado(x, y);
    }
    
    public void setElementoSeleccionadoDiseño(String nombre) {
    	factoriaDibujo.getDiseño().setElementoSeleccionado(nombre);
    }

	public ListaElementosDiseño getElementosSeleccionadosDiseño() {
		return factoriaDibujo.getDiseño().getElementosSeleccionados();
	}
    
    public void setTipoSeleccionadoDiseño(int tipo) {
        factoriaDibujo.getDiseño().setTipoSeleccionado(tipo);
    }
    
    public int getTipoSeleccionadoDiseño() {
        return factoriaDibujo.getDiseño().getTipoSeleccionado();
    }
    
    public boolean añadeElementoDiseño(int tipo, String nombre, Punto puntoInicio, Punto puntoFin){
    	return factoriaDibujo.getDiseño().añadeElementoDiseño(tipo, nombre, puntoInicio, puntoFin);
    }
    
    public boolean añadeElementoDiseño(int tipo, String nombre, Nodo nodoInicio, Nodo nodoFin, List listaPuntos, int tiempo) {
    	return factoriaDibujo.getDiseño().añadeElementoDiseño(tipo, nombre, nodoInicio, nodoFin, listaPuntos, tiempo);
	}
   
    public boolean existeElementoDiseño(String nombre) {
    	return factoriaDibujo.getDiseño().existeElementoDiseño(nombre);
    }

    public void actualizaNodo(String nombre, Punto puntoInicio , Punto puntoFin, String nuevoNombre) {
        factoriaDibujo.getDiseño().actualizaNodo(nombre, puntoInicio, puntoFin, nuevoNombre);
    }
	
    public void setPosXY(int x, int y) {
        factoriaDibujo.getDiseño().setPosXY(x,y);
    }
    
    public int getActualX() {
        return factoriaDibujo.getDiseño().getActualX();
    }
    public int getActualY() {
        return factoriaDibujo.getDiseño().getActualY();
    }
    
    public boolean estaDentro(int x, int y){
    	return factoriaDibujo.getDiseño().estaDentro(x,y);
    }

	public void deleteElementosDiseño(ListaElementosDiseño elementosDiseño) {
		factoriaDibujo.getDiseño().deleteElementos(elementosDiseño);
	}
	
	/* (non-Javadoc)
	 * @see es.ucm.fdi.si.dibujo.IModuloDibujo#getNumElementosDiseño()
	 */
	public int getNumElementosDiseño() {
		return factoriaDibujo.getDiseño().getNumElementosDiseño();
	}

	/* Contenido
	 */
	public int getTipoSeleccionadoContenido() {
		return factoriaDibujo.getContenido().getTipoSeleccionadoContenido();
	}

	/* (non-Javadoc)
	 * @see es.ucm.fdi.si.dibujo.IModuloDibujo#setTipoSeleccionadoContenido(int)
	 */
	public void setTipoSeleccionadoContenido(int tipoSeleccionadoContenido) {
		factoriaDibujo.getContenido().setTipoSeleccionadoContenido(tipoSeleccionadoContenido);
		
	}

	/* (non-Javadoc)
	 * @see es.ucm.fdi.si.dibujo.IModuloDibujo#getElementoSeleccionadoContenido()
	 */
	public ListaElementosContenido getElementosSeleccionadosContenido() {
		return factoriaDibujo.getContenido().getElementosSeleccionados();
	}

	
	public boolean añadeElementoContenido(int tipo, String nombre, Nodo nodoInicio, Nodo nodoFin, List listaPuntos) {
		return factoriaDibujo.getContenido().añadeElementoContenido(tipo, nombre, nodoInicio, nodoFin, listaPuntos);
	}

	
	public boolean añadeElementoContenido(int tipo, String nombre, Punto puntoInicio, Punto puntoFin) {
		return factoriaDibujo.getContenido().añadeElementoContenido(tipo, nombre, puntoInicio, puntoFin);
	}

	/* (non-Javadoc)
	 * @see es.ucm.fdi.si.dibujo.IModuloDibujo#setElementoSeleccionadoContenido(int, int)
	 */
	public void setElementoSeleccionadoContenido(int x, int y) {
		factoriaDibujo.getContenido().setElementoSeleccionado(x, y);
		
	}

	/* (non-Javadoc)
	 * @see es.ucm.fdi.si.dibujo.IModuloDibujo#setPulsadoControl(boolean)
	 */
	public void setPulsadoControl(boolean b) {
		modelo.setPulsadoControl(b);
	}

	/* (non-Javadoc)
	 * @see es.ucm.fdi.si.dibujo.IModuloDibujo#isPulsadoControl()
	 */
	public boolean isPulsadoControl() {
		return modelo.isPulsadoControl();
	}

	/* (non-Javadoc)
	 * @see es.ucm.fdi.si.dibujo.IModuloDibujo#añadeElementoSeleccionadoDiseño(int, int)
	 */
	public void añadeElementoSeleccionadoDiseño(int posX, int posY) {
		factoriaDibujo.getDiseño().añadeElementoSeleccionado(posX, posY);
	}

	/* (non-Javadoc)
	 * @see es.ucm.fdi.si.dibujo.IModuloDibujo#añadeElementoSeleccionadoContenido(int, int)
	 */
	public void añadeElementoSeleccionadoContenido(int posX, int posY) {
		factoriaDibujo.getContenido().añadeElementoSeleccionado(posX, posY);		
	}

	/* (non-Javadoc)
	 * @see es.ucm.fdi.si.dibujo.IModuloDibujo#deleteElementosContenido(es.ucm.fdi.si.modelo.ListaElementosContenido)
	 */
	public void deleteElementosContenido(ListaElementosContenido elementos) {
		factoriaDibujo.getContenido().deleteElementos(elementos);		
	}

	/* (non-Javadoc)
	 * @see es.ucm.fdi.si.dibujo.IModuloDibujo#getNumElementosContenido()
	 */
	public int getNumElementosContenido() {
		return factoriaDibujo.getContenido().getNumElementosContenido();
	}

	/* (non-Javadoc)
	 * @see es.ucm.fdi.si.dibujo.IModuloDibujo#existeElementoContenido(java.lang.String)
	 */
	public boolean existeElementoContenido(String nombre) {
		return factoriaDibujo.getContenido().existeElementoContenido(nombre);
	}

	/* (non-Javadoc)
	 * @see es.ucm.fdi.si.dibujo.IModuloDibujo#actualizaNodoContenido(java.lang.String, es.ucm.fdi.si.modelo.Punto, es.ucm.fdi.si.modelo.Punto, java.lang.String)
	 */
	public void actualizaNodoContenido(String nombre, Punto puntoInicio, Punto puntoFin, String nuevoNombre) {
		factoriaDibujo.getContenido().actualizaNodoContenido(nombre, puntoInicio, puntoFin, nuevoNombre);
		
	}

	
}
