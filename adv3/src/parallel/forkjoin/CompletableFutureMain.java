package parallel.forkjoin;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static parallel.MyLogger.log;

public class CompletableFutureMain {

    public static void main(String[] args) {
        CompletableFuture.runAsync(() -> log("Fork/Join")); // Fork/Join 공용 풀

        ExecutorService es = Executors.newFixedThreadPool(100);
        CompletableFuture.runAsync(() -> log("Custom Pool"), es); // 별도의 풀
        es.close();
    }

}
