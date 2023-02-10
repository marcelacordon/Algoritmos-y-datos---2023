/**
 * @author: Sofia Garcia, Diego Duarte, Marcela Cordon 
 * @since:5/02/2023
 **/

public class Controller {
    View vista = new View();
    boolean sort = true;
    int choice = 0;
    Read read = new Read();
    int [] tresk = read.readOrCreateFile();
    Sorts sorter = new Sorts<>(new Comparable<>());

    /*
    * menu funcional del programa
    */
    public void menu(){

        while (sort == true){
            choice = vista.menu();
            /*
            * Gnome Sort
            */
            if (choice == 1){
                vista.gnome();
                ordenar(choice);
                

            }
            /*
            * merge sort
            */
            else if (choice == 2){
                vista.mergr();
                ordenar(choice);

            }
            /*
            * quick sort
            */
            else if (choice ==3){
                vista.quick();
                ordenar(choice);
                

            }
            /*
            * radix sort
            */
            else if (choice ==4){
                vista.radixxx();
                ordenar(choice);

            }
            /*
            * Bubble sort
            */
            else if (choice == 5){
                vista.bub();
                ordenar(choice);

            }
            /*
            * salir
            */
            else if (choice == 6){
                vista.salir();
                sort = false;
            }
            /*
            * respuesta inválida
            */
            else {
                vista.invalido();

            }

        }
    }

    public void ordenar (int choice2){
        for(int i = 10; i <= 3000; i+=299){
            int[] lista = new int[i];
        
            for(int o=0; o<i; o++) {
                lista[o]=tresk[o];
            }
            if (choice2 == 1){
                sorter.Gnome(lista);
            }
            else if (choice2 == 2)  {
                sorter.mergesort(lista);
            }
            else if (choice2 == 3)    {
                sorter.Quicksort(lista, 0, lista.length-1);
            }
            else if (choice2 ==4){
                sorter.radixsort(lista);
            }
            else if (choice2 == 5) {
                sorter.bubblesort(lista);
            }                 
            for(int recorrido:lista) {
                System.out.println(recorrido);
            }
            vista.ordenadopor(i);
        }
    }

    
    
}
