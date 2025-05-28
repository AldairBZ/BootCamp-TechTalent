package com.ud21;

public class Geometria {

    // Método para calcular el área de un cuadrado
    public int areacuadrado(int n1) {
        return n1 * n1;
    }

    // Método para calcular el área de un círculo
    public double areaCirculo(int r) {
        final double PI = 3.1416;
        return PI * Math.pow(r, 2);
    }

    // Método para calcular el área de un triángulo
    public int areatriangulo(int a, int b) {
        return (a * b) / 2;
    }

    // Método para calcular el área de un rectángulo
    public int arearectangulo(int b, int h) {
        return b * h;
    }

    // Método para calcular el área de un pentágono
    public int areapentagono(int p, int a) {
        return (p * a) / 2;
    }
}