package parallel;

import java.util.stream.IntStream;

import static parallel.MyLogger.log;

public class ParallelMain4 {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        int sum = IntStream
                .rangeClosed(1, 8)
                .parallel()
                .map(HeavyJob::heavyTask)
                .reduce(0, Integer::sum);

        long endTime = System.currentTimeMillis();

        log("time: " + (endTime - startTime) + "ms, sum: " + sum);
    }

}
