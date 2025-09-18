package parallel;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class MyLogger {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");

    public static <T> void log(T t) {
        String time = LocalTime.now().format(formatter);
        System.out.printf("%s [%9s] %s\n", time, Thread.currentThread().getName(), t);
    }

}
