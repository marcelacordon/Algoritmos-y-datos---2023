import java.util.Scanner;

public class View {
    public Scanner sc = new Scanner(System.in);
    String res;
    int resp;


    public String Input(){
        System.out.println("Ingrese la instrucción: ");
        res = sc.next();
        res+= sc.nextLine();
        return res;
    }

    public void Despedida(){
        System.out.println("GRACIAS POR UTILIZAR EL INTERPRETADOR DE LISP");
    }

    public void NoCero(){
        System.out.println("No es posible dividir dentro de 0");
    }

    public void ManualDeUsuario(){
        System.out.println("\n\n\n\n\nBIENVENIDO AL INTERPRETADOR DE LISP \n1. Sus intrucciones deben de ir escritas en solo una linea de código.\nEJEMPLO: (cond ((> 2 3) 'mayor) (= 2 3) 'igual)\nEjemplo de aritmeticas: ( * 1 2 )\nEjemplo de funciones ya creadas en defun: ( operacion 1 2 )\nEjemplos de como escribir quotes '(1 2 3 4)\nEjemplo para crear un nuevo defun: (defun operacion (xy) (*xy) )\nEjemplo para crear un setq: (setq x 42 b 30)\nEjemplo para crear un cond: (cond ((< 8 9) 'x) ((= 0 1) 'y) (t 'z) ) *Se pueden poner más o menos parámetros\nEjemplo para crear Predicados: (atom 'x) o (listp '(1 2 3))\n");
        System.out.println("2. Solo debe de poner espacios después de una función, variable, dato. (Los parentesis deben de ser una guía y es preferible que vayan juntos de esos parametros)");
        System.out.println("3. Las instrucciones las debe de colocar en la terminal ");
        System.out.println("4. Ingrese las instrucciones de 1 en 1");
        System.out.println("5. Si desea salir del interprete, ingrese 0\n\n\n\n\n");
    }

    public void Res(String res){
        System.out.println(res);
    }

    public void Error(){
        System.out.println("Ingrese una instruccion valida");
    }

    
}
