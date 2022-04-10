package com.tcs.edu.decorator;

import java.time.Instant;

/**
 * Декорирование сообщений с операцией добавления к строке текущего времени
 *
 * @author s.saparbekov
 * **/

public class TimestampMessageDecorator {

    public static int messageCount = 0;
    public static int PAGE_SIZE = 3;
    /**
     * Метод возвращает строку с счетчиком (messageCount) и текущим временем,
     * и увеличивает счетчик. При выводе разделяет "страницы" согласно PAGE_SIZE.
     *
     * @param message строка, которая будет сконкатинирована с текущим временем
     * **/
    public static String decorate(String message) {
        messageCount++;
        final var decoratedMessage = String.format("%d %s %s", messageCount, Instant.now(), message);
        return messageCount % PAGE_SIZE == 0
                ? decoratedMessage + "\n---"
                : decoratedMessage;
    }
}
