/*
 * Created on 15-feb-2005
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package es.ucm.fdi.si.controlador;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import es.ucm.fdi.si.ICase;

/**
 * @author usuario
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class IntroducirNombre extends JPanel {
	
	private int contador;
	
	/** Es Diseño o Contenido y nos sirve para ponerlo en el nombre */
	private String tipo;
	
	private JLabel etiquetaNombre;
	
	private JTextField entradaNombre;
	
	/** Nos dice si se pulsó aceptar (true) o cancelar (false) al salir */
	private boolean salida;
	
	
	
	public IntroducirNombre(String tipo, ICase fachada){
	
		JButton botonOk, botonCancel;
			
		etiquetaNombre = new JLabel("Nombre");
		
		if (tipo.equals("Diseño")){
			entradaNombre = new JTextField("elemento_" + fachada.getNumElementosDiseño());
		}else if (tipo.equals("Contenido")){
			entradaNombre = new JTextField("elemento_" + fachada.getNumElementosContenido());
		}
				
		this.tipo=tipo;
		
		contador = 0;
		
		salida=false;
		
		
		GridLayout celda = new GridLayout(2,2);
		setLayout(celda);
		
		add(etiquetaNombre);
		add(entradaNombre);
		
		
		setSize(200, 100);
		
		
	}
	
	public void mostrar() {
		this.setVisible(true);
		entradaNombre.setText("Elemento "+tipo+" "+contador);
	}
	
	public String getNombre() {
		return entradaNombre.getText();
	}
	
	public boolean getSalida(){
		return salida;
	}
	

	private class ControladorAceptar implements ActionListener {
		
		IntroducirNombre dialogo;
	    
		public ControladorAceptar(IntroducirNombre dialogo) {
			this.dialogo=dialogo;
	    }

	    /* (non-Javadoc)
	     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	     */
	    public void actionPerformed(ActionEvent arg0) {
	        dialogo.setVisible(false);
	        dialogo.salida=true;
	        contador++;
	    }

	}
	
	private class ControladorCancelar implements ActionListener {
		
		IntroducirNombre dialogo;
	    
		public ControladorCancelar(IntroducirNombre dialogo) {
			this.dialogo=dialogo;
	    }

	    /* (non-Javadoc)
	     * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	     */
	    public void actionPerformed(ActionEvent arg0) {
	        dialogo.setVisible(false);
	        dialogo.salida=false;
	    }

	}

}
