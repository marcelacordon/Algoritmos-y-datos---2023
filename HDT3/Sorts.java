/**
 * @author: Sofia Garcia, Diego Duarte, Marcela Cordon 
 * @since:5/02/2023
 **/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sorts<T> {
    Comparable<T> comparable = new Comparable<>();

    
public Sorts(Comparable<T> comparable) {
        this.comparable = comparable;
    }

    
/**
* Método principal para ordenar un array con GnomeSort.
* 
* @param lista El array a ordenar.
* @see https://iq.opengenus.org/gnome-sort/#:~:text=Gnome%20Sort%20is%20an%20in,similar%20to%20a%20bubble%20sort. 
*/
public static void Gnome(int[] lista) {
    int indice = 0;
    while (indice < lista.length) {
        //En caso de que el indice sea 0, sumarle 1.
        if (indice == 0){
            indice++;
        }
        //Verificar si un numero con indice menor es menor o igual a un numero con un indice mayor.
        if (lista[indice - 1] <= lista[indice]) {
            indice++;
        } 
        //En caso contrario cambiar de indices los numeros comparados.
        else {
        int change = lista[indice - 1];
        lista[indice - 1] = lista[indice];
        lista[indice] = change;
        indice--;
        }
    }
}

/**
* Método principal para ordenar un array con QuickSort
* 
* @param lista El array original. 
* @param first Indice bajo del subarray
* @param last Indice alto del subarray
* @see https://www.programiz.com/java-programming/examples/quick-sort#:~:text=Quicksort%20in%20Java&text=While%20dividing%20the%20array%2C%20the,both%20left%20and%20right%20subarrays 
* @see https://www.geeksforgeeks.org/java-program-for-quicksort/ 
*/
public static void Quicksort(int[] lista, int first, int last) {
    if (first < last) {
    // Se encuentra el índice pivot y se parte el array
    int numchange = split(lista, first, last);
    // Se ordena el subarray izquierdo
    sort(lista, first, numchange - 1);
    // Se ordena el subarray derecho
    sort(lista, numchange + 1, last);
    }
}


/** 
* Método auxiliar de sort para combinar dos subarrays en un array.
*
* @param lista El array original.
* @param first Indice izquierdo del subarray.
* @param middle Indice medio del subarray.
* @param last Indice derecho del subarray.
* @see https://www.geeksforgeeks.org/java-program-for-quicksort/
*/
private static void merge(int[] lista, int first, int middle, int last) {
    // Tamaños de los subarrays
    int size1 = middle - first + 1;
    int size2 = last - middle;
    // Subarray Izquierdo
    int[] Leftie = new int[size1];
    // Subarray Derecho
    int[] Righty = new int[size2];
    // Agregando elementos al subarray Izquierdo
    for (int i = 0; i < size1; i++) {
        Leftie[i] = lista[first + i];
    }
    // Agregando elementos al subarray Derecho
    for (int i = 0; i < size2; i++) {
        Righty[i] = lista[middle + 1 + i];
    }
    // Índice para los Arrays
    int IL = 0;
    int IR = 0;
    int indice = first;
    // Mientras haya elementos en ambos subarrays
    while (IL < size1 && IR < size2) {
        if (Leftie[IL] <= Righty[IR]) {
            // Asignar elemento menor a lista
            lista[indice] = Leftie[IL];
            IL++;
        } 
        else {
            lista[indice] = Righty[IR];
            IR++;
        }
        indice++;
    }
    // Mientras haya elementos en el Subarray Izquierdo
    while (IL < size1) {
        // Asignar elemento a lista
        lista[indice] = Leftie[IL];
        IL++;
        indice++;
    }
    // Mientras haya elementos en el Subarray Derecho
    while (IR < size2) {
        // Asignar elemento a lista
        lista[indice] = Righty[IR];
        IR++;
        indice++;
    }
}

/** 
* Metodo auxilar del QuickSort y MergeSort que ordena un subarray usando el algoritmo de Merge sort.
* 
* @param arr El array original.
* @param first Índice izquierdo del subarray.
* @param last Índice derecho del subarray.
* @see https://www.geeksforgeeks.org/java-program-for-quicksort/ 
*/
private static void sort(int[] arr, int first, int last) {
    if (first < last) {
        int middle = (first + last) / 2;
        sort(arr, first, middle);
        sort(arr, middle + 1, last);
        merge(arr, first, middle, last);
    }
}

/** 
* Método Principal que odena el array con Merge sort.
* 
* @param arr El array a ordenar.
* @see https://www.programiz.com/java-programming/examples/quick-sort#:~:text=Quicksort%20in%20Java&text=While%20dividing%20the%20array%2C%20the,both%20left%20and%20right%20subarrays 
* @see https://www.geeksforgeeks.org/java-program-for-quicksort/
*/
public static void mergesort(int[] arr) {
    sort(arr, 0, arr.length - 1);
}


/**
* Método auxiliar de quick sort para separar el array y encontrar el índice de cambio
* 
* @param lista array a particionar
* @param first índice bajo del subarray
* @param last índice alto del subarray
* @return índice del pivot
* @see https://www.programiz.com/java-programming/examples/quick-sort#:~:text=Quicksort%20in%20Java&text=While%20dividing%20the%20array%2C%20the,both%20left%20and%20right%20subarrays
* @see https://www.geeksforgeeks.org/java-program-for-quicksort/ 
*/
private static int split(int[] lista, int first, int last) {
// Se elige el elemento pivot
    int eje = lista[last];
    int i = first - 1;
    for (int o = first; o < last; o++) {
        if (lista[o] <= eje) {
        i++;
        // Se intercambian los elementos
        int numchange = lista[i];
        lista[i] = lista[o];
        lista[o] = numchange;
        }
    }
    // Se coloca el pivot en su posición correcta
    int numchange = lista[i + 1];
    lista[i + 1] = lista[last];
    lista[last] = numchange;
    return i + 1;
  }

/**
 * Función de ordenamiento de radix sort.
 * @param lista Arreglo de enteros a ordenar.
 * @see https://www.java67.com/2018/03/how-to-implement-radix-sort-in-java.html
 */
public static void radixsort(int[] arr) {
    int max = getMax(arr);
    for (int exp = 1; max / exp > 0; exp *= 10) {
        countSort(arr, exp);
    }
}

private static void countSort(int[] arr, int exp) {
    int[] output = new int[arr.length];
    int[] count = new int[10];

    for (int i = 0; i < arr.length; i++) {
        count[(arr[i] / exp) % 10]++;
    }

    for (int i = 1; i < count.length; i++) {
        count[i] += count[i - 1];
    }

    for (int i = arr.length - 1; i >= 0; i--) {
        output[count[(arr[i] / exp) % 10] - 1] = arr[i];
        count[(arr[i] / exp) % 10]--;
    }

    for (int i = 0; i < arr.length; i++) {
        arr[i] = output[i];
    }
}

private static int getMax(int[] arr) {
    int max = arr[0];
    for (int i = 1; i < arr.length; i++) {
        if (arr[i] > max) {
            max = arr[i];
        }
    }
    return max;
}


    /**
     * El método sort toma un arreglo de enteros y lo ordena utilizando el
     * algoritmo de Bubble Sort.
     * 
     * @param arr El arreglo de enteros a ordenar.
     * @see https://mkyong.com/java/java-bubble-sort-example/
     * @see https://www.geeksforgeeks.org/bubble-sort/ 
     */
    public static void bubblesort(int[] lista) {
        // Tamaño de la lista.
        int size = lista.length; 
        for (int i = 0; i < size-1; i++) { 
            for (int o = 0; o < size-i-1; o++) { 
                // Comparación de elementos consecutivos.
                if (lista[o] > lista[o+1]) {
                    int numchange = lista[o]; // Variable temporal.
                    lista[o] = lista[o+1];
                    lista[o+1] = numchange;
                }
            }
        }
    }
  


}
