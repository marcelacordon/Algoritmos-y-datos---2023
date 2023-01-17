//Importacion de Librerias
import javax.swing.JOptionPane;

/**
 * View
 */
public class View {
    radio bbRadio = new radio();
    int respuesta = 0;

    
    /** 
     * @return int Menu Principal de la Radio
     */
    public int menu (){
        if (bbRadio.getFrequence() == "AM"){//En caso de que la frecuencia de la radio sea AM
            respuesta = Integer.parseInt(JOptionPane.showInputDialog("Bienvenido a la radio YAYUY!\n\t\tQué desea hacer?\n1.Cambiar de frecuencia\n2. Pasar a la siguiente emisora\n3. Regresar a la emisora pasada\n4. Guardar emisora\n5. Escoger una emisora de las guardadas\n6. Apagar el radio\n\nFrecuencia actual: AM\nEmisora actual: "+bbRadio.getAMActualStation()));// Interfaz gráfica para el usaurio
        }
        else if (bbRadio.getFrequence() == "FM"){//En caso de que la frecuencai de la radio sea FM
            respuesta = Integer.parseInt(JOptionPane.showInputDialog("Bienvenido a la radio YAYUY!\n\t\tQué desea hacer?\n1.Cambiar de frecuencia\n2. Pasar a la siguiente emisora\n3. Regresar a la emisora pasada\n4. Guardar emisora\n5. Escoger una emisora de las guardadas\n6. Apagar el radio\n\nFrecuencia actual: FM\nEmisora actual: "+bbRadio.getFMActualStation()));// Interfaz gráfica para el usaurio
        }
        return respuesta;//Regresa un int dependiendo de la elección del usuario.
    }


    public void frecuenciacambiada(){ //Mensaje de que la frecuencia fue cambiada exitosamente
        JOptionPane.showMessageDialog(null,"Frecuencia cambiada!");
    }



    public void siguienteemisora(){ //Mensaje de que se cambio de emisora exitosamente 
        bbRadio.Forward();
        JOptionPane.showMessageDialog(null,"Avanzaste a la siguiente emisora!");
    }



    public void emisorapasada (){ //Mensaje de que se cambio la emisora exitosamente 
        bbRadio.Backward();
        JOptionPane.showMessageDialog(null,"Ahora estás en la emisora pasada!");
    }



    public void guardaremisora(){ // Guardar la emisora 
        String emisoras = "";
        if (bbRadio.getFrequence() == "AM"){ //En caso de que la radio se encuentre en AM

            respuesta  = Integer.parseInt(JOptionPane.showInputDialog("Puedes guardar la emisora actual en cualquiera de los botones del 1-12\n\nEscoge un número de índice:")); //Le pregunta al usuario donde quiere guardar la emisora 
            if (respuesta>0 && respuesta < 13){ //En caso de que el usario escriba un indice valido
                respuesta = respuesta -1;
                bbRadio.saveAMStation(bbRadio.getAMActualStation(), respuesta);
                JOptionPane.showMessageDialog(null, "Emisora agregada a favoritas exitosamente!");
            }
            else{//En caso de que el usario escriba un indice invalido
                JOptionPane.showMessageDialog(null, "Número de índice inválido, intenta de nuevo.");
            }
        }
        else if (bbRadio.getFrequence() == "FM"){//En caso de que la radio se encuentre en FM

            respuesta  = Integer.parseInt(JOptionPane.showInputDialog("Puedes guardar la emisora actual en cualquiera de los botones del 1-12\n\nEscoge un número de índice:")); //Le pregunta al usuario donde quiere guardar la emisora 
            if (respuesta>0 && respuesta < 13){//En caso de que el usario escriba un indice valido
                respuesta = respuesta -1;
                bbRadio.saveFMStation(bbRadio.getFMActualStation(), respuesta);
                JOptionPane.showMessageDialog(null, "Emisora agregada a favoritas exitosamente!");
            }
            else{//En caso de que el usario escriba un indice invalido
                JOptionPane.showMessageDialog(null, "Número de índice inválido, intenta de nuevo.");
            }
        }
        
    }


    
    /** 
     * @throws Exception
     */
    public void escogeremisoraguardada() throws Exception{ //Escoger una emisora ya guardada 
        respuesta = Integer.parseInt(JOptionPane.showInputDialog("De qué tipo de emisora quieres escoger de la lista de favoritas?\n1. AM\n2. FM"));
        int respuestita;
        if (respuesta == 1){//En caso que eliga escoger una emisora AM
            bbRadio.setFrequence("AM");
            respuestita = Integer.parseInt(JOptionPane.showInputDialog("\nIngresa el número de índice (del 1-12): "));
            if (respuestita > 0 && respuestita <13){//En caso de que el usaurio eliga un indice valido
                respuestita = respuestita -1;
                bbRadio.setAMActualStation(bbRadio.getAMSlot(respuestita));
                JOptionPane.showMessageDialog(null, "Emisora cambiada exitosamente!");

            }
            else{//En caso de que el usaurio eliga un indice invalido
                JOptionPane.showMessageDialog(null, "Número de índice inválido, intenta de nuevo.");
            }
        }
        if (respuesta == 2){//En caso que eliga escoger una emisora FM
            bbRadio.setFrequence("FM");
            respuestita = Integer.parseInt(JOptionPane.showInputDialog("\nIngresa el número de índice (del 1-12): "));
            if (respuestita > 0 && respuestita <13){//En caso de que el usaurio eliga un indice valido
                respuestita = respuestita -1;
                bbRadio.setFMActualStation(bbRadio.getFMSlot(respuestita));
                JOptionPane.showMessageDialog(null, "Emisora cambiada exitosamente!");
            }
            else{//En caso de que el usaurio eliga un indice invalido
                JOptionPane.showMessageDialog(null, "Número de índice inválido, intenta de nuevo.");
            }
        }
    }


    public void adios(){//Mensaje de despedida en caso de que el usuario quiera apagar la radio. 
        JOptionPane.showMessageDialog(null, "Gracias por usar el radio! Hasta luego");
    }

    public void invalido(){ //Mensaje de opción invalida 
        JOptionPane.showMessageDialog(null, "Opción inválida, intente de nuevo.");
    }
  
}
