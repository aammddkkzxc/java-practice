package stream.collectors;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Collectors2Map {

    public static void main(String[] args) {
        Map<String, Integer> map1 = Stream
                .of("Apple", "Banana", "Tomato")
                .collect(
                        Collectors.toMap(
                                name -> name,
                                String::length
                        )
                );
        System.out.println("map1 = " + map1);
        System.out.println("map1 = " + map1.getClass());

//        duplicate key
//        Map<String, Integer> map2 = Stream
//                .of("Apple", "Apple", "Tomato")
//                .collect(
//                        Collectors.toMap(
//                                name -> name,
//                                name -> name.length()
//                        )
//                );
//        System.out.println("map1 = " + map2);

        //키 중복 대안 (병합)
        Map<String, Integer> map2 = Stream
                .of("Apple", "Apple", "Tomato")
                .collect(
                        Collectors.toMap(
                                name -> name,
                                String::length,
                                Integer::sum
                        )
                );
        System.out.println("map3 = " + map2);

        Map<String, Integer> map4 = Stream
                .of("Apple", "Apple", "Banana")
                .collect(
                        Collectors.toMap(
                                name -> name,
                                String::length,
                                (oldValue, newValue) -> oldValue + newValue,
                                LinkedHashMap::new
                        )
                );
        System.out.println("map4 = " + map4);
        System.out.println("map4 = " + map4.getClass());
    }

}
