package UD09Herencias.ElectrodomesticosApp;

// Clase principal para probar los electrodomésticos
public class Electrodomestico {

    // Constantes por defecto
    protected final static String COLOR_DEFECTO = "blanco";
    protected final static char CONSUMO_DEFECTO = 'F';
    protected final static double PRECIO_DEFECTO = 100.0;
    protected final static double PESO_DEFECTO = 5.0;

    // ATRIBUTOS
    protected double precioBase;
    protected String color;
    protected static char consumoEnergetico;
    protected double peso;

    // constructor por defecto 
    public Electrodomestico() {
        this.precioBase = PRECIO_DEFECTO;
        this.color = COLOR_DEFECTO;
        Electrodomestico.consumoEnergetico = CONSUMO_DEFECTO;
        this.peso = PESO_DEFECTO;
    }

    // constructor con precio y peso
    public Electrodomestico(double precioBase, double peso) {
        this.precioBase = precioBase;
        this.peso = peso;
        this.color = COLOR_DEFECTO;
        Electrodomestico.consumoEnergetico = CONSUMO_DEFECTO;
    }

    // Verifica si el consumo energético está entre A y F. Si no, devuelve 'F' como valor por defecto.
    private char comprobarConsumoEnergetico(char letra) {
        if (letra >= 'A' && letra <= 'F') {
            return letra;
        } else {
            return CONSUMO_DEFECTO;
        }
    }

    // Recorre los colores válidos y compara ignorando mayúsculas. Si encuentra coincidencia, la devuelve en minúscula.
    private String ComprobarColor(String color) {
        String[] coloresValidos = {"blanco", "negro", "rojo", "azul", "gris"};

        for (String c : coloresValidos) {
            if (c.equalsIgnoreCase(color)) {
                return c.toLowerCase(); // devuelve en minúsculas
            }
        }

        return COLOR_DEFECTO; // si no es válido devuelve el color por defecto
    }

    // Constructor completo que valida los parámetros usando los métodos anteriores.
    public Electrodomestico(double precioBase, String color, char consumoEnergetico, double peso) {
        this.precioBase = precioBase;
        this.color = ComprobarColor(color);
        Electrodomestico.consumoEnergetico = comprobarConsumoEnergetico(consumoEnergetico);
        this.peso = peso;
    }

    // Método para calcular el precio final
    public double precioFinal() {
        double extra = 0;

        // Incremento por consumo energético
        switch (consumoEnergetico) {
            case 'A': extra += 100; break;
            case 'B': extra += 80; break;
            case 'C': extra += 60; break;
            case 'D': extra += 50; break;
            case 'E': extra += 30; break;
            case 'F': extra += 10; break;
        }

        // Incremento por peso
        if (peso >= 0 && peso < 20) {
            extra += 10;
        } else if (peso >= 20 && peso < 50) {
            extra += 50;
        } else if (peso >= 50 && peso < 80) {
            extra += 80;
        } else if (peso >= 80) {
            extra += 100;
        }

        return precioBase + extra;
    }
}