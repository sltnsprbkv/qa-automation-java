package com.tcs.edu.decorator;

import com.tcs.edu.domain.Message;
import com.tcs.edu.repository.Decorator;
import com.tcs.edu.repository.MessageDecorator;

import java.lang.reflect.Member;

/**
 * Декорирование сообщений с операцией разделения
 *
 * @author s.saparbekov
 * **/

public class SeparateDecorator implements MessageDecorator {

    private static int PAGE_SIZE = 3;
    private static String separator = "\n---";

    /**
     * Метод возвращает строку с разделителем, если эта строка последняя по счету.
     *
     * @param message строка, к которой будет добавлен разделитель
     * **/
    public Message decorate(Message message) {
        return NumerateMessageDecorator.messageCount % PAGE_SIZE == 0
                ? new Message(message.getBody() + separator, message.getSeverity())
                : new Message(message.getBody(), message.getSeverity());
    }
}
