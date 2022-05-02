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

public class TimestampMessageDecorator implements MessageDecorator {

    /**
     * Метод возвращает строку с счетчиком (messageCount) и текущим временем.
     *
     * @param message строка, которая будет сконкатинирована с текущим временем
     * **/
    public Message decorate(Message message) {
        return new Message(String.format("%s %s", Instant.now(), message.getBody()), message.getSeverity());
    }
}
