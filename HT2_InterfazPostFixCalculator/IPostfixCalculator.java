/**
 * @author: Sofia Garcia, Diego Duarte, Marcela Cordon 
 * 
 * @since:30/01/2023
 **/

public interface IPostfixCalculator {
	
	boolean isOneItem(IStack operandos);
	
	int suma(int a, int b);
	
	int resta(int a, int b);
	
	int multiplicacion(int a, int b);
	
	int division(int a, int b);
	
	boolean isOperator(String item);
	
	java.util.ArrayList<String> getItems(String _expresion);
}