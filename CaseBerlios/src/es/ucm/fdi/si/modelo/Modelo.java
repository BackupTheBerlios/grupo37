/*
 * Created on 27-nov-2004
 *
 */
package es.ucm.fdi.si.modelo;

import java.util.Iterator;
import java.util.List;
import java.util.Observable;

/**
 * @author Alejandro Blanco, David Curieses Chamon, Oscar Ortega
 *
 * Proyecto Sistemas Informaticos: 
 * 	
 * Herramienta CASE para diseño y prototipado de aplicaciones hipermedia
 */
public class Modelo extends Observable implements IModelo {
    
	private boolean pulsadoControl=false;
	
    // Diseño
	private ListaElementosDiseño elementosDiseño;
    
    private ListaElementosDiseño elementosSeleccionadosDiseño;
    private int tipoSeleccionadoDiseño;
    private int numElementosDiseño;
    

    
    /** Posicion x de la ultima pulsacion sobre pizarra*/
    private int actualXDiseño;
    /** Posicion y de la ultima pulsacion sobre pizarra*/
    private int actualYDiseño;
    
    //Contenido
    private ListaElementosContenido elementosContenido;
    private int tipoSeleccionadoContenido;
    private ListaElementosContenido elementosSeleccionadosContenido;
    
    /** Posicion x de la ultima pulsacion sobre pizarra*/
    private int actualXContenido;
    /** Posicion y de la ultima pulsacion sobre pizarra*/
    private int actualYContenido;
	private int numElementosContenido;
    
    public Modelo() {
        //factoriaElementos=new FactoriaElementos();
        elementosDiseño=new ListaElementosDiseño();
        elementosContenido=new ListaElementosContenido();
        this.tipoSeleccionadoDiseño = Elemento.NINGUNO;
        this.tipoSeleccionadoContenido = Elemento.NINGUNO;
        this.elementosSeleccionadosDiseño=new ListaElementosDiseño();
        this.elementosSeleccionadosContenido=new ListaElementosContenido();
        numElementosContenido = 0;
        numElementosDiseño = 0;
    }
    
    public void iniciar() {
        setChanged();
        notifyObservers();
    }
    
    // Diseño
    public ListaElementosDiseño getListaElementosDiseño() {
        return elementosDiseño;
    }
    
    public void setElementoSeleccionadoDiseño(int x, int y) {
        boolean encontrado = false;
        Elemento elemento=null;
        Iterator iterador = this.elementosDiseño.getIterador();
    	while (iterador.hasNext() && !encontrado){
    	    elemento = (Elemento) iterador.next();
    		encontrado = elemento.estaDentro(x, y);
    	}
		if (encontrado) {
			elementosSeleccionadosDiseño.clear();
			elementosSeleccionadosDiseño.addElemento(elemento);
		} else {
			elementosSeleccionadosDiseño.clear();
		}
        setChanged();
        notifyObservers();
    }
    
    public void añadeElementoSeleccionadoDiseño(int x, int y) {
        boolean encontrado = false;
        Elemento elemento=null;
        Iterator iterador = this.elementosDiseño.getIterador();
    	while (iterador.hasNext() && !encontrado){
    	    elemento = (Elemento) iterador.next();
    		encontrado = elemento.estaDentro(x, y);
    	}
		if (encontrado) {
			elementosSeleccionadosDiseño.addElemento(elemento);
	        setChanged();
	        notifyObservers();
		}
    }
    
    public void setElementoSeleccionadoDiseño(String nombre) {
        boolean encontrado = false;
        Elemento elemento=null;
        Iterator iterador = this.elementosDiseño.getIterador();
    	while (iterador.hasNext() && !encontrado){
    	    elemento = (Elemento) iterador.next();
    		encontrado = elemento.getNombre().equals(nombre);
    	}
    	if (encontrado) {
			elementosSeleccionadosDiseño.clear();
			elementosSeleccionadosDiseño.addElemento(elemento);
		} else {
			elementosSeleccionadosDiseño.clear();
		}
        setChanged();
        notifyObservers();
    }
    
