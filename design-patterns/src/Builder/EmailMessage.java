package Builder;

import java.util.List;

public class EmailMessage extends AEmailMessage {
    @Override
    public void send() {

    }

    @Override
    public IEmailMessage receive() {
        return null;
    }

    @Override
    public IEmailMessage create(IRecipient sender, IRecipient... recipient) {
        return null;
    }

    @Override
    public String toString() {
        return "EmailMessage{" +
                "Recipients=" + Recipients +
                ", Sender=" + Sender +
                ", Body='" + Body + '\'' +
                ", Subject='" + Subject + '\'' +
                '}';
    }

    public static class Builder {
        private EmailMessage newEmailMessage;

        public Builder() {
            newEmailMessage = new EmailMessage();
        }

        public Builder withRecipients(List<IRecipient> Recipients) {
            newEmailMessage.Recipients = Recipients;
            return this;
        }

        public Builder withSender(Recipient Sender) {
            newEmailMessage.Sender = Sender;
            return this;
        }

        public Builder withBody(String body) {
            newEmailMessage.Body = body;
            return this;
        }

        public Builder withSubject(String Subject) {
            newEmailMessage.Subject = Subject;
            return this;
        }

        public EmailMessage build(){
            return newEmailMessage;
        }
    }
}
