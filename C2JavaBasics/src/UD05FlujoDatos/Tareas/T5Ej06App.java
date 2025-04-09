package UD05FlujoDatos.Tareas;


import javax.swing.JOptionPane;

public class T5Ej06App {

	private static double iRPF;

	public static void main(String[] args) {
		final double IVA = 0.21; // 21%
		setiRPF(0.15);

//		IVA= 0.22;
		setiRPF(0.18);
		double precioBase = Double.parseDouble(JOptionPane.showInputDialog(""
				+ "Introduce un precio de base: "));
		double precio = precioBase + precioBase * IVA;

		JOptionPane.showMessageDialog(null, "" + "El precio final es: " 
									+ precio);

	}

	public static double getiRPF() {
		return iRPF;
	}

	public static void setiRPF(double iRPF) {
		T5Ej06App.iRPF = iRPF;
	}

}