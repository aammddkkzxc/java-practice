package lambda;

@FunctionalInterface
public interface MyReducer<T> {

    T reduce(T a, T b);

}
