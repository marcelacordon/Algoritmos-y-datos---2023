/**
 * @author: Sofia Garcia, Diego Duarte
 * 
 * @since:14/03/2023
 **/

import java.util.*;

public class Aritmetica {

    /**
    Método público para evaluar una cadena de expresión aritmética y devolver el resultado.
    @param input La cadena de expresión aritmética a evaluar.
    @return El resultado de la evaluación de la expresión.
    */
    public String evaluar(String input) {
        Queue<String> tokens = tokenize(input);
        return "Resultado = " + Double.toString(evaluarTokens(tokens));
    }
    
    /**
    Método para tokenizar una cadena de expresión aritmética.
    @param input La cadena de expresión aritmética a tokenizar.
    @return Una cola de tokens (números, operadores y paréntesis) obtenida al tokenizar la expresión.
    */
    private Queue<String> tokenize(String input) {
        Queue<String> tokens = new LinkedList<>();
        StringBuilder TokenPrincipal = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c) || c == '.') {
                TokenPrincipal.append(c);
            } 
            else if (Character.isWhitespace(c)) {
                if (TokenPrincipal.length() > 0) {
                    tokens.add(TokenPrincipal.toString());
                    TokenPrincipal = new StringBuilder();
                }
            } 
            else if (c == '(' || c == ')') {
                if (TokenPrincipal.length() > 0) {
                    tokens.add(TokenPrincipal.toString());
                    TokenPrincipal = new StringBuilder();
                }
                tokens.add(String.valueOf(c));
            } 
            else {
                if (TokenPrincipal.length() > 0) {
                    tokens.add(TokenPrincipal.toString());
                    TokenPrincipal = new StringBuilder();
                }
                tokens.add(String.valueOf(c));
            }
        }
        if (TokenPrincipal.length() > 0) {
            tokens.add(TokenPrincipal.toString());
        }
        return tokens;
    }
    

     /**
    Método para evaluar la cola de tokens.
    @param tokens La cola aritmetica ya tokenizada.
    @return Double como respuesta de realizar las operaciones.
    */
    private double evaluarTokens(Queue<String> tokens) {
        Stack<Double> stackValores = new Stack<>();
        Stack<String> stackOperandos = new Stack<>();
        while (!tokens.isEmpty()) {
            String token = tokens.poll();
            if (isNumero(token)) {
                stackValores.push(Double.parseDouble(token));
            } 
            else if (token.equals("(")) {
                stackOperandos.push(token);
            } 
            else if (token.equals(")")) {
                while (!stackOperandos.peek().equals("(")) {
                    evaluarTop(stackValores, stackOperandos);
                }
                stackOperandos.pop(); 
            } 
            else {
                while (!stackOperandos.isEmpty() && hasPrecedence(token, stackOperandos.peek())) {
                    evaluarTop(stackValores, stackOperandos);
                }
                stackOperandos.push(token);
            }
        }
        while (!stackOperandos.isEmpty()) {
            evaluarTop(stackValores, stackOperandos);
        }
        return stackValores.pop();
    }

     /**
    Método para evaluar si un caracter es un numero.
    @param token Caracter individual
    @return Booleano dependiendo si es numero o no.
    */
    private boolean isNumero(String token) {
        return token.matches("\\d+(\\.\\d+)?");
    }
    

    /**
    Método para evaluar si un caracter es un numero.
    @param token Caracter individual
    @param token Caracter individual
    @return Booleano dependiendo si es numero o no.
    */
    private boolean hasPrecedence(String op1, String op2) {
        if (op2.equals("(") || op2.equals(")")) {
            return false;
        }
        if ((op1.equals("*") || op1.equals("/")) && (op2.equals("+") || op2.equals("-"))) {
            return false;
        }
        return true;
    }
    
    private void evaluarTop(Stack<Double> stackValores, Stack<String> stackOperandos) {
        double val2 = stackValores.pop();
        double val1 = stackValores.pop();
        String op = stackOperandos.pop();
        if (op.equals("+")) {
            stackValores.push(val1 + val2);
        } 
        else if (op.equals("-")) {
            stackValores.push(val1 - val2);
        } 
        else if (op.equals("*")) {
            stackValores.push(val1 * val2);
        } 
        else if (op.equals("/")) {
            try {
                if (val2 == 0) {
                    throw new ArithmeticException("No se puede dividir dentro de 0");
                }
                stackValores.push(val1 / val2);
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}

