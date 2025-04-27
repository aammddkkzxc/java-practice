package generic.type;

import generic.animal.Animal;

public class AnimalHospital<T extends Animal> {

    private final T animal;

    public AnimalHospital(T animal) {
        this.animal = animal;
    }

    public void checkup() {
        System.out.println("동물 이름: " + animal.getName());
        System.out.println("동물 크기: " + animal.getSize());
        animal.sound();
    }

    public T getBigger(T target) {
        return animal.getSize() > target.getSize() ? animal : target;
    }

}
