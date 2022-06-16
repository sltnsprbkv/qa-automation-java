package com.tcs.edu.decorator;

import com.tcs.edu.domain.Message;

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
        Message newMessage = Message.builder()
                .body(String.format("%s %s", Instant.now(), message.getBody()))
                .severity(message.getSeverity())
                .uuid(message.getUuid())
                .build();
        return nextDecorator == null
                ? newMessage
                : nextDecorator.decorate(newMessage);
    }
}
