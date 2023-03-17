/**
 * @author: Sofia Garcia, Diego Duarte
 * 
 * @since:16/03/2023
 **/

import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;

/**
 * Clase que representa la operación de setq en LISP.
 */
public class SetQ{
    String letra;
    int value;

    SetQ(){}

    SetQ(String variable, int valor){
        this.letra = variable;
        this.value = valor;
    }

    
    /** 
     * @param input
     * @param variables
     * @return String
     */
    public String setq(String input, ArrayList<SetQ> variables){
        String setqanswer = "";
        String[] tokens = input.replaceAll("[\\(\\)]", "").split("\\s+");
        int i = 0;
        while (i < tokens.length) {
            if (tokens[i].equals("setq")) {
                i++; // saltar la palabra clave 'setq'
            } else {
                SetQ variablenueva = new SetQ(tokens[i], Integer.parseInt(tokens[i+1]));
                variables.add(variablenueva);
                setqanswer += "Variable " + tokens[i] + " = " + tokens[i + 1] + "\n";
                i += 2; // avanzar al siguiente par nombre-valor
            }
        }
        return setqanswer;
    }

    
    /** 
     * @return String
     */
    public String getLetra() {
        return letra;
    }
    
    /** 
     * @return int
     */
    public int getValue() {
        return value;
    }
}

