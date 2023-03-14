import java.util.Map;

/**
 * Clase que representa la operación de setq en LISP.
 */
public class SetQ extends Expresion {
    private String variable;
    private Expresion value;

//(SETQ a 1 b 2)
// for (setq)
// con setq encontado 
// a <-- Key
// 
// 10.1 <-- Value 
//

    @Override
    public Object evaluate(Map<String, Expresion> environment) {
        Object result = value.evaluate(environment);
        environment.put(variable, new AtomExpression(result));
        return result;
    }
}

