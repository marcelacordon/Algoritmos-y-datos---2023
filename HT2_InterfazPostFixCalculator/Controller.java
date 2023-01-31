import java.util.ArrayList;

/**
 * @author: Sofia Garcia, Diego Duarte, Marcela Cordon 
 * @param <T>
 * 
 * @since:30/01/2023
 **/

public class Controller {
    
    View vista = new View();
    Calculator calc = new Calculator(); 
    Stack<Integer> Pila = new Stack<Integer>();
    String item; 
    ArrayList<String> items = new ArrayList<String>();
    int resultado;
    

    public void calculo(){
        int a;
        int b;
        item = vista.ingresardirec();
        items = calc.getItems(item);
        for (int i = 0 ; i < items.size();i++){
            if (items.get(i) != " "){
                if (items.get(i).equals("+")){
                    a = Pila.pull();
                    b = Pila.pull();
                    resultado = calc.suma(a, b);
                    Pila.push(resultado);
                }
                else if (items.get(i).equals("-")){
                    a = Pila.pull();
                    b = Pila.pull();
                    resultado = calc.resta(a, b);
                    Pila.push(resultado);
                }
                else if (items.get(i).equals("*")){
                    a = Pila.pull();
                    b = Pila.pull();
                    resultado = calc.multiplicacion(a, b);
                    Pila.push(resultado);
                }
                else if (items.get(i).equals("/")){
                    a = Pila.pull();
                    b = Pila.pull();
                    resultado = calc.division(a, b);
                    Pila.push(resultado);
                }
                else{
                    Pila.push(Integer.valueOf(items.get(i)));
                    
                }
                

            }

        }
    }

    
    
}
