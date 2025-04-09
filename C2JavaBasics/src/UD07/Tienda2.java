package UD07;

import javax.swing.*;
import java.util.*;

public class Tienda2 {

	private static final Scanner scanner = new Scanner(System.in);
	private static final HashMap<String, HashMap<String, Double>> inventario = new HashMap<>();
	private static final ArrayList<Double> carrito = new ArrayList<>();
	private static double suma;

	public static void main(String[] args) {
		inicializarInventario();
		mostrarBienvenida();
		elegirModo();
	}

	// Muestra un mensaje de bienvenida con opción de entrar
	private static void mostrarBienvenida() {
		Object[] options = { "Entrar" };
		JOptionPane.showOptionDialog(null, "¡Bienvenido a la aplicación de gestión de ventas y stock!", "Bienvenida",
				JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
	}

	// Menú para elegir entre usuario y administrador
	private static void elegirModo() {
		String[] opciones = { "Administrador", "Usuario", "Salir" };
		while (true) {
			String opcion = (String) JOptionPane.showInputDialog(null, "Selecciona el modo de acceso:",
					"Modo de acceso", JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

			if (opcion == null) {
				System.exit(0);
			}

			switch (opcion) {
			case "Administrador" -> mostrarMenuStock();
			case "Usuario" -> mostrarMenuCompras();
			case "Salir" -> System.exit(0);
			}
		}
	}

	// Inicializa la lista de productos con inventario y precios
	private static void inicializarInventario() {
		agregarProducto("Manzana", 0.99, 50, .21);
		agregarProducto("Leche", 1.49, 30, .04);
		agregarProducto("Pan", 2.75, 20, .04);
		agregarProducto("Arroz", 1.20, 100, .04);
		agregarProducto("Huevos", 3.50, 60, .21);
	}

	// 🔹 Agrega un producto al inventario
	private static void agregarProducto(String nombre, double precio, int stock, double iva) {
		HashMap<String, Double> info = new HashMap<>();
		info.put("precio", precio);
		info.put("stock", (double) stock);
		info.put("iva", iva);

		inventario.put(nombre.toLowerCase(), info);
	}

	// Menú administrador con JOptionPane
	private static void mostrarMenuStock() {
		String[] opciones = { "Listar productos", "Consultar un producto", "Añadir o actualizar producto",
				"Volver al menú principal" };
		while (true) {
			String opcion = (String) JOptionPane.showInputDialog(null, "Selecciona una opción:",
					"Modo Administrador: Gestión de Stock", JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

			if (opcion == null || opcion.equals("Volver al menú principal")) {
				elegirModo();
				break;
			}

			switch (opcion) {
			case "Listar productos" -> listarProductos();
			case "Consultar un producto" -> consultarProducto();
			case "Añadir o actualizar producto" -> añadirOActualizarProducto();
			}
		}
	}

	// Menú de compras con JOptionPane
	private static void mostrarMenuCompras() {
		String[] opciones = { "Agregar producto al carrito", "Finalizar compra", "Volver al menú principal" };
		while (true) {
			String opcion = (String) JOptionPane.showInputDialog(null, "Selecciona una opción:",
					"Modo Usuario: Compras", JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);

			if (opcion == null || opcion.equals("Volver al menú principal")) {
				elegirModo();
				break;
			}

			switch (opcion) {
			case "Agregar producto al carrito" -> venderProducto();
			case "Finalizar compra" -> finalizarCompra();
			}
		}
	}

	// 🔹 Lista los productos disponibles
	private static void listarProductos() {
		StringBuilder listaProductos = new StringBuilder("===== LISTA DE PRODUCTOS =====\n");
		inventario.forEach((producto, info) -> {
			listaProductos.append(producto).append(" → Precio: ").append(info.get("precio")).append("€, Stock: ")
					.append(info.get("stock").intValue()).append("\n");
		});
		JOptionPane.showMessageDialog(null, listaProductos.toString());
	}

	// 🔹 Consulta un producto en el inventario
	private static void consultarProducto() {
		String articulo = JOptionPane.showInputDialog("Introduce el nombre del artículo:").toLowerCase();
		if (inventario.containsKey(articulo)) {
			String producto = "Producto: " + articulo + ", Precio: " + inventario.get(articulo).get("precio")
					+ "€, Stock: " + inventario.get(articulo).get("stock").intValue();
			JOptionPane.showMessageDialog(null, producto);
		} else {
			JOptionPane.showMessageDialog(null, "El artículo no está en la base de datos.");
		}
	}

	// 🔹 Añade o actualiza un producto en el inventario
	private static void añadirOActualizarProducto() {
		String articulo = JOptionPane.showInputDialog("Introduce el nombre del artículo:").toLowerCase();

		if (inventario.containsKey(articulo)) {
			JOptionPane.showMessageDialog(null, "El artículo ya existe en el inventario.");
			int cantidadExtra = Integer
					.parseInt(JOptionPane.showInputDialog("Introduce la cantidad adicional en stock:"));
			inventario.get(articulo).put("stock", inventario.get(articulo).get("stock") + cantidadExtra);
			JOptionPane.showMessageDialog(null, "Stock actualizado correctamente.");
		} else {
			double precio = Double.parseDouble(JOptionPane.showInputDialog("Introduce el precio del artículo:"));
			int stock = Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad en stock:"));
			double iva = Double.parseDouble(JOptionPane.showInputDialog("Introduce el IVA del artículo:"));
			agregarProducto(articulo, precio, stock, iva);
			JOptionPane.showMessageDialog(null, "Artículo añadido correctamente.");
		}
	}

	// 🔹 Permite vender productos (JOptionPane) y descuenta stock
	private static void venderProducto() {
		String producto = JOptionPane.showInputDialog("Introduce el nombre del producto:").toLowerCase();
		if (inventario.containsKey(producto)) {
			int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Introduce la cantidad:"));
			if (cantidad <= inventario.get(producto).get("stock")) {
				double precioTotal = inventario.get(producto).get("precio") * cantidad;
				carrito.add(precioTotal);
				inventario.get(producto).put("stock", inventario.get(producto).get("stock") - cantidad);
				JOptionPane.showMessageDialog(null, "Producto agregado al carrito.");
			} else {
				JOptionPane.showMessageDialog(null, "Stock insuficiente.");
			}
		} else {
			JOptionPane.showMessageDialog(null, "Producto no disponible.");
		}
	}

	// 🔹 Calcula el total de la compra y finaliza la venta
	private static void finalizarCompra() {
		if (carrito.isEmpty()) {
			JOptionPane.showMessageDialog(null, "No hay productos en el carrito.");
			return;
		}

		setSuma(0);
		double totalConIVA = 0;
		for (String producto : inventario.keySet()) {
			for (double precio : carrito) {
				setSuma(getSuma() + precio);
				totalConIVA += precio * (1 + inventario.get(producto).get("iva"));
			}
		}

		double pago = Double.parseDouble(
				JOptionPane.showInputDialog("Total: " + String.format("%.2f", totalConIVA) + "€. Introduce el pago:"));
		double cambio = pago - totalConIVA;

		if (cambio < 0) {
			JOptionPane.showMessageDialog(null, "Faltan " + String.format("%.2f", Math.abs(cambio)) + "€ por pagar.");
		} else {
			JOptionPane.showMessageDialog(null, "Cambio a devolver: " + String.format("%.2f", cambio) + "€");
			carrito.clear();
		}
	}

	public static Scanner getScanner() {
		return scanner;
	}

	public static double getSuma() {
		return suma;
	}

	public static void setSuma(double suma) {
		Tienda2.suma = suma;
	}

}