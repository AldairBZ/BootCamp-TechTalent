package UD09Herencias.ElectrodomesticosApp;

public class ElectrodomesticosApp {

    public static void main(String[] args) {

        // Creamos un array de Electrodomestico con 10 posiciones
        Electrodomestico[] lista = new Electrodomestico[10];

        // Rellenamos el array con diferentes objetos
        lista[0] = new Lavadora(200, "blanco", 'A', 40, 10);
        lista[1] = new Televisor(500, "negro", 'B', 20, 42, true);
        lista[2] = new Lavadora(150, 30);
        lista[3] = new Televisor(250, 15);
        lista[4] = new Lavadora();
        lista[5] = new Televisor();
        lista[6] = new Lavadora(400, "gris", 'C', 60, 35);
        lista[7] = new Televisor(700, "azul", 'A', 25, 55, true);
        lista[8] = new Lavadora(120, 28);
        lista[9] = new Televisor(300, "rojo", 'D', 22, 32, false);

        double totalLavadoras = 0;
        double totalTelevisores = 0;
        double totalElectrodomesticos = 0;

        for (Electrodomestico e : lista) {
            double precio = e.precioFinal(); // calculamos el precio final

            // Sumamos al total general
            totalElectrodomesticos += precio;

            // Verificamos tipo con instanceof
            if (e instanceof Lavadora) {
                totalLavadoras += precio;
            } else if (e instanceof Televisor) {
                totalTelevisores += precio;
            }
        }

        System.out.println(" Total Lavadoras: " + totalLavadoras + " €");
        System.out.println(" Total Televisores: " + totalTelevisores + " €");
        System.out.println(" Total Electrodomésticos: " + totalElectrodomesticos + " €");
    }
}
