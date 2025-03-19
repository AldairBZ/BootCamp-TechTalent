package UD04JavaBasic.Tareas;

public class T4Ejercicios3App {
	public static void main(String[] args) {
		// Declaracion e inicializacion de variables
		int X = 10;
		int Y = 5;
		double N = 7.5;
		double M = 2.5;
		
		//Muestra el valor de cada variable
		System.out.println("Valores iniciales");
		System.out.println("x = " + X);
		System.out.println("Y = " + Y);
		System.out.println("N = " + N);
		System.out.println("M = " + M);
		
		//Operaciones con variables enteras (X e Y)
		System.out.println("\nOperaciones con variables enteras (x e y):");
		System.out.println("X + Y = " + (X + Y));
		System.out.println("X - Y = " + (X - Y));
		System.out.println("X * Y = " + (X * Y));
		System.out.println("X / Y = " + (X / Y));
		System.out.println("X % Y = " + (X % Y));
		
		//Operaciones con variables de tipo double (N Y M)
		System.out.println("\nOperaciones con variables de tipo double (N y M):");
		System.out.println("N + M = " + (N + M));
		System.out.println("N - M = " + (N - M));
		System.out.println("N * M = " + (N * M));
		System.out.println("N / M = " + (N / M));
		System.out.println("N % M = " + (N % M));
		
		//Operaciones mixtas
		System.out.println("\nOperaciones mixtas:");
		System.out.println("X + N = " + (X + Y));
		System.out.println("Y / M = " + (Y / M));
		System.out.println("Y % M = " + (Y % M));
		System.out.println();
		
		//Operaciones adicionales
		System.out.println("\nOperaciones adicionales:");
		System.out.println("Double de X = " + (X * 2));
		System.out.println("Double de Y = " + (Y * 2));
		System.out.println("Double de N = " + (N * 2));
		System.out.println("Double de M = " + (M * 2));
		
		//Suma y producto de todas las variables
		Double sumaTodas = X + Y + N + M;
		Double productoTodas = X * Y * N * M;
		
		System.out.println("\nSuma de todas las variables: = " + sumaTodas);
		System.out.println("Producto de todas las variables = " + productoTodas);
	}
}