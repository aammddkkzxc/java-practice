package lambda.methodref;

import stream.MyStream;

import java.util.List;
import java.util.function.BiFunction;

public class MethodRefEx2 {

    public static void main(String[] args) {
        List<Person> personList = List.of(
                new Person("Kim"),
                new Person("Park"),
                new Person("Lee")
        );

        List<String> result = MyStream
                .of(personList)
                .map(Person::introduce)
                .map(String::toUpperCase)
                .toList();
        System.out.println(result);

        Person person = new Person("Kim");
        BiFunction<Person, Integer, String> function = Person::introduceWithNumber;
        System.out.println(function.apply(person, 1));
    }

}
