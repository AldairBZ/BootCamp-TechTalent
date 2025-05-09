package UD09 Herencias.ElectrodomesticosApp;

public class Electrodomestico {

// Constantes por defecto
protected final static String COLOR_DEFECTO = "blanco";
protected final static char CONSUMO_DEFECTO = 'F';
protected final static double PRECIO_DEFECTO = 100.0;
protected final static double PESO_DEFECTO = 5.0;

//ATRIBUTOS
protected double precioBase;
protected String color;
protected char consumoEnergetico;
protected double peso;

// constructor por defecto 
public Electrodomestico(){
    this.precioBase = PRECIO_DEFECTO;
    this.color = COLOR_DEFECTO;
    this.consumoEnergetico = CONSUMO_DEFECTO;
    this.peso = PESO_DEFECTO;
}
// constructor con precio y peso
public Electrodomestico(double precioBase, double peso){
    this.precioBase = precioBase;
    this.peso = peso;
    this.color = COLOR_DEFECTO;
    this.consumoEnergetico = CONSUMO_DEFECTO;
}

// constructor con todos los atributos
private  char comprobarConsumoEnergetico(char letra){
    

}

}
