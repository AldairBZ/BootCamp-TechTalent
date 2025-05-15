package UD09Herencias.ElectrodomesticosApp;

// Clase Televisor que hereda de Electrodomestico
public class Televisor extends Electrodomestico {
    private int resolucion; // Resolución en pulgadas
    private boolean sintonizadorTDT; // Indica si tiene sintonizador TDT

    // Constructor por defecto
    public Televisor() {
        super(); // Llama al constructor por defecto de Electrodomestico
        this.resolucion = 20; // Resolución por defecto
        this.sintonizadorTDT = false; // Sin TDT por defecto
    }

    // Constructor con precio y peso
    public Televisor(double precioBase, double peso) {
        super(precioBase, "blanco", 'F', peso); // Llama al constructor de Electrodomestico con valores por defecto
        this.resolucion = 20; // Resolución por defecto
        this.sintonizadorTDT = false; // Sin TDT por defecto
    }

    // Constructor con todos los parámetros
    public Televisor(double precioBase, String color, char consumoEnergetico, double peso, int resolucion, boolean sintonizadorTDT) {
        super(precioBase, color, consumoEnergetico, peso); // Llama al constructor de Electrodomestico
        this.resolucion = resolucion; // Asigna la resolución
        this.sintonizadorTDT = sintonizadorTDT; // Asigna si tiene TDT
    }

    // Sobrescribir el método precioFinal para calcular el precio final del televisor
    @Override
    public double precioFinal() {
        double extra = super.precioFinal(); // Calcula el precio base usando el método de la clase padre

        // Si la resolución es mayor a 40 pulgadas, incrementa el precio en un 30%
        if (resolucion > 40) {
            extra += precioBase * 0.3;
        }

        // Si tiene sintonizador TDT, incrementa el precio en 50 €
        if (sintonizadorTDT) {
            extra += 50;
        }

        return extra; // Devuelve el precio final
    }
}