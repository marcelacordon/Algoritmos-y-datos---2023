/**
 * @author: Sofia Garcia, Diego Duarte
 * 
 * @since:16/03/2023
 **/

import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DefunCalculator {
    private String name;
    private ArrayList<String> parameters;
    private String funcion;

    DefunCalculator(){}
    DefunCalculator(String nam, ArrayList<String> param, String funct ){
        name = nam;
        parameters = param;
        funcion = funct;
    }
    
    /** 
     * @param defunct
     * @param saveddefun
     */
    public void setdefun (String defunct, ArrayList<DefunCalculator> saveddefun){
        if (defunct.contains("defun")){
            String[] tokens = defunct.split(" ");
            String newname = tokens[1];
            String funcions = tokens[3];
            ArrayList<String> parameterss = new ArrayList<>();
            String[] newparameters = tokens[2].split("");
            for (int i = 1 ; i < newparameters.length - 1; i ++){
                parameterss.add(newparameters[i]);
            }
            DefunCalculator defun = new DefunCalculator(newname, parameterss, funcions);
            saveddefun.add(defun);
        }
        else {
            System.out.println("Expresion invalida");
        }
    }

    
    /** 
     * @param defunct
     * @param saveddefun
     */
    public void testsaveddefun(String defunct, ArrayList<DefunCalculator> saveddefun){
        String finalanswer = "";
        ArrayList<String> parameters = new ArrayList<>();
        for (int i = 0; i < saveddefun.size() ; i ++){
            if (defunct.contains(saveddefun.get(i).getName())){
                String [] tokens = defunct.split(" ");
                int e = 2;
                while (e < tokens.length -1 ){
                    parameters.add(tokens[e]);
                    e++;
                    continue;
                }
                if (parameters.size() == saveddefun.get(i).getParameters().size()){
                    String[]original = saveddefun.get(i).getFuncion().replaceAll("[()\\*\\+\\-\\/]", "").split("");
                    String originalll = saveddefun.get(i).getFuncion();
                    for (int l = 0; l <original.length; l++){
                        if (originalll.contains(original[i])){
                            originalll = originalll.replaceAll(original[l], parameters.get(l));
                            i++;
                            continue;
                        }
                    }

                    String operacion = addSpacesToString(originalll);
                    Aritmetica ari = new Aritmetica();
                    finalanswer = ari.evaluar(operacion);
                    System.out.println("Resultado: "+ finalanswer);
            }
            else{
                System.out.println("error");
            }
            }
        }
        
    }

    
    /** 
     * @return String
     */
    public String getName() {
        return name;
    }
    
    /** 
     * @return ArrayList<String>
     */
    public ArrayList<String> getParameters() {
        return parameters;
    }

    
    /** 
     * @return String
     */
    public String getFuncion() {
        return funcion;
    }
    
    
    /** 
     * @param str
     * @return String
     */
    public String addSpacesToString(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            result += str.charAt(i) + " ";
        }
        return result.trim();
    }

}



