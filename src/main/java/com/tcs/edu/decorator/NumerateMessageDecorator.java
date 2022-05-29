package com.tcs.edu.decorator;

import com.tcs.edu.domain.Message;

/**
 * Декорирование сообщений с операцией добавления номера строки
 *
 * @author s.saparbekov
 * **/

public class NumerateMessageDecorator extends MessageDecorator {

    public static int messageCount = 0;

    public NumerateMessageDecorator(MessageDecorator nextDecorator) {
        super(nextDecorator);
    }

    public NumerateMessageDecorator() {
        super(null);
    }

    /**
     * Метод возвращает строку с счетчиком (messageCount) и увеличивает счетчик.
     *
     * @param message строка, которая будет сконкатинирована с ее номером
     * **/
    @Override
    public Message decorate(Message message) {
        Message newMessage = new Message(message, String.format("%d %s", ++messageCount, message.getBody()));
        return nextDecorator == null
                ? newMessage
                : nextDecorator.decorate(newMessage);
    }
}
