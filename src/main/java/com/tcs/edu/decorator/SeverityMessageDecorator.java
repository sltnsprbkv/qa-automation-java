package com.tcs.edu.decorator;

import com.tcs.edu.domain.Message;
import com.tcs.edu.repository.Decorator;

/**
 * Декорирование сообщений с операцией добавления уровня важности сообщения
 *
 * @author s.saparbekov
 * **/

public class SeverityMessageDecorator implements Decorator<Message> {

    private static String messageFormat = "%s %s";

    /**
     * Метод возвращает строку с уровнем важности (severity).
     *
     * @param message сообщение, которое будет сконкатинирована с ее уровнем важности
     *
     * **/
    public String decorate(Message message) {
        switch (message.getSeverity()) {
            case MAJOR:
                return String.format(messageFormat, message.getBody(), "(!!!)");
            case REGULAR:
                return String.format(messageFormat, message.getBody(), "(!)");
            case MINOR:
                return String.format(messageFormat, message.getBody(), "()");
            default:
                return String.format(messageFormat, message.getBody(), "(-)");
        }
    }
}
