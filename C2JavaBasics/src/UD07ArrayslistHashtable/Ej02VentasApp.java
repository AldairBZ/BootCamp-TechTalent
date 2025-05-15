package UD07ArrayslistHashtable;

import java.util.ArrayList;
import java.util.Scanner;

public class Ej02VentasApp {

	// Método principal: punto de inicio del programa
	public static void main(String[] args) {
		double IVA = 0.21; 
		Scanner sc = new Scanner(System.in); 
		ArrayList<Double> carrito = new ArrayList<>(); 

		// Llamada a los métodos principales
		ingresePrecios(sc, carrito); 
		double[] resultados = seleccionarIVA(sc, carrito);
		IVA = resultados[0]; 
		double suma = resultados[1]; 
		double totalconIVA = resultados[2]; 
		resumen(IVA, suma, totalconIVA, carrito); 
		pagoYcambio(sc, totalconIVA); 
	}

	// Método para ingresar precios de los productos
	public static void ingresePrecios(Scanner sc, ArrayList<Double> carrito) {
		System.out.println("Ingrese el precio de los productos uno por uno (digite -1 para terminar):");
		while (true) {
			double precio = sc.nextDouble(); 
			if (precio == -1) { 
				break;
			}
			carrito.add(precio);
		}
	}


	// Método para seleccionar IVA y calcular totales
	public static double[] seleccionarIVA(Scanner sc, ArrayList<Double> carrito) {
		double suma = 0; 
		for (double precio : carrito) { 
			suma += precio;
		}

		System.out.println("El precio en bruto es: " + (Math.round(suma * 100.0) / 100.0));
		System.out.println("\nSelecciona el IVA: \n1. 21%\n2. 4%");
		int opcionIVA = sc.nextInt(); 

		double IVA = 0; 
		double totalconIVA = 0; 
		switch (opcionIVA) {
		case 1:
			IVA = 0.21; 
			totalconIVA = suma * (1 + IVA); 
			System.out.println("El precio con el 21% de IVA es: " + (Math.round(totalconIVA * 100.0) / 100.0));
			break;
		case 2:
			IVA = 0.04;
			totalconIVA = suma * (1 + IVA); 
			System.out.println("El precio con el 4% de IVA es: " + Math.round(totalconIVA * 100.0) / 100.0);
			break;
		default:
			System.out.println("Opción de IVA no válida."); 
			break;
		}
		return new double[] { IVA, suma, totalconIVA }; 
	}

	// Método para mostrar un resumen de la compra
	public static void resumen(double IVA, double suma, double totalconIVA, ArrayList<Double> carrito) {
		System.out.println("\n--- Resumen de la compra ---");
		System.out.println("IVA aplicado: " + (IVA * 100) + "%"); 
		System.out.println("Precio bruto: " + (Math.round(suma * 100.0) / 100.0)); 
		System.out.println("Precio total (con IVA): " + (Math.round(totalconIVA * 100.0) / 100.0)); 
		System.out.println("Número de artículos comprados: " + carrito.size()); 
	}

	// Método para gestionar el pago y calcular el cambio
	public static void pagoYcambio(Scanner sc, double totalconIVA) {
		System.out.println("Ingrese la cantidad pagada por el cliente: ");
		double pago = sc.nextDouble(); 
		double cambio = Math.round((pago - totalconIVA) * 100.0) / 100.0; 
		if (cambio < 0) { 
			System.out.println("Falta " + cambio + " por pagar.");
		} else {
			System.out.println("Cambio a devolver: " + cambio + " €"); 
		}
	}
}