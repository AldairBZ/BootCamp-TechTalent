package UD09Herencias.ElectrodomesticosApp;

public class Lavadora extends Electrodomestico {
    private double carga;

    // Constructor por defecto
    public Lavadora() {
        super();
        this.carga = 5;
    }

    // Constructor con precio y peso
    public Lavadora(double precioBase, double peso) {
        super(precioBase, "blanco", 'F', peso);
        this.carga = 5;
    }

    // Constructor con todos los parámetros
    public Lavadora(double precioBase, String color, char consumoEnergetico, double peso, double carga) {
        super(precioBase, color, consumoEnergetico, peso);
        this.carga = carga;
    }

    // Sobrescribir el método precioFinal
    @Override
    public double precioFinal() {
        double extra = super.precioFinal();
        if (carga > 30) {
            extra += 50;
        }
        return extra;
    }
}