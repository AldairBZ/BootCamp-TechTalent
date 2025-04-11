package UD06MetodosArrays;

import java.util.Scanner;

public class T6Ej12App {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingresa la longitud del array a crear:");
		int lengthIntro = Integer.parseInt(sc.nextLine());

		int[] arrayCreado = crearYrellenarArrayRANDOM(lengthIntro);

		System.out.println("El array creado es:");
		imprimirArray(arrayCreado);
		System.out.println("\n¿Que ultimo digito quieres chequear?");
		String num2checkIntro = sc.nextLine();
		checkArray(arrayCreado, num2checkIntro);
		System.out.println("\nSe ha generado el array cuyo digito escogido "
				+ "\ncoincide con los valores del array generado anteriormente:");
		imprimirArray(newArraySelectedDigit(arrayCreado, num2checkIntro));
		sc.close();
	}

	public static int[] crearYrellenarArrayRANDOM(int lengthArray) {

		int array[] = new int[lengthArray];

		for (int i = 0; i < lengthArray; i++) {
			int randomNum = (int) (Math.random() * (300 - 1 + 1)) + 1;
			array[i] = randomNum;
		}

		return array;
	}

	public static void imprimirArray(int lista[]) {
		for (int i = 0; i < lista.length; i++) {
			System.out.print(lista[i]);
			if (i < lista.length - 1) {
				System.out.print(", ");
			}
		}
	}

	public static void checkArray(int array2check[], String num2check) {
		System.out.print("Los numeros cuyo ultimo digito es " + num2check + " son:");
		for (int i = 0; i < array2check.length; i++) {
			String valuePosition = String.valueOf(array2check[i]);
			char lastDigit = valuePosition.charAt(valuePosition.length() - 1);

			if (String.valueOf(lastDigit).equals(num2check)) {
				System.out.print("\n" + valuePosition);
			}

		}
	}

	public static int[] newArraySelectedDigit(int[] array2check, String num2check) {
	
		int[] numerosGuardadosTEMP = new int[array2check.length];
		int coincidencias = 0; // contador generado

		for (int i = 0; i < array2check.length; i++) {
			String checkPosition = String.valueOf(array2check[i]);
			char lastDigit = checkPosition.charAt(checkPosition.length() - 1);

			if (String.valueOf(lastDigit).equals(num2check)) {
				numerosGuardadosTEMP[coincidencias] = array2check[i];
				coincidencias++;
			}
		}
		int size = coincidencias;

		int[] arrayFinal = new int[size];
		
		System.arraycopy(numerosGuardadosTEMP, 0, arrayFinal, 0, size);

		return arrayFinal;

	}


	public static void mostrarArrayDigito(int[] a, int n) {
		for (int i = 0; i < a.length; i++) {
			if (a[i] % 10 == n) {
				System.out.println("a[" + i + "] : " + a[i]);
			}
		}
	}
}