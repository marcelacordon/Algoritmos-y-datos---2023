
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * @author: Sofia Garcia, Diego Duarte, Marcela Cordon 
 * 
 * @since:30/01/2023
 **/


public class View {
    String resp; 
    
    Read r = new Read();

    ArrayList<String> rf = new ArrayList<String>();

    public String ingresardirec (){
        resp = JOptionPane.showInputDialog("Ingrese la ruta del archivo ej C:\\ejemplos\\example1.txt");
        String expression = r.leer(resp);
        return expression;
    }

    public void noOperandos(){
        JOptionPane.showMessageDialog(null, "No hay suficientes operandos para poder realizar la operacion");
    }

    public void dividirCero(){
        JOptionPane.showMessageDialog(null, "Esta operacion no se puede realizar, debido a que se divide entre cero");
    }

    public void simboloNoReconocido(){
        JOptionPane.showMessageDialog(null, "Esta operacion no se puede realizar, no se reconoce el simbolo utilizado.");
    }

     public void resultadoOPer(int res){
        JOptionPane.showMessageDialog(null, "El resultado es: " +  res);
    }
}

