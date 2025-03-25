package UD05FlujoDatos;

public class UD05VariableGlobal {
	
	static int variableGlobal = 10;
	
	public static void metodoPrueba(){
		
		int variableMetodo=40;
		for (int i=0;i<10;i++) {
			System.out.println("la variable i vale" + 1);//Aqui existe la variable i
		}
//System.out.println("la variable i vale")+ 1);
//aqui no existe la variable i
		
System.out.println("Muestra variableMetodo"+ variableMetodo);
 
        }
public static void main(String[]args) {
//  System.out.println("La variableMetodo local vale " + variableMetodo);
//  Aqui ya no existe esta vatiable
	    int variableLocal1=20;
	    if (variableGlobal==10) {
	    	int variableLocal2=30;
	    	System.out.print("La variable local 1 vale" + variableLocal1);
	    	
	    }
//	    System.out.println("La variable local 2 vale " + variableLocal2);)
        System.out.println("La variable global vale " + variableGlobal);
        
        metodoPrueba();
        
        }
}