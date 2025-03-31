package UD05FlujoDatos;

import javax.swing.JOptionPane;

public class T5Ej11App {

	public static void main(String[] args) {
		String semana = ""; 

		semana = JOptionPane.showInputDialog("" + "Introduce el dia de la semana: ");

		semana = semana.toLowerCase();

		String laborableMensaje = "";

		switch (semana) {
			case "lunes", "martes", "miércoles", "jueves", "viernes":
				laborableMensaje = "Laborable";
				break;
			default:
				laborableMensaje = "No laborable " + " o no es un dia de la semana";
				break;
		}
		System.out.println(laborableMensaje);

	}

}