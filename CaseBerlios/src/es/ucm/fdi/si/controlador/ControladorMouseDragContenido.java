/*
 * Created on 05-dic-2004
 *
 */
package es.ucm.fdi.si.controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import es.ucm.fdi.si.ICase;
import es.ucm.fdi.si.modelo.Elemento;
import es.ucm.fdi.si.modelo.Nodo;
import es.ucm.fdi.si.modelo.Punto;
import es.ucm.fdi.si.vista.LienzoDiseño;

/**
 * @author Alejandro Blanco, David Curieses Chamon, Oscar Ortega
 *
 * Proyecto Sistemas Informaticos: 
 * 	
 * Herramienta CASE para diseño y prototipado de aplicaciones hipermedia
 */
public class ControladorMouseDragContenido implements MouseMotionListener {

    private ICase fachada;
    
    
    public ControladorMouseDragContenido(ICase fachada) {
        this.fachada=fachada;
    }
    
    /* (non-Javadoc)
     * @see java.awt.event.MouseMotionListener#mouseDragged(java.awt.event.MouseEvent)
     */
    public void mouseDragged(MouseEvent arg0) {
        
        moverElemento(arg0);
        resizeElemento(arg0);
    }

    //SE encarga de hacer la funcionalidad asociada a mover un elemento
    private void moverElemento(MouseEvent arg0){
    	if (fachada.getTipoSeleccionadoContenido()==Elemento.SELECCION) {
    		// TODO ¿Queremos mover más de un elemento a la vez? 
    		if ((fachada.getElementosSeleccionadosContenido().esVacia())||(fachada.getElementosSeleccionadosContenido().getSize()>1))
    			return;
    		Nodo nodoSel=(Nodo)fachada.getElementosSeleccionadosContenido().getElemento(0);
    		if (nodoSel!=null) {
                int actualX=arg0.getX();
                int actualY=arg0.getY();
                
                if (!fachada.estaDentro((actualX+(nodoSel.getPuntoFin().getX()-actualX)+10), actualY))
                {
                
                int antiguoX=fachada.getActualX();
                int antiguoY=fachada.getActualY();
                
                int difX=actualX-antiguoX;
                int difY=actualY-antiguoY;
            
                //antiguoX=actualX;
                //antiguoY=actualY;
                
                fachada.setPosXY(actualX, actualY);

                Punto puntoInicio=nodoSel.getPuntoInicio();
                Punto puntoFin=nodoSel.getPuntoFin();
                if ( ((puntoInicio.getX()+difX)<0) 
                		|| ((puntoInicio.getY()+difY)<0) 
						|| ((puntoFin.getX()+difX)<0)
						|| ((puntoFin.getY()+difY)<0) 
						|| ((puntoInicio.getX()+difX)>LienzoDiseño.INFINITO_X) 
						|| ((puntoInicio.getY()+difY)>LienzoDiseño.INFINITO_Y) 
						|| ((puntoFin.getX()+difX)>LienzoDiseño.INFINITO_X)
						|| ((puntoFin.getY()+difY)>LienzoDiseño.INFINITO_Y)) {
                	//Estamos fuera de los limites
                	
                } else  { 
                	puntoInicio.setX(puntoInicio.getX()+difX);
                	puntoInicio.setY(puntoInicio.getY()+difY);
            		puntoFin.setX(puntoFin.getX()+difX);
            		puntoFin.setY(puntoFin.getY()+difY);
            		
            		
            		fachada.actualizaNodoContenido(nodoSel.getNombre(), puntoInicio, puntoFin, nodoSel.getNombre());
                }
            	//	TODO Hay q notificar al modelo para que cambie vista
                }
            }
        }
    }
    
    //Se encarga de la funcionalidad de redimensionar un elemento
    private void resizeElemento(MouseEvent arg0){
    	if (fachada.getTipoSeleccionadoContenido() == Elemento.RESIZE){
          	int actualX, actualY;
          	actualX = arg0.getX();
          	actualY = arg0.getY();
            int antiguoX=fachada.getActualX();
            int antiguoY=fachada.getActualY();
            
            int difX=actualX-antiguoX;
            int difY=actualY-antiguoY;
        
            //antiguoX=actualX;
            //antiguoY=actualY;
            // TODO ¿Queremos que se pueda cambiar el tamaño de varios a la vez?
            fachada.setPosXY(actualX, actualY);
            if ((fachada.getElementosSeleccionadosContenido().esVacia())||(fachada.getElementosSeleccionadosContenido().getSize()>1))
            	return;
            Nodo nodoSel = (Nodo)fachada.getElementosSeleccionadosContenido().getElemento(0);
            Punto puntoInicio=nodoSel.getPuntoInicio();
            Punto puntoFin=nodoSel.getPuntoFin();
            puntoFin.setX(puntoFin.getX()+difX);
        	puntoFin.setY(puntoFin.getY()+difY);
        	
        	
        	fachada.actualizaNodoContenido(nodoSel.getNombre(), puntoInicio, puntoFin, nodoSel.getNombre());
        	
          }
    }
    /* (non-Javadoc)
     * @see java.awt.event.MouseMotionListener#mouseMoved(java.awt.event.MouseEvent)
     */
    public void mouseMoved(MouseEvent arg0) {
        // 
        
    }

}