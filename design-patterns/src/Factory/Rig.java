package Factory;

public class Rig implements ITransport {
    private IProduct product;

    @Override
    public void answer() {
        System.out.println("id = 45");
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
    public IProduct getProduct() {
        return this.product;
    }

    @Override
    public void putProduct(IProduct product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Rig{" +
                "product=" + product +
                '}';
    }
}
