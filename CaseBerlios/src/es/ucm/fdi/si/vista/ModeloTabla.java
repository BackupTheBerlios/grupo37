/*
 * Created on 03-dic-2004
 *
 */
package es.ucm.fdi.si.vista;

import java.util.Observable;
import java.util.Observer;

import javax.swing.table.AbstractTableModel;

import es.ucm.fdi.si.ICase;
import es.ucm.fdi.si.modelo.Elemento;
import es.ucm.fdi.si.modelo.Nodo;
import es.ucm.fdi.si.modelo.Punto;

/**
 * @author usuario_local
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ModeloTabla extends AbstractTableModel  implements Observer{

	private String [] columnNames = {"campo"," valor"};
	private Object [][] data = {{"Nombre", ""} , {"Altura",""}, {"Anchura",""}};
	
	private ICase fachada;
	
	private boolean[] editable = {true,true,true};
	
	public ModeloTabla(ICase fachada){
		this.fachada=fachada;
	}
	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getRowCount()
	 */
	public int getRowCount() {
		return data.length;
	}

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getColumnCount()
	 */
	public int getColumnCount() {
		return columnNames.length;
	}
	
	public String getColumnName(int col) {
        return columnNames[col];
    }
	
	

	/* (non-Javadoc)
	 * @see javax.swing.table.TableModel#getValueAt(int, int)
	 */
	public Object getValueAt(int row, int col) {
		return data[row][col];

	}
	
	public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
	
	public boolean isCellEditable(int row, int col) {
        if (col < 1) {
            return false;
        } else {
            return editable[row];
        }
    }
	
	public void setValueAt(Object value, int row, int col) {
		data[row][col] = value;
        fireTableCellUpdated(row, col);
	}
	
	public void borrarValores(){
		for (int i=0; i<getRowCount();i++)
			this.setValueAt("",i,1);
	}
	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(Observable arg0, Object arg1) {
		if ((fachada.getElementosSeleccionadosDiseño().esVacia()) ||(fachada.getElementosSeleccionadosDiseño().getSize()>1) ){
			borrarValores();
			return;
		}
		Elemento elemento=fachada.getElementosSeleccionadosDiseño().getElemento(0);
		if (elemento==null) {
			borrarValores();
			return;
		}
		String nombre=elemento.getNombre();
		this.setValueAt(nombre,0,1);
		if (elemento.esRelacion()) {
			editable[0]=false;
			editable[1]=false;
			editable[2]=false;
			this.setValueAt("XXX",1,1);
			this.setValueAt("XXX",2,1);
			return;
		}
		Nodo nodo = (Nodo)elemento;
		editable[0]=true;
		editable[1]=true;
		editable[2]=true;
		Punto puntoInicio=nodo.getPuntoInicio();
		Punto puntoFin=nodo.getPuntoFin();
		int inicioX=puntoInicio.getX();
		int inicioY=puntoInicio.getY();
		int finX=puntoFin.getX();
		int finY=puntoFin.getY();
		int altura=inicioY-finY;
		int anchura=inicioX-finX;
		this.setValueAt(""+Math.abs(altura),1,1);
		this.setValueAt(""+Math.abs(anchura),2,1);
	}

}
