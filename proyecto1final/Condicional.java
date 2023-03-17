import java.util.ArrayList;

public class Condicional {
    Predicados p = new Predicados();
    private String evaluar;
    private String print;


    //Funcion principal para condicionales 
    public String cond(String input){
        String result = "NIL";
        int i = 1;
        boolean onetrue = true;
        input = input.substring(1, input.length() - 1);
        String[] tokens = input.split("\\s+(?=\\()");
        ArrayList<Condicional> condi = new ArrayList<Condicional>();
        Condicional actual = new Condicional();
        if (tokens[0].equals("cond")){
            while(i< tokens.length){
                ArrayList<String> subtokens = subtoken(tokens[i]);
                actual.setEvaluar(subtokens.get(0));
                actual.setPrint(subtokens.get(1));
                condi.add(actual);
                actual = new Condicional();
                i++;
            }
        }
        while(onetrue == true){ 
            for(int o = 0; o < condi.size(); o++){
                if(p.Predicate(condi.get(o).getEvaluar()).equals("T")){
                    result = condi.get(o).getPrint();
                    onetrue = false;
                    break;
                }
                else if(condi.get(o).getEvaluar().equals("t")){
                    result = condi.get(o).getPrint();
                    onetrue = false;
                    break;
                }
                else if(p.Predicate(condi.get(o).getEvaluar()).equals("NIL")){
                    continue;
                }
                else{
                    result = "NIL";
                    onetrue = false;
                    break;
                }
            }
        }
        return result; 
    }

    //Gets y Set de Métodos
    public void setEvaluar(String evaluar) {
        this.evaluar = evaluar;
    }

    public String getEvaluar() {
        return this.evaluar;
    }

    public void setPrint(String print) {
        this.print = print;
    }

    public String getPrint() {
        return this.print;
    }

    //Convertir los tokens a subtokens
    public static ArrayList<String> subtoken(String input) {
        ArrayList<String> tokens = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        boolean condicional = true;
        char[] charArray = input.toCharArray();
        boolean addt = false;

        for(int i = 1; i < charArray.length; i++){
            if(charArray[1] == 't' && addt == false){
                tokens.add("t");
                condicional = false;
                addt = true;
            }
            if(condicional == true){
                if(charArray[i] == ')'){
                    sb.append(charArray[i]);
                    tokens.add(sb.toString());
                    sb = new StringBuilder();
                    condicional = false;
                }
                else{
                    sb.append(charArray[i]);
                }
            }
            else{
                if(Character.isLetter(charArray[i])){
                    sb.append(charArray[i]);
                }
            }
        }
        tokens.add(sb.toString());
    
    return tokens;
    
    }
}



