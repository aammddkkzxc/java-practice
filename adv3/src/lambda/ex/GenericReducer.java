package lambda.ex;

import lambda.MyReducer;

import java.util.List;

public class GenericReducer {

    public static <T> T reduce(List<T> list, T initial, MyReducer<T> reducer) {
        T result = initial;

        for (T element : list) {
            result = reducer.reduce(result, element);
        }

        return result;
    }

}
