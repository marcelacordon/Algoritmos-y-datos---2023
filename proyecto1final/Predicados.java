import java.util.Stack;

public class Predicados {
    public String Predicate(String input){
    Stack<Double> stack = new Stack<>();
    boolean mayor = false;
    boolean menor = false;
    boolean igual = false;
    String respuesta = "NIL";
    StringBuilder mientras = new StringBuilder();
    boolean antes = false;
    if (input.contains("listp")){
        int i = 7;
        int open = 1;
        int close = 0;
        int apos = 0;
        String[] tokens = input.split("");;
        while (i < tokens.length){
            if (tokens[i].equals("(")){
                open ++;
                i++;
                continue;
            }
            else if (tokens[i].equals(")")){
                close ++;
                i++;
                continue;
            }
            else if (tokens[i].equals("'")){
                apos++;
                i++;
                continue;
            } 
            else{
                i++;
                continue;
            }
            
        }
        if (open == 2 && close == 2 && apos == 1){
            return "T";
        }
        else{
            return "NIL";
        }
    }
    else if (input.contains("atom")){
        int i = 6;
        int open = 1;
        int close = 0;
        int apos = 0;
        boolean space = false;
        String[] tokens = input.split("");
        while (i<tokens.length){
            if (tokens[i] == "("){
                return "NIL";
            }
            else if (tokens[i].equals(" ")){
                return "NIL";
            }
            else if (tokens[i].equals(")")){
                i++;
                close++;
                continue;
            }
            else if (tokens[i].equals("'")){
                apos++;
                i++;
                continue;
            }
            else{
                i++;
                continue;
            }
        }
        if (open == 1 && close == 1 && apos == 1){
            return "T";
        }
        else{
            return "NIL";
        }
    }
    else{
        for (int i = 0; i < input.length(); i++) {
            char info = input.charAt(i);
            if(info == ' '){ 
                if (antes == true) {
                    stack.push(Double.parseDouble(mientras.toString()));
                    mientras = new StringBuilder();
                    antes = false;
                }
                continue;
            }
            else if (info == '('){ 
                if (antes == true) {
                    stack.push(Double.parseDouble(mientras.toString()));
                    mientras = new StringBuilder();
                    antes = false;
                }
                break;
            }
            else if (info == ')'){ 
                if (antes == true) {
                    stack.push(Double.parseDouble(mientras.toString()));
                    mientras = new StringBuilder();
                    antes = false;
                }
                break;
            }
            else if (info == '<'){ 
                menor = true;
                if (antes == true) {
                    stack.push(Double.parseDouble(mientras.toString()));
                    mientras = new StringBuilder();
                    antes = false;
                }
                break;
            }
            else if (info == '>'){ 
                mayor = true;
                if (antes == true) {
                    stack.push(Double.parseDouble(mientras.toString()));
                    mientras = new StringBuilder();
                    antes = false;
                }
                break;
            }
            else if (info == '='){ 
                igual = true;
                if (antes == true) {
                    stack.push(Double.parseDouble(mientras.toString()));
                    mientras = new StringBuilder();
                    antes = false;
                }
                break;
            }
            else if (Character.isDigit(info) || info == '.'){ 
                mientras.append(info);
                antes = true;
                break;
            }
            else{
                continue;
            }           
        }
        if (mayor == true) {
        double valor2 = stack.pop();
        double valor1 = stack.pop();
        respuesta = (valor1 > valor2) ? "T" : "NIL";
        }
        else if (menor == true) {
        double valor2 = stack.pop();
        double valor1 = stack.pop();
        respuesta = (valor1 < valor2) ? "T" : "NIL";
        }
        else if (igual == true) {
        double valor2 = stack.pop();
        double valor1 = stack.pop();
        respuesta = (valor1 == valor2) ? "T" : "NIL";
        }
        return respuesta;
    }

 }

}
