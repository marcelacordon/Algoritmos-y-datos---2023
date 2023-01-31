import javax.swing.JOptionPane;

/**
 * @author: Sofia Garcia, Diego Duarte, Marcela Cordon 
 * 
 * @since:30/01/2023
 **/


public class View {
    String resp; 
    
    Read r = new Read();

    public String ingresardirec (){
        resp = JOptionPane.showInputDialog("Ingrese la ruta del archivo ej C:\\ejemplos\\example1.txt");
        String expression = r.leer(resp);
        return expression;
    }

}
