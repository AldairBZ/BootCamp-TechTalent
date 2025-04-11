package UD06MetodosArrays;

import java.util.Scanner;

public class T6Ej10App {

	public static void main(String[] args) {
		
		int[] numerosPrimos = new int[sizeArray()]; 

		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el valor mínimo:");
		int min = sc.nextInt();
		System.out.println("Introduce el valor máximo:");
		int max = sc.nextInt();

		randomValoresPrimos(numerosPrimos, min, max);

		for (int i = 0; i < numerosPrimos.length; i++) {
			if (i==0) {
				System.out.print("Los números primos son: {[" + i + "] = " 
						+ numerosPrimos[i] + ", ");
			} else if (i == numerosPrimos.length - 1) {
				System.out.print("[" + i + "] = "+numerosPrimos[i] + "}");
			} else if (i == numerosPrimos.length - 2) {
				System.out.print("[" + i + "] = " + numerosPrimos[i] + ", ");
			} else {
				System.out.print("[" + i + "] = " + numerosPrimos[i]);
			}
		}

		System.out.println("\nEl número mayor es: " + buscarMayor(numerosPrimos));
		sc.close();

	}

	private static void randomValoresPrimos(int[] numerosPrimos, int min, int max) {
		// Rellenar array con valores primos random entre min y max
		for (int i = 0; i < numerosPrimos.length; i++) {
			numerosPrimos[i] = numeroPrimo(min, max);
		}

	}

	private static int numeroPrimo(int min, int max) {
	
		int numero = 0;
		boolean esPrimo = false;
		while (!esPrimo) {
			numero = (int) (Math.random() * (max - min + 1) + min);
			esPrimo = esPrimo(numero);
		}

		return numero;
	}

	public static boolean esPrimo(int valorPrimo) {
		boolean primoSiNo = true;

		if (valorPrimo <= 1) {
			primoSiNo = false;
			return primoSiNo;
		}


		for (int i = 2; i <= Math.sqrt(valorPrimo); i++) {
			if (valorPrimo % i == 0) {
				primoSiNo = false;
				return primoSiNo;
				
			}
		}

		return primoSiNo;
	}

	private static int sizeArray() {
	
		Scanner sc = new Scanner(System.in);
		System.out.println("Introduce el tamaño del array:");
		int size = sc.nextInt();
		return size;
	}

	private static int buscarMayor(int[] numerosPrimos) {
		int mayor = 0;
		for (int i = 0; i < numerosPrimos.length; i++) {
			if (numerosPrimos[i] > mayor) {
				mayor = numerosPrimos[i];
			}
		}

		return mayor;
	}

}