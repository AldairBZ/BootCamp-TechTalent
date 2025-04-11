package UD06MetodosArrays;

import java.util.Scanner;

import javax.swing.JOptionPane;

@SuppressWarnings("unused")
public class T6Ej11App {

	public static void main(String[] args) {
		/*
		 * 
		 *
		 * 
		 */

		String tamany = JOptionPane.showInputDialog("¿Cual será el tamaño del array?");
		int tam = Integer.parseInt(tamany);

		StringBuilder coleccion1 = new StringBuilder();
		StringBuilder coleccion2 = new StringBuilder();
		StringBuilder coleccion3 = new StringBuilder();
		int array1[] = new int[tam];
		int array2[] = new int[tam];
		int multiplicado[] = new int[tam];


		rellenarArray1(array1, tam, coleccion1);
		// rellenararray2(array1, array2, yaAsignado, tam, coleccion2);
		rellenarArray2(array1, array2, tam, coleccion2);
		rellenarArray3(array1, array2, multiplicado, tam, coleccion3);

		JOptionPane.showMessageDialog(null,
				"La primera colección contiene: \n - - " + coleccion1 + " - - \n La segunda colección contiene: "
						+ "\n - - " + coleccion2 + " - - \n Y las " + "multiplicaciones dan: \n - - " + coleccion3
						+ " - - ");
	}


	public static void rellenarArray1(int[] array, int tam, StringBuilder coleccion1) {
		int min = 0;
		int max = 10;
		for (int i = 0; i < tam; i++) {
			int alea = (int) ((Math.random() * (max - min)) + min);
			min += 10;
			max += 10;
			array[i] = alea;
			coleccion1.append(alea + " ");
		}
	}


	public static void rellenarArray2(int[] array, int[] aleatorio, int tam, StringBuilder coleccion2) {
		for (int i = 0; i < tam; i++) {
			aleatorio[i] = (int) (Math.random() * (1 + array[i]) - 1);
			coleccion2.append(aleatorio[i] + " ");
		}
	}

	public static void rellenarArray3(int[] array, int[] aleatorio, int[] multiplicado, int tam,
			StringBuilder coleccion3) {
		for (int i = 0; i < tam; i++) {
			multiplicado[i] = array[i] * aleatorio[i];
			coleccion3.append(multiplicado[i] + " ");
		}
	}

}