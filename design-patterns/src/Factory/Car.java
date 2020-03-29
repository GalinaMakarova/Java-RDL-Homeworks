package Factory;

public class Car implements ITransport {
    private IProduct product;

    @Override
    public void answer() {
        System.out.println("id = 1");
    }

    @Override
    public void deliver() {
        if (product == null) {
            System.out.println("delivering: No");
        } else {
            System.out.println("delivering: Yes " + getProduct().toString());
        }
    }

    @Override
    public void putProduct(IProduct product) {
        this.product = product;
    }

    @Override
    public IProduct getProduct() {
        return this.product;
    }

    @Override
    public String toString() {
        return "Car{" +
                "product=" + product +
                '}';
    }
}
