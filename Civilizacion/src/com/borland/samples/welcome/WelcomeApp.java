/**
 * Copyright (c) 1996-2003 Borland Software Corporation. Reservados todos los derechos.
 * 
 * Este ARCHIVO DE CÓDIGO FUENTE, proporcionado por Borland Software como parte
 * de un producto de Borland Software para su utilización SÓLO por parte de los usuarios con licencia,
 * incluye información CONFIDENCIAL y PROPIEDAD de Borland Software.  
 *
 * LA UTILIZACIÓN DE ESTE SOFTWARE SE RIGE POR LOS TÉRMINOS Y CONDICIONES
 * DE LA DECLARACIÓN DE LICENCIA Y DE LA GARANTÍA LIMITADA PROPORCIONADA JUNTO CON
 * EL PRODUCTO.
 *
 * CONCRETAMENTE, TENDRÁ QUE DESAGRAVIAR Y MANTENER A BORLAND SOFTWARE, SUS
 * COMPAÑÍAS RELACIONADAS Y PROVEEDORES AL MARGEN DE TODA
 * DEMANDA O CAUSA POR RESPONSABILIDAD CIVIL DERIVADA DE LA UTILIZACIÓN, REPRODUCCIÓN O
 * DISTRIBUCIÓN DE SUS PROGRAMAS, ENTRE LAS QUE SE INCLUYE CUALQUIER DEMANDA O CAUSA POR RESPONSABILIDAD CIVIL
 * DERIVADA O RESULTANTE DE LA UTILIZACIÓN, MODIFICACIÓN O
 * DISTRIBUCIÓN DE PROGRAMAS O ARCHIVOS CREADOS A PARTIR DE, BASADOS EN Y/O
 * DERIVADOS DE ESTE ARCHIVO DE CÓDIGO FUENTE.
 */


package com.borland.samples.welcome;

import java.awt.*;
import javax.swing.UIManager;

public class WelcomeApp {
  boolean packFrame = false;

  //Crear la aplicación
  public WelcomeApp() {
    WelcomeFrame frame = new WelcomeFrame();

    //Empaquetar los marcos con información de tamaño preferente de los usuarios, p. ej. del diseño
    //Validar marcos que tienen tamaños preestablecidos
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

  // Método Main
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

