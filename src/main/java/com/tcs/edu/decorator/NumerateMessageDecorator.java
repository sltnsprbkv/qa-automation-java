package com.tcs.edu.decorator;

import com.tcs.edu.domain.Message;
import com.tcs.edu.repository.Decorator;
import com.tcs.edu.repository.MessageDecorator;

/**
 * Декорирование сообщений с операцией добавления номера строки
 *
 * @author s.saparbekov
 * **/

public class NumerateMessageDecorator implements MessageDecorator {

    public static int messageCount = 0;

    /**
     * Метод возвращает строку с счетчиком (messageCount) и увеличивает счетчик.
     *
     * @param message строка, которая будет сконкатинирована с ее номером
     * **/
    public Message decorate(Message message) {
        return new Message(String.format("%d %s", ++messageCount, message.getBody()), message.getSeverity());
    }
}