    public void setTipoSeleccionadoDiseño(int tipo) {
        tipoSeleccionadoDiseño=tipo;
        setChanged();
        notifyObservers();
    }
    
    public int getTipoSeleccionadoDiseño() {
        return tipoSeleccionadoDiseño;
    }
    
    public ListaElementosDiseño getElementosSeleccionadoDiseño(){
    	return this.elementosSeleccionadosDiseño;
    }
    
    public boolean existeElementoDiseño(String nombre) {
    	
    	boolean existe = false;
    	int i = 0;
    	while (i< elementosDiseño.getSize() && !existe){
    		Elemento elemento = (Elemento) elementosDiseño.getElemento(i);
    		existe = elemento.getNombre().equals(nombre);
    		i++;
    	}
    	   	
    	return existe;
    }

    public boolean existeElementoContenido(String nombre) {
    	
    	boolean existe = false;
    	int i = 0;
    	while (i< elementosContenido.getSize() && !existe){
    		Elemento elemento = (Elemento) elementosContenido.getElemento(i);
    		existe = elemento.getNombre().equals(nombre);
    		i++;
    	}
    	   	
    	return existe;
    }

    
	public boolean añadirElementoDiseño(int tipo, String nombre, Punto puntoInicio, Punto puntoFin) {
		boolean añadido;
		Elemento elemento = crearElementoDiseño(tipo,nombre,puntoInicio,puntoFin);
		if (elemento!=null) {
		    elementosDiseño.addElemento(elemento);
		    setChanged();
		    notifyObservers();
		    añadido = true;
		    numElementosDiseño++;
		}
		else
			añadido = false;
		
		return añadido;
		
	}
	
	public boolean añadirElementoDiseño(int tipo, String nombre, Nodo nodoInicio, Nodo nodoFin, List listaPuntos, int tiempo) {
		boolean añadido;
		Elemento elemento = this.crearElementoDiseño(tipo,nombre,nodoInicio,nodoFin, listaPuntos, tiempo);
		if (elemento!=null) {
			añadido = true;
			// Se añade el enlace o la conexion a la lista de elmentos de diseño
		    elementosDiseño.addElemento(elemento);
		    // Establecemos el enlace o conexion al que pertenecen cada nodo
		    nodoInicio.addEnlace_conexion(elemento);
		    nodoFin.addEnlace_conexion(elemento);
		    setChanged();
		    notifyObservers();
		    numElementosDiseño++;
		} else {
			añadido = false;
		}
		return añadido;
	}
	
	public Elemento crearElementoDiseño(int tipo, String nombre, Punto puntoInicio, Punto puntoFin){
		Elemento elemento = null;
		
		switch (tipo){
			case Elemento.NEXO: elemento =new Nexo(tipo,nombre,puntoInicio,puntoFin);
								//Comprobamos que ningún elemento este dibujado dentro de otro
								if (estaContenidoDiseño(elemento) != null)
									elemento = null;
								break;
			case Elemento.CONTENEDOR: elemento =new Contenedor(tipo,nombre,puntoInicio,puntoFin);
									  if (estaContenidoDiseño(elemento) != null)
									  		elemento = null;
									  break;
			case Elemento.ACTIVADOR_NEXO: elemento =new Activador_Nexo(tipo,nombre,puntoInicio,puntoFin);
													if (estaContenidoDiseño(elemento) != null)
														elemento = null;
													break;						
		}
		
		return elemento;
	}
	
	public Elemento estaContenidoDiseño(Elemento elemento){
		boolean contenido = false;
		Iterator iterador = elementosDiseño.getIterador();
		Elemento aux = null;
		while (iterador.hasNext() && !contenido){
			aux = (Elemento)iterador.next();
			//Un ancla estatica puede estar dentro de un contenido estatico o contenido 
			//dinámico rectangulares
			boolean vertice1 =aux.estaDentro(((Nodo)elemento).getPuntoInicio().getX(),
											 ((Nodo)elemento).getPuntoInicio().getY());
			boolean vertice2 = aux.estaDentro(((Nodo)elemento).getPuntoFin().getX(),
					 					  	  ((Nodo)elemento).getPuntoFin().getY());
			boolean vertice3 =aux.estaDentro(((Nodo)elemento).getPuntoFin().getX(),
					 						 ((Nodo)elemento).getPuntoInicio().getY());
			boolean vertice4 = aux.estaDentro(((Nodo)elemento).getPuntoInicio().getX(),
				  	  						  ((Nodo)elemento).getPuntoFin().getY());
			contenido = vertice1 || vertice2 || vertice3 || vertice4;
			if (!contenido)
				aux = null;
		}
		return aux;
	}

