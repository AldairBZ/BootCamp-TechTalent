package UD19SwingAWT.Tarea;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Saludator3000 extends JFrame {

    // Componentes de la interfaz
    private JTextField campoTexto;
    private JButton botonSaludar;

    // Constructor CORREGIDO con el nombre exacto de la clase
    public Saludator3000() {
        super("Saludador Personalizable");

        setSize(350, 120);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        campoTexto = new JTextField(20);
        botonSaludar = new JButton("Saludar");

        JPanel panel = new JPanel();
        panel.add(new JLabel("Escribe tu nombre:"));
        panel.add(campoTexto);
        panel.add(botonSaludar);

        add(panel);

        botonSaludar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = campoTexto.getText().trim();
                if (!nombre.isEmpty()) {
                    JOptionPane.showMessageDialog(Saludator3000.this,
                        "¡Hola " + nombre + "!");
                } else {
                    JOptionPane.showMessageDialog(Saludator3000.this,
                        "Por favor, escribe tu nombre.");
                }
            }
        });
    }

    // Método principal corregido
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Saludator3000().setVisible(true);  // CORREGIDO aquí
        });
    }
}