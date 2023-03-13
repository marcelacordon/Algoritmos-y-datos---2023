import java.util.ArrayList;
import java.util.List;

public class LispInterpreter {

  public List<Object> parse(String input) {
    List<Object> elements = new ArrayList<>();
    int i = 0;
    while (i < input.length()) {
        char c = input.charAt(i);
        if (Character.isWhitespace(c)) {
            i++;
        } else if (c == '(') {
            // Parse a list
            List<Object> sublist = new ArrayList<>();
            i++;
            while (i < input.length() && input.charAt(i) != ')') {
                sublist.add(parse(input.substring(i)));
                i += getExpressionLength(input.substring(i));
            }
            elements.add(sublist);
            i++;
        } else {
            // Parse an atom
            int j = i + 1;
            while (j < input.length() && !Character.isWhitespace(input.charAt(j)) && input.charAt(j) != ')') {
                j++;
            }
            elements.add(input.substring(i, j));
            i = j;
        }
    }
    return elements;
}

private int getExpressionLength(String input) {
    int i = 0;
    int count = 0;
    while (i < input.length()) {
        char c = input.charAt(i);
        if (c == '(') {
            count++;
        } else if (c == ')') {
            count--;
        }
        if (count == 0) {
            return i + 1;
        }
        i++;
    }
    return i;
}

}
