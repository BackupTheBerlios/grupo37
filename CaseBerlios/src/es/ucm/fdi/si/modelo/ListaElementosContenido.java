/*
 * Created on 28-nov-2004
 *
 */
package es.ucm.fdi.si.modelo;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Alejandro Blanco, David Curieses Chamon, Oscar Ortega
 *
 * Proyecto Sistemas Informaticos: 
 * 	
 * Herramienta CASE para diseño y prototipado de aplicaciones hipermedia
 */
public class ListaElementosContenido {

    private List lista;
    
    public ListaElementosContenido() {
        lista=new LinkedList();
    }
    
    public List getLista() {
        return lista;
    }
    
    public int getSize(){
    	return lista.size();
    }
    
    
    public void addElemento(Elemento elemento){
    	lista.add(elemento);
    }
    
    public Elemento getElemento(int index){
    	return (Elemento) lista.get(index); 
    }
    
	/**
	 * @return un iterador de la lista de elmentos
	 */
	public Iterator getIterador() {
		return lista.iterator();
	}
	
	public void delete(Elemento elemento){
		lista.remove(elemento);
	}
	
	public void clear() {
		lista.clear();
	}

	/**
	 * @return
	 */
	public boolean esVacia() {
		return lista.isEmpty();
	}
	
	public boolean contiene(Elemento elemento) {
		return lista.contains(elemento);
	}
}
