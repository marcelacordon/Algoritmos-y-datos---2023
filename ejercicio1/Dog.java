public class Dog implements Animal {
    private String name;

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public void speak() {
        System.out.println("Woof!");
    }
}