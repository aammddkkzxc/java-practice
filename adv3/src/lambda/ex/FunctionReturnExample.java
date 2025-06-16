package lambda.ex;

import lambda.MyUnaryOperator;

public class FunctionReturnExample {

    public static void main(String[] args) {
        MyUnaryOperator<String> hello = operate("Hello");
        MyUnaryOperator<String> hi = operate("Hi");

        System.out.println(hello.apply("Java"));
        System.out.println(hi.apply("Lambda"));
    }

    public static MyUnaryOperator<String> operate(String value) {
        return x -> value + ", " + x;
    }

}
