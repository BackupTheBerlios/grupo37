/*
 * Created on 26-dic-2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package es.ucm.fdi.si.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import es.ucm.fdi.si.ICase;
import es.ucm.fdi.si.modelo.Elemento;

/**
 * @author Alejandro
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ControladorContenidoEstaticoGrande implements ActionListener {

    private ICase fachada;
    
    public ControladorContenidoEstaticoGrande(ICase fachada) {
        this.fachada=fachada;
    }

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent arg0) {
		fachada.setTipoSeleccionadoContenido(Elemento.CONTENIDO_ESTATICO_GRANDE);
	}
}
