package Ejercicio1;

import javax.swing.*;

public class VentanaBasica {
	
    public static void main(String[] args) {
        // Crear la ventana (JFrame)
        JFrame ventana = new JFrame("Mi Primera Ventana");

        // Configurar tamaño inicial
        ventana.setSize(400, 300);

        // Acción al cerrar la ventana: salir completamente del programa
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Hacer que el usuario pueda cambiar el tamaño
        ventana.setResizable(true);

        // Crear una etiqueta
        JLabel etiqueta = new JLabel("¡Hola, esta es mi etiqueta!", SwingConstants.CENTER);

        // Agregar la etiqueta a la ventana
        ventana.add(etiqueta);

        // Hacer visible la ventana
        ventana.setVisible(true);
    }
}