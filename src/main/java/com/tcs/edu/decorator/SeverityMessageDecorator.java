package com.tcs.edu.decorator;

import com.tcs.edu.domain.Message;
import com.tcs.edu.repository.Decorator;
import com.tcs.edu.repository.MessageDecorator;
import com.tcs.edu.repository.MessageService;

import java.time.Instant;

/**
 * Декорирование сообщений с операцией добавления уровня важности сообщения
 *
 * @author s.saparbekov
 * **/

public class SeverityMessageDecorator extends MessageDecorator {

    private static String messageFormat = "%s %s";

    public SeverityMessageDecorator(MessageDecorator nextDecorator) {
        super(nextDecorator);
    }

    public SeverityMessageDecorator() {
        super(null);
    }

    /**
     * Метод возвращает строку с уровнем важности (severity).
     *
     * @param message сообщение, которое будет сконкатинировано с уровнем важности
     *
     * **/
    @Override
    public Message decorate(Message message) {
        Message newMessage;
        switch (message.getSeverity()) {
            case MAJOR:
                newMessage = new Message(message, String.format(messageFormat, message.getBody(), "(!!!)"));
                break;
            case REGULAR:
                newMessage = new Message(message, String.format(messageFormat, message.getBody(), "(!)"));
                break;
            case MINOR:
                newMessage = new Message(message, String.format(messageFormat, message.getBody(), "()"));
                break;
            default:
                newMessage = new Message(message, String.format(messageFormat, message.getBody(), "(-)"));
        }
        return nextDecorator == null
                ? newMessage
                : nextDecorator.decorate(newMessage);
    }
}
