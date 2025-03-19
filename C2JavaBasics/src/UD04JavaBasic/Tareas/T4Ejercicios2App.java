package UD04JavaBasic.Tareas;

public class T4Ejercicios2App {
	public static void main(String[] args) {
		// Declaración e inicialización de variables
		int N = 5;
		double A = 4.56;
		char C = 'a';
		char D = '&';
		
		// Muestra el valor de cada variable
		System.out.println("Variable N = " + N);
		System.out.println("Variable A = " + A);
		System.out.println("Variable C = " + C);
		System.out.println("Variable D = " + D);
//      Double resultadoSuma = N + A;
		
		// Muestra la suma de N + A y la diferencia de A - N
		System.out.println(N + " + " + A + " = " + (N + A));
		System.out.println(A + " - " + N + " = " + (A - N));
		
		// Muestra el valor numérico correspondiente al carácter en la variable C
		System.out.println("Valor numérico del carácter " + C + " = " + (int) C); 
		
		// URL de referencia para la tabla ASCII
		// https://elcodigoascii.com.ar/ Tabla ASCII
		
		System.out.println("Ejemplo de & en ASCII: " + (int) D); // Error corregido: Error de impresión
	}
}