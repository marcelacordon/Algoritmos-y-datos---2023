import java.util.Stack;

public class Predicados {
    public String Predicate(String input){
        Stack stack = new Stack<>();
        Boolean mayor = false;
        Boolean menor = false;
        Boolean igual = false;
        int open = 0;
        int close = 0;
        String respuesta = " ";
        StringBuilder mientras = new StringBuilder();
        boolean antes = false;
        for(int i = 0; i < input.length(); i++){
            char info = input.charAt(i);
            if(info == ' '){
                if(antes == true){
                    stack.push(Double.parseDouble(mientras.toString()));
                    mientras = new StringBuilder();
                    antes = false;
                }
                continue;
            }
            else if(info == '('){
                open++;
                if(antes == true){
                    stack.push(Double.parseDouble(mientras.toString()));
                    mientras = new StringBuilder();
                    antes = false;
                }
            }
            else if(info == ')'){
                close++;
                if(antes == true){
                    stack.push(Double.parseDouble(mientras.toString()));
                    mientras = new StringBuilder();
                    antes = false;
                }
            }
            else if(info == '<'){
                menor = true;
                if(antes == true){
                    stack.push(Double.parseDouble(mientras.toString()));
                    mientras = new StringBuilder();
                    antes = false;
                }
            }
            else if(info == '>'){
                mayor = true;
                if(antes == true){
                    stack.push(Double.parseDouble(mientras.toString()));
                    mientras = new StringBuilder();
                    antes = false;
                }
            }
            else if(info == '='){
                igual = true;
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
        if(mayor == true && open == close){
            double valor2 = (double) stack.pop();
            double valor1 = (double) stack.pop();
            if(valor1 > valor2){
                respuesta = "T";
            }
            else{
                respuesta = "NIL";
            }
        }
        else if (menor == true && open == close){
            double valor2 = (double) stack.pop();
            double valor1 = (double) stack.pop();
            if(valor1 < valor2){
                respuesta = "T";
            }
            else{
                respuesta = "NIL";
            }

        }
        else if (igual == true && open == close){
            double valor2 = (double) stack.pop();
            double valor1 = (double) stack.pop();
            if(valor1 == valor2){
                respuesta = "T";
            }
            else{
                respuesta = "NIL";
            }

        }
        return respuesta;
    }
}
