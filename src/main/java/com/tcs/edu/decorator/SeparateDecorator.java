package com.tcs.edu.decorator;

import com.tcs.edu.repository.Decorator;

/**
 * Декорирование сообщений с операцией разделения
 *
 * @author s.saparbekov
 * **/

public class SeparateDecorator implements Decorator<String> {

    public static int PAGE_SIZE = 3;
    private static String separator = "\n---";

    /**
     * Метод возвращает строку с разделителем, если эта строка последняя по счету.
     *
     * @param message строка, к которой будет добавлен разделитель
     * **/
    public String decorate(String message) {
        return NumerateMessageDecorator.messageCount % PAGE_SIZE == 0 ? message + separator : message;
    }
}
