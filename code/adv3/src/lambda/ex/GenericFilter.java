package lambda.ex;

import lambda.MyPredicate;

import java.util.ArrayList;
import java.util.List;

public class GenericFilter {

    public static <T> List<T> filter(List<T> list, MyPredicate<T> predicate) {
        List<T> filteredList = new ArrayList<>();

        for (T t : list) {
            if (predicate.test(t)) {
                filteredList.add(t);
            }
        }

        return filteredList;
    }

}
