/*
 * Created on 18-dic-2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package es.ucm.fdi.si.controlador;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JOptionPane;

import es.ucm.fdi.si.ICase;
import es.ucm.fdi.si.modelo.Elemento;

/**
 * @author Oscar Ortega
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ControladorTeclado implements KeyListener {

	private ICase fachada;
	/**
	 * 
	 */
	public ControladorTeclado(ICase fachada) {
		super();
		this.fachada = fachada;
		
	}
	
	public void keyTyped(KeyEvent arg0) {}
	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	public void keyPressed(KeyEvent arg0) {
		//Cuando pulsemos la tecla supr borraremos la figura seleccionada
		//preguntando previamente si esta seguro de que la desea eliminar
		//Tenemos un elemento seleccionado
		if(fachada.getTipoSeleccionadoDiseño()==Elemento.SELECCION){
			//Comprobamos que la tecla pulsada es supr
			if(arg0.getKeyCode() == KeyEvent.VK_DELETE){
				if(JOptionPane.showConfirmDialog(null,"¿Desea eliminar el elemento?","Confirmación de borrado",JOptionPane.OK_CANCEL_OPTION)
						== JOptionPane.OK_OPTION){
						fachada.deleteElementosDiseño(fachada.getElementosSeleccionadosDiseño());
				}
			} else if (arg0.getKeyCode() == KeyEvent.VK_CONTROL) {
				fachada.setPulsadoControl(true);
			}
		}else if(fachada.getTipoSeleccionadoContenido()==Elemento.SELECCION){
			//Comprobamos que la tecla pulsada es supr
			if(arg0.getKeyCode() == KeyEvent.VK_DELETE){
				if(JOptionPane.showConfirmDialog(null,"¿Desea eliminar el elemento?","Confirmación de borrado",JOptionPane.OK_CANCEL_OPTION)
						== JOptionPane.OK_OPTION){
						fachada.deleteElementoContenido(fachada.getElementosSeleccionadosContenido());
				}
			} else if (arg0.getKeyCode() == KeyEvent.VK_CONTROL) {
				fachada.setPulsadoControl(true);
			}
		}
	}
	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	public void keyReleased(KeyEvent arg0) {
		if (arg0.getKeyCode() == KeyEvent.VK_CONTROL) {
			fachada.setPulsadoControl(false);
		}
	}

}