	public Elemento estaContenidoContenido(Elemento elemento){
		boolean contenido = false;
		Iterator iterador = elementosContenido.getIterador();
		Elemento aux = null;
		while (iterador.hasNext() && !contenido){
			aux = (Elemento)iterador.next();
			boolean vertice1 =aux.estaDentro(((Nodo)elemento).getPuntoInicio().getX(),
											 ((Nodo)elemento).getPuntoInicio().getY());
			boolean vertice2 = aux.estaDentro(((Nodo)elemento).getPuntoFin().getX(),
					 					  	  ((Nodo)elemento).getPuntoFin().getY());
			boolean vertice3 =aux.estaDentro(((Nodo)elemento).getPuntoFin().getX(),
					 						 ((Nodo)elemento).getPuntoInicio().getY());
			boolean vertice4 = aux.estaDentro(((Nodo)elemento).getPuntoInicio().getX(),
				  	  						  ((Nodo)elemento).getPuntoFin().getY());
			contenido = vertice1 || vertice2 || vertice3 || vertice4;
			if (!contenido)
				aux = null;
		}
		return aux;
	}

	public Elemento crearElementoDiseño(int tipo, String nombre, Nodo nodoInicio, Nodo nodoFin, List listaPuntos, int tiempo){
		Elemento elemento = null;
		/*if ((nodoInicio==null)||(nodoFin==null)) {
		    System.out.println("Los nodos no pueden ser nulos");
		    elemento = null;
		}*/
		//TODO Comprobar Restricciones se puede sacar del case
		switch (tipo){
			case Elemento.ENLACE: elemento =new Enlace(nodoInicio,nodoFin, listaPuntos);
								  if (this.existeElementoDiseño(elemento.getNombre())) {
								  	elemento = null;
								  } else {
								  	elemento = comprobarRestriccionesDiseño(tipo,elemento);
								  }
								  break;
			case Elemento.CONEXION: elemento =new Conexion(nodoInicio,nodoFin, listaPuntos);
								  	if (this.existeElementoDiseño(elemento.getNombre())) {
								  		elemento = null;
								  	} else {
								  		elemento = comprobarRestriccionesDiseño(tipo,elemento);
								  	}
								  	break;
			case Elemento.ENLACE_SINCRO: elemento =new Enlace_sincro(nodoInicio,nodoFin, listaPuntos,tiempo);
										 if (this.existeElementoDiseño(elemento.getNombre())) {
										 	elemento = null;
										 } else {
										 elemento = comprobarRestriccionesDiseño(tipo,elemento);
										 }
										 break;
			case Elemento.CONEXION_SINCRO: elemento =new Conexion_sincro(nodoInicio,nodoFin, listaPuntos,tiempo);
										   if (this.existeElementoDiseño(elemento.getNombre())) {
										   		elemento = null;
										   } else {
										   elemento = comprobarRestriccionesDiseño(tipo,elemento);
										   }
										   break;
		}
		return elemento;
	}

	private Elemento comprobarRestriccionesDiseño(int tipo, Elemento elemento){
		Elemento aux;
		switch (tipo){
		case Elemento.ENLACE: aux = restriccionEnlace(elemento);
								return aux;
		case Elemento.CONEXION: aux = restriccionConexion(elemento);
								return aux;
		case Elemento.ENLACE_SINCRO: aux = restriccionEnlace_Sincro(elemento);
								return aux;
		case Elemento.CONEXION_SINCRO: aux = restriccionConexion_Sincro(elemento);
								return aux;
		default: return null;
		}
	}
	
