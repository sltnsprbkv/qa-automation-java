package com.tcs.edu.decorator;

import java.time.Instant;

/**
 * Декорирование сообщений с операцией добавления к строке текущего времени
 *
 * @author s.saparbekov
 * **/

public class TimestampMessageDecorator {

    /**
     * Метод возвращает строку с счетчиком (messageCount) и текущим временем,
     * и увеличивает счетчик. При выводе разделяет "страницы" согласно PAGE_SIZE.
     *
     * @param message строка, которая будет сконкатинирована с текущим временем
     * **/
    public static String decorate(String message) {
        return String.format("%s %s", Instant.now(), message);
    }
}
