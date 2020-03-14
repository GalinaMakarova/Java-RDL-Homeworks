package io.humb1t;

import java.util.*;

public class OptionalTask { //distinct number counter
    private static HashMap<Integer, Integer> myCache = new HashMap<>();

    private static void run() {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int buf = random.nextInt(10);
            myCache.putIfAbsent(buf, 0);
            myCache.computeIfPresent(buf, (key, value) -> value + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("API and Optional: ");
        OptionalTask.run();
        System.out.println("Results: ");
        for (int i = 0; i < 10; i++) {
            String buf = String.valueOf(i);
            Optional<Integer> optional = Optional.ofNullable(myCache.get(i));
            optional.ifPresent(x -> System.out.println(buf + ", count: " + x.toString()));
            if (optional.isEmpty()) {
                System.out.println(i + " is null");
            }
        }
        System.out.println("Not empty rows count: " + Arrays.stream(myCache.values().toArray()).mapToInt(x -> (int) x).sum());
    }
}