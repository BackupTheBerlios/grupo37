/*
 * Created on 28-nov-2004
 *
 */
package es.ucm.fdi.si.vista;

import java.awt.Color;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import es.ucm.fdi.si.controlador.FactoriaControladores;
import es.ucm.fdi.si.modelo.Elemento;
import es.ucm.fdi.si.modelo.Modelo;

/**
 * @author Alejandro Blanco, David Curieses Chamon, Oscar Ortega
 *
 * Proyecto Sistemas Informaticos: 
 * 	
 * Herramienta CASE para diseño y prototipado de aplicaciones hipermedia
 */
public class FigurasContenido extends JPanel implements Observer {

    private FactoriaControladores factoriaControladores;
    
    private JButton botonContenidoEstaticoGrande;
    private JButton botonContenidoEstaticoPequeño;
    private JButton botonContenidoDinamicoGrande;
    private JButton botonContenidoDinamicoPequeño;
    private JButton botonAnclaEstatica;
    private JButton botonAnclaDinamica;
    private JButton botonEnlaceEstatico;
    private JButton botonEnlaceDinamico;
    private JButton botonEnlaceEstaticoNArio;
    private JButton botonEnlaceDinamicoNArio;
    private JButton botonSeleccion;
    private JButton botonDelete;
    
    private Color colorNormal;
    private Color colorOscuro;

    
    public FigurasContenido(FactoriaControladores factoriaControladores) {
        this.factoriaControladores=factoriaControladores;
        BoxLayout box=new BoxLayout(this, BoxLayout.X_AXIS);
        this.setLayout(box);
        try {
        //Contenido estático Grande
        URL urlContenidoEstaticoGrande = this.getClass().getClassLoader().getResource("Imagenes/ContenidoEstatico.gif");
        botonContenidoEstaticoGrande=new JButton(new ImageIcon(urlContenidoEstaticoGrande));
        botonContenidoEstaticoGrande.setToolTipText("Contenido Estatico Grande");
        this.add(botonContenidoEstaticoGrande);
        colorNormal=botonContenidoEstaticoGrande.getBackground();
        colorOscuro=colorNormal.darker();
        botonContenidoEstaticoGrande.addActionListener(factoriaControladores.getControladorContenidoEstaticoGrande());
        //Contenido estático Pequeño
        URL urlContenidoEstaticoPequeño = this.getClass().getClassLoader().getResource("Imagenes/ContenidoEstatico.gif");
        botonContenidoEstaticoPequeño=new JButton(new ImageIcon(urlContenidoEstaticoPequeño));
        botonContenidoEstaticoPequeño.setToolTipText("Contenido Estatico Pequeño");
        this.add(botonContenidoEstaticoPequeño);
        botonContenidoEstaticoPequeño.addActionListener(factoriaControladores.getControladorContenidoEstaticoPequeño());
        //Ancla Estatica
        URL urlAnclaEstatica = FigurasContenido.class.getClassLoader().getResource("Imagenes/AnclaEstatica.gif");
        botonAnclaEstatica=new JButton(new ImageIcon(urlAnclaEstatica));
        botonAnclaEstatica.setToolTipText("Ancla Estatica");
        this.add(botonAnclaEstatica);
        botonAnclaEstatica.addActionListener(factoriaControladores.getControladorAnclaEstatica());
        //Contenido dinámico Grande
        URL urlContenidoDinamicoGrande = FigurasContenido.class.getClassLoader().getResource("Imagenes/ContenidoDinamico.gif");
        botonContenidoDinamicoGrande=new JButton(new ImageIcon(urlContenidoDinamicoGrande));
        botonContenidoDinamicoGrande.setToolTipText("Contenido Dinamico");
        this.add(botonContenidoDinamicoGrande);
        botonContenidoDinamicoGrande.addActionListener(factoriaControladores.getControladorContenidoDinamicoGrande());
        //Contenido dinámico Pequeño
        URL urlContenidoDinamicoPequeño = FigurasContenido.class.getClassLoader().getResource("Imagenes/ContenidoDinamico.gif");
        botonContenidoDinamicoPequeño=new JButton(new ImageIcon(urlContenidoDinamicoPequeño));
        botonContenidoDinamicoPequeño.setToolTipText("Contenido Dinamico");
        this.add(botonContenidoDinamicoPequeño);
        botonContenidoDinamicoPequeño.addActionListener(factoriaControladores.getControladorContenidoDinamicoPequeño());
        //Ancla Dinamica
        URL urlAnclaDinamica = FigurasContenido.class.getClassLoader().getResource("Imagenes/AnclaDinamica.gif");
        botonAnclaDinamica=new JButton(new ImageIcon(urlAnclaDinamica));
        botonAnclaDinamica.setToolTipText("Ancla Dinamica");
        this.add(botonAnclaDinamica);
        botonAnclaDinamica.addActionListener(factoriaControladores.getControladorAnclaDinamica());
        //Enlace Estatico
        URL urlEnlaceEstatico = FigurasContenido.class.getClassLoader().getResource("Imagenes/Transition.gif");
        botonEnlaceEstatico=new JButton(new ImageIcon(urlEnlaceEstatico));
        botonEnlaceEstatico.setToolTipText("Enlace Estatico");
        this.add(botonEnlaceEstatico);
        botonEnlaceEstatico.addActionListener(factoriaControladores.getControladorEnlaceEstatico());
        //Enlace Dinamico
        URL urlEnlaceDinamico = FigurasContenido.class.getClassLoader().getResource("Imagenes/enlaceDinamico.gif");
        botonEnlaceDinamico=new JButton(new ImageIcon(urlEnlaceDinamico));
        botonEnlaceDinamico.setToolTipText("Enlace Dinamico");
        this.add(botonEnlaceDinamico);
        botonEnlaceDinamico.addActionListener(factoriaControladores.getControladorEnlaceDinamico());
        //Enlace Estatico N Ario
        URL urlEnlaceEstaticoNArio = FigurasContenido.class.getClassLoader().getResource("Imagenes/enlaceEstaticoNArio.gif");
        botonEnlaceEstaticoNArio=new JButton(new ImageIcon(urlEnlaceEstaticoNArio));
        botonEnlaceEstaticoNArio.setToolTipText("Enlace Estatico n-ario");
        this.add(botonEnlaceEstaticoNArio);
        botonEnlaceEstaticoNArio.addActionListener(factoriaControladores.getControladorEnlaceEstaticoNArio());
        //Enlace Dinamico N Ario
        URL urlEnlaceDinamicoNario = FigurasContenido.class.getClassLoader().getResource("Imagenes/enlaceDinamicoNArio.gif");
        botonEnlaceDinamicoNArio=new JButton(new ImageIcon(urlEnlaceDinamicoNario));
        botonEnlaceDinamicoNArio.setToolTipText("Enlace Dinamico n-ario");
        this.add(botonEnlaceDinamicoNArio);
        botonEnlaceDinamicoNArio.addActionListener(factoriaControladores.getControladorEnlaceDinamicoNArio());
        //Boton de seleccion de un elemento
        URL urlSeleccion = FigurasContenido.class.getClassLoader().getResource("Imagenes/Seleccion.gif");
        botonSeleccion=new JButton(new ImageIcon(urlSeleccion));
        botonSeleccion.setToolTipText("Seleccionar");
        this.add(botonSeleccion);
        botonSeleccion.addActionListener(factoriaControladores.getControladorSeleccionContenido());
        //Boton de borrado de un elemento
        URL urlDelete = FigurasContenido.class.getClassLoader().getResource("Imagenes/delete.gif");
        botonDelete=new JButton(new ImageIcon(urlDelete));
        botonDelete.setToolTipText("Borrado de un elemento");
        this.add(botonDelete);
        botonDelete.addActionListener(factoriaControladores.getControladorDeleteContenido());
        } catch (Exception e) {
			e.printStackTrace();
		}
    }
    
