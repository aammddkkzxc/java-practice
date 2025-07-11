package thread.join;

import static thread.util.ThreadUtils.sleep;
import static thread.util.logger.MyLogger.log;

public class JoinMain {

    public static void main(String[] args) throws InterruptedException {
        log("start");
        SumTask task1 = new SumTask(1, 50);
        Thread thread1 = new Thread(task1);

        thread1.start();

        log("join() - main 스레드가 thread1 종료까지 대기");
        thread1.join();

//        log("join(1000) - main 스레드가 thread1 종료까지 1초 대기");
//        thread1.join(1000);
        log("main 스레드 대기 완료");
        log("task1.result = " + task1.result);
    }

    private static class SumTask implements Runnable {

        int startValue;
        int endValue;
        int result = 0;

        public SumTask(int startValue, int endValue) { this.startValue = startValue;
            this.endValue = endValue;
        }

        @Override
        public void run() {
            log("작업 시작");
            sleep(2000);
            int sum = 0;

            for (int i = startValue; i <= endValue; i++) {
                sum += i;
            }

            result = sum;
            log("작업 완료 result = " + result);
        }
    }

}
