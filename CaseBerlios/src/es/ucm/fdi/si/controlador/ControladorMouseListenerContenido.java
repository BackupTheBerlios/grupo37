/*
 * Created on 28-nov-2004
 *
 */
package es.ucm.fdi.si.controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Cursor;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

import es.ucm.fdi.si.ICase;
import es.ucm.fdi.si.modelo.Nodo;
import es.ucm.fdi.si.modelo.Punto;
import es.ucm.fdi.si.modelo.Elemento;
import es.ucm.fdi.si.vista.PizarraContenido;

/**
 * @author Alejandro Blanco, David Curieses Chamon, Oscar Ortega
 *
 * Proyecto Sistemas Informaticos: 
 * 	
 * Herramienta CASE para diseño y prototipado de aplicaciones hipermedia
 */
public class ControladorMouseListenerContenido implements MouseListener {

    private ICase fachada;
    private Nodo nodoInicio;
    private Nodo nodoFin;
    private String nombre;
	private static final int incrementoX = 20;
	private static final int incrementoY = 20;
	
	private boolean seleccionadoOrigen=false;
	private List listaPuntos=new LinkedList();
	
	private IntroducirNombre dialogo;
	
	PizarraContenido pizarraContenido;
	
	/** Este booleano nos indicara si estamos pintando una relacion, cuando se hace
	 * click en un elemento se acabará la creación de la relación
	 */
    
