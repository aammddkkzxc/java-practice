package generic.wildcard;

import generic.animal.Animal;

public class WildCardEx{

    static <T> void genericMethod(Box<T> box) {
        System.out.println(box.getValue());
    }

    static void normalMethodWithWildCard(Box<?> box) {
        System.out.println(box.getValue());
    }

    static <T extends Animal> T genericMethodUpper(Box<T> box) {
        T dog = box.getValue();
        System.out.println(dog.getName());
        return dog;
    }

    static Animal normalMethodWithWildCardUpper(Box<? extends Animal> box) {
        Animal animal = box.getValue();
        System.out.println(animal.getName());
        return animal;
    }

}
