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
 * Herramienta CASE para dise�o y prototipado de aplicaciones hipermedia
 */
public class LienzoRelacion extends JPanel implements Observer {
    private FactoriaControladores factoriaControladores;
    
    private FigurasDise�o figurasDise�o;
    private PizarraDise�o pizarraDise�o;
    private TablaDise�o tablaDise�o;
    private ArbolDise�o arbolDise�o;
    private ModeloTabla modeloTabla;
    private ModeloArbol modeloArbol;
    
    private FigurasContenido figurasContenido;
    private PizarraContenido pizarraContenido;

    
    JPanel panelDise�o;
    JPanel panelContenido;
    
    private int INFINITO_X=5000;
    private int INFINITO_Y=5000;

    public LienzoRelacion(FactoriaControladores factoriaControladores, ModeloTabla modeloTabla,
    		ModeloArbol modeloArbol) {
        this.factoriaControladores=factoriaControladores;
        this.modeloTabla=modeloTabla;
        this.modeloArbol=modeloArbol;
        
        //Panel Dise�o
        panelDise�o=new JPanel();
        BorderLayout layoutDise�o=new BorderLayout();
        panelDise�o.setLayout(layoutDise�o);
        //Figuras Dise�o
        figurasDise�o=new FigurasDise�o(factoriaControladores);
        panelDise�o.add(figurasDise�o, BorderLayout.NORTH);
        //Pizarra Dise�o
        pizarraDise�o=new PizarraDise�o(factoriaControladores);
        pizarraDise�o.setPreferredSize(new Dimension(INFINITO_X,INFINITO_Y));
        JScrollPane panePizarraDise�o = new JScrollPane(pizarraDise�o, 
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panePizarraDise�o.setBorder(new LineBorder(Color.BLACK, 2));
        panelDise�o.add(panePizarraDise�o, BorderLayout.CENTER);
        //Tabla Dise�o
        tablaDise�o=new TablaDise�o(factoriaControladores,modeloTabla);
        JScrollPane scrollPaneTabla = new JScrollPane(tablaDise�o);
        tablaDise�o.setPreferredScrollableViewportSize(new Dimension(150, 200));
        panelDise�o.add(scrollPaneTabla, BorderLayout.EAST);
        //Construimos el �rbol
        arbolDise�o=new ArbolDise�o(factoriaControladores);
        arbolDise�o.setModel(modeloArbol);
        arbolDise�o.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        arbolDise�o.setRootVisible(true);
        arbolDise�o.setBorder(new LineBorder(Color.BLACK, 2));
        JScrollPane scrollPaneArbol = new JScrollPane(arbolDise�o, 
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPaneArbol.setPreferredSize(new Dimension(150,200));
        panelDise�o.add(scrollPaneArbol, BorderLayout.WEST);

        
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
        add(panelDise�o);
        add(panelContenido);
    }

    /* (non-Javadoc)
     * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
     */
    public void update(Observable arg0, Object arg1) {
        figurasDise�o.update(arg0, arg1);
        pizarraDise�o.update(arg0, arg1);
        modeloTabla.update(arg0, arg1);
        modeloArbol.update(arg0, arg1);
        
        figurasContenido.update(arg0, arg1);
        pizarraContenido.update(arg0, arg1);
    }

}
