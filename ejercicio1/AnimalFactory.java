class AnimalFactory {
    public static Animal getAnimal(String type, String name) {
        if ("dog".equals(type)) {
            return new Dog(name);
        } else if ("cat".equals(type)) {
            return new Cat(name);
        }
        return null;
    }
}
