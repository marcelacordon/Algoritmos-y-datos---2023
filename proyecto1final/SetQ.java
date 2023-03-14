import java.util.Map;

/**
 * Clase que representa la operación de setq en LISP.
 */
public class SetQ extends Expresion {
    private String variable;
    private Expresion value;


    @Override
    public Object evaluate(Map<String, Expresion> environment) {
        Object result = value.evaluate(environment);
        environment.put(variable, new AtomExpression(result));
        return result;
    }
}

