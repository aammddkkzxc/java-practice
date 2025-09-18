package lambda.ex;

import lambda.MyFunction;

import java.util.ArrayList;
import java.util.List;

import static lambda.ex.GenericMapper.map;

public class MapExample {

    public static void main(String[] args) {
        List<String> fruits = List.of("apple", "banana", "orange");

        //String -> String
        List<String> upper = map(fruits, String::toUpperCase);
        System.out.println(upper);

        List<Integer> length = map(fruits, String::length);
        System.out.println(length);

        List<Integer> integers = List.of(1, 2, 3);
        List<String> starList = GenericMapper.map(integers, "*"::repeat);
        System.out.println(starList);
    }

}
