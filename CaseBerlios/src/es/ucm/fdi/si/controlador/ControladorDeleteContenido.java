/*
 * Created on 18-dic-2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package es.ucm.fdi.si.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import es.ucm.fdi.si.ICase;
import es.ucm.fdi.si.modelo.Elemento;

/**
 * @author Oscar Ortega
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ControladorDeleteContenido implements ActionListener {

	private ICase fachada;
	public ControladorDeleteContenido(ICase fachada) {
		super();
		this.fachada = fachada;
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent arg0) {
//		Tenemos un elemento seleccionado
		if(fachada.getTipoSeleccionadoContenido()==Elemento.SELECCION && (!fachada.getElementosSeleccionadosContenido().esVacia())){
			//Previamente hay que preguntar si desea o no eliminar la figura
			if(JOptionPane.showConfirmDialog(null,"¿Desea eliminar el elemento?","Confirmación de borrado",JOptionPane.OK_CANCEL_OPTION)
					== JOptionPane.OK_OPTION){
					fachada.deleteElementoContenido(fachada.getElementosSeleccionadosContenido());
			}
		}
		else JOptionPane.showMessageDialog(null,"No hay nada que borrar porque o no esta seleccionado o algo");

	}

}
