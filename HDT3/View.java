import java.util.Scanner;

/**
 * @author: Sofia Garcia, Diego Duarte, Marcela Cordon 
 * @since:5/02/2023
 **/

public class View {
    int choice = 0;
    Scanner sc = new Scanner(System.in);

    /*
    * menu que se imprimirá en pantalla
    */
    public int menu(){
        System.out.println("\t\t\t\t\tBienvenid@ al programa de Sorts! Qué tipo de sort quisieras probar?\n\n1. Gnome Sort\n2. Merge Sort\n3. Quick Sort\n4. Radix Sort\n5. Bubble Sort\n6. salir del programa");
        choice = sc.nextInt();
        return choice;
    }

    /*
    * imprime el tipo de sort que están utilizando actualmente
    */
    public void gnome(){
        System.out.println("\t\t\tGnome Sort:");
    }

    /*
    * imprime el tipo de sort que están utilizando actualmente
    */
    public void mergr(){
        System.out.println("\t\t\tMerge Sort:");
    }

    /*
    * imprime el tipo de sort que están utilizando actualmente
    */
    public void quick(){
        System.out.println("\t\t\tQuick Sort:");
    }

    /*
    * imprime el tipo de sort que están utilizando actualmente
    */
    public void radixxx(){
        System.out.println("\t\t\tRadix Sort:");
    }

    /*
    * imprime el tipo de sort que están utilizando actualmente
    */
    public void bub(){
        System.out.println("\t\t\tBubble Sort:");
    }

    /*
    * imprime el tipo de sort que están utilizando actualmente
    */
    public void salir(){
        System.out.println("\t\t\tHasta luego!");
    }

    /*
    * imprime el tipo de sort que están utilizando actualmente
    */
    public void invalido(){
        System.out.println("Opción inválida, intente de nuevo.");
    }

    /*
    * imprime el tipo de sort que están utilizando actualmente
    */
    public void ordenadopor(int i){
        System.out.println("\nOrdenamiento con: " + i + " numeros.\n\nPresionar Enter para seguir");
        sc.nextLine();
    }


    
}
