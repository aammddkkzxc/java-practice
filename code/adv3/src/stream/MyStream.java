package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyStream<T> {

    private List<T> internalList;

    private MyStream(List<T> internalList) {
        this.internalList = internalList;
    }

    public static <T> MyStream<T> of(List<T> list) {
        return new MyStream<>(list);
    }

    public MyStream<T> filter(Predicate<T> predicate) {
        List<T> filteredList = new ArrayList<>();

        for (T item : internalList) {
            if (predicate.test(item)) {
                filteredList.add(item);
            }
        }

        return of(filteredList);
    }

    public <R> MyStream<R> map(Function<T, R> mapper) {
        List<R> mapped = new ArrayList<>();

        for (T element : internalList) {
            mapped.add(mapper.apply(element));
        }

        return of(mapped);
    }

    public void forEach(Consumer<T> consumer) {
        for (T element : internalList) {
            consumer.accept(element);
        }
    }

    public T getFirst() {
        return internalList.getFirst();
    }

    public List<T> toList() {
        return internalList;
    }

}
