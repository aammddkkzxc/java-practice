package stream.collectors;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DownStreamMain1 {

    public static void main(String[] args) {
        List<Student> students = List.of(
                new Student("Kim", 1, 85),
                new Student("Park", 1, 70),
                new Student("Lee", 2, 70),
                new Student("Han", 2, 90),
                new Student("Hoon", 3, 90),
                new Student("Ha", 3, 89)
        );

        // 학년별로 학생들 그룹화
        Map<Integer, List<Student>> collect1_1 = students
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Student::getGrade,
                                Collectors.toList()
                        )
                );
        System.out.println("collect1_1 = " + collect1_1);

        // 다운스트림 toList()는 생략 가능
        Map<Integer, List<Student>> collect1_2 = students
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Student::getGrade
                        )
                );
        System.out.println("collect1_1 = " + collect1_2);

        // 학년별로 학생들의 이름 출력
        Map<Integer, List<String>> collect2 = students
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Student::getGrade,
                                Collectors.mapping(
                                        Student::getName,
                                        Collectors.toList()
                                )
                        )
                );
        System.out.println(collect2);

        // 학년별로 학생들의 수를 출력
        Map<Integer, Long> collect3 = students
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Student::getGrade,
                                Collectors.counting()
                        )
                );
        System.out.println(collect3);

        // 학년별로 학생들의 평균 성적 출력
        Map<Integer, Double> collect4 = students
                .stream()
                .collect(
                        Collectors.groupingBy(
                                Student::getGrade,
                                Collectors.averagingInt(
                                        Student::getScore
                                )
                        )
                );
        System.out.println(collect4);
    }

}
