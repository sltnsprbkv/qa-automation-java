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

public class SeparateDecorator extends MessageDecorator {

    private static int PAGE_SIZE = 3;
    private static String separator = "\n---";

    public SeparateDecorator(MessageDecorator nextDecorator) {
        super(nextDecorator);
    }

    public SeparateDecorator() {
        super(null);
    }

    /**
     * Метод возвращает строку с разделителем, если эта строка последняя по счету.
     *
     * @param message строка, к которой будет добавлен разделитель
     * **/
    @Override
    public Message decorate(Message message) {
        Message newMessage = NumerateMessageDecorator.messageCount % PAGE_SIZE == 0
                ? new Message(message, message.getBody() + separator)
                : new Message(message, message.getBody());
        return nextDecorator == null
                ? newMessage
                : nextDecorator.decorate(newMessage);
    }
}
