import java.util.ArrayList;

public class Condicional {
    Predicados p = new Predicados();
    private String evaluar;
    private String print;

    public String cond(String input){
        int i = 1;
        boolean onetrue = false;
        String result = " ";
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
            }
        }
        while(onetrue == false){ 
            for(int o = 0; i< condi.size(); o++){
                if(condi.get(o).getEvaluar().equals("t")){
                    result = condi.get(o).getPrint();
                }
                else if(p.Predicate(condi.get(o).getEvaluar()).equals("T")){
                    result = condi.get(o).getPrint();
                    onetrue = true;
                }
            }
        }
        return result; 
    }

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

    public static ArrayList<String> subtoken(String input) {
    ArrayList<String> tokens = new ArrayList<String>();
    StringBuilder sb = new StringBuilder();
    boolean inQuotes = false;
    for (int i = 1; i < input.length() - 1; i++) {
        char c = input.charAt(i);
        if (c == '(' || c == ')') {
            if (sb.length() > 0) {
                tokens.add(sb.toString());
                sb.setLength(0);
            }
            tokens.add(Character.toString(c));
        } else if (c == '\'') {
            inQuotes = !inQuotes;
            if (sb.length() > 0) {
                tokens.add(sb.toString());
                sb.setLength(0);
            }
            tokens.add(Character.toString(c));
        } else if (c == ' ' && !inQuotes) {
            if (sb.length() > 0) {
                tokens.add(sb.toString());
                sb.setLength(0);
            }
        } else {
            sb.append(c);
        }
    }
    if (sb.length() > 0) {
        tokens.add(sb.toString());
    }
    return tokens;
}



}