	private Elemento restriccionEnlace(Elemento elemento){
		Elemento aux;
		int tipoNodoInicio = ((ConexionEnlace)elemento).getNodoInicio().getTipo();
		int tipoNodoFin = ((ConexionEnlace)elemento).getNodoFin().getTipo();
		if(tipoNodoInicio == Elemento.CONTENEDOR && tipoNodoFin == Elemento.CONTENEDOR)
			aux = elemento;
		else if (tipoNodoInicio == Elemento.ACTIVADOR_NEXO && tipoNodoFin == Elemento.NEXO)
			aux = elemento;
		else //en cualquier otro caso no es valido hacer un enlace
			aux = null;
		return aux;
	}
	
	private Elemento restriccionConexion(Elemento elemento){
		Elemento aux;
		int tipoNodoInicio = ((ConexionEnlace)elemento).getNodoInicio().getTipo();
		int tipoNodoFin = ((ConexionEnlace)elemento).getNodoFin().getTipo();
		if(tipoNodoInicio == Elemento.NEXO && tipoNodoFin == Elemento.ACTIVADOR_NEXO)
			aux = elemento;
		else if(tipoNodoInicio == Elemento.ACTIVADOR_NEXO && tipoNodoFin == Elemento.NEXO)
			aux = elemento;
		else if (tipoNodoInicio == Elemento.NEXO && tipoNodoFin == Elemento.CONTENEDOR)
			aux = elemento;
		else if (tipoNodoInicio == Elemento.CONTENEDOR && tipoNodoFin == Elemento.NEXO)
			aux = elemento;
		else //en cualquier otro caso no es valido hacer una conexion
			aux = null;
		return aux;
	}
	
	private Elemento restriccionEnlace_Sincro(Elemento elemento){
		Elemento aux;
		int tipoNodoInicio = ((ConexionEnlace)elemento).getNodoInicio().getTipo();
		int tipoNodoFin = ((ConexionEnlace)elemento).getNodoFin().getTipo();
		if(tipoNodoInicio == Elemento.NEXO && tipoNodoFin == Elemento.NEXO)
			aux = elemento;
		else //en cualquier otro caso no es valido hacer una conexion
			aux = null;
		return aux;
	}
	
	private Elemento restriccionConexion_Sincro(Elemento elemento){
		Elemento aux;
		int tipoNodoInicio = ((ConexionEnlace)elemento).getNodoInicio().getTipo();
		int tipoNodoFin = ((ConexionEnlace)elemento).getNodoFin().getTipo();
		if(tipoNodoInicio == Elemento.NEXO && tipoNodoFin == Elemento.CONTENEDOR)
			aux = elemento;
		else //en cualquier otro caso no es valido hacer una conexion
			aux = null;
		return aux;
	}
	
	public void actualizaNodoDiseño(String nombre, Punto puntoInicio , Punto puntoFin, String nuevoNombre) {
    	boolean existe = false;
    	Elemento elemento=null;
    	int i = 0;
    	while (i< elementosDiseño.getSize() && !existe){
    		elemento = (Elemento) elementosDiseño.getElemento(i);
    		existe = elemento.getNombre().equals(nombre);
    		i++;
    	}
    	if (existe) {
    	    Nodo nodo=(Nodo)elemento;
    	    nodo.setNombre(nuevoNombre);
    	    nodo.setPuntoInicio(puntoInicio);
    	    nodo.setPuntoFin(puntoFin);
    	    cambiaEnlaces(nombre,nuevoNombre);
    	    setChanged();
    	    notifyObservers();
    	}
	}
	
