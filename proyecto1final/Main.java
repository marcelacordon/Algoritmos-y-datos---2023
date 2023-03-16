import java.util.ArrayList;

public class Main {
    public static void main (String [] args) {
        Controller cont = new Controller();
        LispInterpreter lis = new LispInterpreter();
        QuoteExpression q = new QuoteExpression();
        Predicados p = new Predicados();
        Aritmetica ari = new Aritmetica();
        SetQ set = new SetQ();
        ArrayList<SetQ> setqvariables = new ArrayList<SetQ>();

        System.out.println(ari.evaluar("( * 2 ( + 2 3))"));
        
        System.out.println(q.getquoteexp("'(1 2 3 4)"));
        
        System.out.println(set.setq("(setq x 42 b 30)", setqvariables));
        
        System.out.println(p.Predicate("(listp '(1 2 3))"));
        System.out.println(p.Predicate("(atom '( 1 2 3 ))"));
        System.out.println(p.Predicate("(listp '1)"));
        System.out.println(p.Predicate("(atom '123)"));


    
    }
}
