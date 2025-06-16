package lambda.ex;

import java.util.List;

import static lambda.ex.GenericFilter.filter;

public class FilterExample {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(-3, -2, -1, 1, 2, 3, 5);

        //음수
        List<Integer> negatives = filter(numbers, number -> number < 0);
        System.out.println(negatives);

        //짝수
        List<Integer> evens = filter(numbers, number -> (number % 2) == 0);
        System.out.println(evens);
    }

}
