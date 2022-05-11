package com.tcs.edu.decorator;

import com.tcs.edu.repository.Decorator;

/**
 * Декорирование сообщений с операцией добавления номера строки
 *
 * @author s.saparbekov
 * **/

public class NumerateMessageDecorator implements Decorator<String> {

    public static int messageCount = 0;

    /**
     * Метод возвращает строку с счетчиком (messageCount) и увеличивает счетчик.
     *
     * @param message строка, которая будет сконкатинирована с ее номером
     * **/
    public String decorate(String message) {
        return String.format("%d %s", ++messageCount, message);
    }
}
