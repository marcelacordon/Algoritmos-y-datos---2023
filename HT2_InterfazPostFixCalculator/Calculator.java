/**
 * @author: Sofia Garcia, Diego Duarte, Marcela Cordon 
 * 
 * @since:30/01/2023
 **/



import java.util.ArrayList;

public class Calculator implements IPostfixCalculator{

    

    Calculator (){}

    @Override
    public boolean isOneItem(IStack operandos) {
        if (operandos.size() == 1){
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public int suma(int a, int b) {
        int respuesta = a + b;
        return respuesta;
    }

    @Override
    public int resta(int a, int b) {
        int respuesta = a - b;
        return respuesta;
    }

    @Override
    public int multiplicacion(int a, int b) {
        int respuesta = a * b;
        return respuesta;
    }

    @Override
    public int division(int a, int b) {
        int respuesta = a/b;
        return respuesta;
    }

    @Override
    public boolean isOperator(String item) {
        try {
            Integer.valueOf(item);
            return false;
        } 
        catch (NumberFormatException e) {
            return true;
        }     
    }

    @Override
    public ArrayList<String> getItems(String _expresion) {
        // TODO Auto-generated method stub
        ArrayList<String> ite = new ArrayList<String>();
        String [] items = _expresion.split(" ");
        for (int i = 0; i < items.length; i++){
            ite.add(items[i]);
        }
        return ite;
    }
    
}
