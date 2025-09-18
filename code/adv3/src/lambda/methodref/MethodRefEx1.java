package lambda.methodref;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class MethodRefEx1 {

    public static void main(String[] args) {
        //정적 메서드
        Supplier<String> staticMethod1 = Person::greeting;
        System.out.println(staticMethod1.get());
        //정적 메서드 매개변수
        UnaryOperator<String> staticMethod2 = Person::greetingWithName;
        System.out.println(staticMethod2.apply("Kim"));

        //특정 객체 인스턴스 메서드
        Person person = new Person();
        Supplier<String> instanceMethod1 = person::introduce;
        System.out.println(instanceMethod1.get());
        //특정 객체 인스턴스 메서드 매개변수
        Function<Integer, String> instanceMethod2 = person::introduceWithNumber;
        System.out.println(instanceMethod2.apply(2));

        //생성자
        Supplier<Person> newPerson1 = Person::new;
        System.out.println(newPerson1.get());
        //생성자 매개변수
        Function<String, Person> newPerson2 = Person::new;
        System.out.println(newPerson2.apply("Kim"));

        //임의 객체 인스턴스 메서드
        Person person1 = new Person("Kim");
        Person person2 = new Person("Park");
        Person person3 = new Person("Lee");
        Function<Person, String> randoInstanceMethod1 = Person::introduce;
        System.out.println(randoInstanceMethod1.apply(person1));
        System.out.println(randoInstanceMethod1.apply(person2));
        System.out.println(randoInstanceMethod1.apply(person3));

        //임의 객체 인스턴스 메서드 매개변수
        BiFunction<Person, Integer ,String> randoInstanceMethod2 = Person::introduceWithNumber;
        System.out.println(randoInstanceMethod2.apply(person1, 1));
        System.out.println(randoInstanceMethod2.apply(person2, 2));
        System.out.println(randoInstanceMethod2.apply(person3, 3));
    }

}
