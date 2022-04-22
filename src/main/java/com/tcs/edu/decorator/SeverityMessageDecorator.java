package com.tcs.edu.decorator;

import com.tcs.edu.model.Severity;

/**
 * Декорирование сообщений с операцией добавления уровня важности сообщения
 *
 * @author s.saparbekov
 * **/

public class SeverityMessageDecorator {

    private static String messageFormat = "%s %s";

    /**
     * Метод возвращает строку с уровнем важности (severity).
     *
     * @param message строка, которая будет сконкатинирована с ее уровнем важности
     * @param severity уровень важности
     *
     * **/
    public static String decorate(Severity severity, String message) {
        switch (severity) {
            case MAJOR:
                return String.format(messageFormat, message, "(!!!)");
            case REGULAR:
                return String.format(messageFormat, message, "(!)");
            case MINOR:
                return String.format(messageFormat, message, "()");
            default:
                return String.format(messageFormat, message, "(-)");
        }
    }
}
