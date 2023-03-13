import java.util.Map;

/**
 * Clase base para representar una expresión en el intérprete LISP.
 */
public abstract class Expresion {
    /**
     * Método para evaluar la expresión.
     * @param environment
     * 
     * @return Resultado de la evaluación de la expresión.
     */
    public abstract Object evaluate(Map<String, Expresion> environment);
}

