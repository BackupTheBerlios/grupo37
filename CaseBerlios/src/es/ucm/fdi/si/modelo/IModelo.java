/*
 * Created on 28-nov-2004
 *
 */
package es.ucm.fdi.si.modelo;

/**
 * @author Alejandro Blanco, David Curieses Chamon, Oscar Ortega
 *
 * Proyecto Sistemas Informaticos: 
 * 	
 * Herramienta CASE para diseño y prototipado de aplicaciones hipermedia
 */
public interface IModelo extends IModeloDiseño, IModeloContenido {
	//Esta funcionalidad no va a aparecer
    public void iniciar();
    //public FactoriaElementos getFactoriaElementos();

	/**
	 * @param b
	 */
	public void setPulsadoControl(boolean b);
	/**
	 * @return
	 */
	public boolean isPulsadoControl();
    
}
