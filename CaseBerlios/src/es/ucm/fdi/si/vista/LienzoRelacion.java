/*
 * Created on 28-nov-2004
 *
 */
package es.ucm.fdi.si.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.tree.TreeSelectionModel;

import es.ucm.fdi.si.controlador.FactoriaControladores;

/**
 * @author Alejandro Blanco, David Curieses Chamon, Oscar Ortega
 *
 * Proyecto Sistemas Informaticos: 
 * 	
 * Herramienta CASE para diseño y prototipado de aplicaciones hipermedia
 */
public class LienzoRelacion extends JPanel implements Observer {
    private FactoriaControladores factoriaControladores;
    
    private FigurasDiseño figurasDiseño;
    private PizarraDiseño pizarraDiseño;
    private TablaDiseño tablaDiseño;
    private ArbolDiseño arbolDiseño;
    private ModeloTabla modeloTabla;
    private ModeloArbol modeloArbol;
    
    private FigurasContenido figurasContenido;
    private PizarraContenido pizarraContenido;

    
    JPanel panelDiseño;
    JPanel panelContenido;
    
    private int INFINITO_X=5000;
    private int INFINITO_Y=5000;

    public LienzoRelacion(FactoriaControladores factoriaControladores, ModeloTabla modeloTabla,
    		ModeloArbol modeloArbol) {
        this.factoriaControladores=factoriaControladores;
        this.modeloTabla=modeloTabla;
        this.modeloArbol=modeloArbol;
        
        //Panel Diseño
        panelDiseño=new JPanel();
        BorderLayout layoutDiseño=new BorderLayout();
        panelDiseño.setLayout(layoutDiseño);
        //Figuras Diseño
        figurasDiseño=new FigurasDiseño(factoriaControladores);
        panelDiseño.add(figurasDiseño, BorderLayout.NORTH);
        //Pizarra Diseño
        pizarraDiseño=new PizarraDiseño(factoriaControladores);
        pizarraDiseño.setPreferredSize(new Dimension(INFINITO_X,INFINITO_Y));
        JScrollPane panePizarraDiseño = new JScrollPane(pizarraDiseño, 
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panePizarraDiseño.setBorder(new LineBorder(Color.BLACK, 2));
        panelDiseño.add(panePizarraDiseño, BorderLayout.CENTER);
        //Tabla Diseño
        tablaDiseño=new TablaDiseño(factoriaControladores,modeloTabla);
        JScrollPane scrollPaneTabla = new JScrollPane(tablaDiseño);
        tablaDiseño.setPreferredScrollableViewportSize(new Dimension(150, 200));
        panelDiseño.add(scrollPaneTabla, BorderLayout.EAST);
        //Construimos el árbol
        arbolDiseño=new ArbolDiseño(factoriaControladores);
        arbolDiseño.setModel(modeloArbol);
        arbolDiseño.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        arbolDiseño.setRootVisible(true);
        arbolDiseño.setBorder(new LineBorder(Color.BLACK, 2));
        JScrollPane scrollPaneArbol = new JScrollPane(arbolDiseño, 
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPaneArbol.setPreferredSize(new Dimension(150,200));
        panelDiseño.add(scrollPaneArbol, BorderLayout.WEST);

        
        // Contenido
        panelContenido=new JPanel();
        BorderLayout layoutContenido=new BorderLayout();
        panelContenido.setLayout(layoutContenido);
        //Figuras Contenido
        figurasContenido=new FigurasContenido(factoriaControladores);
        panelContenido.add(figurasContenido, BorderLayout.NORTH);
        //Pizarra Contenido
        pizarraContenido=new PizarraContenido(factoriaControladores);
        pizarraContenido.setPreferredSize(new Dimension(INFINITO_X,INFINITO_Y));
        JScrollPane panePizarraContenido = new JScrollPane(pizarraContenido, 
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pizarraContenido.setBorder(new LineBorder(Color.BLACK, 2));
        panelContenido.add(panePizarraContenido, BorderLayout.CENTER);
       
        BoxLayout boxLayout=new BoxLayout(this, BoxLayout.Y_AXIS);
        setLayout(boxLayout);
        add(panelDiseño);
        add(panelContenido);
    }

    /* (non-Javadoc)
     * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
     */
    public void update(Observable arg0, Object arg1) {
        figurasDiseño.update(arg0, arg1);
        pizarraDiseño.update(arg0, arg1);
        modeloTabla.update(arg0, arg1);
        modeloArbol.update(arg0, arg1);
        
        figurasContenido.update(arg0, arg1);
        pizarraContenido.update(arg0, arg1);
    }

}
