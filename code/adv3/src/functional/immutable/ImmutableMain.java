package functional.immutable;

public class ImmutableMain {
    public static void main(String[] args) {
        ImmutablePerson i1 = new ImmutablePerson("Lee", 20);
        ImmutablePerson i2 = i1.withAge(21); // i2는 새로운 객체
        System.out.println("i1 = " + i1); // 20
        System.out.println("i2 = " + i2); // 21
    }
}