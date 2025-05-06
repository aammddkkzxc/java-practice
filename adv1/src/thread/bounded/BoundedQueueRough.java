package thread.bounded;

import java.util.ArrayDeque;
import java.util.Queue;

import static thread.util.logger.MyLogger.log;

public class BoundedQueueRough implements BoundedQueue{

    private final Queue<String> queue = new ArrayDeque<>();
    private final int max;

    public BoundedQueueRough(int max) {
        this.max = max;
    }

    @Override
    public void put(String data) {
        if (queue.size() == max) {
            log("[put] 큐가 가득 참, 버림: " + data);
            return;
        }

        queue.offer(data);
    }

    @Override
    public String take() {
        if (queue.isEmpty()) {
            return null;
        }

        return queue.poll();
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
