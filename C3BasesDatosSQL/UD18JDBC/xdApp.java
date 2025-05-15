
package UD18JDBC;

import java.util.Random;

import javax.swing.JOptionPane;

public class xdApp {

        // Variables
        int[] randoms = new int[cantRadoms];
        Random random = new Random();
        int suma = 0;
        int media = 0;

        // Pedir rango
        rangoMin = Integer.parseInt(JOptionPane.showInputDialog("Introduce el rango "
                + "mínimo: "));
        rangoMax = Integer.parseInt(JOptionPane.showInputDialog("Introduce el rango "
                + "máximo: "));

        // Generar números aleatorios
        for (int i = 0; i < cantRadoms; i++) {
            randoms[i] = random.nextInt(rangoMin, rangoMax);
            suma += randoms[i];
            System.out.println(randoms[i]);
        }

        // Calcular media
        if (cantRadoms > 0) {
            media = suma / cantRadoms;
            System.out.println("La media es: " + media);
        } else {
            System.out.println("No se ha podido calcular la media");
        }

    }