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
            respuesta = Integer.parseInt(JOptionPane.showInputDialog("Bienvenido a la radio YAYUY!\n\t\tQué desea hacer?\n1.Cambiar de frecuencia\n2. Pasar a la siguiente emisora\n3. Regresar a la emisora pasada\n4. Guardar emisora\n5. Escoger una emisora de las guardadas\n6. Apagar el radio\n\nFrecuencia actual: AM\nEmisora actual: "+bbRadio.getAMstation()));// Interfaz gráfica para el usaurio
        }
        else if (bbRadio.getFrequence() == "FM"){//En caso de que la frecuencai de la radio sea FM
            respuesta = Integer.parseInt(JOptionPane.showInputDialog("Bienvenido a la radio YAYUY!\n\t\tQué desea hacer?\n1.Cambiar de frecuencia\n2. Pasar a la siguiente emisora\n3. Regresar a la emisora pasada\n4. Guardar emisora\n5. Escoger una emisora de las guardadas\n6. Apagar el radio\n\nFrecuencia actual: FM\nEmisora actual: "+bbRadio.getFMActualStation()));// Interfaz gráfica para el usaurio
        }
        return respuesta;//Regresa un int dependiendo de la elección del usuario.
    }


    public void frecuenciacambiada(){
        JOptionPane.showMessageDialog(null,"Frecuencia cambiada!");
    }

    public void siguienteemisora(){
        bbRadio.Forward();
        JOptionPane.showMessageDialog(null,"Avanzaste a la siguiente emisora!");
    }

    public void emisorapasada (){
        bbRadio.Backward();
        JOptionPane.showMessageDialog(null,"Ahora estás en la emisora pasada!");
    }

    public void guardaremisora(){
        if (bbRadio.getFrequence() == "AM"){
            
        }
    }














    
}
