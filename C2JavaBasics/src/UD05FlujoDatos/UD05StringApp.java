package UD05FlujoDatos;

public class UD05StringApp {

	public static void main(String[] args) {

		String cadena1 = "Hola"; //Forma simple de crear un String
		
		String cadena2 = new String("Mundo"); //Forma de rear un objeto String
		
		System.out.println(cadena1 + " " + cadena2 + "!");
		
		String cadena3 = "Esto es un ejemplo "
				+ "de String de "
				+ "varias lineas";
		System.out.println("\nMostrar cadena3: " + cadena3);
		//Aunque se representan en una sola linea, a no ser del uso de \n
		
	}

}