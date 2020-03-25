package io.humb1t.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Task1 {
    private static final int COUNT = 10;

    public static void main(String[] args) {
        List<Object> list = getFilledList();
        System.out.println("Initial elements count: " + list.size());
        list = listFiltration(list);
        System.out.println("Filtered elements count: " + list.size());
    }

    static List<Object> getFilledList() {
        Random random = new Random();
        List<Object> arr = new ArrayList<>();
        for (int i = 0; i < COUNT; i++) {
            if ((random.nextInt(100) % 2) != 0) {
                arr.add(new depClass());
            } else {
                if ((random.nextInt(100) % 2) != 0) {
                    arr.add(new myClass(random.nextInt(100)));
                } else {
                    arr.add(new myClass());
                }
            }
        }
        return arr;
    }

    static List<Object> listFiltration(List<Object> list) {
        List<Object> arr = new ArrayList<>();
        for (Object o : list) {
            if (!o.getClass().isAnnotationPresent(Deprecated.class)) {
                arr.add(o);
            }
        }
        return arr;
    }
}
