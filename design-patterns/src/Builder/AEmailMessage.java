package Builder;

import java.util.List;

public abstract class AEmailMessage implements IEmailMessage {
    List<IRecipient> Recipients; // получатели
    IRecipient Sender; // отправитель
    String Body; // текст письма
    String Subject; // тема письма
}
