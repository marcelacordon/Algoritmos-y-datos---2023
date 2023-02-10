public class Main {
    public static void main(String[] args) {
        Animal dog = AnimalFactory.getAnimal("dog", "Toby");
        dog.speak();

        Animal cat = AnimalFactory.getAnimal("cat", "Dallas");
        cat.speak();

        Animal chucha = AnimalFactory.getAnimal("dog", "Pelusita");
        chucha.speak();

        Animal mishi = AnimalFactory.getAnimal("cat", "Luni");
        cat.speak();
    }
}