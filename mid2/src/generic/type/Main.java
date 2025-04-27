package generic.type;

import generic.animal.Cat;
import generic.animal.Dog;

public class Main {

    public static void main(String[] args) {
        Dog dog = new Dog("멍멍이1", 100);
        Cat cat = new Cat("냐옹이1", 300);

        AnimalHospital<Dog> dogHospital = new AnimalHospital<>(dog);
        AnimalHospital<Cat> catHospital = new AnimalHospital<>(cat);

        dogHospital.checkup();
        catHospital.checkup();
    }

}
