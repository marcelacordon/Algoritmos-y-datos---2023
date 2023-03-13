import java.util.Map;

/**
 * Clase que representa una expresión atómica en LISP.
 */
public class AtomExpression extends Expresion {
    private Object value;

    public AtomExpression(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public Object evaluate(Map<String, Expresion> environment) {
        return value;
    }
}


