package Builder;

public class Recipient extends ARecipient {
    @Override
    public void create(String username, String address) {

    }

    @Override
    public String toString() {
        return "Recipient{" +
                "Username='" + Username + '\'' +
                ", Address='" + Address + '\'' +
                '}';
    }

    public static class Builder {
        private Recipient newRecipient;

        public Builder() {
            newRecipient = new Recipient();
        }

        public Builder withUsername(String Username) {
            newRecipient.Username = Username;
            return this;
        }

        public Builder withAddress(String Address) {
            newRecipient.Address = Address;
            return this;
        }

        public Recipient build(){
            return newRecipient;
        }
    }
}