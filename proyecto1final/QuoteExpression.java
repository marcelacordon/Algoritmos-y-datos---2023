import java.util.Map;
import java.util.Stack;

/**
 * Clase que representa la operación de quote en LISP.
 */
public class QuoteExpression {

    public String quoteexp (String quote){
        String result = "Resultado: ( ";
        int open = 0;
        int close = 0;
        Stack stack = new Stack<>();
        StringBuilder mientras = new StringBuilder();
        for(int i = 0; i < quote.length(); i++){
            char info = quote.charAt(i);
            if (info == '(' ){
                open ++;
                continue;
            }
            else if (info == ' '){
                continue;
            }
            else if (info == 's'){
                mientras.append(info);
            }
            else if (info == 'e'){
                mientras.append(info);
            }
            else if (info == 't'){
                mientras.append(info);
            }
            else if (info == 'q'){
                mientras.append(info);
            }
            else if (info == ')' ){
                close++;
                continue;
            }
            else {
                stack.push(Character.toString(info));
            }
        }
        if (close != open && mientras.toString() != "setq"){
            result = "La expresion que ingreso es incorrecta";
        }
        else{
            Stack stackfinal = new Stack<>();
            while(!stack.isEmpty()){
                stackfinal.push(stack.pop());
            }
            while (!stackfinal.isEmpty()){
                result += stackfinal.pop() + " ";
            }
        }
        return result += ")";
    }

}

