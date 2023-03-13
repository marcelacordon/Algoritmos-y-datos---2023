public class Main {
    public static void main (String [] args) {
        Controller cont = new Controller();
        LispInterpreter lis = new LispInterpreter();

        System.out.println(lis.parse("( + 2 3 )"));
    
    }
}
