package com.tcs.edu.decorator;

import com.tcs.edu.domain.Message;
import com.tcs.edu.repository.Decorator;
import com.tcs.edu.repository.MessageDecorator;

import java.time.Instant;

/**
 * Декорирование сообщений с операцией добавления к строке текущего времени
 *
 * @author s.saparbekov
 * **/

public class TimestampMessageDecorator extends MessageDecorator {

    public TimestampMessageDecorator(MessageDecorator nextDecorator) {
        super(nextDecorator);
    }

    public TimestampMessageDecorator() {
        super(null);
    }

    /**
     * Метод возвращает строку с счетчиком (messageCount) и текущим временем.
     *
     * @param message строка, которая будет сконкатинирована с текущим временем
     * **/
    @Override
    public Message decorate(Message message) {
        Message newMessage = new Message(message, String.format("%s %s", Instant.now(), message.getBody()));
        return nextDecorator == null
                ? newMessage
                : nextDecorator.decorate(newMessage);
    }
}
