/*
 * Created on 27-nov-2004
 *
 */
package es.ucm.fdi.si.vista;

import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTabbedPane;

import es.ucm.fdi.si.ICase;
import es.ucm.fdi.si.controlador.FactoriaControladores;

/**
 * @author Alejandro Blanco, David Curieses Chamon, Oscar Ortega
 *
 * Proyecto Sistemas Informaticos: 
 * 	
 * Herramienta CASE para diseño y prototipado de aplicaciones hipermedia
 */
public class Vista extends JFrame implements Observer {

    private FactoriaControladores factoriaControladores;
    
    private JTabbedPane tabbedPane;
    private LienzoDiseño lienzoDibujo;
    private LienzoContenido lienzoContenido;
    private LienzoRelacion lienzoRelacion;
    private ModeloTabla modeloTabla;
    private ModeloArbol modeloArbol;
    
    public Vista(FactoriaControladores factoriaControladores, ICase fachada) {
        this.factoriaControladores=factoriaControladores;
        
        Container contenedor=getContentPane();
        setTitle("Herramienta CASE");
        setJMenuBar(construirMenu());
        tabbedPane= new JTabbedPane();
        modeloTabla= new ModeloTabla(fachada);
        modeloArbol = new ModeloArbol("Elementos");
        
        lienzoDibujo = new LienzoDiseño(factoriaControladores, modeloTabla, modeloArbol);
        lienzoContenido = new LienzoContenido(factoriaControladores);
        lienzoRelacion= new LienzoRelacion(factoriaControladores, modeloTabla, modeloArbol);
        
        tabbedPane.addTab("Contenido", lienzoContenido);
        tabbedPane.addTab("Diseño",lienzoDibujo);
        tabbedPane.addTab("Relacion", lienzoRelacion);
        
        contenedor.add(tabbedPane);
        setSize(800, 600);
		setVisible(true);
		addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e)
            {
              System.exit(0);
            }
          });
    }
    
    /* (non-Javadoc)
     * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
     */
    public void update(Observable arg0, Object arg1) {
        lienzoDibujo.update(arg0, arg1);
        lienzoContenido.update(arg0, arg1);
        lienzoRelacion.update(arg0, arg1);
    }
    
	public JMenuBar construirMenu() {
	    JMenuBar barra=new JMenuBar();
	    JMenu barraArchivo=contruirBarraArchivo();
	    JMenu barraDibujo=contruirBarraDibujo();
	    JMenu barraPrototipo=contruirBarraPropotivo();
	    JMenu barraPersistencia=contruirBarraPersistencia();
	    barra.add(barraArchivo);
	    barra.add(barraDibujo);
	    barra.add(barraPrototipo);
	    return barra;
	}

	public JMenu contruirBarraArchivo() {
	    JMenu barraArchivo=new JMenu("Archivo");
	    JMenuItem itemSalir=new JMenuItem("Salir");
	    barraArchivo.add(itemSalir);
	    return barraArchivo;
	}
	
	public JMenu contruirBarraDibujo() {
	    JMenu barraDiseño=new JMenu("Dibujo");
	    return barraDiseño;
	}

	public JMenu contruirBarraPersistencia() {
	    JMenu barraDiseño=new JMenu("Persistencia");
	    return barraDiseño;
	}
	
	public JMenu contruirBarraPropotivo() {
	    JMenu barraPrototipo=new JMenu("Prototipo");
	    JMenuItem itemGuardarPropotipo=new JMenuItem("Guardar Prototipo");
	    JMenuItem itemCargarPropotipo=new JMenuItem("Cargar Prototipo");
	    barraPrototipo.add(itemGuardarPropotipo);
	    barraPrototipo.add(itemCargarPropotipo);
	    return barraPrototipo;
	}



}
