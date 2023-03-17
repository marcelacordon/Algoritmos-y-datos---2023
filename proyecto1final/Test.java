import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

public class Test{
    View view = new View();
    String respuesta;
    LispInterpreter lispo = new LispInterpreter();
    boolean cont = true;
    Aritmetica a = new Aritmetica();
    Predicados p = new Predicados();
    DefunCalculator d = new DefunCalculator();
    Condicional c = new Condicional();
    SetQ s = new SetQ();
    QuoteExpression q = new QuoteExpression();
    Expresion e = new Expresion();
    ArrayList<SetQ> variables = new ArrayList<SetQ>();
    ArrayList<DefunCalculator> defunsaved = new ArrayList<>();

    @org.junit.Test
    public void AritmeticaTest1(){
        respuesta = a.evaluar("( * 2 ( + 2 3))");
        assertEquals("10.0000", respuesta);
    }

    @org.junit.Test
    public void AritmeticaTest2(){
        respuesta = a.evaluar("( / 10 ( + 1 4))");
        assertEquals("2.0000", respuesta);
    }

    @org.junit.Test
    public void PredicadosTest1(){
        respuesta = p.Predicate("(listp '(1 2 3))");
        assertEquals("T", respuesta);
    }

    @org.junit.Test
    public void PredicadosTest2(){
        respuesta = p.Predicate("(atom '123)");
        assertEquals("T", respuesta);
    }

    @org.junit.Test
    public void PredicadosTest3(){
        respuesta = p.Predicate("(atom '1 23)");
        assertEquals("NIL", respuesta);
    }

    @org.junit.Test
    public void CondicionalesTest1(){
        respuesta =  c.cond("(cond ((> 2 3) 'mayor))");
        assertEquals("NIL", respuesta);
    }

    @org.junit.Test
    public void CondicionalesTest2(){
        respuesta =  c.cond("(cond ((< 2 3) 'mayor))");
        assertEquals("mayor", respuesta);
    }

    @org.junit.Test
    public void CondicionalesTest3(){
        respuesta =  c.cond("(cond ((> 2 3) 'mayor) ((< 2 3) 'menor))");
        assertEquals("menor", respuesta);
    }

    @org.junit.Test
    public void QuoteTest1(){
        respuesta =  q.getquoteexp("(quote '(1 2 3))");
        assertEquals("1 2 3", respuesta);
    }




}
    
   

    
