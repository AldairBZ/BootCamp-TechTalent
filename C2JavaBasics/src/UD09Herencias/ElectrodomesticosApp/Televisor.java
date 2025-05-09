package UD09Herencias.ElectrodomesticosApp;

// Clase Televisor, esta clase representa un televisor y hereda de la clase Electrodomestico
// La herencia permite que Televisor tenga todos los atributos y métodos de Electrodomestico
// Además, puede tener sus propios atributos y métodos específicos
public class Televisor extends Electrodomestico{

    //Atributos propios de Televisor
    private int resolucion; //Resolucion en pulgadas
    private boolean sintonizadorTDT; //Indica si tiene TDT

    //Valores por defecto
    private final static int RESOLUCION_DEFECTO = 20;
    private final static boolean TDT_DEFECTO = false;
    
    //Constructor por defecto
    public Televisor(){
        super();//Constructor por defecto de Electrodomestico
        this.resolucion = 20; //Resolucion por defecto
        this.sintonizadorTDT = TDT_DEFECTO;
    }
    
    //Constructor con precio y peso
    public Televisor(double precioBase, double peso){
        super(precioBase, "blanco", 'F', peso); // Constructor de Electrodomestico con valores por defecto
        this.resolucion = RESOLUCION_DEFECTO;
        this.sintonizadorTDT = TDT_DEFECTO; 
    }
    // Constructor con precio, color, consumo energético y peso
    public Televisor(double precioBase, String color, char consumoEnergetico, double peso) {
        super(precioBase, color, consumoEnergetico, peso);
        this.resolucion = RESOLUCION_DEFECTO;
        this.sintonizadorTDT = TDT_DEFECTO;
    }
    //constructor completo
    public Televisor(double precioBase, String color, char consumoEnergetico, double peso, int resolucion, boolean sintonizadorTDT){
        super(precioBase, color, consumoEnergetico, peso);
        this.resolucion = resolucion; 
        this.sintonizadorTDT = sintonizadorTDT;
    }
    /*
     * Calcula el precio final del televisor.
     * si la resolución es mayor a 40 pulgadas, suma 30 euros al precio base.
     * si tiene TDT, se suma 50 euros adicionales.
     */
    public double precioFinal(){
        double precio = super.precioBase;

        //Aumenta un 30% si la resolución es mayor a 40 pulgadas
        if (resolucion > 40){
            precio *=1.3;
        }

        //Suma 50 euros si tiene TDT
        if (sintonizadorTDT){
            precio +=50;
        }

        return precio; //Devuelve el precio total
    }
}