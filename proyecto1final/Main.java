import java.util.Scanner;

public class Main {
    public static void main (String [] args) {
        Controller cont = new Controller();
        LispInterpreter lis = new LispInterpreter();
        QuoteExpression q = new QuoteExpression();
        System.out.println(q.quoteexp("( setq ( caca ) )"));
        
        Scanner sc = new Scanner(System.in);
        String cac = sc.nextLine();
        if (cac.contains("setq") ){
         System.out.println(q.quoteexp(cac));
        }
        else{
         System.out.println("OUTA");
        }
        
        

    
    }
}
