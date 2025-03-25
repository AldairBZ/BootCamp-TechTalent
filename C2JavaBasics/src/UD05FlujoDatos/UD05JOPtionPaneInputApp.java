package UD05FlujoDatos;

import javax.swing.JOptionPane;

public class UD05JOPtionPaneInputApp {

	public static void main(String[] args) {
		
		String nombre = JOptionPane.showInputDialog("introducir tu nombre");
		
		JOptionPane.showMessageDialog(null, "Bien, tu nombre es " + nombre);
	}
}
