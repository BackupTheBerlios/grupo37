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
import javax.swing.UIManager;

public class WelcomeApp {
  boolean packFrame = false;

  //Crear la aplicaci�n
  public WelcomeApp() {
    WelcomeFrame frame = new WelcomeFrame();

    //Empaquetar los marcos con informaci�n de tama�o preferente de los usuarios, p. ej. del dise�o
    //Validar marcos que tienen tama�os preestablecidos
    if (packFrame)
      frame.pack();
    else
      frame.validate();

    // Centrar el marco
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = frame.getSize();
    if (frameSize.height > screenSize.height)
      frameSize.height = screenSize.height;
    if (frameSize.width > screenSize.width)
      frameSize.width = screenSize.width;
    frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

    frame.setVisible(true);
  }

  // M�todo Main
  static public void main(String[] args) {
    try {
      UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    }
    catch(Exception e) {
      e.printStackTrace();
    }
    new WelcomeApp();
  }
}