    public ControladorMouseListenerContenido(ICase fachada, PizarraContenido pizarraContenido) {
        this.fachada=fachada;
        this.pizarraContenido=pizarraContenido;
        this.dialogo= new IntroducirNombre("Contenido",fachada);
    }
    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
     */
    public void mouseClicked(MouseEvent arg0) {
        
    }

    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
     */
    public void mousePressed(MouseEvent arg0) {
    	if (seleccionadoOrigen)
    		return;
        if(fachada.getTipoSeleccionadoContenido() != Elemento.NINGUNO){
       	int posX=arg0.getX();
        int posY=arg0.getY();
        fachada.setPosXY(posX, posY);
        if(fachada.getTipoSeleccionadoContenido() != Elemento.SELECCION){
	    	Punto puntoInicio=new Punto(posX, posY);
	        Punto puntoFin=new Punto(posX+incrementoX, posY+incrementoY);
	        //Solicitamos el nombre al usuario
	        if (fachada.getTipoSeleccionadoContenido()<= Elemento.ANCLA_DINAMICA){
	        	nombre = solicitarNombre();
		        if (nombre == null) return;
	        	//Añadimos el elemento a pintar en la lista correspondiente
	        	if (!fachada.añadeElementoContenido(fachada.getTipoSeleccionadoContenido(),nombre,puntoInicio,puntoFin))
	        		JOptionPane.showMessageDialog(null,"No se puede pintar un elemento dentro de otro","ERROR FATAL",JOptionPane.ERROR_MESSAGE);
	        	nombre = new String();
	        	fachada.setTipoSeleccionadoContenido(Elemento.SELECCION);
	        }
	        else { //Se presiona sobre nodo con modo crear enlace
	        	 fachada.setElementoSeleccionadoContenido(posX,posY);
	        	 //Al usarse el set solo se va a haber un elemento
	        	 nodoInicio = (Nodo)fachada.getElementosSeleccionadosContenido().getElemento(0);
	        	 seleccionadoOrigen=true;
	        	 }
	        
       	}
       	else{
       		//SELECCIONAMOS UN ELEMENTO
       		if (fachada.isPulsadoControl()) {
       			System.out.println("Estaba pulsado control");
       			fachada.añadirElementoSeleccionadoContenido(posX, posY);
       		} else {  			
       			System.out.println("NO estaba pulsado control");
       			fachada.setElementoSeleccionadoContenido(posX, posY);
       		}
       		
       	}
       }
       
       if(fachada.getTipoSeleccionadoContenido() == Elemento.SELECCION){
       	//El usuario pulsa el boton derecho
       	if(arg0.getButton() == 3){
       		//TODO Comprobar si esto esta bien hecho desde la filofia de MVC
       		((PizarraContenido)arg0.getSource()).setCursor(new Cursor(Cursor.SE_RESIZE_CURSOR));
       		fachada.setTipoSeleccionadoContenido(Elemento.RESIZE);
       	}
       	
       }
    }

    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
     */
    public void mouseReleased(MouseEvent arg0) {
    	
    	if (fachada.getTipoSeleccionadoContenido() == Elemento.RESIZE){
    		//TODO Comprobar si esto viola el patron MVC
    		((PizarraContenido)arg0.getSource()).setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    		fachada.setTipoSeleccionadoContenido(Elemento.SELECCION);
    	}	
        if (fachada.getTipoSeleccionadoContenido() >= Elemento.ENLACE_ESTATICO){
        	int posX = arg0.getX();
        	int posY = arg0.getY();
        	fachada.setElementoSeleccionadoContenido(posX, posY);
        	//Al usar el setElementoSeleccionadoDiseño siempre va a haber un unico elemento seleccionado
        	if (fachada.getElementosSeleccionadosContenido().esVacia())
        		nodoFin = null;
        	else
        		nodoFin = (Nodo)fachada.getElementosSeleccionadosContenido().getElemento(0);
        	// En principio nunca va a pasar, pero siempre es bueno tener un por si acaso
        	if (nodoInicio == null){
        		JOptionPane.showMessageDialog(null,"No esta definido el origen","ERROR FATAL",JOptionPane.ERROR_MESSAGE);
        		return;
        	} 
        	if (nodoFin == null){
        		//JOptionPane.showMessageDialog(null,"No esta definido el destino","ERROR FATAL",JOptionPane.ERROR_MESSAGE);
        		listaPuntos.add(new Punto(posX, posY));
        		return;
        	} 
        	if (nodoInicio.getNombre().equals(nodoFin.getNombre())){
        		if (listaPuntos.isEmpty())
        			return;
        		JOptionPane.showMessageDialog(null,"No se pueden hacer conexiones cíclicas","ERROR FATAL",JOptionPane.ERROR_MESSAGE);
        		return;
        	}
        	if (!fachada.añadeElementoContenido(fachada.getTipoSeleccionadoContenido(),nombre,nodoInicio,nodoFin,listaPuntos)){
        		JOptionPane.showMessageDialog(null,"Posibles errores:\n El enlace o la conexión se debe realizar entre dos nodos\n Error semántico" +
        				"\n El enlace o la conexion ya existe","ERROR FATAL",JOptionPane.ERROR_MESSAGE);
        	}
        	fachada.setTipoSeleccionadoContenido(Elemento.SELECCION);
        	seleccionadoOrigen=false;
        	listaPuntos=new LinkedList();
        }
        
    }

    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
     */
    public void mouseEntered(MouseEvent arg0) {
    	pizarraContenido.requestFocus();
    }

    /* (non-Javadoc)
     * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
     */
    public void mouseExited(MouseEvent arg0) {
        // 
        
    }
    
    private String solicitarNombre(){
    	/*Hay que usar el atributo dialogo de tipo IntroducirNombre */
    	boolean existe=true;
    	String nombre = new String();
    	do {
    		dialogo = new IntroducirNombre("Contenido",fachada);
    		if (JOptionPane.showConfirmDialog(null, dialogo,"Introduzca nombre", JOptionPane.YES_NO_OPTION)==
    			JOptionPane.NO_OPTION){
    			return null;
    		}
    		nombre = dialogo.getNombre();
    		if (nombre == null) return null;
    		if (nombre.equals("")) continue;
            while (nombre.charAt(0)==' ')
            	nombre=nombre.substring(1);
            CharSequence pep=" ";
            /*if (nombre.contains(pep)) {
            	int aparicion = nombre.indexOf(" ");
            	nombre=nombre.substring(0,aparicion);
            }*/
    		if(!nombre.equals(""))
    			existe = fachada.existeElementoContenido(nombre);
    		if (existe) JOptionPane.showMessageDialog(null,"Ya existe un elemento con ese nombre o el nombre es vacio","ERROR FATAL",JOptionPane.ERROR_MESSAGE);
    	}
    	while(nombre.equals("") || existe);
    	
    	return nombre;
    }
    
}
