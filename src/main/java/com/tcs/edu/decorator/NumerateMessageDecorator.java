package com.tcs.edu.decorator;

/**
 * Декорирование сообщений с операцией добавления номера строки
 *
 * @author s.saparbekov
 * **/
public class NumerateMessageDecorator {

    public static int messageCount = 0;

    /**
     * Метод возвращает строку с счетчиком (messageCount) и увеличивает счетчик.
     *
     * @param message строка, которая будет сконкатинирована с ее номером
     * **/
    public static String decorate(String message) {
        return String.format("%d %s", ++messageCount, message);
    }
}
