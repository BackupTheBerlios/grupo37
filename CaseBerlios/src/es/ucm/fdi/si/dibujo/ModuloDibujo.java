/*
 * Created on 27-nov-2004
 *
 */
package es.ucm.fdi.si.dibujo;

import java.util.List;

import es.ucm.fdi.si.modelo.IModelo;
import es.ucm.fdi.si.modelo.ListaElementosContenido;
import es.ucm.fdi.si.modelo.ListaElementosDiseņo;
import es.ucm.fdi.si.modelo.Nodo;
import es.ucm.fdi.si.modelo.Punto;

/**
 * @author Alejandro Blanco, David Curieses Chamon, Oscar Ortega
 *
 * Proyecto Sistemas Informaticos: 
 * 	
 * Herramienta CASE para diseņo y prototipado de aplicaciones hipermedia
 */
public class ModuloDibujo implements IModuloDibujo {
    
    private IModelo modelo; //Deberá desaparecer en realidad
    private FactoriaDibujo factoriaDibujo;
    
    public ModuloDibujo(IModelo modelo) {
        this.modelo=modelo;
        this.factoriaDibujo = new FactoriaDibujo(modelo);
    }
    
    public void setElementoSeleccionadoDiseņo(int x, int y) {
    	factoriaDibujo.getDiseņo().setElementoSeleccionado(x, y);
    }
    
    public void setElementoSeleccionadoDiseņo(String nombre) {
    	factoriaDibujo.getDiseņo().setElementoSeleccionado(nombre);
    }

	public ListaElementosDiseņo getElementosSeleccionadosDiseņo() {
		return factoriaDibujo.getDiseņo().getElementosSeleccionados();
	}
    
    public void setTipoSeleccionadoDiseņo(int tipo) {
        factoriaDibujo.getDiseņo().setTipoSeleccionado(tipo);
    }
    
    public int getTipoSeleccionadoDiseņo() {
        return factoriaDibujo.getDiseņo().getTipoSeleccionado();
    }
    
    public boolean aņadeElementoDiseņo(int tipo, String nombre, Punto puntoInicio, Punto puntoFin){
    	return factoriaDibujo.getDiseņo().aņadeElementoDiseņo(tipo, nombre, puntoInicio, puntoFin);
    }
    
    public boolean aņadeElementoDiseņo(int tipo, String nombre, Nodo nodoInicio, Nodo nodoFin, List listaPuntos, int tiempo) {
    	return factoriaDibujo.getDiseņo().aņadeElementoDiseņo(tipo, nombre, nodoInicio, nodoFin, listaPuntos, tiempo);
	}
   
    public boolean existeElementoDiseņo(String nombre) {
    	return factoriaDibujo.getDiseņo().existeElementoDiseņo(nombre);
    }

    public void actualizaNodo(String nombre, Punto puntoInicio , Punto puntoFin, String nuevoNombre) {
        factoriaDibujo.getDiseņo().actualizaNodo(nombre, puntoInicio, puntoFin, nuevoNombre);
    }
	
    public void setPosXY(int x, int y) {
        factoriaDibujo.getDiseņo().setPosXY(x,y);
    }
    
    public int getActualX() {
        return factoriaDibujo.getDiseņo().getActualX();
    }
    public int getActualY() {
        return factoriaDibujo.getDiseņo().getActualY();
    }
    
    public boolean estaDentro(int x, int y){
    	return factoriaDibujo.getDiseņo().estaDentro(x,y);
    }

	public void deleteElementosDiseņo(ListaElementosDiseņo elementosDiseņo) {
		factoriaDibujo.getDiseņo().deleteElementos(elementosDiseņo);
	}
	
	/* (non-Javadoc)
	 * @see es.ucm.fdi.si.dibujo.IModuloDibujo#getNumElementosDiseņo()
	 */
	public int getNumElementosDiseņo() {
		return factoriaDibujo.getDiseņo().getNumElementosDiseņo();
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

	
	public boolean aņadeElementoContenido(int tipo, String nombre, Nodo nodoInicio, Nodo nodoFin, List listaPuntos) {
		return factoriaDibujo.getContenido().aņadeElementoContenido(tipo, nombre, nodoInicio, nodoFin, listaPuntos);
	}

	
	public boolean aņadeElementoContenido(int tipo, String nombre, Punto puntoInicio, Punto puntoFin) {
		return factoriaDibujo.getContenido().aņadeElementoContenido(tipo, nombre, puntoInicio, puntoFin);
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
	 * @see es.ucm.fdi.si.dibujo.IModuloDibujo#aņadeElementoSeleccionadoDiseņo(int, int)
	 */
	public void aņadeElementoSeleccionadoDiseņo(int posX, int posY) {
		factoriaDibujo.getDiseņo().aņadeElementoSeleccionado(posX, posY);
	}

	/* (non-Javadoc)
	 * @see es.ucm.fdi.si.dibujo.IModuloDibujo#aņadeElementoSeleccionadoContenido(int, int)
	 */
	public void aņadeElementoSeleccionadoContenido(int posX, int posY) {
		factoriaDibujo.getContenido().aņadeElementoSeleccionado(posX, posY);		
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
