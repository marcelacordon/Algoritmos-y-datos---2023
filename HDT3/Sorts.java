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
*/
public static void Gnome(int[] lista) {
    int indice = 0;
    while (indice < lista.length) {
        if (indice == 0){
            indice++;
        }
        if (lista[indice - 1] <= lista[indice]) {
            indice++;
        } 
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
* Método auxiliar de QuickSort para combinar dos subarrays en un array.
* 
* @param lista El array original.
* @param first Indice izquierdo del subarray.
* @param middle Indice medio del subarray.
* @param last Indice derecho del subarray.
*/
private static void merge(int[] lista, int first, int middle, int last) {
    int size1 = middle - first + 1;
    int size2 = last - middle;
    int[] Leftie = new int[size1];
    int[] Righty = new int[size2];
    for (int i = 0; i < size1; i++) {
        Leftie[i] = lista[first + i];
    }
    for (int i = 0; i < size2; i++) {
        Righty[i] = lista[middle + 1 + i];
    }
    int IL = 0;
    int IR = 0;
    int indice = first;
    while (IL < size1 && IR < size2) {
        if (Leftie[IL] <= Righty[IR]) {
            lista[indice] = Leftie[IL];
            IL++;
        } 
        else {
            lista[indice] = Righty[IR];
            IR++;
        }
        indice++;
    }
    while (IL < size1) {
        lista[indice] = Leftie[IL];
        IL++;
        indice++;
    }
    while (IR < size2) {
        lista[indice] = Righty[IR];
        IR++;
        indice++;
    }
}

/** 
* Ordena un subarray usando el algoritmo de Merge sort.
* 
* @param arr El array original.
* @param first Índice izquierdo del subarray.
* @param last Índice derecho del subarray.
*/
private static void sort(int[] arr, int first, int last) {
    if (first < last) {
        int middle = (first + last) / 2;
        sort(arr, first, middle);
        sort(arr, middle + 1, last);
        merge(arr, first, middle, last);
    }
}

/** merge sort main
* Ordena el array de entrada usando el algoritmo de Merge sort.
* 
* @param arr El array a ordenar.
*/
public static void mergesort(int[] arr) {
    sort(arr, 0, arr.length - 1);
}

  

  


/**para quick sort
* Método auxiliar para separar el array y encontrar el índice de cambio
* 
* @param lista array a particionar
* @param first índice bajo del subarray
* @param last índice alto del subarray
* @return índice del pivot
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
 */
public static void radixSort(int[] lista) {
    int max = Arrays.stream(lista).max().getAsInt();
    int digitos = (int) Math.log10(max) + 1;
    for (int i = 0; i < digitos; i++) {
        List<List<Integer>> buckets = new ArrayList<>(10);
        for (int o = 0; o < 10; o++) {
            buckets.add(new ArrayList<>());
        }
        for (int o = 0; o < lista.length; o++) {
            int digito = getDigit(lista[o], i + 1);
            buckets.get(digito).add(lista[o]);
        }
        int indice = 0;
        for (int o = 0; o < 10; o++) {
            for (int num : buckets.get(o)) {
                lista[indice++] = num;
            }
        }
    }
}

/**pal radix
 * Obtiene el dígito en la posición dada de un número.
 * @param num Número del cual se desea obtener el dígito.
 * @param pos Posición del dígito a obtener 
 * @return El dígito en la posición dada.
 */
private static int getDigit(int num, int pos) {
    return (int) ((num / Math.pow(10, pos - 1)) % 10);
}


    /**
     * El método sort toma un arreglo de enteros y lo ordena utilizando el
     * algoritmo de Bubble Sort.
     * 
     * @param arr El arreglo de enteros a ordenar.
     */
    public static void bubblesort(int[] lista) {
        int size = lista.length;
        for (int i = 0; i < size-1; i++) {
            for (int o = 0; o < size-i-1; o++) {
                if (lista[o] > lista[o+1]) {
                    int numchange = lista[o];
                    lista[o] = lista[o+1];
                    lista[o+1] = numchange;
                }
            }
        }
    }
  


}
