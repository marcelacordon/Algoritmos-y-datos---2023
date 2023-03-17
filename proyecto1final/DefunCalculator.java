import java.util.ArrayList;
import java.util.StringTokenizer;

public class DefunCalculator {
    private String code;
    private String functionName;
    private String[] parameters;
    private String[] expression;

    public DefunCalculator(String code, String[] parameters) {
        this.code = code;
        this.parameters = parameters;
        parseCode();
    }

    private void parseCode() {
        StringTokenizer tokenizer = new StringTokenizer(code, "() ");
        tokenizer.nextToken(); // "defun"
        functionName = tokenizer.nextToken();
        ArrayList<String> parameterList = new ArrayList<>(); // Usar un ArrayList para guardar los parámetros
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (token.equals("(")) {
                break;
            } else {
                parameterList.add(token); // Añadir cada parámetro a la lista
            }
        }
        parameters = parameterList.toArray(new String[parameterList.size()]); // Convertir la lista en un array
        ArrayList<String> expressionList = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (token.equals(")")) {
                break;
            } else {
                expressionList.add(token);
            }
        }
        expression = expressionList.toArray(new String[expressionList.size()]);
    }

    public String calculate(double[] valueParams) {
        StringBuilder sb = new StringBuilder();
        for (String s : expression) {
            if (isParameter(s)) {
                sb.append(valueParams[getParameterIndex(s)]).append(" ");
            } else {
                sb.append(s).append(" ");
            }
        }
        String codeToCalculate = sb.toString();
        Aritmetica calculator = new Aritmetica();
        String result = calculator.evaluar(codeToCalculate);
        return "Result: " + result;
    }

    private boolean isParameter(String token) {
        for (String param : parameters) {
            if (param.equals(token)) {
                return true;
            }
        }
        return false;
    }

    private int getParameterIndex(String token) {
        for (int i = 0; i < parameters.length; i++) {
            if (parameters[i].equals(token)) {
                return i;
            }
        }
        return -1;
    }
}



