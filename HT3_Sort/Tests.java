
import java.util.Arrays;

import org.junit.Test;

public class Tests {

    private int[] prueba = new int[]{4,2,5,6,8,9,10,3,6,7};
    
    @Test
    public void TestGnome(){
        Sorts.Gnome(prueba);
        Arrays.equals(new int[]{2,3,4,5,6,6,7,8,9,10}, prueba);
    }

    @Test
    public void Testmerge(){
        Sorts.mergesort(prueba);
        Arrays.equals(new int[]{2,3,4,5,6,6,7,8,9,10}, prueba);
    }

    @Test
    public void Testquick(){
        Sorts.Quicksort(prueba,0, prueba.length - 1);
        Arrays.equals(new int[]{2,3,4,5,6,6,7,8,9,10}, prueba);
    }

    @Test
    public void Testradix(){
        Sorts.radixSort(prueba);
        Arrays.equals(new int[]{2,3,4,5,6,6,7,8,9,10}, prueba);
    }

    @Test
    public void Testbubble(){
        Sorts.radixSort(prueba);
        Arrays.equals(new int[]{2,3,4,5,6,6,7,8,9,10}, prueba);
    }


}
