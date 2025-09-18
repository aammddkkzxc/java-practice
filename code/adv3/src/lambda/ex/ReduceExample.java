package lambda.ex;

import java.util.List;

import static lambda.ex.GenericReducer.reduce;

public class ReduceExample {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 4);
        System.out.println("리스트: " + numbers);

        int sum = reduce(numbers, 0, (a, b) -> a + b);
        System.out.println(sum);

        int mult = reduce(numbers, 1, (a, b) -> a * b);
        System.out.println(mult);
    }

}
