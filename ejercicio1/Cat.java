
class Cat implements Animal {
    private String name;

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void speak() {
        System.out.println("Meow!");
    }
}