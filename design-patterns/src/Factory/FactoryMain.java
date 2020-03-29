package Factory;

public class FactoryMain {
    public static void main(String[] args){
        Factory f1 = new Factory();
        Object someTransport = f1.getTransport("car");
        System.out.println(someTransport.toString());
        Object someTransport2 = f1.getTransport("rig");
        System.out.println(someTransport2.toString());
        Object someTransport3 = f1.getTransport("tractor");
        System.out.println(someTransport3.toString());
    }
}
