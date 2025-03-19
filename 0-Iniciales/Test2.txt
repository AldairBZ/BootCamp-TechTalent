public class Test2 {

    public static void main(String[] args) {
        Integer num1 = 125;
        Integer num2 = 20;
        Integer num3 = 7;
        
        int n1 = num1.intValue();
        int n2 = num2.intValue();
        
        // Corregimos la concatenación en el println
        System.out.println("Suma de " + n1 + " y " + n2 + " vale " + (n1 + n2));
        
        // Corregimos la condición del if
        if (n1 + n2 > 2130)  // Ejemplo de comparación
            n1++;
        else
            n1--;
        
        System.out.println(n1);
    }
}
