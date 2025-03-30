package ud05FlujoDeDatos;

import javax.swing.JOptionPane;

public class EntradaYSalidaDeDatos2App {

	public static void main(String[] args) {
		
		int precioProducto = 300;
		
		final double IVA = 0.21;
		//Invariable gracias al double
		
		JOptionPane.showInternalMessageDialog(null, "El precio del producto, incluido el IVA es "+((precioProducto*IVA)+precioProducto));
		//Solamente es un panel informativo, no te abre nada para poner información.
	}

}