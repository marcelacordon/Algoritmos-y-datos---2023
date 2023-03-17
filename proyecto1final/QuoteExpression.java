/**
 * @author: Sofia Garcia, Diego Duarte
 * 
 * @since:14/03/2023
 **/
public class QuoteExpression {

    /**
     * Método que toma una expresión LISP con la operación quote (') y devuelve su contenido.
     * @param expr expresión LISP con la operación '.
     * @return contenido dentro de la expresión.
     */
    public String getquoteexp(String expr) {
        StringBuilder expresion = new StringBuilder();
        if (expr.contains("'")){
            for (char c : expr.toCharArray()){
                if (c == '\'' || c == '(' || c == ')'|| c == ' '){
                    continue;
                }
                else{
                    expresion.append(c+ " ");
                }
            }
        }
        else{
            return "Expresion invalida";
        }
        return "Expresion: " + expresion.toString();
    }
}







