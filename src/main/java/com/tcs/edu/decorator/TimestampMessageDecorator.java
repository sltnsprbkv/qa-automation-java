package com.tcs.edu.decorator;

import com.tcs.edu.repository.Decorator;

import java.time.Instant;

/**
 * Декорирование сообщений с операцией добавления к строке текущего времени
 *
 * @author s.saparbekov
 * **/

public class TimestampMessageDecorator implements Decorator<String> {

    /**
     * Метод возвращает строку с счетчиком (messageCount) и текущим временем.
     *
     * @param message строка, которая будет сконкатинирована с текущим временем
     * **/
    public String decorate(String message) {
        return String.format("%s %s", Instant.now(), message);
    }
}
