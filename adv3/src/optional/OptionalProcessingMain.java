package optional;

import java.util.Optional;

public class OptionalProcessingMain {

    public static void main(String[] args) {
        Optional<String> optValue = Optional.of("Hello");
        Optional<String> optEmpty = Optional.empty();

        System.out.println("==========================");
        optValue.ifPresent(value -> System.out.println("optValue 값: " + value));
        optEmpty.ifPresent(value -> System.out.println("optValue 값: " + value));
        System.out.println("==========================");

        System.out.println("==========================");
        optValue.ifPresentOrElse(
                value -> System.out.println("optValue 값: " + value),
                () -> System.out.println("비어있음")
        );
        optEmpty.ifPresentOrElse(
                value -> System.out.println("optEmpty 값: " + value),
                () -> System.out.println("비어있음")
        );
        System.out.println("==========================");

        System.out.println("==========================");
        Optional<Integer> lengthOpt1 = optValue.map(String::length);
        Optional<Integer> lengthOpt2 = optEmpty.map(String::length);
        System.out.println("optValue.map(String::length) = " + lengthOpt1);
        System.out.println("optEmpty.map(String::length) = " + lengthOpt2);
        System.out.println("==========================");

        System.out.println("==========================");
        Optional<Optional<String>> nestedOpt = optValue.map(s -> Optional.of(s));
        Optional<String> flattenedOpt = optValue.flatMap(s -> Optional.of(s));
        System.out.println("optValue = " + optValue);
        System.out.println("nestedOpt = " + nestedOpt);
        System.out.println("flattenedOpt = " + flattenedOpt);
        System.out.println("=========================");

        System.out.println("=========================");
        // 값이 있고 조건을 만족하면 그 값을 그대로, 불만족시 Optional.emtpy()
        Optional<String> filtered1 = optValue.filter(s -> s.startsWith("H"));
        Optional<String> filtered2 = optValue.filter(s -> s.startsWith("X"));
        Optional<String> filtered3 = optEmpty.filter(s -> s.startsWith("X"));
        System.out.println("filter(H) = " + filtered1);
        System.out.println("filter(X) = " + filtered2);
        System.out.println("filter(X) = " + filtered3);
        System.out.println("=========================");

        System.out.println("=========================");
        optValue
                .stream()
                .forEach(
                        s -> System.out.println(("optValue.stream() -> " + s))
                );
        optEmpty.stream()
                .forEach(
                        s -> System.out.println("optEmpty.stream() -> " + s)
                );
    }

}
