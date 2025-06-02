package UD19SwingAWT;

import javax.swing.*;

public class Calculadora {
    public static void main(String[] args) {
        // Crear la ventana principal
        SwingUtilities.invokeLater(() -> {
            VentanaCalculadora ventana = new VentanaCalculadora();
            ventana.setVisible(true);
        });
    }
}