package com.miapp;

public class Geometria {

    public int areaCuadrado(int lado) {
        return lado * lado;
    }

    public double areaCirculo(int radio) {
        return Math.PI * radio * radio;
    }

    public int areaTriangulo(int base, int altura) {
        return (base * altura) / 2;
    }

    public int areaRectangulo(int base, int altura) {
        return base * altura;
    }

    public int areaPentagono(int perimetro, int apotema) {
        return (perimetro * apotema) / 2;
    }
}