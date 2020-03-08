package io.humb1t;

import java.text.DecimalFormat;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Vector;

public class Task5 {
    public static void main(String[] args) {
        System.out.println("task#5");
        DecimalFormat df = new DecimalFormat("#.#########");
        Vector<Integer> vector = new Vector<>();
        long fromTime = System.currentTimeMillis();
        for (int i = 0; i < 40000000; i++) {
            vector.add(i);
        }
        long toTime = System.currentTimeMillis();
        double timeDifference = (toTime - fromTime) * 0.001;
        System.out.println("Vector: add 40.000.000 elements - time " + df.format(timeDifference) + " sec.");
        fromTime = System.currentTimeMillis();
        int buf = vector.get(15648792);
        toTime = System.currentTimeMillis();
        timeDifference = (toTime - fromTime) * 0.001;
        System.out.println("Vector: get element#15.648.792 - time " + df.format(timeDifference) + " sec.");
        fromTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            vector.remove(0);
        }
        toTime = System.currentTimeMillis();
        timeDifference = (toTime - fromTime) * 0.001;
        System.out.println("Vector: remove 1.000 elements - time " + df.format(timeDifference) + " sec.");
        vector = null;

        Queue<Integer> queue = new ArrayDeque<>();
        fromTime = System.currentTimeMillis();
        for (int i = 0; i < 40000000; i++) {
            queue.add(i);
        }
        toTime = System.currentTimeMillis();
        timeDifference = (toTime - fromTime) * 0.001;
        System.out.println("Queue: add 40.000.000 elements - time " + df.format(timeDifference) + " sec.");
        fromTime = System.currentTimeMillis();
        for (int i = 0; i < 15648792; i++) {
            queue.peek();
        }
        buf = queue.peek();
        toTime = System.currentTimeMillis();
        timeDifference = (toTime - fromTime) * 0.001;
        System.out.println("Queue: get element#15.648.792 - time " + df.format(timeDifference) + " sec.");
        fromTime = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            queue.poll();
        }
        toTime = System.currentTimeMillis();
        timeDifference = (toTime - fromTime) * 0.001;
        System.out.println("Queue: remove 1.000 elements - time " + df.format(timeDifference) + " sec.");
    }
}