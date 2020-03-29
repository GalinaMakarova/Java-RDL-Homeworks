package Factory;

public class Factory {
    public ITransport getTransport(String input) {
        ITransport transport = null;
        switch (input) {
            case "rig":
                transport = new Rig();
                break;
            case "tractor":
                transport = new Tractor();
                break;
            case "car":
                transport = new Car();
                break;
        }
        return transport;
    }
}
