/**
 * Clase que representa a un perro.
 * Herencia de la interfaz
 */
class Dog implements Animal {
    @Override
    public void speak() {
        System.out.println("Woof!");
    }
}