import java.util.Map;

/**
 * Clase que representa la operación de setq en LISP.
 */
public class SetQ extends Expresion {
    private String variable;
    private Expresion value;

    public SetQ(String variable, Expresion value) {
        this.variable = variable;
        this.value = value;
    }

    public String getVariable() {
        return variable;
    }

    public Expresion getValue() {
        return value;
    }

    @Override
    public Object evaluate(Map<String, Expresion> environment) {
        Object result = value.evaluate(environment);
        environment.put(variable, new AtomExpression(result));
        return result;
    }
}

