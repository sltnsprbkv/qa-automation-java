package com.tcs.edu.decorator;

import java.time.Instant;

/**
 * Декорирование сообщений с операцией добавления к строке текущего времени
 *
 * @author s.saparbekov
 * **/

public class TimestampMessageDecorator {

    /**
     * Метод возвращает строку с текущим временем
     *
     * @param message строка, которая будет сконкатинирована с текущим временем
     * **/
    public static String decorate(String message) {
        return Instant.now() + " " + message;
    }
}
