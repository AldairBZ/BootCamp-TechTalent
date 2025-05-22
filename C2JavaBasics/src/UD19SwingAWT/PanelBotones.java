package UD19SwingAWT;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PanelBotones extends JPanel {

    private JTextField campoOperador;
    private JTextField campoResultado;
    private DefaultListModel<String> modeloHistorial;

    private String operadorActual = "";
    private double operando1 = 0;
    private boolean nuevoNumero = true;

    public PanelBotones(JTextField campoOperador, JTextField campoResultado, DefaultListModel<String> modeloHistorial) {
        this.campoOperador = campoOperador;
        this.campoResultado = campoResultado;
        this.modeloHistorial = modeloHistorial;

        setLayout(new GridLayout(6, 4, 5, 5));

        String[] etiquetas = {
            "√", "^", "←", "C",
            "7", "8", "9", "÷",
            "4", "5", "6", "×",
            "1", "2", "3", "-",
            ".", "0", "+", "=",
        };

        for (String texto : etiquetas) {
            if (texto.equals("")) {
                add(new JLabel());
            } else {
                JButton btn = new JButton(texto);
                btn.setFont(new Font("Arial", Font.BOLD, 20));
                btn.addActionListener(new BotonListener());

                if (texto.equals("=")) {
                    btn.setFont(new Font("Arial", Font.BOLD, 24));
                }

                add(btn);
            }
        }
    }

    public void cambiarTema(Color fondo, Color texto, Color botones, Color bordes) {
        setBackground(fondo);
        for (Component c : getComponents()) {
            if (c instanceof JButton btn) {
                btn.setBackground(botones);
                btn.setForeground(texto);
                btn.setBorder(BorderFactory.createLineBorder(bordes, 2, true));
                btn.setFocusPainted(false);
            }
        }
    }

    private class BotonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String texto = ((JButton) e.getSource()).getText();

            if ("0123456789.".contains(texto)) {
                if (nuevoNumero) {
                    campoResultado.setText(texto);
                    nuevoNumero = false;
                } else {
                    campoResultado.setText(campoResultado.getText() + texto);
                }
                return;
            }

            switch (texto) {
                case "+": case "-": case "×": case "÷": case "^":
                    operando1 = Double.parseDouble(campoResultado.getText());
                    operadorActual = texto;
                    campoOperador.setText(texto);
                    nuevoNumero = true;
                    break;

                case "=":
                    double operando2 = Double.parseDouble(campoResultado.getText());
                    double resultado = calcularResultado(operando1, operando2);
                    campoResultado.setText(String.valueOf(resultado));
                    modeloHistorial.addElement(operando1 + " " + operadorActual + " " + operando2 + " = " + resultado);
                    campoOperador.setText("");
                    nuevoNumero = true;
                    break;
                    
                case "C":
                    campoResultado.setText("");
                    campoOperador.setText("");
                    nuevoNumero = true;
                    operadorActual = "";
                    break;

                case "←":
                    String current = campoResultado.getText();
                    if (!current.isEmpty()) {
                        campoResultado.setText(current.substring(0, current.length() - 1));
                    }
                    break;

                case "√":
                    String val = campoResultado.getText();
                    if (!val.isEmpty()) {
                        double num = Double.parseDouble(val);
                        double sqrt = Math.sqrt(num);
                        campoResultado.setText(String.valueOf(sqrt));
                        modeloHistorial.addElement("√" + num + " = " + sqrt);
                        nuevoNumero = true;
                    }
                    break;
            }
        }
    }

    private double calcularResultado(double op1, double op2) {
        return switch (operadorActual) {
            case "+" -> op1 + op2;
            case "-" -> op1 - op2;
            case "×" -> op1 * op2;
            case "÷" -> (op2 == 0) ? Double.NaN : op1 / op2;
            case "^" -> Math.pow(op1, op2);
            default -> 0;
        };
    }
}
