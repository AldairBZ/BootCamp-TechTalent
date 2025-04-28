package UD07ArrayslistHashtable;

import java.util.Scanner;

public class Tareaxd {
//----------------------------------------------------------------------------------------//
	//CREA UN PROGRAMA QUE PIDA UN NÚMERO Y QUE DIGA SI ES NEGATIVO, CERO O POSITIVO. =D
//----------------------------------------------------------------------------------------//
	
	public static void main(String[] args) {
		
		// Crear el scanner para leer desde teclado
		Scanner scanner= new Scanner(System.in);
		
		//Pedir al usuario que ingrese un número
        System.out.print("Introduce un numero: ");
        
        // Leer el número y guardarlo en una variable num
        int num= scanner.nextInt();
        
        //Verificar si el número es negativo, cero o positivo
        if(num < 0) {
           System.out.println("El numero es negativo");	
		} else if (num == 0) {
			System.out.println("El numero es cero");
		} else {
			System.out.println("El numero es positivo");
		}
                //Cerrar el scanner
        scanner.close();
  }
}	
//----------------------------------------------------------------------------------------------//