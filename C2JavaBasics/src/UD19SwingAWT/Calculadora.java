package UD19SwingAWT;

import javax.swing.*;

public class Calculadora {
    public static void main(String[] args) {
    	// Probar la conexión a la base de datos
    	  if (ConnexionBD.obtenerConexion() != null) {
              System.out.println("¡Conexión realizada correctamente!");
          } else {
              System.out.println("No se pudo establecer conexión con la base de datos.");
          }
        // Crear la ventana principal
        SwingUtilities.invokeLater(() -> {
            VentanaCalculadora ventana = new VentanaCalculadora();
            ventana.setVisible(true);
        });
    }
}