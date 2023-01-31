/**
 * @author: Sofia Garcia, Diego Duarte, Marcela Cordon 
 * 
 * @since:30/01/2023
 **/


 import java.util.EmptyStackException;

 /**
  * Stack
  * 
  * Interface de un Stack.
  */
 public interface IStack<E> {
 
    /**
     * pre:
     * post: el item se agrega a Stack 
     * va hacer popped si no hay un empuje intermedio
     * 
     * @param item elemento para empujar a la pila
     */
    public void push(E item);
 
    /**
     * pre: la pila no esta vacia 
     * post: el elemento empujado mas recientemente se elimina y se devuelve
     * 
     * @return el elemento en la parte superior de la pila.
     * @throws EmptyStackException Si la pila esta vacia.
     */
    public E pull() throws EmptyStackException;
 

 
   /** regresa verdadero si el stack está vacío
    * post: returns true if and only if the stack is empty
    * 
    * @return True if empty, false otherwise.
    */
    public boolean empty();


    /**
    * devuelve devuelve el número de elementos en la pila: Verdadero si está vacío, falso en caso contrario. 
    * 
    * @return The number of elements in the stack.
    */
   public int size();
 
 
 }
