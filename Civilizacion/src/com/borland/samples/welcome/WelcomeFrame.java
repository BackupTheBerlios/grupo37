/**
 * Copyright (c) 1996-2003 Borland Software Corporation. Reservados todos los derechos.
 * 
 * Este ARCHIVO DE C�DIGO FUENTE, proporcionado por Borland Software como parte
 * de un producto de Borland Software para su utilizaci�n S�LO por parte de los usuarios con licencia,
 * incluye informaci�n CONFIDENCIAL y PROPIEDAD de Borland Software.  
 *
 * LA UTILIZACI�N DE ESTE SOFTWARE SE RIGE POR LOS T�RMINOS Y CONDICIONES
 * DE LA DECLARACI�N DE LICENCIA Y DE LA GARANT�A LIMITADA PROPORCIONADA JUNTO CON
 * EL PRODUCTO.
 *
 * CONCRETAMENTE, TENDR� QUE DESAGRAVIAR Y MANTENER A BORLAND SOFTWARE, SUS
 * COMPA��AS RELACIONADAS Y PROVEEDORES AL MARGEN DE TODA
 * DEMANDA O CAUSA POR RESPONSABILIDAD CIVIL DERIVADA DE LA UTILIZACI�N, REPRODUCCI�N O
 * DISTRIBUCI�N DE SUS PROGRAMAS, ENTRE LAS QUE SE INCLUYE CUALQUIER DEMANDA O CAUSA POR RESPONSABILIDAD CIVIL
 * DERIVADA O RESULTANTE DE LA UTILIZACI�N, MODIFICACI�N O
 * DISTRIBUCI�N DE PROGRAMAS O ARCHIVOS CREADOS A PARTIR DE, BASADOS EN Y/O
 * DERIVADOS DE ESTE ARCHIVO DE C�DIGO FUENTE.
 */

package com.borland.samples.welcome;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class WelcomeFrame extends JFrame {
  JPanel contentPane;
  BorderLayout borderLayout1 = new BorderLayout();
  JMenuBar jMenuBar1 = new JMenuBar();
  JMenu jMenuFile = new JMenu();
  JMenuItem jMenuFileExit = new JMenuItem();
  JMenu jMenuHelp = new JMenu();
  JMenuItem jMenuHelpAbout = new JMenuItem();

  // Construir el marco
  public WelcomeFrame() {
    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      jbInit();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
  }

  //Inicializaci�n del componente
  private void jbInit() throws Exception  {
    contentPane = (JPanel) this.getContentPane();
    contentPane.setLayout(borderLayout1);
    this.setTitle("Bienvenido a JBuilder");
    this.setJMenuBar(jMenuBar1);
    this.setSize(new Dimension(400, 300));
    jMenuFile.setText("Archivo");
    jMenuFileExit.setText("Salir");
    jMenuFileExit.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jMenuFileExit_actionPerformed(e);
      }
    });
    jMenuFile.add(jMenuFileExit);
    jMenuHelp.setText("Ayuda");
    jMenuHelpAbout.setText("Acerca de");
    jMenuHelpAbout.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(ActionEvent e) {
        jMenuHelpAbout_actionPerformed(e);
      }
    });
    jMenuHelp.add(jMenuHelpAbout);
    jMenuBar1.add(jMenuFile);
    jMenuBar1.add(jMenuHelp);
  }

  //Modificado para poder salir cuando se cierra la ventana
  protected void processWindowEvent(WindowEvent e) {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      System.exit(0);
    }
  }

  //Realizada la acci�n Archivo | Salir
  public void jMenuFileExit_actionPerformed(ActionEvent e) {
    System.exit(0);
  }

  //Realizada la acci�n Ayuda | Acerca de
  public void jMenuHelpAbout_actionPerformed(ActionEvent e) {
  }
}

