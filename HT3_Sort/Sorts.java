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
* Ordena el array de entrada usando el algoritmo de Gnome sort.
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
/** merge sort 1
* Método auxiliar para combinar dos subarrays ordenados en un array ordenado.
* 
* @param lista El array original.
* @param first Índice izquierdo del subarray.
* @param middle Índice medio del subarray.
* @param last Índice derecho del subarray.
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

/** merge sort 2
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

  

  
/**
* Función principal para ordenar un array usando QuickSort
* 
* @param arr array a ordenar
* @param low índice bajo del subarray
* @param high índice alto del subarray
*/
public static void Quicksort(int[] lista, int low, int high) {
    if (low < high) {
    // Se encuentra el índice pivot y se parte el array
    int pivotIndex = partition(lista, low, high);

    // Se ordena el subarray izquierdo
    sort(lista, low, pivotIndex - 1);

    // Se ordena el subarray derecho
    sort(lista, pivotIndex + 1, high);
    }
}

/**para quick sort
* Función auxiliar para particionar el array y encontrar el índice pivot
* 
* @param lista array a particionar
* @param low índice bajo del subarray
* @param high índice alto del subarray
* @return índice del pivot
*/
private static int partition(int[] lista, int low, int high) {
// Se elige el elemento pivot
    int pivot = lista[high];
    int i = low - 1;
    for (int j = low; j < high; j++) {
      if (lista[j] <= pivot) {
        i++;
        // Se intercambian los elementos
        int temp = lista[i];
        lista[i] = lista[j];
        lista[j] = temp;
      }
    }

    // Se coloca el pivot en su posición correcta
    int temp = lista[i + 1];
    lista[i + 1] = lista[high];
    lista[high] = temp;

    return i + 1;
  }


  

  /**
 * Función de ordenamiento de radix sort.
 * @param arr Arreglo de enteros a ordenar.
 */
public static void radixSort(int[] arr) {
    int max = Arrays.stream(arr).max().getAsInt();
    int numDigits = (int) Math.log10(max) + 1;
    for (int i = 0; i < numDigits; i++) {
        List<List<Integer>> buckets = new ArrayList<>(10);
        for (int j = 0; j < 10; j++) {
            buckets.add(new ArrayList<>());
        }
        for (int j = 0; j < arr.length; j++) {
            int digit = getDigit(arr[j], i + 1);
            buckets.get(digit).add(arr[j]);
        }
        int k = 0;
        for (int j = 0; j < 10; j++) {
            for (int num : buckets.get(j)) {
                arr[k++] = num;
            }
        }
    }
}

/**pal radix
 * Obtiene el dígito en la posición dada de un número.
 * @param num Número del cual se desea obtener el dígito.
 * @param pos Posición del dígito a obtener (empieza en 1).
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
    public static void bubblesort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    // Intercambia arr[j] y arr[j+1] si están en el orden incorrecto
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
  


}
