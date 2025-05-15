package UD07ArrayslistHashtable;

//blibliotecas que se usaran

import java.util.HashMap;
import java.util.Scanner;

//main

public class Ej03articuloStockprecioApp {

	public static void main(String[] args) {
		HashMap<String, Double> Precios = new HashMap<>();
		HashMap<String, Integer> Stock = new HashMap<>();
		Scanner sc = new Scanner(System.in);

		// Inicializa los datos de productos y su stock.
		inicializarBaseDatos(Precios, Stock);
		mostrarMenu(sc, Precios, Stock);
	}

	public static void mostrarMenu(Scanner sc, HashMap<String, Double> Precios, HashMap<String, Integer> Stock) {
		int opcion;
		do {
			System.out.println("\n===== MENU PRINCIPAL =====");
			System.out.println("1. Mostrar todos los productos");
			System.out.println("2. Consultar información de un producto");
			System.out.println("3. Añadir nuevo producto");
			System.out.println("4. Salir");
			System.out.print("Elige una opción: ");
			opcion = sc.nextInt();
			sc.nextLine();
			procesarOpcion(opcion, Precios, Stock, sc);
		} while (opcion != 4);
	}

	public static void procesarOpcion(int opcion, HashMap<String, Double> Precios, HashMap<String, Integer> Stock, Scanner sc) {
		switch (opcion) {
		case 1:
			mostrarProductos(Precios, Stock);
			break;
		case 2:
			consultarProducto(Precios, Stock, sc);
			break;
		case 3:
			añadirProducto(Precios, Stock, sc);
			break;
		case 4:
			System.out.println("Gracias, ¡adiós!");
			break;
		default:
			System.out.println("Opción no válida. Por favor, intenta de nuevo.");
		}
	}

	// Inicializa los datos de productos y su stock.
	public static void inicializarBaseDatos(HashMap<String, Double> Precios, HashMap<String, Integer> Stock) {
		Precios.put("Manzana", 0.99);
		Precios.put("Leche", 1.49);
		Precios.put("Pan", 2.75);
		Precios.put("Arroz", 1.20);
		Precios.put("Huevos", 3.50);
		Precios.put("Queso", 4.99);
		Precios.put("Tomate", 1.10);
		Precios.put("Pasta", 2.30);
		Precios.put("Café", 5.40);
		Precios.put("Té", 3.00);

		Stock.put("Manzana", 50);
		Stock.put("Leche", 30);
		Stock.put("Pan", 20);
		Stock.put("Arroz", 100);
		Stock.put("Huevos", 60);
		Stock.put("Queso", 15);
		Stock.put("Tomate", 40);
		Stock.put("Pasta", 70);
		Stock.put("Café", 25);
		Stock.put("Té", 45);
	}

	// Muestra la lista de productos disponibles junto con su precio y stock.
	public static void mostrarProductos(HashMap<String, Double> Precios, HashMap<String, Integer> Stock) {
		System.out.println("\n===== LISTA DE PRODUCTOS =====");
		for (String articulo : Precios.keySet()) {
			double precio = Precios.get(articulo);
			int stock = Stock.get(articulo);
			System.out.println("Artículo: " + articulo + ", Precio: " + precio + "€, Stock: " + stock);
		}
	}

	// Permite consultar detalles de un producto específico.
	public static void consultarProducto(HashMap<String, Double> Precios, HashMap<String, Integer> Stock, Scanner sc) {
		System.out.print("\nIntroduce el nombre del artículo a consultar: ");
		String articulo = sc.nextLine();
		if (Precios.containsKey(articulo)) {
			double precio = Precios.get(articulo);
			int stock = Stock.get(articulo);
			System.out.println("Artículo: " + articulo + ", Precio: " + precio + "€, Stock: " + stock);
		} else {
			System.out.println("El artículo no se encuentra en la lista.");
		}
	}

	// Permite añadir un nuevo producto a los HashMap.
	public static void añadirProducto(HashMap<String, Double> Precios, HashMap<String, Integer> Stock, Scanner sc) {
		System.out.print("\nIntroduce el nombre del nuevo artículo: ");
		String articulo = sc.nextLine();
		if (Precios.containsKey(articulo)) {
			System.out.println("El artículo ya existe.");
		} else {
			System.out.print("Introduce el precio del artículo: ");
			double precio = sc.nextDouble();
			System.out.print("Introduce la cantidad en stock: ");
			int stock = sc.nextInt();
			sc.nextLine();
			Precios.put(articulo, precio);
			Stock.put(articulo, stock);
			System.out.println("Artículo añadido correctamente.");
		}
	}
}