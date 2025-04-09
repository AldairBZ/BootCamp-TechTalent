package UD07;
public class UD07 {

    // El latido de un nuevo día
    public static void main(String[] args) {
        String alma = "curiosa";
        int energia = 100;
        
        despertar(alma);
        meditar(energia);
        crear("poesía", true);
    }

    // El primer respiro
    public static void despertar(String alma) {
        System.out.println("El código se despierta con el alma " + alma + ".");
    }

    // Momento de pausa
    public static void meditar(int energia) {
        if (energia >= 50) {
            System.out.println("Respira hondo... la mente se calma.");
        } else {
            System.out.println("Demasiado cansancio... vuelve a soñar.");
        }
    }

    // Acción creativa
    public static void crear(String arte, boolean conCorazon) {
        if (conCorazon) {
            System.out.println("Creando " + arte + " con pasión infinita.");
        } else {
            System.out.println("El arte sin alma no vibra...");
        }
    }
}
