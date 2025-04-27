package generic.method;

import generic.animal.Animal;

public class ComplexBox<T extends Animal> {

    private T animal;

    public ComplexBox(T animal) {
        this.animal = animal;
    }

    //제네릭 메소드가 아님
    public T getAnimal() {
        return animal;
    }

    //제네릭 메소드
    public <Z> Z genericMethod(Z z) {
        return z;
    }

    //매개변수와 리턴 타입이 다를 때
    public <T, R> R convert(T input) {
        // 변환 로직
        return null;
    }

    // 리턴타입 void
    public <T> void print(T item) {

    }

    // 매개변수 없음, 리턴타입만 T
    public <T> T create() {
        return null;
    }

    public static <V> V genericStaticMethod(V v) {
        return v;
    }

}
