package com.tcs.edu.decorator;

import com.tcs.edu.domain.Message;
import com.tcs.edu.repository.Decorator;
import com.tcs.edu.repository.MessageDecorator;

/**
 * Декорирование сообщений с операцией добавления уровня важности сообщения
 *
 * @author s.saparbekov
 * **/

public class SeverityMessageDecorator implements MessageDecorator {

    private static String messageFormat = "%s %s";

    /**
     * Метод возвращает строку с уровнем важности (severity).
     *
     * @param message сообщение, которое будет сконкатинировано с уровнем важности
     *
     * **/
    public Message decorate(Message message) {
        switch (message.getSeverity()) {
            case MAJOR:
                return new Message(String.format(messageFormat, message.getBody(), "(!!!)"), message.getSeverity());
            case REGULAR:
                return new Message(String.format(messageFormat, message.getBody(), "(!)"), message.getSeverity());
            case MINOR:
                return new Message(String.format(messageFormat, message.getBody(), "()"), message.getSeverity());
            default:
                return new Message(String.format(messageFormat, message.getBody(), "(-)"), message.getSeverity());
        }
    }
}
