public class Main {
    public static void main(String[] args) {
        Animal dog = AnimalFactory.getAnimal("dog", "Max");
        dog.speak();

        Animal cat = AnimalFactory.getAnimal("cat", "Luna");
        cat.speak();
    }
}