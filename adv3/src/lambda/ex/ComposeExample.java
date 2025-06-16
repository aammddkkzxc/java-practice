package lambda.ex;

import lambda.MyTransformer;

public class ComposeExample {

    public static void main(String[] args) {
        MyTransformer<String> toUpper = s -> s.toUpperCase();
        MyTransformer<String> addDeco = s -> "**" + s + "**";
        MyTransformer<String> composed = compose(toUpper, addDeco);

        String result = composed.transform("hello");
        System.out.println(result);
    }

    public static <T> MyTransformer<T> compose(MyTransformer<T> first, MyTransformer<T> second) {
        return val -> second.transform(first.transform(val));
    }

}
