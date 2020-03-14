package io.humb1t;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        System.out.println("Method references and Streams: ");
        List<Order> orders = getFilledList();
        System.out.println("All orders: ");
        orders.forEach(order -> System.out.println(order.toString()));
        System.out.println("filtered by condition, task#1: ");
        orders.stream()
                .filter(order -> order.itemsCount > Order.ITEMS_COUNT)
                .forEach(order -> System.out.println(order.toString()));
        System.out.println();
        System.out.println("filtered by method reference, task#2: ");
        orders.stream().filter(Order::isOrderItemsBigger).forEach(order -> System.out.println(order.toString()));

        System.out.println();
        System.out.println("Default methods: ");
        List<Order> factoryOrders = new ArrayList<>();
        OrderFactory factory = new OrderFactory() {
        };
        factoryOrders.add(factory.completedOrder());
        factoryOrders.add(factory.notStartedOrder());
        factoryOrders.add(factory.processingOrder());

        factoryOrders.forEach(order -> System.out.println(order.toString()));
    }

    public static List<Order> getFilledList() {
        List<Order> resultList = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < Order.ITEMS_COUNT * 3; i++) {
            OrderStatus status = OrderStatus.NOT_STARTED;
            if (0 == i % 2) {
                status = OrderStatus.PROCESSING;
            } else if (0 == i % 3) {
                status = OrderStatus.COMPLETED;
            }
            resultList.add(new Order(status, random.nextInt(Order.ITEMS_COUNT * 2)));
        }
        return resultList;
    }

    public enum OrderStatus {
        NOT_STARTED, PROCESSING, COMPLETED
    }

    public static class Order {
        public OrderStatus status;
        public int itemsCount;
        public static final int ITEMS_COUNT = 5;

        public Order() {
        }

        public boolean isOrderItemsBigger() {
            return itemsCount > ITEMS_COUNT;
        }

        public Order(OrderStatus status) {
            this.status = status;
            this.itemsCount = 0;
        }

        public Order(OrderStatus status, int itemsCount) {
            this.status = status;
            this.itemsCount = itemsCount;
        }

        @Override
        public String toString() {
            return "Order{" +
                    "status=" + status +
                    ", itemsCount=" + itemsCount +
                    '}';
        }
    }
}
