/*
 * Created on 03-dic-2004
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
package es.ucm.fdi.si.controlador;

import javax.swing.JOptionPane;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import es.ucm.fdi.si.ICase;
import es.ucm.fdi.si.modelo.Elemento;
import es.ucm.fdi.si.modelo.ListaElementosDiseño;
import es.ucm.fdi.si.modelo.Nodo;
import es.ucm.fdi.si.modelo.Punto;

/**
 * @author Alejandro Blanco, David Curieses, Oscar Ortega
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ControladorTableModel implements TableModelListener {
	
	ICase fachada;
	
	ControladorTableModel(ICase fachada){
		this.fachada=fachada;
	}

	/* (non-Javadoc)
	 * @see javax.swing.event.TableModelListener#tableChanged(javax.swing.event.TableModelEvent)
	 */
    /*TODO se tiene que llamar a metodos de fachada para que se modifique 
    * el modelo global. No solo TableModel modelo
    */
	public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
        TableModel model = (TableModel)e.getSource();
        String columnName = model.getColumnName(column);
        String data =(String) model.getValueAt(row, column);
        if (data.equals("")) return;
        while (data.charAt(0)==' ')
        	data=data.substring(1);
        /*if (data.contains(" ")){
        	int aparece = data.indexOf(" ");
        	while (aparece==data.length()) {
        		data=data.substring(0,aparece);
        		aparece = data.indexOf(" ");
        	}
        }
        CharSequence pep="  ";
        if (data.contains(pep)) {
        	int aparicion = data.indexOf("  ");
        	data=data.substring(0,aparicion);
        }
        */
        
        ListaElementosDiseño listaElementosDiseño=fachada.getElementosSeleccionadosDiseño();
        if ((listaElementosDiseño.esVacia())||(listaElementosDiseño.getSize()>1))
        	return;
        Elemento elemento=listaElementosDiseño.getElemento(0);
        if (elemento== null) return;
        if (row==0) { //Cambio en el nombre
        	if (data.equals(elemento.getNombre())) return;
            //TODO como diferencia de cambio por seleccion a un nombre que existe 
            //TODO de cuando modificamos nombre a nombre existente
            if (fachada.existeElementoDiseño(data) || data.equals("")) {
                JOptionPane.showMessageDialog(null,"Ya existe un elemento con ese nombre o el nombre es vacio","ERROR FATAL",JOptionPane.ERROR_MESSAGE);
                model.setValueAt(elemento.getNombre(),0,1);
            } else if (elemento.esRelacion()){
            	model.setValueAt(elemento.getNombre(),0,1);
            	return;
            	}
            		else{
            			Nodo nodo=(Nodo)elemento;
            			fachada.actualizaNodoDiseño(nodo.getNombre(),nodo.getPuntoInicio(),nodo.getPuntoFin(), data);
            		}
        }
        	else if (row==1) { //altura
        		if (elemento.esRelacion()){
                	model.setValueAt("XXX",0,1);
                	return;
                	}
        		Nodo nodo=(Nodo)elemento;
        		Punto puntoInicio=nodo.getPuntoInicio();
        		Punto puntoFin=nodo.getPuntoFin();
        		int alturaVieja=Math.abs(puntoInicio.getY()-puntoFin.getY());
        		int alturaNueva=Integer.parseInt(data);
        		if (alturaVieja==alturaNueva) return;
        		Punto punto=new Punto(puntoFin.getX(),puntoInicio.getY()+alturaNueva);
        		//TODO ver si la nueva figura ocupa parte de otra
        		fachada.actualizaNodoDiseño(nodo.getNombre(),nodo.getPuntoInicio(),punto,nodo.getNombre());
        	}
        		else { //anchura
        			if (elemento.esRelacion()){
                    	model.setValueAt("XXX",0,1);
                    	return;
                    	}
            		Nodo nodo=(Nodo)elemento;
        			Punto puntoInicio=nodo.getPuntoInicio();
            		Punto puntoFin=nodo.getPuntoFin();
            		int anchuraVieja=Math.abs(puntoInicio.getX()-puntoFin.getX());
            		int anchuraNueva=Integer.parseInt(data);
            		if (anchuraVieja==anchuraNueva) return;
            		Punto punto = new Punto(puntoInicio.getX()+anchuraNueva,puntoFin.getY());
            		//TODO ver si la nueva figura ocupa parte de otra
            		fachada.actualizaNodoDiseño(nodo.getNombre(),nodo.getPuntoInicio(),punto, nodo.getNombre());
        		}
    }
}
