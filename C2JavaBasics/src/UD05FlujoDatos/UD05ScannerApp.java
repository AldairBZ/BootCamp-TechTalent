package UD05FlujoDatos;
import java.util.Scanner;

public class UD05ScannerApp {

	public static void main(String[] args) {
		Scanner escaner = new Scanner(System.in); 
		System.out.println("-- Bienvenido a JAVA --");
		System.out.println("Introduce tu edad:");
		
		int edad = escaner.nextInt();
		escaner.close();
		
		if (edad < 18) {
			System.out.println("Eres menor de edad, no te muestro el contenido");
		} else {
			System.out.println("Tu edad es " + edad + ". Eres mayor de edad, el contenido es el siguiente:");
		}
	

	}
	

}