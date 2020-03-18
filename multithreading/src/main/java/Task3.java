import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Task3 {

    public static void main(String[] args) {
        BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(5);
        new Thread(new Producer(queue)).start();
        new Thread(new Consumer(queue)).start();
    }

    public static class Producer implements Runnable {
        private final BlockingQueue<Integer> queue;

        @Override
        public void run() {
            try {
                for (int i = 0; i < 21; i++) {
                    queue.put(i);
                    System.out.println("Producer: adding, step#" + i + ". Buffer size = " + queue.remainingCapacity());
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        public Producer(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }
    }

    public static class Consumer implements Runnable {
        private final BlockingQueue<Integer> queue;

        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println("Consumer: removing, step#" + queue.take() + ". Buffer size = " + queue.remainingCapacity());
                    Thread.sleep(200);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        public Consumer(BlockingQueue<Integer> queue) {
            this.queue = queue;
        }
    }

}
