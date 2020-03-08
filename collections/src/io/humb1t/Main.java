package io.humb1t;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

import static java.lang.Math.random;

public class Main {
    public static void main(String[] args) {
        //task#1
        Collection<String> c = Collections.EMPTY_LIST;
        List<String> list = new ArrayList<>(c);

        List<Order> orders = Collections.singletonList(new Order(OrderStatus.COMPLETED));
        orders.stream()
                .filter(order -> order.status == OrderStatus.COMPLETED)
                .forEach(order -> System.out.println(order.toString()));
        for (Order order : orders) {
            System.out.println(order.toString());
        }
        for (Iterator<Order> iterator = orders.iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next().toString());
        }
        Map<OrderStatus, List<Order>> ordersByStatus = orders.stream()
                .collect(Collectors.groupingBy(Order::getStatus));

        //task#2 - start
        System.out.println("task#2");
        orders = getFilledList();
        orders.add(new Order(OrderStatus.COMPLETED, 0)); //task#4
        orders.add(new Order(OrderStatus.COMPLETED, 0)); //task#4
        orders.forEach(order -> System.out.println(order.toString()));
        System.out.println("filtered: ");
        orders.stream()
                .filter(order -> order.itemsCount > 50)
                .forEach(order -> System.out.println(order.toString()));
        //task#2 - end

        //task#4 - start
        System.out.println("task#4");
        System.out.println("distinct orders: ");
        orders.stream()
                .distinct()
                .forEach(order -> System.out.println(order.toString()));
        //task#4 - end

        //task#3 - start
        System.out.println("task#3");
        ConcurrentLinkedQueue<Order> orderRequests = new ConcurrentLinkedQueue<>(orders);
        myThread thread1 = new myThread("thread1", 500, orderRequests);
        thread1.start();
        myThread thread2 = new myThread("thread2", 200, orderRequests);
        thread2.start();
        myThread thread3 = new myThread("thread3", 100, orderRequests);
        thread3.start();
        //task#3 - end
    }

    //task#2 - start
    public static List<Order> getFilledList() {
        List<Order> resultList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            OrderStatus status = OrderStatus.NOT_STARTED;
            if (0 == i % 2) {
                status = OrderStatus.PROCESSING;
            } else if (0 == i % 3) {
                status = OrderStatus.COMPLETED;
            }
            resultList.add(new Order(status, (int) (random() * 100)));
        }
        return resultList;
        //task#2 - end
    }

    //task#3 - start
    static class myThread extends Thread {
        private String threadName;
        private int timeout;
        private ConcurrentLinkedQueue orderRequests;

        myThread(String name, int timeout, ConcurrentLinkedQueue orderRequests) {
            this.threadName = name;
            this.timeout = timeout;
            this.orderRequests = orderRequests;
            System.out.println("Creating " + threadName + ", timeout = " + timeout);
        }

        public void run() {
            while (!orderRequests.isEmpty()) {
                System.out.println(orderRequests.poll() + " " + threadName);
                try {
                    Thread.sleep(timeout);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //task#3 - end

    public enum OrderStatus {
        NOT_STARTED, PROCESSING, COMPLETED
    }

    public static class Order {
        public final OrderStatus status;
        public int itemsCount; //task#2

        public Order(OrderStatus status) {
            this.status = status;
            this.itemsCount = 0; //task#2
        }

        public OrderStatus getStatus() {
            return status;
        }

        //task#2 - start
        public Order(OrderStatus status, int itemsCount) {
            this.status = status;
            this.itemsCount = itemsCount;
        }

        public int getItemsCount() {
            return itemsCount;
        }

        public void setItemsCount(int itemsCount) {
            this.itemsCount = itemsCount;
        }

        @Override
        public String toString() {
            return "Order{" +
                    "status=" + status +
                    ", itemsCount=" + itemsCount +
                    '}';
        }
        //task#2 - end

        //task#4 - start
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Order order = (Order) o;
            return itemsCount == order.itemsCount &&
                    status == order.status;
        }

        @Override
        public int hashCode() {
            return Objects.hash(status, itemsCount);
        }
        //task#4
    }
}
