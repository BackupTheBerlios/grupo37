/*
 * Created on 27-nov-2004
 *
 */
package es.ucm.fdi.si.dibujo;

import java.util.List;

import es.ucm.fdi.si.modelo.IModelo;
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
public class ModuloDibujo implements IModuloDibujo {
    
    private IModelo modelo; //Deber� desaparecer en realidad
    private FactoriaDibujo factoriaDibujo;
    
    public ModuloDibujo(IModelo modelo) {
        this.modelo=modelo;
        this.factoriaDibujo = new FactoriaDibujo(modelo);
    }
    
    public void setElementoSeleccionadoDise�o(int x, int y) {
    	factoriaDibujo.getDise�o().setElementoSeleccionado(x, y);
    }
    
    public void setElementoSeleccionadoDise�o(String nombre) {
    	factoriaDibujo.getDise�o().setElementoSeleccionado(nombre);
    }

	public ListaElementosDise�o getElementosSeleccionadosDise�o() {
		return factoriaDibujo.getDise�o().getElementosSeleccionados();
	}
    
    public void setTipoSeleccionadoDise�o(int tipo) {
        factoriaDibujo.getDise�o().setTipoSeleccionado(tipo);
    }
    
    public int getTipoSeleccionadoDise�o() {
        return factoriaDibujo.getDise�o().getTipoSeleccionado();
    }
    
    public boolean a�adeElementoDise�o(int tipo, String nombre, Punto puntoInicio, Punto puntoFin){
    	return factoriaDibujo.getDise�o().a�adeElementoDise�o(tipo, nombre, puntoInicio, puntoFin);
    }
    
    public boolean a�adeElementoDise�o(int tipo, String nombre, Nodo nodoInicio, Nodo nodoFin, List listaPuntos, int tiempo) {
    	return factoriaDibujo.getDise�o().a�adeElementoDise�o(tipo, nombre, nodoInicio, nodoFin, listaPuntos, tiempo);
	}
   
    public boolean existeElementoDise�o(String nombre) {
    	return factoriaDibujo.getDise�o().existeElementoDise�o(nombre);
    }

    public void actualizaNodo(String nombre, Punto puntoInicio , Punto puntoFin, String nuevoNombre) {
        factoriaDibujo.getDise�o().actualizaNodo(nombre, puntoInicio, puntoFin, nuevoNombre);
    }
	
    public void setPosXY(int x, int y) {
        factoriaDibujo.getDise�o().setPosXY(x,y);
    }
    
    public int getActualX() {
        return factoriaDibujo.getDise�o().getActualX();
    }
    public int getActualY() {
        return factoriaDibujo.getDise�o().getActualY();
    }
    
    public boolean estaDentro(int x, int y){
    	return factoriaDibujo.getDise�o().estaDentro(x,y);
    }

	public void deleteElementosDise�o(ListaElementosDise�o elementosDise�o) {
		factoriaDibujo.getDise�o().deleteElementos(elementosDise�o);
	}
	
	/* (non-Javadoc)
	 * @see es.ucm.fdi.si.dibujo.IModuloDibujo#getNumElementosDise�o()
	 */
	public int getNumElementosDise�o() {
		return factoriaDibujo.getDise�o().getNumElementosDise�o();
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

	
	public boolean a�adeElementoContenido(int tipo, String nombre, Nodo nodoInicio, Nodo nodoFin, List listaPuntos) {
		return factoriaDibujo.getContenido().a�adeElementoContenido(tipo, nombre, nodoInicio, nodoFin, listaPuntos);
	}

	
	public boolean a�adeElementoContenido(int tipo, String nombre, Punto puntoInicio, Punto puntoFin) {
		return factoriaDibujo.getContenido().a�adeElementoContenido(tipo, nombre, puntoInicio, puntoFin);
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
	 * @see es.ucm.fdi.si.dibujo.IModuloDibujo#a�adeElementoSeleccionadoDise�o(int, int)
	 */
	public void a�adeElementoSeleccionadoDise�o(int posX, int posY) {
		factoriaDibujo.getDise�o().a�adeElementoSeleccionado(posX, posY);
	}

	/* (non-Javadoc)
	 * @see es.ucm.fdi.si.dibujo.IModuloDibujo#a�adeElementoSeleccionadoContenido(int, int)
	 */
	public void a�adeElementoSeleccionadoContenido(int posX, int posY) {
		factoriaDibujo.getContenido().a�adeElementoSeleccionado(posX, posY);		
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
