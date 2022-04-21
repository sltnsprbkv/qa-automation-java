package com.tcs.edu.decorator;

/**
 * Декорирование сообщений с операцией разделения
 *
 * @author s.saparbekov
 * **/

public class SeparateDecorator {

    public static int PAGE_SIZE = 3;
    private static String separator = "\n---";

    /**
     * Метод возвращает строку с разделителем, если эта строка последняя по счету.
     *
     * @param message строка, к которой будет добавлен разделитель
     * **/
    public static String decorate(String message) {
        return NumerateMessageDecorator.messageCount % PAGE_SIZE == 0 ? message + separator : message;
    }
}
