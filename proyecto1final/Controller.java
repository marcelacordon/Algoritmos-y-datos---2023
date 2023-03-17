import java.util.ArrayList;

public class Controller {
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
    ArrayList<SetQ> variables = new ArrayList<SetQ>();
    ArrayList<DefunCalculator> defunsaved = new ArrayList<>();
    DefunCalculator defunner = new DefunCalculator();
    
    
    //Funcionamiento Principal del programa
    public void Work(){
        boolean cont = true;
        while(cont == true){ 
            view.ManualDeUsuario();
            String input = view.Input();

            if(input.contains("listp") || input.contains("atom") || input.contains("<") || input.contains(">") || input.contains("=")){
                respuesta = p.Predicate(input);
                view.Res(respuesta);
            }
            else if(input.contains("cond")){
                respuesta = c.cond(input);
                view.Res(respuesta);

            }
            else if(input.contains("defun")){
                defunner.setdefun(input, defunsaved);

            }
            else if(input.contains("setq")){
                respuesta = s.setq(input, variables);
                view.Res(respuesta);
            }
            else if(input.contains("'")){
                respuesta = q.getquoteexp(input);
                view.Res(respuesta);
            }
            else if(input.contains("+") || input.contains("-") || input.contains("*") || input.contains("/")){
                respuesta = a.evaluar(input);
                view.Res(respuesta);
            }
            else if(input.equals("0")){
                cont = false;
                break;
            }
            else{
                for (int i = 0; i < defunsaved.size(); i ++){
                    if (input.contains(defunsaved.get(i).getName())){
                        defunner.testsaveddefun(input, defunsaved);
                        break;
                    }
                    else{
                        i++;
                        view.Error();
                    }
                }
            }
        }
            
        
    }
}


