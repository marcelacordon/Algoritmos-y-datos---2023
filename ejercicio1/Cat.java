
/**
 * Clase que representa a un gato.
 * herencia de la interfaz animal
 */
class Cat implements Animal {
    @Override
    public void speak() {
        System.out.println("Meow!");
    }
}