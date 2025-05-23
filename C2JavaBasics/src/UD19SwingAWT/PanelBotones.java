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

		String[] etiquetas = { "√", "^", "←", "C", "7", "8", "9", "÷", "4", "5", "6", "×", "1", "2", "3", "-", ".", "0",
				"+", "=" };

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
					campoResultado.setText(texto.equals(".") ? "0." : texto);
					nuevoNumero = false;
				} else {
					campoResultado.setText(campoResultado.getText() + texto);
				}
				return;
			}

			switch (texto) {
			case "+", "-", "×", "÷", "^" -> {
				if (campoResultado.getText().isEmpty() || campoResultado.getText().equals(".")) {
					campoResultado.setText("0");
				}

				if (!operadorActual.isEmpty() && !nuevoNumero) {
					double operando2 = Double.parseDouble(campoResultado.getText());
					operando1 = calcularResultado(operando1, operando2);
					campoResultado.setText(formatearNumero(operando1));
				} else {
					operando1 = Double.parseDouble(campoResultado.getText());
				}

				operadorActual = texto;
				campoOperador.setText(formatearNumero(operando1) + " " + texto);
				nuevoNumero = true;
			}

			case "=" -> {
				try {
					if (campoResultado.getText().isEmpty() || campoResultado.getText().equals(".")) {
						campoResultado.setText("0");
					}

					double operando2 = Double.parseDouble(campoResultado.getText());
					double resultado = calcularResultado(operando1, operando2);

					String resultadoFormateado = formatearNumero(resultado);
					String operando1Formateado = formatearNumero(operando1);
					String operando2Formateado = formatearNumero(operando2);

					campoResultado.setText(resultadoFormateado);
					campoOperador.setText(operando1Formateado + " " + operadorActual + " " + operando2Formateado);
					modeloHistorial.addElement(operando1Formateado + " " + operadorActual + " " + operando2Formateado
							+ " = " + resultadoFormateado);
					nuevoNumero = true;
					operadorActual = "";
				} catch (ArithmeticException ex) {
					campoResultado.setText("Error/Cero no, crack");
					campoOperador.setText("");
					nuevoNumero = true;
					operadorActual = "";
				}
			}

			case "C" -> {
				campoResultado.setText("");
				campoOperador.setText("");
				nuevoNumero = true;
				operadorActual = "";
			}

			case "←" -> {
				String current = campoResultado.getText();
				if (!current.isEmpty()) {
					campoResultado.setText(current.substring(0, current.length() - 1));
				}
			}

			case "√" -> {
				try {
					String val = campoResultado.getText();
					if (!val.isEmpty()) {
						double num = Double.parseDouble(val);
						if (num < 0) {
							campoResultado.setText("Error");
						} else {
							double sqrt = Math.sqrt(num);
							campoResultado.setText(formatearNumero(sqrt));
							modeloHistorial.addElement("√" + formatearNumero(num) + " = " + formatearNumero(sqrt));
							nuevoNumero = true;
						}
					}
				} catch (NumberFormatException ex) {
					campoResultado.setText("Error");
					nuevoNumero = true;
				}
			}
			}
		}
	}

	private double calcularResultado(double op1, double op2) throws ArithmeticException {
		return switch (operadorActual) {
		case "+" -> op1 + op2;
		case "-" -> op1 - op2;
		case "×" -> op1 * op2;
		case "÷" -> {
			if (op2 == 0)
				throw new ArithmeticException("División por cero");
			yield op1 / op2;
		}
		case "^" -> Math.pow(op1, op2);
		default -> 0;
		};
	}

	private String formatearNumero(double numero) {
		if (numero == (int) numero) {
			return String.valueOf((int) numero);
		} else {
			return String.valueOf(numero);
		}
	}
}