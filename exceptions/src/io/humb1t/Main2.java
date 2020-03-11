package io.humb1t;

public class Main2 {
    //task#2
    public static void main(String[] args) {
        try (MyResource resource = new MyResource("testResource");
             MyResource resource2 = new MyResource("testResource2");
             MyResource resource3 = new MyResource("testResource3")
        ) {
            System.out.println("try with resources works correctly");
        } catch (Exception e) {
            System.out.println("resource exception: " + e.getMessage());
        }
    }
}