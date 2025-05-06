package thread.interrupt.exercise;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedDeque;

import static thread.util.ThreadUtils.sleep;
import static thread.util.logger.MyLogger.log;

public class MyPrinterInterrupt {

    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread printerThread = new Thread(printer, "printer");
        printerThread.start();

        Scanner userInput = new Scanner(System.in);
        while (true) {
            System.out.println("프린터할 문서를 입력하세요. 종료 (q): ");
            String input = userInput.nextLine();
            if (input.equals("exit")) {
                printerThread.interrupt();
                break;
            }
            printer.addJob(input);
        }
    }

    static class Printer implements Runnable {
        Queue<String> jobQueue = new ConcurrentLinkedDeque<>();

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                if (jobQueue.isEmpty()) {

                    Thread.yield();
                    //인터럽트가 발생하기 전까지 계속 인터럽트의 상태 체크, jobQueue 의 상태를 확인
                    //쉴 틈 없이 CPU에서 이 로직이 계속 반복해서 수행된다는 점이다. 1초에 while문을 수억 번 반복할 수도 있다
                    //결과적으로 CPU 자원을 많이 사용하게 된다.
                    //작동하는 스레드가 아주 많다고 가정해보자. 인터럽트도 걸리지 않고, jobQueue 도 비어있는데,
                    //이런 체크 로직에 CPU 자원을 많이 사용하게 되면, 정작 필요한스레드들의 효율이 상대적으로 떨어질 수 있다.
                    //jobQueue 에 작업이 비어있으면 yield() 를 호출해서, 다른 스레드에 작업을 양보하는게 전체 관점에서 보면 더 효율적
                    continue;
                }

                String job = jobQueue.poll();
                log("출력 시작: " + job + ", 대기 문서: " + jobQueue);
                sleep(3000); //출력에 걸리는 시간
                log("출력 완료: " + job);
            }
            log("프린터 종료");
        }

        public void addJob(String input) {
            jobQueue.offer(input);
        }
    }
}
