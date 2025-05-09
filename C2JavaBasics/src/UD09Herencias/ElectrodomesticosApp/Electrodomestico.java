package UD09Herencias.ElectrodomesticosApp;


// Clase principal para probar los electrodomésticos
public class Electrodomestico {

// Constantes por defecto
protected final static String COLOR_DEFECTO = "blanco";
protected final static char CONSUMO_DEFECTO = 'F';
protected final static double PRECIO_DEFECTO = 100.0;
protected final static double PESO_DEFECTO = 5.0;

//ATRIBUTOS
protected double precioBase;
protected String color;
protected static char consumoEnergetico;
protected double peso;

// constructor por defecto 
public Electrodomestico(){
    this.precioBase = PRECIO_DEFECTO;
    this.color = COLOR_DEFECTO;
    Electrodomestico.consumoEnergetico = CONSUMO_DEFECTO;
    this.peso = PESO_DEFECTO;
}
// constructor con precio y peso
public Electrodomestico(double precioBase, double peso){
    this.precioBase = precioBase;
    this.peso = peso;
    this.color = COLOR_DEFECTO;
    Electrodomestico.consumoEnergetico = CONSUMO_DEFECTO;
}

// Verifica si el consumo energético está entre A y F. Si no, devuelve 'F' como valor por defecto.

private  char comprobarConsumoEnergetico(char letra){
    if(letra >= 'A' && letra <= 'F'){
        return letra;
    }else{
        return CONSUMO_DEFECTO;
    }
    }  
// Recorre los colores válidos y compara ignorando mayúsculas. Si encuentra coincidencia, la devuelve en minúscula.

    private String ComprobarColor(String color){
        String[] coloresValidos = {"blanco", "negro", "rojo", "azul", "gris"};

        for (String c : coloresValidos){
            if (c.equalsIgnoreCase(color)){
                return c.toLowerCase(); //devuelve en minusculas
            }
        }

        return COLOR_DEFECTO; //si no es valido devuelve el color por defecto
    
    }

// Constructor completo que valida los parámetros usando los métodos anteriores.
    public Electrodomestico(double precioBase, String color, char consumoEnergetico, double peso) {
        this.precioBase = precioBase;
        this.color = ComprobarColor(color);
        Electrodomestico.consumoEnergetico = comprobarConsumoEnergetico(consumoEnergetico);
        this.peso = peso;
    }
}