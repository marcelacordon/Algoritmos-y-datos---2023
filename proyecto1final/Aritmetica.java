import java.util.*;
import java.util.Stack;

public class Aritmetica {

    public double LispAritmetica(String input){
        Stack stack = new Stack<>();
        boolean sum = false;
        boolean rest = false;
        boolean mult = false;
        boolean div = false;
        int open = 0;
        int close = 0;
        double respuesta = 0;
        StringBuilder mientras = new StringBuilder();
        boolean antes = false;
        for(int i = 0; i < input.length(); i ++){
            char info = input.charAt(i);
            if(info == ' '){
                if(antes == true){
                    stack.push(Double.parseDouble(mientras.toString()));
                    mientras = new StringBuilder();
                    antes = false;
                }
                continue;
            }
            else if (info == '('){
                open++;
                if(antes == true){
                    stack.push(Double.parseDouble(mientras.toString()));
                    mientras = new StringBuilder();
                    antes = false;
                }
            }
            else if (info == ')'){
                close++;
                if(antes == true){
                    stack.push(Double.parseDouble(mientras.toString()));
                    mientras = new StringBuilder();
                    antes = false;
                }
            }
            else if (info == '+'){
                sum = true;
                if(antes == true){
                    stack.push(Double.parseDouble(mientras.toString()));
                    mientras = new StringBuilder();
                    antes = false;
                }
            }
            else if (info == '-'){
                rest = true;
                if(antes == true){
                    stack.push(Double.parseDouble(mientras.toString()));
                    mientras = new StringBuilder();
                    antes = false;
                }
            }
            else if (info == '*'){
                mult = true;
                if(antes == true){
                    stack.push(Double.parseDouble(mientras.toString()));
                    mientras = new StringBuilder();
                    antes = false;
                }
            }
            else if (info == '/'){
                div = true;
                if(antes == true){
                    stack.push(Double.parseDouble(mientras.toString()));
                    mientras = new StringBuilder();
                    antes = false;
                }
            }
            else if (Character.isDigit(info) || info == '.'){
                mientras.append(info);
                antes = true;
            }
        }
        respuesta = calc(sum, rest, mult, div, open, close, stack);
        return respuesta;
    }

    public double suma(Stack stack){
        double respuesta = 0;
        while(!stack.isEmpty()){
            double dato = (double) stack.pop();
            respuesta = respuesta + dato;
        }
        return respuesta;
    }

    public double resta(Stack stack){
        double respuesta = 0;
        while(!stack.isEmpty()){
            if(respuesta == 0){
                double dato2 = (double) stack.pop();
                double dato1 = (double) stack.pop();
                respuesta = dato1-dato2;
            }
            else if (respuesta != 0){
                double dato1 = (double) stack.pop();
                respuesta = respuesta-dato1;
            }
        }
        return respuesta;
    }

    public double multiplicacion(Stack stack){
        double respuesta = 0;
        while(!stack.isEmpty()){
            if(respuesta == 0){
                double dato2 = (double) stack.pop();
                double dato1 = (double) stack.pop();
                respuesta = dato1*dato2;
            }
            else if (respuesta != 0){
                double dato1 = (double) stack.pop();
                respuesta = respuesta*dato1;
            }
        }
        return respuesta;
    }

    public double division(Stack stack){
        double respuesta = 0;
        while(!stack.isEmpty()){
            if(respuesta == 0){
                double dato2 = (double) stack.pop();
                double dato1 = (double) stack.pop();
                respuesta = dato1/dato2;
            }
            else if (respuesta != 0){
                double dato1 = (double) stack.pop();
                respuesta = respuesta/dato1;
            }
        }
        return respuesta;
    }

    public double calc(boolean sum, boolean rest, boolean mult, boolean div, int open, int close, Stack stack){
        double respuesta = 0;
        if(sum == true && open == close){
            respuesta = suma(stack);
        }
        if(rest == true && open == close){
            respuesta = resta(stack);
        }
        if(mult == true && open == close){
            respuesta = multiplicacion(stack);
        }
        if(div == true && open == close){
            respuesta = division(stack);
        }
        return respuesta;
    }
}
