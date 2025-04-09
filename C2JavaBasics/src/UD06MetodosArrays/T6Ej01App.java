package UD06MetodosArrays;

import javax.swing.JOptionPane;

public class T6Ej01App {

	public static void main(String[] args) {
		// Pedir los datos del poligono
		String poligono = JOptionPane.showInputDialog("Introduce un poligono: ");
		poligono.toLowerCase();

		switch (poligono) {
			case "circulo":
				// 1. Pedir variable de parametro radio
				// 2. Pedir los valores
				double radio = Double.parseDouble(JOptionPane.showInputDialog("Dame el radio: "));
				// 3.Llamar el metodo y mostrar el resultado
				double resultado = Math.round(circulo(radio));
				JOptionPane.showMessageDialog(null, "El resultado del " + "area del circulo es: " + resultado);
				break;
	
			case "triangulo":
				// 1.Crear dos variables base y altura
				double base = Double.parseDouble(JOptionPane.showInputDialog("Dame la base: "));
				double altura = Double.parseDouble(JOptionPane.showInputDialog("Dame la altura: "));
				// 3.Llamar el metodo y mostrar el resultado
				double resultado2 = Math.round(triangulo(base, altura));
				JOptionPane.showMessageDialog(null, "El resultado del " + "area del triangulo es: " + resultado2);
				break;
	
			case "cuadrado":
				// 1.Crear una variable del lado
				double lado = Double.parseDouble(JOptionPane.showInputDialog("Dame el lado: "));
				// 3.Llamar el metodo y mostrar el resultado
				double resultado3 = Math.round(cuadrado(lado));
				JOptionPane.showMessageDialog(null, "El resultado del " + "area del cuadrado es: " + resultado3);
				break;

		}
//		int key = 9;
//		String semana = "";
//		switch (semana) {
//		case "lunes":
//			// accion
//			System.out.println("Es Lunes");
//			break;
//		case "martes":
//			// accion
//			System.out.println("Esto vale 1");
//			break;
//		case "miércoles":
//			// accion
//			System.out.println("Esto vale 2");
//			break;
//
//		default:
//			// acción por defecto si no entra en ningun case
//			System.out.println("No es ningun dia de la semana");
//		}
		// Continua el codigo
	}

	private static double circulo(double var1) {
		return (var1 * var1) * Math.PI;
	}

	private static double triangulo(double base, double altura) {
		return (base * altura) / 2;
	}

	private static double cuadrado(double lado) {
		return (lado * lado);
	}
}	