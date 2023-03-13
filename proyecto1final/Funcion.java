import java.util.List;
import java.util.Map;

/**
 * Clase que representa una función en LISP.
 */
public class Funcion extends Expresion {
    private List<String> parameters;
    private Expresion body;

    public Funcion(List<String> parameters, Expresion body) {
        this.parameters = parameters;
        this.body = body;
    }

    public List<String> getParameters() {
        return parameters;
    }

    public Expresion getBody() {
        return body;
    }

    @Override
    public Object evaluate(Map<String, Expresion> environment) {
        return new Closure(environment, parameters, body);
    }
}







  
