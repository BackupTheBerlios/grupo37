/*
 * Created on 06-dic-2004
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
package es.ucm.fdi.si.vista;

import java.util.Iterator;
import java.util.Observable;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import es.ucm.fdi.si.modelo.ListaElementosDiseño;
import es.ucm.fdi.si.modelo.Modelo;


/**
 * @author usuario
 *
 * 
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ModeloArbol extends DefaultTreeModel {

	/**
	 * @param arg0
	 */
	public ModeloArbol(String arg0) {
		super(new DefaultMutableTreeNode(arg0));
		this.setRoot(new DefaultMutableTreeNode(arg0));
	}
	
	public void update(Observable arg0, java.lang.Object arg1) {
        Modelo modelo=(Modelo)arg0;
        ListaElementosDiseño listaElementosDiseño=modelo.getListaElementosDiseño();
        Iterator iterador=listaElementosDiseño.getLista().iterator();
        int size=listaElementosDiseño.getLista().size();
        Object[] jerarquia=new Object[size+1];
        jerarquia[0]="Elementos";
        int i=1;
        while (iterador.hasNext()) {
            jerarquia[i]=iterador.next();
            i++;
        }
        if (jerarquia.length>0) {
            DefaultMutableTreeNode root=processHierarchy(jerarquia);
            this.setRoot(root);
        }
        
    }
    
    private DefaultMutableTreeNode processHierarchy(Object[] hierarchy) {
        DefaultMutableTreeNode node =
          new DefaultMutableTreeNode(hierarchy[0]);
        DefaultMutableTreeNode child;
        for(int i=1; i<hierarchy.length; i++) {
          Object nodeSpecifier = hierarchy[i];
          if (nodeSpecifier instanceof Object[])  // Ie node with children
            child = processHierarchy((Object[])nodeSpecifier);
          else
            child = new DefaultMutableTreeNode(nodeSpecifier); // Ie Leaf
          node.add(child);
        }
        return(node);
      }
	
}
