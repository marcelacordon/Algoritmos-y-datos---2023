public class Controller {
    View view = new View();
    LispInterpreter lispo = new LispInterpreter();
    boolean cont = true;
    Aritmetica a = new Aritmetica();

    public void Work(){
        while(cont == true){

            int choice = view.MenuPrincipal();
            if(choice == 1){
                String input = view.Input();
            }
            else if (choice == 2){

            }
            else if (choice == 3){

            }
            else if (choice == 4){

            }
            else if (choice == 5){

            }
            else if (choice == 6){

            }
            else if (choice == 7){

            }
            else if (choice == 8){
                cont = false;
                view.Despedida();
                break;
            }
        }

    }

}