	public void actualizaNodoContenido(String nombre, Punto puntoInicio , Punto puntoFin, String nuevoNombre) {
		boolean existe = false;
    	Elemento elemento=null;
    	int i = 0;
    	while (i< elementosContenido.getSize() && !existe){
    		elemento = (Elemento) elementosContenido.getElemento(i);
    		existe = elemento.getNombre().equals(nombre);
    		i++;
    	}
    	if (existe) {
    	    Nodo nodo=(Nodo)elemento;
    	    nodo.setNombre(nuevoNombre);
    	    nodo.setPuntoInicio(puntoInicio);
    	    nodo.setPuntoFin(puntoFin);
    	    cambiaEnlaces(nombre,nuevoNombre);
    	    setChanged();
    	    notifyObservers();
    	}
	}
    /**
	 * @param nombre
	 * @param nuevoNombre
	 */
	private void cambiaEnlaces(String nombre, String nuevoNombre) {
		Iterator iterador = this.elementosDiseño.getIterador();
		while (iterador.hasNext()){
			Elemento elem = (Elemento)iterador.next();
			if (!elem.esRelacion()){
				continue;
			}
			if (((ConexionEnlace)elem).getNodoInicio().getNombre().equals(nuevoNombre)){
				String nombreEnlace=((ConexionEnlace)elem).toString();
				((ConexionEnlace)elem).setNombre(nombreEnlace);
				continue;
			}
			
			if (((ConexionEnlace)elem).getNodoFin().getNombre().equals(nuevoNombre)){
				String nombreEnlace=((ConexionEnlace)elem).toString();
				((ConexionEnlace)elem).setNombre(nombreEnlace);
			}
			
		}
	}

	public int getActualXDiseño() {
        return actualXDiseño;
    }
    public void setActualXDiseño(int actualX) {
        this.actualXDiseño = actualX;
    }
    public int getActualYDiseño() {
        return actualYDiseño;
    }
    public void setActualYDiseño(int actualY) {
        this.actualYDiseño = actualY;
    }
    
    public void setActualXYDiseño(int x, int y) {
        this.actualXDiseño=x;
        this.actualYDiseño=y;
    }
    
    public boolean estaDentroDiseño(int x, int y){
    	Iterator iterador = elementosDiseño.getIterador();
    	boolean dentro = false;
    	while (!dentro & iterador.hasNext()){
    		Elemento elemento = (Elemento) iterador.next();
    		dentro = elemento.estaDentro(x,y);
    	}
    	return dentro;
    }

	public void deleteElementosDiseño(ListaElementosDiseño elementos) {
		// Eliminamos el elemento seleccionado
		Iterator iteradorDelete=elementos.getIterador();
		while (iteradorDelete.hasNext()) {
			Elemento elemento=(Elemento)iteradorDelete.next();
			elementosDiseño.delete(elemento);
			// Borramos los enlaces y conexiones en los que se vea implicado
			List lista = ((Nodo) elemento).getEnlaces_conexiones();
			Iterator iterador = lista.iterator();
			while (iterador.hasNext()){
				elementosDiseño.delete((Elemento)iterador.next());
			}
		}
		//Ya no hay elemento seleccionado
		elementosSeleccionadosDiseño.clear();
		setChanged();
	    notifyObservers();
	}
	
	/* (non-Javadoc)
	 * @see es.ucm.fdi.si.modelo.IModeloDiseño#getNumElementosDiseño()
	 */
	public int getNumElementosDiseño() {
		return numElementosDiseño;
	}
	
//	Contenido
    public ListaElementosContenido getListaElementosContenido() {
        return elementosContenido;
    }
	
	/**
	 * @return Returns the tipoSeleccionadoContenido.
	 */
	public int getTipoSeleccionadoContenido() {
		return tipoSeleccionadoContenido;
	}
	/**
	 * @param tipoSeleccionadoContenido The tipoSeleccionadoContenido to set.
	 */
	public void setTipoSeleccionadoContenido(int tipoSeleccionadoContenido) {
		this.tipoSeleccionadoContenido = tipoSeleccionadoContenido;
        setChanged();
        notifyObservers();
	}
	
