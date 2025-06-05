package Ejercicio1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContadorBotones {
    public static void main(String[] args) {
        // Crear la ventana
        JFrame ventana = new JFrame("Ventana con más interacción");
        ventana.setSize(300, 150);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new BorderLayout());

        // Contadores de clics
        final int[] contador1 = {0};
        final int[] contador2 = {0};

        // Etiqueta de conteo
        JLabel etiqueta = new JLabel("Boton 1: 0 veces   Boton 2: 0 veces", SwingConstants.CENTER);
        ventana.add(etiqueta, BorderLayout.NORTH);

        // Panel para los botones
        JPanel panelBotones = new JPanel();

        // Botones
        JButton boton1 = new JButton("Boton 1");
        JButton boton2 = new JButton("Boton 2");

        // Acción para el botón 1
        boton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contador1[0]++;
                etiqueta.setText("Boton 1: " + contador1[0] + " veces   Boton 2: " + contador2[0] + " veces");
            }
        });

        // Acción para el botón 2
        boton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contador2[0]++;
                etiqueta.setText("Boton 1: " + contador1[0] + " veces   Boton 2: " + contador2[0] + " veces");
            }
        });

        // Añadir botones al panel
        panelBotones.add(boton1);
        panelBotones.add(boton2);

        // Añadir panel a la ventana
        ventana.add(panelBotones, BorderLayout.CENTER);

        // Mostrar ventana
        ventana.setVisible(true);
    }
}