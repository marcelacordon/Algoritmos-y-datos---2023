/**
 * Clase principal que demuestra el uso de la clase AnimalFactory.
 */
public class Main {
    public static void main(String[] args) {
        // Crea una nueva instancia de la clase AnimalFactory
        AnimalFactory factory = new AnimalFactory();

        // Crea un perro y un gato
        factory.createAnimal("dog", "Fido");
        factory.createAnimal("cat", "Fluffy");

        // Obtiene los animales creados y los hace hablar
        Animal dog = factory.getAnimal("Fido");
        dog.speak();
        Animal cat = factory.getAnimal("Fluffy");
        cat.speak();
    }
}





