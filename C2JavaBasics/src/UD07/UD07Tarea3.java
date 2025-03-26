/**
 * 
 */
package UD07;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class  UD07Tarea3 {
    private static Map<String, Producto> productos = new HashMap<>();

    public static void main(String[] args) {
        // Inicializar productos
        productos.put("Manzana", new Producto("Manzana", 0.5, 100));
        productos.put("Pan", new Producto("Pan", 1.0, 50));
        productos.put("Leche", new Producto("Leche", 1.2, 30));
        productos.put("Arroz", new Producto("Arroz", 0.8, 20));
        productos.put("Carne", new Producto("Carne", 5.0, 10));
        productos.put("Huevos", new Producto("Huevos", 2.0, 60));
        productos.put("Queso", new Producto("Queso", 3.5, 15));
        productos.put("Aceite", new Producto("Aceite", 4.0, 25));
        productos.put("Pasta", new Producto("Pasta", 1.5, 40));
        productos.put("Jugo", new Producto("Jugo", 2.5, 35));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar nuevo producto");
            System.out.println("2. Consultar producto");
            System.out.println("3. Listar todos los productos");
            System.out.println("4. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    agregarNuevoProducto(scanner);
                    break;
                case 2:
                    consultarProducto(scanner);
                    break;
                case 3:
                    listarProductos();
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida. Por favor intente de nuevo.");
            }
        }
    }

    private static void agregarNuevoProducto(Scanner scanner) {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el precio del producto: ");
        double precio = scanner.nextDouble();
        System.out.print("Ingrese el stock del producto: ");
        int stock = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

        productos.put(nombre, new Producto(nombre, precio, stock));
        System.out.println("Producto agregado exitosamente.");
    }

    private static void consultarProducto(Scanner scanner) {
        System.out.print("Ingrese el nombre del producto: ");
        String nombre = scanner.nextLine();

        Producto producto = productos.get(nombre);
        if (producto != null) {
            System.out.println("Producto: " + producto.getNombre());
            System.out.println("Precio: " + producto.getPrecio());
            System.out.println("Stock: " + producto.getStock());
        } else {
            System.out.println("Producto no encontrado.");
        }
    }

    private static void listarProductos() {
        System.out.println("Listado de productos:");
        for (Producto producto : productos.values()) {
            System.out.println("Producto: " + producto.getNombre() +
                    ", Precio: " + producto.getPrecio() +
                    ", Stock: " + producto.getStock());
        }
    }
}

class Producto {
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStock() {
        return stock;
    }
}