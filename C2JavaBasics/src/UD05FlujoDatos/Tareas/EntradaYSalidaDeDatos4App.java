package ud05FlujoDeDatos;

import javax.swing.JOptionPane;

public class EntradaYSalidaDeDatos4App {

	public static void main(String[] args) {
		
		final double IVA=0.21;
		String texto_num=JOptionPane.showInputDialog("Introduce el precio del producto: ");
		
		int precio=Integer.parseInt(texto_num);
		/*Texo_numero es el que recibe el texto, entonces 
		hay que cambiarlo a valor numérico asignándolo a
		una variable precio.*/
		
		JOptionPane.showMessageDialog(null, "El producto tiene un precio de "+precio+" y su precio final es de "+(precio+(precio*IVA)));
		
	}

}