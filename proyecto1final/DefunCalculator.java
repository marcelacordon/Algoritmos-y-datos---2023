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
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            if (token.equals("(")) {
                break;
            } else {
                parameters.add(token);
            }
        }
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
        Calculator calculator = new Calculator();
        double result = calculator.calculate(codeToCalculate);
        return "Result: " + Double.toString(result);
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



