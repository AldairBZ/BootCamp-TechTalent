public class Test2 {
    public static void main(String args[]) {

        // En lugar de usar new Integer("125"), se usa Integer.valueOf()
        Integer num1 = Integer.valueOf("125");

        // En lugar de usar new Integer(20), se usa Integer.valueOf()
        Integer num2 = Integer.valueOf(20);

        // Obtención del valor entero
        int n1 = num1.intValue();
        int n2 = num2.intValue();

        System.out.println("Suma de " + n1 + " y " + n2 + " vale " + (n1 + n2));

        if (n1 + n2 > 130){
            n1++;
        }else{
            n1--;
	}
        System.out.println(n1);
    }
}
