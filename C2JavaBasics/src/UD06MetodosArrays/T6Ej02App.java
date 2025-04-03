package UD06MetodosArrays;

import java.util.Random;
import javax.swing.JOptionPane;

public class T6Ej02App {
	

	public static void main(String[] args) {
		
		int cantRadoms = Integer.parseInt(JOptionPane.showInputDialog("Introduce" + "la cantidad de ramdoms: "));
		
		int rangoMax, rangoMin;
		
		
		while (cantRadoms > 0) {
			//Acciones de rangos y randoms
			rangoMin = Integer.parseint(JOptionPane.showInputDialog("" + "Introduce el rango minimo: "));
			rangoMax = Integer.parseInt(JOptionPane.showInputDialog("" + "Introduce el rango maximo: "));
			System.out.println(enteroRandom(rangoMin, rangoMax));
			cantRadoms--;
		}
}

	// Metodo para generar un numero random entre dos rangos
	public static int enteroRandom(int rangoMin, int rangoMax) {
		Random aleatorio = new Random();
		int resultado = aleatorio.nextInt(rangoMax - rangoMin);
		return resultado;
	}
}