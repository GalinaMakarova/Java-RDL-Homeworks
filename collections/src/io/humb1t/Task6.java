package io.humb1t;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Task6 {
    private static HashMap<Integer, Integer> myCache = new HashMap<>();

    private static void run() {
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            int buf = random.nextInt(101);
            myCache.computeIfAbsent(buf, x -> 0);
            myCache.computeIfPresent(buf, (key, value) -> value + 1);
        }
    }

    public static void main(String[] args) {
        Task6.run();
        System.out.println("Results: ");
        for (Map.Entry<Integer, Integer> entry : myCache.entrySet()) {
            System.out.println(entry.getKey() + ", count: " + entry.getValue());
        }
        System.out.println("Rows count: " + Arrays.stream(myCache.values().toArray()).mapToInt(x -> (int) x).sum());
    }
}