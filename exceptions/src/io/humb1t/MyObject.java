package io.humb1t;
//task#3
public class MyObject {
    private String name;

    @Override
    public String toString() {
        return "MyObject{" +
                "name='" + name + '\'' +
                '}';
    }

    public MyObject(String name) {
        this.name = name;
        throw new RuntimeException("Task#3 exception");
    }

    public static void main(String[] args) {
        MyObject someObject = null;
        someObject = new MyObject("someObject");
        System.out.println(someObject.toString());
        someObject.name = "new name";
        System.out.println(someObject.toString());
    }
}
