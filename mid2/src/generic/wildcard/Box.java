package generic.wildcard;

public class Box<T> {

    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

}
