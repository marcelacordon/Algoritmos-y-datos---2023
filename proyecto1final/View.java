import java.util.Scanner;

public class View {
    public Scanner sc = new Scanner(System.in);
    String res;
    int resp;

    public int MenuPrincipal(){
        System.out.println("\t \t \t INTERPRETADOR DE LISP \n¿Qué desea hacer? \n1. ARITMETICA \n2. QUOTE\n3. DEFUN\n4. SETQ\n5. PREDICADOS (<,>,=)\n6. ATOM\n7. COND\n8.Salir del programa");
        return resp = sc.nextInt();
    }

    public String Input(){
        System.out.println("Ingrese la instrucción: ");
        res = sc.next();
        res+= sc.nextLine();
        return res;
    }

    public void Despedida(){
        System.out.println("GRACIAS POR UTILIZAR EL INTERPRETADOR DE LISP");
    }
}
