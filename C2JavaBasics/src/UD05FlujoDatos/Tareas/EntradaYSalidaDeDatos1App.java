package ud05FlujoDeDatos;

import java.util.Scanner;

public class EntradaYSalidaDeDatos1App {

	public static void main(String[] args) {
		 //Creamos un formulario tipo scanner
		Scanner pepito = new Scanner (System.in);
		
		System.out.println("-- Bienvenido a JAVA 21 --");
		System.out.println("Introduce tu nombre: ");
		/*Le pedimos al usuario un mensaje, que rellene
		un formulario de tipo texto*/
		
		String nombre = pepito.nextLine();
		pepito.close();
		//Abrimos y cerramos el recurso
		
		System.out.println("Hola "+nombre.toUpperCase());
		//UpperCase es para que salga en mayúscula,
		//que no es obligatorio.
		
		
	}

}