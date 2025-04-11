package UD06MetodosArrays;

import java.util.Scanner;

public class T6Ej09Extra {

	public static void main(String[] args) {
		// 1. Preguntar tamaño del array
		int[] numeros = new int[sizeArray()];

		try (// 2. Pedimos 2 valores (max,min) entre los que este de rango el random por consola de scanner
		var sc = new Scanner(System.in)) {
			System.out.println("Introduce el valor mínimo:");
			int min = sc.nextInt();
			System.out.println("Introduce el valor máximo:");
			int max = sc.nextInt();

			// 3. Rellenar array con valores random entre min y max
			randomValores(numeros, min, max);
		}
		// 4. Mostrar valores y suma
		System.out.println("La suma de los valores es: " + mostrarValores(numeros));

	}

	private static int mostrarValores(int[] numeros) {
		// Recorre valores y muestra los randoms y la suma
		int suma = 0;
		for (int i = 0; i < numeros.length; i++) {
			suma += numeros[i];
			System.out.println("Índice: " + i + " - Valor: " + numeros[i]);
		}
		return suma;
	}

	private static int[] randomValores(int[] numeros, int min, int max) {
		for (int i = 0; i < numeros.length; i++) {
            numeros[i] = (int) (Math.random() * (max - min + 1) + min);
		}
		
		return numeros;
	}

	private static int sizeArray() {
		// Pide por consola el tamaño del array
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el tamaño del array:");
		int size = sc.nextInt();
		return size;
	}

}