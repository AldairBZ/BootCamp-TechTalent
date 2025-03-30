package ud05FlujoDeDatos;

import javax.swing.JOptionPane;

public class EntradaYSalidaDeDatos3App {

	public static void main(String[] args) {
		
		String nombre = JOptionPane.showInputDialog("Introduce tu nombre");
		JOptionPane.showMessageDialog(null, "Bien, tu nombre es "+nombre);
		//Es parecido al Scanner, pero lo hace en un panel a parte.
	}

}