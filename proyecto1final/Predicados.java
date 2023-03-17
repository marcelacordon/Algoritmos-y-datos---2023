import java.util.Stack;

public class Predicados {
    public String Predicate(String input){
    String respuesta = "NIL";
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
    else if(input.contains("<")){
         int i = 3;
        int open = 1;
        int close = 0;
        Stack<Double> nums = new Stack();
        String[] tokens = input.split("\\s+"); 
        while (i<tokens.length){
            if (tokens[i].equals("(")){
                return "NIL";
            }
            else if (tokens[i].equals(" ")){
                i++;
                continue;
            }
            else if (tokens[i].equals(")")){
                i++;
                close++;
                continue;
            }
            else if (esNumerico(tokens[i])){
                if (tokens[i].endsWith(")")) { 
                    tokens[i] = tokens[i].substring(0, tokens[i].length() - 1); 
                }
                nums.push(Double.parseDouble(tokens[i]));
                i++;
            }
            else{
                i++;
            continue;
            }
        }
        if (open == 1 && close == 1){
            double num2 = nums.pop();
            double num1 = nums.pop();
            if(num1 < num2){
                return "T";
            }
            else{
                return "NIL";
            }     
        }
        else{
            return "NIL";
        }
    }
    else if(input.contains(">")){
        int i = 3;
        int open = 1;
        int close = 0;
        Stack<Double> nums = new Stack();
        String[] tokens = input.split("\\s+"); 
        while (i<tokens.length){
            if (tokens[i].equals("(")){
                return "NIL";
            }
            else if (tokens[i].equals(" ")){
                i++;
                continue;
            }
            else if (tokens[i].equals(")")){
                i++;
                close++;
                continue;
            }
            else if (esNumerico(tokens[i])){
                if (tokens[i].endsWith(")")) { 
                    tokens[i] = tokens[i].substring(0, tokens[i].length() - 1); 
                }
                    nums.push(Double.parseDouble(tokens[i]));
                    i++;
            }
            else{
                i++;
            continue;
            }
        }
        if (open == 1 && close == 1){
            double num2 = nums.pop();
            double num1 = nums.pop();
            if(num1 > num2){
                return "T";
            }
            else{
                return "NIL";
            }     
        }
        else{
            return "NIL";
        }
    }
    else if(input.contains("=")){
        int i = 3;
        int open = 1;
        int close = 0;
        Stack<Double> nums = new Stack();
        String[] tokens = input.split("\\s+"); 
        while (i<tokens.length){
            if (tokens[i].equals("(")){
                return "NIL";
            }
            else if (tokens[i].equals(" ")){
                i++;
                continue;
            }
            else if (tokens[i].equals(")")){
                i++;
                close++;
                continue;
            }
            else if (esNumerico(tokens[i])){
                if (tokens[i].endsWith(")")) { 
                    tokens[i] = tokens[i].substring(0, tokens[i].length() - 1); 
                }
                nums.push(Double.parseDouble(tokens[i]));
                i++;
            }
            else{
                i++;
            continue;
            }
        }
        if (open == 1 && close == 1){
            double num2 = nums.pop();
            double num1 = nums.pop();
            if(num1 == num2){
                return "T";
            }
            else{
                return "NIL";
            }     
        }
        else{
            return "NIL";
        }
    }
    else{
        return "NIL";
    }
}
    
 public static boolean esNumerico(String cadena) {
    try {
        Double.parseDouble(cadena);
        return true;
    } catch (NumberFormatException e) {
        return false;
    }
}

}