	public ListaElementosContenido getElementosSeleccionadosContenido(){
    	return this.elementosSeleccionadosContenido;
    }

	
	public boolean añadirElementoContenido(int tipo, String nombre, Nodo nodoInicio, Nodo nodoFin, List listaPuntos) {
		boolean añadido;
		Elemento elemento = this.crearElementoContenido(tipo,nombre,nodoInicio,nodoFin, listaPuntos);
		if (elemento!=null) {
			añadido = true;
			// Se añade el enlace o la conexion a la lista de elmentos de diseño
		    elementosContenido.addElemento(elemento);
		    // Establecemos el enlace o conexion al que pertenecen cada nodo
		    nodoInicio.addEnlace_conexion(elemento);
		    nodoFin.addEnlace_conexion(elemento);
		    setChanged();
		    notifyObservers();
		    numElementosContenido++;
		} else {
			añadido = false;
		}
		return añadido;
	}

	
	/**
	 * @param tipo
	 * @param nombre
	 * @param nodoInicio
	 * @param nodoFin
	 * @param listaPuntos
	 * @param tiempo
	 * @return
	 */
	private Elemento crearElementoContenido(int tipo, String nombre, Nodo nodoInicio, Nodo nodoFin, List listaPuntos) {
		Elemento elemento = null;
		if ((nodoInicio==null)||(nodoFin==null)) {
		    System.out.println("Los nodos no pueden ser nulos");
		    elemento = null;
		}
		//TODO Comprobar Restricciones se puede sacar del case
		switch (tipo){
			case Elemento.ENLACE_ESTATICO: elemento =new Enlace_Estatico(nodoInicio,nodoFin, listaPuntos);
								  if (this.existeElementoContenido(elemento.getNombre())) {
								  	elemento = null;
								  } else {
								  	//TODO Falta por hacer el comprobarRestriccionesContenido(tipo,elemento);
								  	//elemento = comprobarRestriccionesContenido(tipo,elemento);
								  }
								  break;
			case Elemento.ENLACE_DINAMICO: elemento =new Enlace_Dinamico(nodoInicio,nodoFin, listaPuntos);
			  						if (this.existeElementoContenido(elemento.getNombre())) {
			  							elemento = null;
			  						} else {
			  							//TODO Falta por hacer el comprobarRestriccionesContenido(tipo,elemento);
			  							//elemento = comprobarRestriccionesContenido(tipo,elemento);
			  						}
			  						break;
		}
		return elemento;
	}

	public boolean añadirElementoContenido(int tipo, String nombre, Punto puntoInicio, Punto puntoFin) {
		boolean añadido;
		Elemento elemento = crearElementoContenido(tipo,nombre,puntoInicio,puntoFin);
		if (elemento!=null) {
		    elementosContenido.addElemento(elemento);
		    setChanged();
		    notifyObservers();
		    añadido = true;
		    numElementosContenido++;
		}
		else
			añadido = false;
		
		return añadido;
	}

	/**
	 * @param tipo
	 * @param nombre
	 * @param puntoInicio
	 * @param puntoFin
	 * @return
	 */
	private Elemento crearElementoContenido(int tipo, String nombre, Punto puntoInicio, Punto puntoFin) {
		Elemento elemento = null;
		Elemento elem;
		
		switch (tipo){
			case Elemento.CONTENIDO_ESTATICO_GRANDE: 
				puntoFin.setY(puntoFin.getY()+ 40);
				puntoFin.setX(puntoFin.getX()+ 20);
				elemento =new Contenido_Estatico(tipo,nombre,puntoInicio,puntoFin);
				//Comprobamos que ningún elemento este dibujado dentro de otro
				if ((estaContenidoContenido(elemento) != null) || existeElementoContenido(elemento.getNombre()))
						elemento = null;
				break;
			case Elemento.CONTENIDO_DINAMICO_PEQUEÑO: elemento =new Contenido_Dinamico(tipo,nombre,puntoInicio,puntoFin);
				//Comprobamos que ningún elemento este dibujado dentro de otro
				if ((estaContenidoContenido(elemento) != null) || existeElementoContenido(elemento.getNombre()))
					elemento = null;
				break;		
			case Elemento.ANCLA_DINAMICA:
				puntoFin.setX(puntoFin.getX()+ 10);
				puntoFin.setY(puntoFin.getY()- 10);
				elemento =new Ancla_Dinamica(tipo,nombre,puntoInicio,puntoFin);
				elem = estaContenidoContenido(elemento);
				//Comprobamos que solo se puede dibujar dentro de un contenido estatico y dinamico
				if(elem != null){
					
					if(elem.esRelacion()){
						elemento = null;
					}
					else{
						if ((((Nodo)elem).tipo != Elemento.CONTENIDO_ESTATICO_GRANDE)
								&& (((Nodo)elem).tipo != Elemento.CONTENIDO_DINAMICO_GRANDE)){							elemento = null;
								elemento = null;
						}
					}
					
					if (elemento != null && existeElementoContenido(elemento.getNombre()))
							elemento = null;
					
				}
								
				break;
			case Elemento.ANCLA_ESTATICA:
				puntoFin.setX(puntoFin.getX()+ 10);
				puntoFin.setY(puntoFin.getY()- 10);
				elemento =new Ancla_Estatica(tipo,nombre,puntoInicio,puntoFin);
				//Comprobamos que ningún elemento este dibujado dentro de otro
				elem = estaContenidoContenido(elemento);
								
				if(elem != null){
					
					if(elem.esRelacion()){
						elemento = null;
					}
					else{
						if ((((Nodo)elem).tipo != Elemento.CONTENIDO_ESTATICO_GRANDE)
								&& (((Nodo)elem).tipo != Elemento.CONTENIDO_DINAMICO_GRANDE)){							elemento = null;
								elemento = null;
						}
					}
					
					if (elemento != null && existeElementoContenido(elemento.getNombre()))
							elemento = null;
					
				}
								
				break;
		}
		
		return elemento;
	}

