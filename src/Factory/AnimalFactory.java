package Factory;

class Dog extends Animal {
    @Override
    public String makeSound() {
        return "Bark";
    }
}

class Cat extends Animal {
    @Override
    public String makeSound() {
        return "Meow";
    }
}

public class AnimalFactory {
    public Animal getAnimal(String type) {
        if ("Dog".equalsIgnoreCase(type)) {
            return new Dog();
        } else if ("Cat".equalsIgnoreCase(type)) {
            return new Cat();
        }
        return null;
    }
}


