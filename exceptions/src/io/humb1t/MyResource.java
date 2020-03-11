package io.humb1t;

public class MyResource implements AutoCloseable {
    private final String resourceName;

    public MyResource(String resourceName) {
        this.resourceName = resourceName;
        System.out.println(resourceName + " resource is created.");
    }

    @Override
    public void close() {
        System.out.println(resourceName + " resource is closed.");
    }
}