	public void setElementoSeleccionadoContenido(int x, int y) {
		boolean encontrado = false;
        Elemento elemento=null;
        Iterator iterador = this.elementosContenido.getIterador();
    	while (iterador.hasNext() && !encontrado){
    	    elemento = (Elemento) iterador.next();
    		encontrado = elemento.estaDentro(x, y);
    	}
		if (encontrado) {
			elementosSeleccionadosContenido.clear();
			elementosSeleccionadosContenido.addElemento(elemento);
		} else {
		    elementosSeleccionadosContenido.clear();
		}
        setChanged();
        notifyObservers();
		
	}
	
	/**
	 * @return Returns the pulsadoControl.
	 */
	public boolean isPulsadoControl() {
		return pulsadoControl;
	}
	/**
	 * @param pulsadoControl The pulsadoControl to set.
	 */
	public void setPulsadoControl(boolean pulsadoControl) {
		this.pulsadoControl = pulsadoControl;
	}

	/* (non-Javadoc)
	 * @see es.ucm.fdi.si.modelo.IModeloContenido#añadeElementoSeleccionadoContenido(int, int)
	 */
	public void añadeElementoSeleccionadoContenido(int posX, int posY) {
		boolean encontrado = false;
        Elemento elemento=null;
        Iterator iterador = this.elementosContenido.getIterador();
    	while (iterador.hasNext() && !encontrado){
    	    elemento = (Elemento) iterador.next();
    		encontrado = elemento.estaDentro(posX, posY);
    	}
		if (encontrado) {
			elementosSeleccionadosContenido.addElemento(elemento);
	        setChanged();
	        notifyObservers();
		}
	}

	/* (non-Javadoc)
	 * @see es.ucm.fdi.si.modelo.IModeloDiseño#deleteElementosContenido(es.ucm.fdi.si.modelo.ListaElementosContenido)
	 */
	public void deleteElementosContenido(ListaElementosContenido elementos) {
//		 Eliminamos el elemento seleccionado
		Iterator iteradorDelete=elementos.getIterador();
		while (iteradorDelete.hasNext()) {
			Elemento elemento=(Elemento)iteradorDelete.next();
			elementosContenido.delete(elemento);
			// Borramos los enlaces y conexiones en los que se vea implicado
			List lista = ((Nodo) elemento).getEnlaces_conexiones();
			Iterator iterador = lista.iterator();
			while (iterador.hasNext()){
				elementosContenido.delete((Elemento)iterador.next());
			}
		}
		//Ya no hay elemento seleccionado
		elementosSeleccionadosDiseño.clear();
		setChanged();
	    notifyObservers();
	}

	public int getNumElementosContenido(){
		return numElementosContenido;
	}
	
}
