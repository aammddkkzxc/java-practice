package optional;

import java.util.Optional;

public class OptionalRetrievalMain {

    public static void main(String[] args) {
        Optional<String> optValue = Optional.of("Hello");
        Optional<String> optEmpty = Optional.empty();

        System.out.println("===================");
        String value1 = optValue.orElse("기본값");
        String empty1 = optEmpty.orElse("기본값");
        System.out.println("value1 = " + value1);
        System.out.println("empty1 = " + empty1);
        System.out.println("===================");

        System.out.println("===================");
        String value2 = optValue.orElseGet(
                () -> {
                    System.out.println("람다 호출 - optValue");
                    return "New Value";
                }
        );
        String empty2 = optEmpty.orElseGet(
                () -> {
                    System.out.println("람다 호출 - optEmpty");
                    return "New Value";
                }
        );
        System.out.println("value2 = " + value2);
        System.out.println("empty2 = " + empty2);
        System.out.println("===================");

        System.out.println("===================");
        String value3 = optValue.orElseThrow(() -> new RuntimeException("값이 없음"));
        System.out.println("value3 = " + value3);
        try {
            String empty3 = optEmpty.orElseThrow(() -> new RuntimeException("값이 없음"));
            System.out.println("empty3 = " + empty3); // 실행 x
        } catch (Exception e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
        System.out.println("===================");

        System.out.println("===================");
        Optional<String> result1 = optValue.or(() -> Optional.of("FallBack"));
        Optional<String> result2 = optEmpty.or(() -> Optional.of("FallBack"));
        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);


    }

}
