package UD07ArrayslistHashtable;

import java.util.*;

public class NotaMediana {


	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		Map<String, ArrayList<Double>> notasAlumnos = demanarNotes(scanner); 
		Map<String, Double> mitjanesAlumnes = calcularMitjanes(notasAlumnos); 
		mostrarMitjanes(mitjanesAlumnes);

		scanner.close();
	}

	// Mètode per demanar noms i notes dels alumnes
	public static Map<String, ArrayList<Double>> demanarNotes(Scanner scanner) {
		Map<String, ArrayList<Double>> dades = new HashMap<>();

		System.out.print("cuantos alumnos vas a introducir? ");
		int numAlumnes = scanner.nextInt();
		scanner.nextLine(); // Neteja buffer

		for (int i = 0; i < numAlumnes; i++) {
			System.out.print("nombre del alumno " + (i + 1) + ": ");
			String nom = scanner.nextLine();

			ArrayList<Double> notes = new ArrayList<>();
			System.out.print("cuantas notas tiene " + nom + "? ");
			int numNotes = scanner.nextInt();

			for (int j = 0; j < numNotes; j++) {
				System.out.print("introducir la nota " + (j + 1) + ": ");
				double nota = scanner.nextDouble();
				notes.add(nota);
			}

			scanner.nextLine(); // Neteja buffer

			dades.put(nom, notes);
		}

		return dades;
	}

	// Mètode per calcular la mitjana de cada alumne
	public static Map<String, Double> calcularMitjanes(Map<String, ArrayList<Double>> dades) {
		Map<String, Double> mitjanes = new HashMap<>();

		for (Map.Entry<String, ArrayList<Double>> entrada : dades.entrySet()) {
			String alumne = entrada.getKey();
			ArrayList<Double> notes = entrada.getValue();

			double suma = 0;
			for (double nota : notes) {
				suma += nota;
			}

			double mitjana = suma / notes.size();
			mitjanes.put(alumne, mitjana);
		}

		return mitjanes;
	}

	// Mètode per mostrar les mitjanes
	public static void mostrarMitjanes(Map<String, Double> mitjanes) {
		System.out.println("\n--- Nota mediana de alumno ---");
		for (Map.Entry<String, Double> entrada : mitjanes.entrySet()) {
			System.out.printf("%s 🡆 %.2f%n", entrada.getKey(), entrada.getValue());
		}
	}
}