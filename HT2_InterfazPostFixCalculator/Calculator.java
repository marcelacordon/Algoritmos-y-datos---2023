/**
 * @author: Sofia Garcia, Diego Duarte, Marcela Cordon 
 * 
 * @since:30/01/2023
 **/



import java.util.ArrayList;

public class Calculator implements IPostfixCalculator{

    Stack<Integer> stack = new Stack<Integer>();

    Calculator (){}

    @Override
    public boolean isOneItem(IStack operandos) {
        if (operandos.size() == 1){
            return true;
        }
        return false;
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
        return null;
    }
    
}
