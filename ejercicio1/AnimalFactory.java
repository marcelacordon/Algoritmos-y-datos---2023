import java.util.HashMap;
import java.util.Map;

/**
 * Clase que se encarga de crear objetos de tipo Animal.
 * Utiliza agregación para mantener una colección de objetos Animal.
 */
class AnimalFactory {
    private Map<String, Animal> animals = new HashMap<>();

    /**
     * Crea un objeto Animal específico según el tipo proporcionado.
     * Si el objeto ya ha sido creado previamente, se devuelve la referencia al mismo.
     *
     * @param type tipo de animal a crear
     * @param name nombre del animal a crear
     * @return un objeto Animal
     */
    public Animal createAnimal(String type, String name) {
        if (!animals.containsKey(name)) {
            switch (type) {
                case "dog":
                    animals.put(name, new Dog());
                    break;
                case "cat":
                    animals.put(name, new Cat());
                    break;
            }
        }
        return animals.get(name);
    }
        /**
     * Devuelve un objeto Animal previamente creado.
     *
     * @param name nombre del animal a obtener
     * @return un objeto Animal
     */
    public Animal getAnimal(String name) {
        return animals.get(name);
    }
}
