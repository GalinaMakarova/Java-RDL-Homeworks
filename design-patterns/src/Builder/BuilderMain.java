package Builder;

import java.util.Arrays;

public class BuilderMain {
    public static void main(String[] args) {
        Recipient myRecipient = new Recipient.Builder()
                .withAddress("123")
                .withUsername("qwerty")
                .build();

        System.out.println(myRecipient);

        EmailMessage myEmailMessage = new EmailMessage.Builder()
                .withBody("qazwsx")
                .withRecipients(Arrays.asList(myRecipient, myRecipient))
                .withSender(myRecipient)
                .withSubject("fgjnfjkjgfb")
                .build();

        System.out.println(myEmailMessage);
    }
}
