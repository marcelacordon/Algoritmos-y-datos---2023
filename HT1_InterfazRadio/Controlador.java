/**
 * Controlador
 */
public class Controlador {
    View vista = new View();
    boolean on = true;
    int choice;

    
    /** 
     * @throws Exception
     */
    public void menu () throws Exception{
        while (on == true){
            choice = vista.menu();
            if ( choice == 1){
                //cambiar de frecuencia 
                if (vista.bbRadio.getFrequence() == "AM"){
                    vista.bbRadio.setFrequence("FM");
                    vista.frecuenciacambiada();
                }
                else if (vista.bbRadio.getFrequence() == "FM"){
                    vista.bbRadio.setFrequence("AM");
                    vista.frecuenciacambiada();
                }
            }
            else if (choice == 2){
                //pasar a la siguiente emisora
                vista.siguienteemisora();
            }
            else if (choice == 3){
                //regresar a la emisora pasada
                vista.emisorapasada();
            }
            else if (choice ==4){
                //guardar emisora


            }
            else if (choice == 5){

            }
            else if (choice == 6){

            }
            else {

            }
        }
    }

    
}