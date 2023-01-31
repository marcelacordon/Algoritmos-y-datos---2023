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
    int resultado = 0;
    

    public void calculo(){
        int a;
        int b;
        item = vista.ingresardirec();
        items = calc.getItems(item);
        for (int i = 0 ; i < items.size();i++){
            if (calc.isOperator(items.get(i)) == true){
                if (calc.isOneItem(Pila) == false){ 
                    if (items.get(i).equals("+")){
                        a = Pila.pull();
                        b = Pila.pull();
                        resultado = calc.suma(a, b);
                        Pila.push(resultado);
                        if(calc.isOneItem(Pila) == true){
                            vista.resultadoOPer(Pila.pull());
                            break;
                        }
                    }
                    else if (items.get(i).equals("-")){
                        a = Pila.pull();
                        b = Pila.pull();
                        resultado = calc.resta(a, b);
                        Pila.push(resultado);
                        if(calc.isOneItem(Pila) == true){
                            vista.resultadoOPer(Pila.pull());
                            break;
                        }
                    }
                    else if (items.get(i).equals("*")){
                        a = Pila.pull();
                        b = Pila.pull();
                        resultado = calc.multiplicacion(a, b);
                        Pila.push(resultado);
                        if(calc.isOneItem(Pila) == true){
                            vista.resultadoOPer(Pila.pull());
                            break;
                        }
                    }
                    else if (items.get(i).equals("/")){
                        a = Pila.pull();
                        b = Pila.pull();
                        if(b == 0){
                            vista.dividirCero();
                            break;
                        }
                        else{
                            resultado = calc.division(a, b);
                            Pila.push(resultado);
                                if(calc.isOneItem(Pila) == true){
                                    vista.resultadoOPer(Pila.pull());
                                    break;
                                }
                        }
                    }
                    else{
                        vista.simboloNoReconocido();
                        //Hay un valor no valido 
                        break;
                    }
                }
                else{
                    vista.noOperandos();
                    //No hay suficientes operandos 
                    break;
                }
            }
            else{
                Pila.push(Integer.valueOf(items.get(i)));
            }
        }
        
    }
}

    
    

