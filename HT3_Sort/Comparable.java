/**
 * @author: Sofia Garcia, Diego Duarte, Marcela Cordon 
 * @since:5/02/2023
 **/

public class Comparable<T> implements IComparable<T>{

    @Override
    public  int Compare(T objeto1, T objeto2) {
        int numero1, numero2;

        numero1 = Integer.parseInt(objeto1.toString());
        numero2 = Integer.parseInt(objeto2.toString());

        if(numero1 > numero2){
            return 1;
        }else if(numero1 < numero2){
            return -1;
        }else{
            return 0;
        }
    }



}