    /* (non-Javadoc)
     * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
     */
    public void update(Observable arg0, Object arg1) {
        Modelo modelo=(Modelo)arg0;
        botonContenidoDinamicoPequeño.setBackground(colorNormal);
        botonContenidoDinamicoGrande.setBackground(colorNormal);
        botonAnclaDinamica.setBackground(colorNormal);
        botonAnclaEstatica.setBackground(colorNormal);
        botonEnlaceDinamico.setBackground(colorNormal);
        botonEnlaceEstatico.setBackground(colorNormal);
        botonEnlaceEstaticoNArio.setBackground(colorNormal);
        botonContenidoEstaticoGrande.setBackground(colorNormal);
        botonContenidoEstaticoPequeño.setBackground(colorNormal);
        botonEnlaceDinamicoNArio.setBackground(colorNormal);
        botonSeleccion.setBackground(colorNormal);
        
        int seleccionado=modelo.getTipoSeleccionadoContenido();
        if (seleccionado==Elemento.CONTENIDO_DINAMICO_PEQUEÑO) {
            botonContenidoDinamicoPequeño.setBackground(colorOscuro);
        } else if (seleccionado==Elemento.ANCLA_DINAMICA) {
            botonAnclaDinamica.setBackground(colorOscuro);
        } else if (seleccionado==Elemento.ENLACE_DINAMICO) {
            botonEnlaceDinamico.setBackground(colorOscuro);
        } else if (seleccionado==Elemento.ANCLA_ESTATICA) {
            botonAnclaEstatica.setBackground(colorOscuro);
        } else if (seleccionado==Elemento.ENLACE_ESTATICO) {
            botonEnlaceEstatico.setBackground(colorOscuro);
        } else if (seleccionado==Elemento.ENLACE_ESTATICO_NARIO) {
            botonEnlaceEstaticoNArio.setBackground(colorOscuro);
        } else if (seleccionado==Elemento.CONTENIDO_ESTATICO_GRANDE) {
            botonContenidoEstaticoGrande.setBackground(colorOscuro);
        } else if (seleccionado==Elemento.ENLACE_DINAMICO_NARIO){
        	botonEnlaceDinamicoNArio.setBackground(colorOscuro);
        } else if (seleccionado==Elemento.SELECCION) {
        	botonSeleccion.setBackground(colorOscuro);
        } else if (seleccionado==Elemento.CONTENIDO_DINAMICO_GRANDE) {
            botonContenidoDinamicoGrande.setBackground(colorOscuro);
        } else if (seleccionado==Elemento.CONTENIDO_ESTATICO_PEQUEÑO) {
            botonContenidoEstaticoPequeño.setBackground(colorOscuro);
        }
    }
    
    

}
