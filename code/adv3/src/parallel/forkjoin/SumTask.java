package parallel.forkjoin;

import parallel.HeavyJob;

import java.util.List;
import java.util.concurrent.RecursiveTask;

import static parallel.MyLogger.log;

public class SumTask extends RecursiveTask<Integer> {

//    private static final int THRESHOLD = 4; // 임계값
    private static final int THRESHOLD = 2; // 임계값 변경

    private final List<Integer> list;

    public SumTask(List<Integer> list) {
        this.list = list;
    }

    @Override
    protected Integer compute() {

        if (list.size() < THRESHOLD) {
            log("[처리 시작] " + list);

            int sum = list
                    .stream()
                    .mapToInt(
                            HeavyJob::heavyTask
                    )
                    .sum();
            log("[처리 완료] " + list + " -> sum: " + sum);

            return sum;
        } else {
            int middle = list.size() / 2;
            List<Integer> leftList = list.subList(0, middle);
            List<Integer> rightList = list.subList(middle, list.size());
            log("[분할] " + list + " -> LEFT" + leftList + ", RIGHT" + rightList);

            SumTask leftTask = new SumTask(leftList);
            SumTask rightTask = new SumTask(rightList);

            // 왼쪽 작업은 다른 스레드에서 처리
            leftTask.fork();
            // 오른쪽 작업은 현재 스레드에서 처리
            int rightResult = rightTask.compute();

            // 왼쪽 작업 결과를 기다림
            int leftResult = leftTask.join();
            // 왼쪽과 오른쪽 작업 결과를 합침
            int joinSum = leftResult + rightResult;
            log("LEFT[" + leftResult + "] + RIGHT[" + rightResult + "] -> sum: " + joinSum);
            return joinSum;
        }
    }

}
