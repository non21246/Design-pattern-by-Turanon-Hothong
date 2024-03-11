package Factory;

public class AnimalFactorys {
    public static void main(String[] args) {
        AnimalFactory factory = new AnimalFactory();

        Animal dog = factory.getAnimal("Dog");
        System.out.println("Dog says: " + dog.makeSound());

        Animal cat = factory.getAnimal("Cat");
        System.out.println("Cat says: " + cat.makeSound());
    }
}
