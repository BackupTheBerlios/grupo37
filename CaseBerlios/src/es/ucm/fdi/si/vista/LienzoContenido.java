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

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import es.ucm.fdi.si.controlador.FactoriaControladores;


/**
 * @author Alejandro Blanco, David Curieses Chamon, Oscar Ortega
 *
 * Proyecto Sistemas Informaticos: 
 * 	
 * Herramienta CASE para dise�o y prototipado de aplicaciones hipermedia
 */
public class LienzoContenido extends JPanel implements Observer {
	
    private FactoriaControladores factoriaControladores;
    
    private FigurasContenido figurasContenido;
    private PizarraContenido pizarraContenido;
    
    private int INFINITO_X=5000;
    private int INFINITO_Y=5000;
    
    public LienzoContenido(FactoriaControladores factoriaControladores) {
        this.factoriaControladores=factoriaControladores;
        BorderLayout layout=new BorderLayout();
        setLayout(layout);
        figurasContenido=new FigurasContenido(factoriaControladores);
        add(figurasContenido, BorderLayout.NORTH);
        pizarraContenido=new PizarraContenido(factoriaControladores);
        pizarraContenido.setPreferredSize(new Dimension(INFINITO_X,INFINITO_Y));
        JScrollPane panePizarraDise�o = new JScrollPane(pizarraContenido, 
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        panePizarraDise�o.setBorder(new LineBorder(Color.BLACK, 2));
        add(panePizarraDise�o, BorderLayout.CENTER);
    }

    /* (non-Javadoc)
     * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
     */
    public void update(Observable arg0, Object arg1) {
        figurasContenido.update(arg0, arg1);
        pizarraContenido.update(arg0, arg1);
        //tablaDise�o.update(arg0, arg1);
        //modeloArbol.update(arg0, arg1);
    }

}
