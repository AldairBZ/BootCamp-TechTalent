package UD09Herencias.ElectrodomesticosApp;

// Clase Lavadora que hereda de Electrodomestico
public class Lavadora extends Electrodomestico {

    // Atributo específico de Lavadora: carga máxima de ropa (en kilogramos)
    private int carga;

    // Constante que define la carga por defecto (en kilogramos)
    private final static int CARGA_DEFECTO = 5;

    // Constructor por defecto (no recibe parámetros)
    public Lavadora() {
        super(); // Llama al constructor por defecto de Electrodomestico
        this.carga = CARGA_DEFECTO; // Le asigna 5 kg por defecto a la lavadora
    }

    // Constructor que recibe precio y peso, y usa valores por defecto para lo demás
    public Lavadora(double precioBase, double peso) {
        super(precioBase, peso); // Llama al constructor de la clase padre
        this.carga = CARGA_DEFECTO; // La carga sigue siendo 5 kg por defecto
    }

    // Constructor completo que permite definir todos los atributos
    public Lavadora(double precioBase, String color, char consumoEnergetico, double peso, int carga) {
        // Llama al constructor de Electrodomestico con todos los valores
        super(precioBase, color, consumoEnergetico, peso);
        this.carga = carga; // Asigna la carga recibida como parámetro
    }

    /**
     * Calcula el precio final de la lavadora.
     * Si la carga es mayor a 30 kg, suma 50 euros al precio base.
     * Se podría mejorar sumando también el cálculo de consumo y peso como en Electrodomestico.
     */
    public double precioFinal() {
        double precio = super.precioBase; // Usamos el precio base de Electrodomestico

        // Si tiene una carga grande, se le suma un extra
        if (carga > 30) {
            precio += 50; // Suma 50 euros por alta capacidad
        }

        return precio; // Devuelve el precio total
    }
}
