package parallel.forkjoin;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

import static parallel.MyLogger.log;

public class ForkJoinMain1 {

    public static void main(String[] args) {
        List<Integer> data = IntStream
                .rangeClosed(1, 8)
                .boxed()
                .toList();
        log("[생성] " + data);

        ForkJoinPool pool = new ForkJoinPool(10);

        long startTime = System.currentTimeMillis();

        SumTask task = new SumTask(data);
        Integer result = pool.invoke(task);
        pool.close();

        long endTime = System.currentTimeMillis();

        log("time: " + (endTime - startTime) + "ms, sum: " + result);
        log("pool: " + pool);
    }

}
