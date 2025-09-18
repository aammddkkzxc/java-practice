package lambda;

@FunctionalInterface
public interface MyTransformer<T> {

    T transform(T t);

}
