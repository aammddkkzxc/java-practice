package lambda.ex;

import lambda.MyFunction;

import java.util.ArrayList;
import java.util.List;

public class GenericMapper {

    public static <T, R> List<R> map(List<T> list, MyFunction<T, R> function) {
        List<R> mappedList = new ArrayList<>();

        for (T t : list) {
            mappedList.add(function.apply(t));
        }

        return mappedList;
    }

}
