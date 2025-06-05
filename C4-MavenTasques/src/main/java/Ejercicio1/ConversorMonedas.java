package Ejercicio1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConversorMonedas {

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Calculadora cambio de monedas");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 120);
        ventana.setLayout(new FlowLayout());


        JLabel labelCantidad = new JLabel("Cantidad a convertir");
        JTextField campoCantidad = new JTextField(10);
        JLabel labelResultado = new JLabel("Resultado");
        JTextField campoResultado = new JTextField(10);
        campoResultado.setEditable(false);

        JButton botonCambiar = new JButton("Cambiar");
        JButton botonBorrar = new JButton("Borrar");

       
        ActionListener accionConvertir = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double pesetas = Double.parseDouble(campoCantidad.getText());
                    double euros = pesetas / 166.386;
                    campoResultado.setText(String.format("%.2f", euros));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(ventana, "Por favor, introduce un número válido.", "Error de formato", JOptionPane.ERROR_MESSAGE);
                }
            }
        };


        botonBorrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                campoCantidad.setText("");
                campoResultado.setText("");
            }
        });


        botonCambiar.addActionListener(accionConvertir);
        campoCantidad.addActionListener(accionConvertir);

      
        ventana.add(labelCantidad);
        ventana.add(campoCantidad);
        ventana.add(labelResultado);
        ventana.add(campoResultado);
        ventana.add(botonCambiar);
        ventana.add(botonBorrar);

        
        ventana.setVisible(true);
    }
}