package lambda;

@FunctionalInterface
public interface MyPredicate<T> {

    boolean test(T value);

}
