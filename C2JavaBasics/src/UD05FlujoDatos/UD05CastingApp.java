package UD05FlujoDatos;

public class UD05CastingApp {
	
	public static void main(String[] args) {
		
//Casting implicito de int a double
		
		int numeroEntero = 10;
		double numeroDouble = numeroEntero;
		System.out.println("numero entero:" + numeroEntero);
		System.out.println("numero double (despues del casting implicito): "
				+ numeroDouble);
		
//Conversion de tipo de datos de mas pequeño a uno mas grande

//Casting esplicito double a int
		
		double otroNumeroDouble = 10.5;
		int otroNumeroEntero = (int) otroNumeroDouble;
		System.out.println("numero double: " + otroNumeroDouble);
		System.out.println("NumeroEntero (despues del casting implicito): " 
				+ otroNumeroEntero);		
	}
	
}